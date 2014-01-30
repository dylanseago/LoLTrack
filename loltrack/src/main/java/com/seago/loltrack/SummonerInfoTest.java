package com.seago.loltrack;

class SummonerInfoTest {
	public boolean					success				= true;

	public String					region				= "NA";
	public String					name				= "Dyrus";
	public int						level				= 30;
	public int						summonerIconId		= 534;

	public String					topRanking			= "Challenger";
	public int						topRankingLP		= 219;
	public int						topRankingWins		= 820;
	public int						topRankingLosses	= 723;
	public double					topRankingKDA		= 2.24;

	public String					topChampion			= "Jayce";
	public int						topChampionGames	= 75;
	public int						topChampionWins		= 50;
	public int						topChampionLosses	= 25;
	public double					topChampionKDA		= 3.23;

	public int						normalWins			= 877;
	public int						timePlayed			= 0;

	public SummonerInfoTest(String region) {
		this.region = region;
	}
}
