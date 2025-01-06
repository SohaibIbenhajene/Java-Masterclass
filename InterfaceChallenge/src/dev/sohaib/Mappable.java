package dev.sohaib;

public interface Mappable {
    String JSON_PROPERTY = """
            "properties": {%s} """;

    String getLabel();
    GeometryType getGeometryType();
    String getIcon();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getGeometryType(), getLabel(), getIcon());
    }

    static void printProperties(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}
