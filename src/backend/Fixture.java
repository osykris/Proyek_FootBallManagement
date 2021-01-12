/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class Fixture extends Team{
    protected String group;
    protected String name;
    

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Fixture> getAllFixture() {
        ArrayList<Fixture> ListFixture= new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM fixture");

        try {
            while (rs.next()) {
                Fixture f = new Fixture();
                f.setGroup(rs.getString("group"));
                f.setName(rs.getString("Team_Name"));
                ListFixture.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListFixture;
    }
}
