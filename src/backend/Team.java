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
public class Team extends FootballClub{
    protected int Team_ID ;
    protected String Team_Name;
    protected int Year_Founded;

    public void setIdTeam(int Team_ID ) {
        this.Team_ID = 	Team_ID;
    }

    public int getIdTeam() {
        return	Team_ID ;
    }

    @Override
    public void setName(String Team_Name) {
        this.Team_Name = Team_Name;
    }

    @Override
    public String getName() {
        return 	Team_Name;
    }

    public void setTahun(int Year_Founded) {
        this.Year_Founded = Year_Founded;
    }

    public int getTahun() {
        return Year_Founded;
    }

    public Team() {

    }

    public Team(int Team_ID , String namaTeam, int Year_Founded) {
        this.Team_ID  = Team_ID ;
        this.Team_Name = namaTeam;
        this.Year_Founded = Year_Founded;
    }

    public Team getById(int id) {
        Team tm = new Team();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM team " + " WHERE Team_ID = '" + id + "'");

        try {
            while (rs.next()) {
                tm = new Team();
                tm.setIdTeam(rs.getInt("Team_ID"));
                tm.setName(rs.getString("Team_Name"));
                tm.setTahun(rs.getInt("Year_Founded"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public ArrayList<Team> getAll() {
        ArrayList<Team> ListTeam = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM team");

        try {
            while (rs.next()) {
                Team tm = new Team();
                tm.setIdTeam(rs.getInt("Team_ID"));
                tm.setName(rs.getString("Team_Name"));
                tm.setTahun(rs.getInt("Year_Founded"));

                ListTeam.add(tm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTeam;
    }

    public ArrayList<Team> search(String keyword) {
        ArrayList<Team> ListTeam = new ArrayList();
        String sql = "SELECT * FROM team WHERE "
                + "       Team_Name LIKE '%" + keyword + "%' ";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Team tm = new Team();
                tm.setIdTeam(rs.getInt("Team_ID"));
                tm.setName(rs.getString("Team_Name"));
                tm.setTahun(rs.getInt("Year_Founded"));

                ListTeam.add(tm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTeam;
    }

    @Override
    public void save() {
        if (getById(Team_ID).getIdTeam() == 0) {
            String SQL = "INSERT INTO team (Team_Name, Year_Founded) VALUES("
                    + "      '" + this.Team_Name + "', "
                    + "      '" + this.Year_Founded + "')";
            this.Team_ID= DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE team SET"
                    + "     Team_Name = '" + this.Team_Name + "', "
                    + "     Year_Founded = '" + this.Year_Founded + "' "
                    + "     WHERE Team_ID = '" + this.Team_ID + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM team WHERE Team_ID = '" + this.Team_ID + "'";
        DBHelper.executeQuery(SQL);
    }
}
