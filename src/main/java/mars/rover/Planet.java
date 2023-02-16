package mars.rover;

public class Planet {
    private final String name;
    private final Long distanceFromSun;
    public PlanetSurface planetSurface;

    private Integer receivedCommands;

    private Vehicle selectedVehicle;
    private Boolean verbose;

    public Planet(String name, Long distanceFromSun) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.receivedCommands = 0;
        this.verbose = false;
    }

    public String getName() {
        return name;
    }

    public Long getDistanceFromSun() {
        return distanceFromSun;
    }

    private String createSurfaceCommand(String receivedCommand) {
        if (!receivedCommand.matches("[ ]*([\\d]*)[ ]*([\\d]*)[ ]*"))
            return "Error command not surface specification";
        else {
            int x, y;
            String[] commandSplit = receivedCommand.trim().split(" ");

            x = Integer.parseInt(commandSplit[0]);
            y = Integer.parseInt(commandSplit[1]);

            this.planetSurface = new PlanetSurface(x, y);
            return "Surface Initialized";
        }
    }

    private String landRoverCommand(String receivedCommand) {
        if (!receivedCommand.matches("[ ]*([\\d]*)[ ]*([\\d]*)[ ]* [NESW][ ]*"))
            return "Error command not rover landing command";
        else {
            int x, y;
            String heading;
            String[] commandSplit = receivedCommand.trim().split(" ");

            x = Integer.parseInt(commandSplit[0]);
            y = Integer.parseInt(commandSplit[1]);
            heading = commandSplit[2];

            selectedVehicle = new Vehicle(x, y, Compass.valueOf(heading),
                    planetSurface.getXSize(), planetSurface.getYSize());
            return "Rover Landed";
        }
    }

    public String receivedCommand(String receivedCommand) {
        String commandResult = "pass through";
        receivedCommands++;

        if (receivedCommand == null || receivedCommand.matches(""))
            return "Error no command";

        if (receivedCommands == 1) {
            commandResult = createSurfaceCommand(receivedCommand);
            if (commandResult.matches("Error command not surface specification")) {
                receivedCommands--;
            } else {
                if (!verbose) {
                    commandResult = "";
                }
            }
        }

        if (receivedCommands == 2) {
            commandResult = landRoverCommand(receivedCommand);
            if (commandResult.matches("Error command not rover landing command")) {
                receivedCommands--;
            } else {
                if (!verbose) {
                    commandResult = "";
                }
            }
        }

//        if (receivedCommands > 2)
//            commandResult = runTimeCommand(receivedCommand);

        return commandResult;
    }
}
