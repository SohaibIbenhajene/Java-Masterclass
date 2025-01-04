package dev.sohaib;

public class Place {
    private String town;
    private int distanceFromStart;

    public Place() {
    }

    public Place(String town, int distanceFromStart) {
        this.town = town;
        this.distanceFromStart = distanceFromStart;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", town, distanceFromStart);
    }

    public String getTown() {
        return town;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }
}
