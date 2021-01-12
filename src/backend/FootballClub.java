/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author ACER
 */
public class FootballClub extends SportsClub {

    protected int winCount;
    protected int drawCount;
    protected int defeatCount;
    protected int scoredGoalsCount;
    protected int receivedGoalsCount;
    protected int points;
    protected int matchesPlayed;

    public int getWinCount() {
        return winCount;
    }

    public int getDrawCount() {
        return drawCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public int getScoredGoalsCount() {
        return scoredGoalsCount;
    }

    public int getReceivedGoalsCount() {
        return receivedGoalsCount;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setWinCount(int i) {
        winCount = i;
    }

    public void setDrawCount(int i) {
        drawCount = i;
    }

    public void setDefeatCount(int i) {
        defeatCount = i;
    }

    public void setScoredGoalsCount(int i) {
        scoredGoalsCount = i;
    }

    public void setRecievedGoalsCount(int i) {
        receivedGoalsCount = i;
    }

    public void setPoints(int i) {
        points = i;
    }

    public void setMatchesPlayed(int i) {
        matchesPlayed = i;
    }

    @Override
    public void save() {
        System.out.println("This is a Football League");
    }

}
