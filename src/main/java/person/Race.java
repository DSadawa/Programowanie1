package person;

import java.util.ArrayList;
import java.util.List;
public class Race implements Comparable<Race>{
    private String raceName;
    private List<Person> drivers;
    private int minimalAge;
    private int raceYear;
    public boolean addDriver(Person driver){
        if(isDriverOnList(driver)){
            System.out.println("Kierowca " + driver.getLastName() + " " + driver.getFirstName() + " jest już na liście.");
            return false;
        }
        if (driver.getAge() > minimalAge){
            System.out.println("Kierowca " + driver.getLastName() + " " + driver.getFirstName() + " dodany.");
            return drivers.add(driver);
        }
        System.out.printf("Kierowca za młody!");
        return false;
    }
    public boolean removeDriver(Person driver){
        if (!isDriverOnList(driver)){
            System.out.println("Kierowcy " + driver.getLastName() + " " + driver.getFirstName() + " nie ma na liście.");
            return false;
        }
        System.out.println("Kierowca " + driver.getLastName() + " " + driver.getFirstName() + " został usunięty z listy.");
        return drivers.remove(driver);
    }
    private boolean isDriverOnList(Person driver) {
        return drivers.indexOf(driver) >= 0;
    }
    public Race(String raceName, int minimalAge) {
        this.raceName = raceName;
        this.minimalAge = minimalAge;
        drivers = new ArrayList<>();
    }
    public Race(String raceName) {
        this.raceName = raceName;
        drivers = new ArrayList<>();
    }
    public String getRaceName() {
        return raceName;
    }
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
    public List<Person> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Person> drivers) {
        this.drivers = drivers;
    }
    public int getMinimalAge() {
        return minimalAge;
    }
    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }
    public int getRaceYear() {
        return raceYear;
    }
    public void setRaceYear(int raceYear) {
        this.raceYear = raceYear;
    }

    @Override
    public int compareTo(Race o) {
        return o.getMinimalAge() - minimalAge;
    }
}