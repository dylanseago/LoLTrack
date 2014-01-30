package com.seago.loltrack.statRetriever;

import com.seago.loltrack.statRetriever.statLeagues.Leagues;
import com.seago.loltrack.statRetriever.statMastery_pages.Mastery_pages;
import com.seago.loltrack.statRetriever.statRanked_stats.Ranked_stats;
import com.seago.loltrack.statRetriever.statRecent_games.Recent_games;
import com.seago.loltrack.statRetriever.statRune_pages.Rune_pages;
import com.seago.loltrack.statRetriever.statSummoner.Summoner;
import com.seago.loltrack.statRetriever.statSummoner_team_info.Summoner_team_info;
import com.seago.loltrack.statRetriever.statPlayer_stats.Player_stats;

public class Player {
	private String				region				= null;
	private Summoner summoner			= null;
	private Player_stats		player_stats		= null;
	private Summoner_team_info summoner_team_info	= null;
	private Recent_games recent_games		= null;
	private Leagues leagues				= null;
	private Ranked_stats ranked_stats		= null;
	private Mastery_pages mastery_pages		= null;
	private Rune_pages rune_pages			= null;

	public Player(String region) {
		this.setRegion(region);
	}

	public Player(String region, Summoner summoner, Player_stats player_stats, Ranked_stats ranked_stats, Leagues leagues, Recent_games recent_games,
			Summoner_team_info summoner_team_info, Mastery_pages mastery_pages, Rune_pages rune_pages) {
		this.setRegion(region);
		this.setSummoner(summoner);
		this.setPlayer_stats(player_stats);
		this.setRanked_stats(ranked_stats);
		this.setLeagues(leagues);
		this.setRecent_games(recent_games);
		this.setSummoner_team_info(summoner_team_info);
		this.setMastery_pages(mastery_pages);
		this.setRune_pages(rune_pages);
	}


	public String getRegion() {
		return region;
	}

	void setRegion(String region) {
		this.region = region;
	}

	public Summoner getSummoner() {
		return summoner;
	}

	public void setSummoner(Summoner summoner) {
		this.summoner = summoner;
	}

	public Player_stats getPlayer_stats() {
		return player_stats;
	}

	public void setPlayer_stats(Player_stats player_stats) {
		this.player_stats = player_stats;
	}

	public Summoner_team_info getSummoner_team_info() {
		return summoner_team_info;
	}

	public void setSummoner_team_info(Summoner_team_info summoner_team_info) {
		this.summoner_team_info = summoner_team_info;
	}

	public Recent_games getRecent_games() {
		return recent_games;
	}

	void setRecent_games(Recent_games recent_games) {
		this.recent_games = recent_games;
	}

	public Leagues getLeagues() {
		return leagues;
	}

	public void setLeagues(Leagues leagues) {
		this.leagues = leagues;
	}

	public Ranked_stats getRanked_stats() {
		return ranked_stats;
	}

	public void setRanked_stats(Ranked_stats ranked_stats) {
		this.ranked_stats = ranked_stats;
	}

	public Mastery_pages getMastery_pages() {
		return mastery_pages;
	}

	void setMastery_pages(Mastery_pages mastery_pages) {
		this.mastery_pages = mastery_pages;
	}

	public Rune_pages getRune_pages() {
		return rune_pages;
	}

	void setRune_pages(Rune_pages rune_pages) {
		this.rune_pages = rune_pages;
	}
}
