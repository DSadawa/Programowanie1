package team;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueTestTeam {
    public LeagueTestTeam() {
    }

    public static void main(String[] args) {

        FootballTeam footballTeam1 = new FootballTeam("Altletico");
        FootballTeam footballTeam2 = new FootballTeam("Real");
        Team footballTeam3 = new FootballTeam("Barcelona");
        Team footballTeam4 = new FootballTeam("Valencia");

        VolleyballTeam volleyballTeam1 = new VolleyballTeam();
        VolleyballTeam volleyballTeam2 = new VolleyballTeam();
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

        LeagueTeam<FootballTeam> footballLeague = new LeagueTeam("Primiera Division");
        LeagueTeam<VolleyballTeam> volleyballLeague = new LeagueTeam("Plus Liga");

        footballLeague.addTeam(footballTeam1);
        footballLeague.addTeam(footballTeam2);
        footballLeague.addTeam((FootballTeam) footballTeam3);
        footballLeague.addTeam((FootballTeam) footballTeam4);
        volleyballLeague.addTeam(volleyballTeam1);
        volleyballLeague.addTeam(volleyballTeam2);
        volleyballLeague.addTeam((VolleyballTeam) volleyballTeam3);
        volleyballLeague.addTeam((VolleyballTeam) volleyballTeam4);


        volleyballLeague.printTable();

        System.out.println("--------------------");
        for (FootballTeam o : footballLeague.getTeams()) {
            System.out.println(o.getName());
        }
        System.out.println("--------------------");
        System.out.println("Stream print: ");
        footballLeague.getTeams().stream()
                .forEach(x -> System.out.println(x.getName()));

        System.out.println("--------------------");
        System.out.println("Stream print with maping teams to names: ");
        footballLeague.getTeams().stream()
                .map(x -> x.getName())
                .forEach(x -> System.out.println(x));

        System.out.println("--------------------");
        System.out.println("Stream print with maping teams to names v2: ");
        footballLeague.getTeams().stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("Stream print with maping teams to names v3: ");
        footballLeague.getTeams().stream()
                .map(Team::getName)
                .forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("Stream print with maping teams to names and limit to 2: ");
        footballLeague.getTeams().stream()
                .limit(2).map(Team::getName)
                .forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("Stream print with maping teams " + "to names were points > 10: ");
        footballLeague.getTeams().stream()
                .filter(x -> x.getPoints() > 10).map(Team::getName)
                .forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("League copy with teams where points > 10: ");
        List<FootballTeam> teamCopy = footballLeague.getTeams().stream()
                .filter(x -> x.getPoints() > 10)
                .collect(Collectors.toList());
        teamCopy.stream().forEach(x -> System.out.println(x.getName()));

        List<FootballTeam> teamCopy2 = footballLeague.getTeams();


        //łączenie strumieni
        System.out.println("--------------------");
        List<FootballTeam> teamConcat =
                Stream.concat(teamCopy.stream(),
                        teamCopy2.stream())
                        .collect(Collectors.toList());
        //strumień zakończony. mamy liste drużyn

        //łączenie sttrumieni v2
        List<FootballTeam> teamConcat2 =
                Stream.of(teamCopy, teamCopy2)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());

        //Lista nazw drużyn z listy drużyn
        List<String> teamNamesList = teamConcat2.stream()
                .map(Team::retriveName)
                .collect(Collectors.toList());

        Set<String> teamNamesSet = teamConcat2.stream()
                .map(Team::retriveName)
                .collect(Collectors.toSet());

        System.out.println("====ListPrint====");
        teamNamesList.stream().forEach(System.out::println);

        System.out.println("====SetPrint====");
        teamNamesSet.stream().forEach(System.out::println);

        System.out.println(".....................");
        //suma punktów druzyny
        int sumPoints = footballLeague.getTeams().stream()
                .map(Team::getPoints)
                .reduce(0, Integer::sum);

        System.out.println("Sum of points: " + sumPoints);

        //zliczanie elementów
        System.out.println("----Sum of elements----");
        long countElements1 = footballLeague.getTeams().stream()
                .map(Team::getPoints)
                .count();

        long countElements2 = footballLeague.getTeams().stream()
                .count();

        long countElements3 = footballLeague.getTeams().stream()
                .filter(x -> x.getPoints() > 8)
                .count();
        System.out.println("Count 1: " + countElements1);
        System.out.println("Count 2: " + countElements2);
        System.out.println("Count 3: " + countElements3);

        //suma punktów drużyn gdzie ma co najmniej 10 punktów
        sumPoints = footballLeague.getTeams().stream()
                .filter(x -> x.getPoints() >= 10)
                .map(Team::getPoints)
                .reduce(0, Integer::sum);

        sumPoints = footballLeague.getTeams().stream()
                .map(Team::getPoints)
                .filter(x -> x >= 10)
                .reduce(0, Integer::sum);

        System.out.println("=================================");

        Integer max = footballLeague.getTeams().stream()
                .mapToInt(t -> t.getPoints())
                .max()
                .orElse(new Integer(0));
        System.out.println("max: " + max);

        Team teamExpected = footballLeague.getTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("max from team " + teamExpected.getPoints());

        Integer max2 = footballLeague.getTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .map(Team::getPoints)
                .orElseThrow(NoSuchElementException::new);
        System.out.println("max2: " + max2);

        Optional<Integer> max3 = footballLeague.getTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .map(Team::getPoints);
        if (max3.isPresent()) System.out.println("max3: " + max3);

    }
}