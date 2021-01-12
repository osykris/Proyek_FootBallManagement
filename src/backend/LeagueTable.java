/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class LeagueTable extends Team{
    public int ID;
    public String Team_Name;
    public int played;
    public int win;
    public int draw;
    public int loss;
    public int points;
 
    
    public LeagueTable(){
        
    }
    public LeagueTable( int ID, String Team_Name, int played, int win, int draw, int loss, int points) {
        this.ID = ID;
        this.Team_Name = Team_Name;
        this.played = played;
        this.win = win;
        this.draw = draw;
        this.loss = loss;
        this.points = points;
       
    }
       
    public void setID_League(int ID){
        this.ID = ID;
    }
    
    public int getID_League(){
        return ID;
    }
    
    @Override
    public void setName(String Team_Name) {
        this.Team_Name = Team_Name;
    }

    @Override
    public String getName() {
        return 	Team_Name;
    }

    @Override
    public void setMatchesPlayed(int played) {
        this.played = played;
    }
    
    @Override
    public int getMatchesPlayed(){
        return played;
    }
    
    @Override
    public void setWinCount(int win){
        this.win = win;
    }
    
    @Override
    public int getWinCount(){
        return win;
    }
    
    @Override
    public void setDrawCount(int draw){
        this.draw = draw;
    }
    
    @Override
    public int getDrawCount(){
        return draw;
    }
    
    @Override
    public void setDefeatCount(int loss){
        this.loss = loss;
    }
    
    @Override
    public int getDefeatCount(){
        return loss;
    }
    
    @Override
    public void setPoints(int points){
        this.points = points;
    }
    
    @Override
    public int getPoints(){
        return points;
    }
 
    @Override
    public LeagueTable getById(int ID) {
        LeagueTable lt = new LeagueTable();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM league_table " + " WHERE ID = '" + ID + "'");

        try {
            while (rs.next()) {
                lt = new LeagueTable();
                lt.setID_League(rs.getInt("ID"));
                lt.setName(rs.getString("Team_Name"));
                lt.setMatchesPlayed(rs.getInt("played"));
                lt.setWinCount(rs.getInt("win"));
                lt.setDrawCount(rs.getInt("draw"));
                lt.setDefeatCount(rs.getInt("loss"));
                lt.setDefeatCount(rs.getInt("points"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lt;
    }
    
     public ArrayList<LeagueTable> searchLeague(String keyword) {
        ArrayList<LeagueTable> ListLeague = new ArrayList();
        String sql = "SELECT * FROM league_table WHERE "
                + "       Team_Name LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
           while (rs.next()) {
                LeagueTable lt = new LeagueTable();
                lt.setID_League(rs.getInt("ID"));
                lt.setName(rs.getString("Team_Name"));
                lt.setMatchesPlayed(rs.getInt("played"));
                lt.setWinCount(rs.getInt("win"));
                lt.setDrawCount(rs.getInt("draw"));
                lt.setDefeatCount(rs.getInt("loss"));
                lt.setPoints(rs.getInt("points"));           

                ListLeague.add(lt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListLeague;
    }
    
    public ArrayList<LeagueTable> getAllLeagueTable() {
        ArrayList<LeagueTable> ListLeague = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM league_table");

        try {
            while (rs.next()) {
                LeagueTable lt = new LeagueTable();
                lt.setID_League(rs.getInt("ID"));
                lt.setName(rs.getString("Team_Name"));
                lt.setMatchesPlayed(rs.getInt("played"));
                lt.setWinCount(rs.getInt("win"));
                lt.setDrawCount(rs.getInt("draw"));
                lt.setDefeatCount(rs.getInt("loss"));
                lt.setPoints(rs.getInt("points"));           

                ListLeague.add(lt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListLeague;
    }
    
    @Override
    public void save() {
        if (getById(ID).getID_League() == 0) {
            String SQL = "INSERT INTO league_table (Team_Name, played, win, draw, loss, points) VALUES("
                    + "      '" + this.Team_Name + "', "
                    + "      '" + this.played + "', "
                    + "      '" + this.win + "', "
                    + "      '" + this.draw + "', "
                    + "      '" + this.loss + "', "
                    + "      '" + this.points + "')";
           this.ID = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE league_table SET"
                    + "      Team_Name = '" + this.Team_Name + "', "
                    + "      played = '" + this.played + "', "
                    + "      win = '" + this.win + "', "
                    + "      draw = '" + this.draw + "', "
                    + "      loss = '" + this.loss + "', "
                    + "      points = '" + this.points + "'"
                     + "     WHERE ID = '" + this.ID + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    @Override
    public void delete() {
        String SQL = "DELETE FROM league_table WHERE ID = '" + this.ID + "'";
        DBHelper.executeQuery(SQL);
    }
}
