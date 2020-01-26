package team;

import java.util.Objects;

public class LeagueTestT {
    public LeagueTestT() {
    }

    public static void main(String[] args) {

        Team footballTeam1 = new FootballTeam("Altletico");
        Team footballTeam2 = new FootballTeam("Real");
        Team footballTeam3 = new FootballTeam("Barcelona");
        Team footballTeam4 = new FootballTeam("Valencia");

        Team volleyballTeam1 = new VolleyballTeam();
        Team volleyballTeam2 = new VolleyballTeam();
        Team volleyballTeam3 = new VolleyballTeam();
        Team volleyballTeam4 = new VolleyballTeam();

        footballTeam1.setPoints(10);
        footballTeam2.setPoints(12);
        footballTeam3.setPoints(15);
        footballTeam4.setPoints(8);

        volleyballTeam1.setPoints(10);
        volleyballTeam1.setName("Skra");
        volleyballTeam2.setPoints(12);
        volleyballTeam2.setName("Zakra");
        volleyballTeam3.setPoints(15);
        volleyballTeam3.setName("Jastrzebski");
        volleyballTeam4.setPoints(8);
        volleyballTeam4.setName("du");

        LeagueT footballLeague = new LeagueT("Primiera Division");
        LeagueT volleyballLeague = new LeagueT("Plus Liga");

        footballLeague.addTeam(footballTeam1);
        footballLeague.addTeam(footballTeam2);
        footballLeague.addTeam(footballTeam3);
        footballLeague.addTeam(footballTeam4);
        volleyballLeague.addTeam(volleyballTeam1);
        volleyballLeague.addTeam(volleyballTeam2);
        volleyballLeague.addTeam(volleyballTeam3);
        volleyballLeague.addTeam(volleyballTeam4);


        volleyballLeague.printTable();
        System.out.println("--------------------");
        for (Object o : footballLeague.getTeams()) {
            System.out.println(((Team) o).getName());
        }
    }
}