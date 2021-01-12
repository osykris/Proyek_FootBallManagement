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
public class Player extends Team {

    private int Player_ID;
    private String Name;
    private String Team_Preference;
    private String Position;
    private String Country_Name;

    public Player() {

    }

    public Player(int Player_ID, int Team_ID, String Name, String Team_Preference, String Position, String Country_Name) {
        this.Player_ID = Player_ID;
        this.Team_ID = Team_ID;
        this.Name = Name;
        this.Team_Preference = Team_Preference;
        this.Position = Position;
        this.Country_Name = Country_Name;
    }
    
    public void setIdPlayer(int Player_ID) {
        this.Player_ID = Player_ID;
    }

    public int getPlayer_ID() {
        return Player_ID;
    }

    @Override
    public void setIdTeam(int Team_ID) {
        this.Team_ID = Team_ID;
    }

    @Override
    public int getIdTeam() {
        return Team_ID;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String getName() {
        return Name;
    }

    public void setTeam_Preference(String Team_Preference) {
        this.Team_Preference = Team_Preference;
    }

    public String getTeam_Preference() {
        return Team_Preference;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getPosition() {
        return Position;
    }

    public void setCountry_Name(String Country_Name) {
        this.Country_Name = Country_Name;
    }

    public String getCountry_Name() {
        return Country_Name;
    }


    @Override
    public Player getById(int id) {
        Player pl = new Player();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM player_info " + " WHERE Player_ID = '" + id + "'");

        try {
            while (rs.next()) {
                pl = new Player();
                pl.setIdPlayer(rs.getInt("Player_ID"));
                pl.setIdTeam(rs.getInt("Team_ID"));
                pl.setName(rs.getString("Name"));
                pl.setTeam_Preference(rs.getString("Team_Preference"));
                pl.setPosition(rs.getString("Position"));
                pl.setCountry_Name(rs.getString("Country_Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pl;
    }

    public ArrayList<Player> getAllPlayer() {
        ArrayList<Player> ListPlayer = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM player_info");

        try {
            while (rs.next()) {
                Player pl = new Player();
                pl.setIdPlayer(rs.getInt("Player_ID"));
                pl.setIdTeam(rs.getInt("Team_ID"));
                pl.setName(rs.getString("Name"));
                pl.setTeam_Preference(rs.getString("Team_Preference"));
                pl.setPosition(rs.getString("Position"));
                pl.setCountry_Name(rs.getString("Country_Name"));

                ListPlayer.add(pl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPlayer;
    }

    public ArrayList<Player> searchPlayer(String keyword) {
        ArrayList<Player> ListPlayer = new ArrayList();
        String sql = "SELECT * FROM player_info WHERE "
                + "       Name LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Player pl = new Player();
               pl.setIdPlayer(rs.getInt("Player_ID"));
                pl.setIdTeam(rs.getInt("Team_ID"));
                pl.setName(rs.getString("Name"));
                pl.setTeam_Preference(rs.getString("Team_Preference"));
                pl.setPosition(rs.getString("Position"));
                pl.setCountry_Name(rs.getString("Country_Name"));

                ListPlayer.add(pl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPlayer;
    }

    @Override
    public void save() {
        if (getById(Player_ID).getPlayer_ID() == 0) {
            String SQL = "INSERT INTO player_info (Team_ID, Name, Team_Preference, Position, Country_Name) VALUES("
                    + "      '" + this.Team_ID + "', "
                    + "      '" + this.Name + "', "
                    + "      '" + this.Team_Preference + "', "
                    + "      '" + this.Position + "', "
                    + "      '" + this.Country_Name + "')";
            this.Player_ID = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE player_info SET"
                    + "      Team_ID = '" + this.Team_ID + "', "
                    + "      Name = '" + this.Name + "', "
                    + "      Team_Preference = '" + this.Team_Preference + "', "
                    + "      Position = '" + this.Position + "', "
                    + "      Country_Name = '" + this.Country_Name + "' "
                    + "     WHERE Player_ID = '" + this.Player_ID + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM player_info WHERE Player_ID = '" + this.Player_ID + "'";
        DBHelper.executeQuery(SQL);
    }
}
