package com.seago.loltrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.seago.loltrack.statRetriever.Player;
import com.seago.loltrack.statRetriever.statLeagues.Leagues;
import com.seago.loltrack.statRetriever.statLeagues.SummonerLeagues;
import com.seago.loltrack.statRetriever.statPlayer_stats.PlayerStatSummarySet;
import com.seago.loltrack.statRetriever.statPlayer_stats.Player_stats;
import com.seago.loltrack.statRetriever.statRanked_stats.LifetimeStatistics;
import com.seago.loltrack.statRetriever.statRanked_stats.Ranked_stats;
import com.seago.loltrack.statRetriever.statSummoner.Summoner;

class SummonerInfo {
	private static final String[]	tierLevel			= { "BRONZE", "SILVER", "GOLD", "PLATINUM", "DIAMOND", "CHALLENGER" };
	private static final String[]	divLevel			= { "V", "IV", "III", "II", "I" };

	private boolean					success				= false;

	public String					region				= null;
	public String					name				= null;
	public int						level				= -1;
	public int						summonerIconId		= -1;

	public String					topRanking			= null;
	public int						topRankingLP		= -1;
	public int						topRankingWins		= -1;
	public int						topRankingLosses	= -1;
	public double					topRankingKDA		= -1;

	public String					topChampion			= null;
	public int						topChampionGames	= -1;
	public int						topChampionWins		= -1;
	public int						topChampionLosses	= -1;
	public double					topChampionKDA		= -1;

	public int						normalWins			= 0;
	public int						timePlayed			= -1;

	public SummonerInfo(Player p) {

		this.success = p.getSummoner().getSuccess();
		this.region = p.getRegion();

		this.setProfileStats(p.getSummoner());

		// Sets the stats contained in 'player_stats'
		if (p.getPlayer_stats() != null && p.getPlayer_stats().getSuccess())
			this.setPlayerStats(p.getPlayer_stats());
		
		// Sets the stats contained in 'leagues'
		if (p.getLeagues() != null && p.getLeagues().getSuccess())
			this.setLeagueStats(p.getLeagues());
		
		// Sets the stats contained in 'ranked_stats'
		if (p.getRanked_stats() != null && p.getRanked_stats().getSuccess())
			this.setRankedStats(p.getRanked_stats());
	}

	// Sets the name, level and summmoner icon id
    void setProfileStats(Summoner summoner) {
		this.name = summoner.getData().getName();
		this.level = summoner.getData().getSummonerLevel().intValue();
		this.summonerIconId = summoner.getData().getProfileIconId().intValue();
	}

	// Finds the total normal game wins
    void setPlayerStats(Player_stats player_stats) {
		// Adds up the unranked wins
		List<PlayerStatSummarySet> ps = player_stats.getData().getPlayerStatSummaries().getPlayerStatSummarySet();
        for (PlayerStatSummarySet p : ps) {
            if (p.getPlayerStatSummaryType().equals("OdinUnranked")) {
                normalWins += p.getWins().intValue();
            } else if (p.getPlayerStatSummaryType().equals("Unranked")) {
                normalWins += p.getWins().intValue();
            } else if (p.getPlayerStatSummaryType().equals("Unranked3x3")) {
                normalWins += p.getWins().intValue();
            }
        }
	}

	// Finds the topRanking LP, Wins and Losses
    void setLeagueStats(Leagues leagues) {
		List<SummonerLeagues> sl = leagues.getData().getSummonerLeagues();
		// Integer code for best rating based off of tier and division
		int topLeagueCode = 0;
		// Index of best rating league
		int topLeagueIndex = 0;

		// Determines the top league
		for (int i = 0; i < sl.size(); i++) {
			// calculates the tier portion of their top league code
			int leagueCode = 0;
			for (int j = 0; j < tierLevel.length; j++) {
				if (sl.get(i).getTier().equals(tierLevel[j])) {
					leagueCode = j * 5;
					break;
				}
			}

			// calculates the division portion of their top league code
			for (int j = 0; j < divLevel.length; j++) {
				if (sl.get(i).getRequestorsRank().equals(divLevel[j])) {
					leagueCode += j + 1;
					break;
				}
			}

			// sets the new top league if the calculated one is higher
			if (topLeagueCode < leagueCode) {
				topLeagueCode = leagueCode;
				topLeagueIndex = i;
			}
		}

		// Sets the tier from e.g. "PLATINUM" at rank "I" to "Platinum I". Takes into account challenger tier as well.
		this.topRanking = sl.get(topLeagueIndex).getTier().substring(0, 1) + sl.get(topLeagueIndex).getTier().substring(1).toLowerCase(Locale.US)
				+ (sl.get(topLeagueIndex).getTier().equals("CHALLENGER") ? "" : " " + sl.get(topLeagueIndex).getRequestorsRank());

		/*
		 * This is temporarily unused because showing the top ranking league points adds clutter and the wins/losses are displayed from the summoners
		 * overall statistics rather than league specific wins/losses
		 * If this were to be re-enabled this method requires the statistic 'Summoner_team_info'

		// Searchs the league for this summoner or their team and stores their stats			
		// If the top ranking is solo queue
		if (sl.get(topLeagueIndex).getQueue().equals("RANKED_SOLO_5x5")) {
			// Searches through entries in the top league for the summoner name
			for (int i = 0; i < sl.get(topLeagueIndex).getEntries().size(); i++) {
				Entries se = sl.get(topLeagueIndex).getEntries().get(i);
				if (se.getPlayerOrTeamName().equals(this.name)) {
					this.topRankingLP = se.getLeaguePoints().intValue();
					this.topRankingWins = se.getWins().intValue();
					this.topRankingLosses = se.getLosses().intValue();
					break;
				}

			}
		}

		// If the top ranking is a team
		else {
			String teamName = sl.get(topLeagueIndex).getRequestorsName();
			String teamId = null;
			List<PlayerTeam> pt = summoner_team_info.getData().getPlayerTeams();

			// find the teamId
			for (int i = 0; i < pt.size(); i++) {
				if (pt.get(i).getName().equals(teamName)) {
					teamId = pt.get(i).getTeamId().getFullId();
				}
			}

			// Searches through entries in the top league for the teamId
			for (int i = 0; i < sl.get(topLeagueIndex).getEntries().size(); i++) {
				Entries se = sl.get(topLeagueIndex).getEntries().get(i);
				if (se.getPlayerOrTeamId().equals(teamId)) {
					this.topRankingLP = se.getLeaguePoints().intValue();
					this.topRankingWins = se.getWins().intValue();
					this.topRankingLosses = se.getLosses().intValue();
					break;
				}
			}
		}*/
	}

	// Determines who the players top champion is and finds its respective stats while also determining their overall ranked KDA
    void setRankedStats(Ranked_stats ranked_stats) {

		int statsSize = ranked_stats.getData().getLifetimeStatistics().size();
		int champId = 0;
		double champKDA = 0;
		int champGames = 0;
		double highestScore = 0;
		int totalKills = 0;
		int totalDeaths = 0;
		int totalAssists = 0;
		// Creates a list of all championId's a player has played as
		ArrayList<Integer> champ = new ArrayList<Integer>();
		for (int i = 0; i < statsSize; i++) {
			LifetimeStatistics ls = ranked_stats.getData().getLifetimeStatistics().get(i);
			if (!champ.contains(ls.getChampionId().intValue()) && ls.getChampionId().intValue() != 0) {
				champ.add(ls.getChampionId().intValue());
			}
		}

		// Searchs the statistics for each champions required stats then calculates a champion score
		for (int i = 0; i < champ.size(); i++) {
			int games = 0, kills = 0, deaths = 0, assists = 0;
			// Iterates through all stat entries
			for (int j = 0; j < statsSize; j++) {
				LifetimeStatistics ls = ranked_stats.getData().getLifetimeStatistics().get(j);
				// Checks if it is champion with id 'i'
				if (ls.getChampionId().intValue() == champ.get(i)) {
					// Checks if it is any of the required stats
					if (ls.getStatType().equals("TOTAL_CHAMPION_KILLS")) {
						kills = ls.getValue().intValue();
					} else if (ls.getStatType().equals("TOTAL_DEATHS_PER_SESSION")) {
						deaths = ls.getValue().intValue();
					} else if (ls.getStatType().equals("TOTAL_ASSISTS")) {
						assists = ls.getValue().intValue();
					} else if (ls.getStatType().equals("TOTAL_SESSIONS_PLAYED")) {
						games = ls.getValue().intValue();
					}
				}
			}

			// Adds to the total K, D and A
			totalKills += kills;
			totalDeaths += deaths;
			totalAssists += assists;

			// Avoids division by 0
			if (deaths == 0)
				deaths = 1;

			// If this is the first champion iteration, set it as the highest
			if (i == 0) {
				champId = champ.get(i);
				champKDA = Utils.getKDA(kills, deaths, assists);
				champGames = games;
				highestScore = Utils.getChampionScore(games, kills, deaths, assists);
			}

			// If this champion score is higher than the top, set it as the highest
			else if (highestScore < Utils.getChampionScore(games, kills, deaths, assists)) {
				champId = champ.get(i);
				champKDA = Utils.getKDA(kills, deaths, assists);
				champGames = games;
				highestScore = Utils.getChampionScore(games, kills, deaths, assists);
			}
		}
		this.topRankingKDA = Utils.getKDA(totalKills, totalDeaths, totalAssists);

		// Determines the name of the top champion
		for (int i = 0; i < Data.champions.getData().size(); i++) {
			if (Data.champions.getData().get(i).getId().intValue() == champId) {
				this.topChampion = Data.champions.getData().get(i).getName();
				break;
			}
		}

		this.topChampionGames = champGames;
		this.topChampionKDA = champKDA;

		// Finds the summoners total wins and losses
		// Iterates through all stat entries
		int totalGamesPlayed = 0, totalGamesWon = 0;
		for (int j = 0; j < statsSize; j++) {
			LifetimeStatistics ls = ranked_stats.getData().getLifetimeStatistics().get(j);
			// Checks if it is championId 0 (0 is the Id for overall stats)
			if (ls.getChampionId().intValue() == 0) {
				// Checks if it is either wins of total games **losses are always displayed as 0 so it is instead found by (plays-wins)
				if (ls.getStatType().equals("TOTAL_SESSIONS_WON")) {
					totalGamesWon = ls.getValue().intValue();
				} else if (ls.getStatType().equals("TOTAL_SESSIONS_PLAYED")) {
					totalGamesPlayed = ls.getValue().intValue();
				}
			}
		}
		topRankingWins = totalGamesWon;
		topRankingLosses = totalGamesPlayed - totalGamesWon;
	}

}
