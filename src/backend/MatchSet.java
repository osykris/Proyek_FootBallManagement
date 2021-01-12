/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class MatchSet extends SportsClub {

    public int idMatch;
    public String group;
    public String HomeTeam;
    public String AwayTeam;
    public String MatchDate;
    public int MatchTime;

    public MatchSet() {

    }

    public MatchSet(int idMatch, String group, String HomeTeam, String AwayTeam, String MatchDate, int MatchTime) {
        this.idMatch = idMatch;
        this.group = group;
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;
        this.MatchDate = MatchDate;
        this.MatchTime = MatchTime;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setHomeTeam(String HomeTeam) {
        this.HomeTeam = HomeTeam;
    }

    public String getHomeTeam() {
        return HomeTeam;
    }

    public void setAwayTeam(String AwayTeam) {
        this.AwayTeam = AwayTeam;
    }

    public String getAwayTeam() {
        return AwayTeam;
    }

    public void setMatchDate(String MatchDate) {
        this.MatchDate = MatchDate;
    }

    public String GetMatchDate() {
        return MatchDate;
    }

    public void setMatchTime(int MatchTime) {
        this.MatchTime = MatchTime;
    }

    public int GetMatchTime() {
        return MatchTime;
    }

    public MatchSet getById(int idMatch) {
        MatchSet ms = new MatchSet();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM matchfootball " + " WHERE idMatch = '" + idMatch + "'");

        try {
            while (rs.next()) {
                ms = new MatchSet();
                ms.setIdMatch(rs.getInt("idMatch"));
                ms.setGroup(rs.getString("group"));
                ms.setHomeTeam(rs.getString("HomeTeam"));
                ms.setAwayTeam(rs.getString("AwayTeam"));
                ms.setMatchDate(rs.getString("MatchDate"));
                ms.setMatchTime(rs.getInt("MatchTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ms;
    }

    public ArrayList<MatchSet> getAllMatch() {
        ArrayList<MatchSet> ListMatch = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM matchfootball ");
        try {
            while (rs.next()) {
                MatchSet ms = new MatchSet();
                ms.setIdMatch(rs.getInt("idMatch"));
                ms.setGroup(rs.getString("group"));
                ms.setHomeTeam(rs.getString("HomeTeam"));
                ms.setAwayTeam(rs.getString("AwayTeam"));
                ms.setMatchDate(rs.getString("MatchDate"));
                ms.setMatchTime(rs.getInt("MatchTime"));

                ListMatch.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMatch;
    }

    public ArrayList<MatchSet> searchMatch(int keyword) {
        ArrayList<MatchSet> ListMatch = new ArrayList();
        String sql = "SELECT * FROM matchfootball WHERE "
                + "       idMatch LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                MatchSet ms = new MatchSet();
                ms.setIdMatch(rs.getInt("idMatch"));
                ms.setGroup(rs.getString("group"));
                ms.setHomeTeam(rs.getString("HomeTeam"));
                ms.setAwayTeam(rs.getString("AwayTeam"));
                ms.setMatchDate(rs.getString("MatchDate"));
                ms.setMatchTime(rs.getInt("MatchTime"));

                ListMatch.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListMatch;
    }

    @Override
    public void save() {
        if (getById(idMatch).getIdMatch() == 0) {
            String SQL = "INSERT INTO matchfootball (group, HomeTeam, AwayTeam, MatchDate, MatchTime) VALUES("
                    + "'" + this.group + "', "
                    + "'" + this.HomeTeam + "', "
                    + "'" + this.AwayTeam + "', "
                    + "'" + this.MatchDate + "', "
                    + "'" + this.MatchTime + "')";
           this.idMatch = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE matchfootball SET"
                    + "      group = '" + this.group + "', "
                    + "      played = '" + this.HomeTeam + "', "
                    + "      win = '" + this.AwayTeam + "', "
                    + "      draw = '" + this.MatchDate + "', "
                    + "      points = '" + this.MatchTime + "'"
                     + "     WHERE idMatch = '" + this.idMatch + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM matchfootball WHERE idMatch= '" + this.idMatch + "'";
        DBHelper.executeQuery(SQL);
    }
}
