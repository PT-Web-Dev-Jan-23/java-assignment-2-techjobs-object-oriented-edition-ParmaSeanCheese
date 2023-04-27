package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String noData = "Data not available";
        if (this.getName().equals("") && this.getEmployer().getValue().equals("") && this.getLocation().getValue().equals("") && this.getPositionType().getValue().equals("") && this.getCoreCompetency().getValue().equals("")){
            return "OOPS! This job does not seem to exist.";
        }
        if (this.getName().equals("")){
            this.setName(noData);
        }
        if (this.getEmployer().getValue().equals("")){
            this.setEmployer(new Employer(noData));
        }
        if (this.getLocation().getValue().equals("")){
            this.setLocation(new Location(noData));
        }
        if (this.getPositionType().getValue().equals("")){
            this.setPositionType(new PositionType(noData));
        }
        if (this.getCoreCompetency().getValue().equals("")){
            this.setCoreCompetency(new CoreCompetency(noData));
        }


//
        return "\n" +
                "ID: " + this.getId() + "\n" +
                "Name: " + this.getName() + "\n" +
                "Employer: " + this.getEmployer().getValue() + "\n" +
                "Location: " + this.getLocation().getValue() + "\n" +
                "Position Type: " + this.getPositionType().getValue() + "\n" +
                "Core Competency: " + this.getCoreCompetency().getValue() +
                "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
