package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League{
    private String name;
    private  List<Team> teams;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Team> getTeams() {
        return teams;
    }


    public League (String name){
        this.name = name;
        teams = new ArrayList<>();
    }

    boolean addTeam (Team team) {
            if (!teams.contains(team)){
                System.out.println("Adding " + team.getName() + "to " + name);
                return teams.add(team);
            }else System.out.println(getName() + " already in league");
            return false;
    }
            public void printTable(){
            Collections.sort(teams);
            System.out.println(name + " table: ");
            for (Team team : teams){
                System.out.println( team.getName() + " "+ team.getPoints());
            }
        }

}


