package team;

public abstract class Team implements Comparable<Team>{
    private int points;
    private String name;

    public Team(){
    }

    public Team(String name) {
        this.name = name;
    }

    /**
     * use retriveName method
     * @return team name
     */

    @Deprecated
    public String getName(){
        return name;
    }
    public String retriveName() { return name; }

    public int getPoints() {
        return points;
    }


    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Team o) {
if(this.points > o.getPoints()) return -1;
if(this.points== o.getPoints()) return 0;
return  1;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
