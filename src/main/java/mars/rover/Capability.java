package mars.rover;

public class Capability {
    private final Integer id;
    private final String name;
    private final String description;
    private final CapabilityType capability;

    public Capability(Integer id, String name, String description, CapabilityType capability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capability = capability;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CapabilityType getCapability() {
        return capability;
    }

    public void performCapability() {

    }

    public String sendResult() {
        return "Result";
    }
}
