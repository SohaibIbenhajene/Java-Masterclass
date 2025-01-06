package dev.sohaib;

enum UtilityType {ELECTRICAL, FIBER_OPTIC, GAS, WATER}

public class UtilityLine implements Mappable {
    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.LINE;
    }

    @Override
    public String getIcon() {
        return switch (type) {
            case ELECTRICAL -> Color.RED + " " + LineIcon.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineIcon.DOTTED;
            case GAS -> Color.ORANGE + " " + LineIcon.SOLID;
            case WATER -> Color.BLUE + " " + LineIcon.SOLID;
            default -> Color.BLACK + " " + LineIcon.SOLID;
        };
    }

    @Override
    public String toJSON() {
        String properties = """
                , "name": "%s", "utility": "%s" """
                .formatted(name, type);
        return Mappable.super.toJSON() + properties;
    }
}
