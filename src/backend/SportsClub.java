/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

public abstract class SportsClub {

    protected String name;
    protected String location;
    protected String statistics;
    
    public abstract void save();

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((SportsClub) o).name);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setLocation(String s) {
        this.location = s;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setStatistics(String s) {
        this.statistics = s;
    }
}
