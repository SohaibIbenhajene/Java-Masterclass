package dev.sohaib;

public class Main {
    public static void main(String[] args) {
        var nationalUSParks = new Park[] {
                new Park("Yellowstone", "44.4882, -110.5916"),
                new Park("Grand Canyon", "36.422, -112.5176"),
                new Park("Yosemite", "37.4882, -80.5916"),
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers = new River[] {
                new River("Mississippi",
                        "44.4882, -110.5916", "29.2445, -68.175",
                        "19.5739, -68.5473"),
                new River("Missouri",
                        "44.4882, -110.5916", "29.2445, -68.175",
                        "19.5739, -68.5473"),
        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);
        riverLayer.addElements(
                new River("Texas", "263.584, -325.292", "12.424, -35.525"),
                new River("Delaware", "263.584, -325.292", "12.424, -35.525"));

        riverLayer.renderLayer();
    }
}
