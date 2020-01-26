package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueTeam<T extends Team> {
    private String name;
    private List<T> teams;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LeagueTeam(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public List<T> getTeams() {
        return teams;
    }

    boolean addTeam(T team) {
        if (!teams.contains(team)) {
            System.out.println("Adding " + team.getName() + "to " + name);
            return teams.add(team);
        } else System.out.println("Team" + team.getName() + " already in league");
        return false;
    }

    public void printTable() {
        Collections.sort(teams);
        System.out.println(name + " table: ");
        for (T team : teams) {
            System.out.println(team.getName() + " " + team.getPoints());
        }
    }

    public void printTableByStream() {
        Collections.sort(teams);
        System.out.println(name + " table: ");
        teams.stream().forEach(x -> System.out.println(x.getName() + " " + x.getPoints()));
    }
}

