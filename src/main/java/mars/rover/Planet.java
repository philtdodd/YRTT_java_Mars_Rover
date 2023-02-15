package mars.rover;

public class Planet {
    private final String name;
    private final Long distanceFromSun;
    public PlanetSurface planetSurface;

    private Integer receivedCommands;

    public Planet(String name, Long distanceFromSun) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.receivedCommands = 0;
    }

    public String getName() {
        return name;
    }

    public Long getDistanceFromSun() {
        return distanceFromSun;
    }

    private String createSurfaceCommand(String receivedCommand) {
        if (!receivedCommand.matches("[ ]*([\\d]*)[ ]*([\\d]*)[ ]*"))
            return "Error for command not Surface";
        else {
            int x, y;
            String[] commandSplit = receivedCommand.trim().split(" ");

            x = Integer.parseInt(commandSplit[0]);
            y = Integer.parseInt(commandSplit[1]);

            this.planetSurface = new PlanetSurface(x, y);
            return "Surface Initialized";
        }
    }

    public String receivedCommand(String receivedCommand) {
        String commandResult = "pass through";
        receivedCommands++;

        if (receivedCommand == null || receivedCommand.matches(""))
            return "Error no command";

        if (receivedCommands == 1)
            commandResult = createSurfaceCommand(receivedCommand);

        if (receivedCommands == 2)
//            commandResult = landRoverCommand(receivedCommand);
;
        return commandResult;
    }
}
