package dev.sohaib;

enum UsageType {ENTERTAINMENT, GOVERNMENT, RESIDENTIAL, SPORTS}

public class Building implements Mappable{
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.POINT;
    }

    @Override
    public String getIcon() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + PointIcon.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointIcon.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointIcon.SQUARE;
            case SPORTS -> Color.ORANGE + " " + PointIcon.PUSH_PIN;
            default -> Color.BLACK + " " + PointIcon.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        String properties = """
                , "name": "%s", "type": "%s" """
                .formatted(name, usage);
        return Mappable.super.toJSON() + properties;
    }
}
