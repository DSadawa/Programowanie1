package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueT<T> {
    private String name;
    private  List<T> teams;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

      public LeagueT(String name){
        this.name = name;
        teams = new ArrayList<>();
    }

    public List<T> getTeams() {
        return teams;
    }

    boolean addTeam (T team) {
            if (!teams.contains(team)){
                System.out.println("Adding " + ((Team)team).getName() + "to " + name);
                return teams.add(team);
            }else System.out.println("Team" + ((Team)team).getName() + " already in league");
            return false;
    }
            public void printTable(){
            Collections.sort((List<Team>)teams);
            System.out.println(name + " table: ");
            for (T team : teams){
                System.out.println(((Team)team).getName() + " "+ ((Team)team).getPoints());
            }
        }

}


