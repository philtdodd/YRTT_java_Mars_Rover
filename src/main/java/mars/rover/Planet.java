package mars.rover;

public class Planet {
    private final String name;
    private final Long distanceFromSun;
    public PlanetSurface planetSurface;

    private Integer receivedCommands;

    public Vehicle selectedVehicle;
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
            return "ERROR: command not surface specification";
        else {
            int x, y;
            String[] commandSplit = receivedCommand.trim().split("\\s+");

            x = Integer.parseInt(commandSplit[0]);
            y = Integer.parseInt(commandSplit[1]);

            this.planetSurface = new PlanetSurface(x, y, false);
            return "VERBOSE: Surface Initialized";
        }
    }

    private String landRoverCommand(String receivedCommand) {
        if (!receivedCommand.matches("[ ]*([\\d]*)[ ]*([\\d]*)[ ]* [NESW][ ]*"))
            return "ERROR: command not rover landing command";
        else {
            int x, y;
            String heading;
            String[] commandSplit = receivedCommand.trim().split("\\s+");

            x = Integer.parseInt(commandSplit[0]);
            y = Integer.parseInt(commandSplit[1]);
            heading = commandSplit[2];

            Compass compassHeading = Compass.valueOfCompass(heading);

            if (x <= planetSurface.getXSize() && y <= planetSurface.getYSize()) {
                selectedVehicle = new Vehicle(x, y, compassHeading,
                        planetSurface.getXSize(), planetSurface.getYSize(),
                        planetSurface.getGlobe(),
                        1);
                return "VERBOSE: Rover Landed";
            } else {
                return "ERROR: Parameters out of bounds, rover crash landed.";
            }
        }
    }

    private String displayMap() {
        String returnResult = "";
        String mapHeader = "";

        for (Integer x = 0; x <= planetSurface.getXSize(); x++)
            mapHeader += "+---";
        mapHeader += "+\n";

        returnResult += mapHeader;
        for (Integer y = planetSurface.getYSize(); y >= 0; y--) {
            for (Integer x = 0; x <= planetSurface.getXSize(); x++) {
                if (x == selectedVehicle.getX() && y == selectedVehicle.getY()) {
                    String vehicleDetails = "|R" + selectedVehicle.getId() + "";
                    for (Integer i = vehicleDetails.length(); i < 4; i++) vehicleDetails += " ";
                    returnResult += vehicleDetails;
                } else
                    returnResult += "|   ";
            }

            returnResult += "|\n";
            returnResult += mapHeader;
        }

        return returnResult;
    }

    private String runTimeCommand(String receivedCommand) {
        if (!receivedCommand.matches("[ ]*(([LRMD]*)[ ]*)*[ ]*"))
            return "ERROR: command not rover landing command";
        else {
            String heading;
            String commandTidied = receivedCommand.replaceAll(" ", "");
            Boolean displayMap = false;
            String returnResult = "";

            // Check if Display Map requested.
            if (receivedCommand.contains("D"))
                displayMap = true;

            for (Integer i = 0; i < commandTidied.length(); i++) {
                switch (commandTidied.substring(i, i + 1)) {
                    case "L":
                        selectedVehicle.rotateLeft();
                        break;
                    case "R":
                        selectedVehicle.rotateRight();
                        break;
                    case "M":
                        selectedVehicle.move();
                        break;
                }
            }

            // Display Map.
            if (displayMap)
                returnResult += displayMap();

            returnResult += selectedVehicle.getLocation();

            return returnResult;
        }
    }

    public String receivedCommand(String receivedCommand) {
        String commandResult = "pass through";
        receivedCommands++;

        // Check for Verbose Response and toggle setting
        if (receivedCommand.contains("V")) {
            receivedCommand = receivedCommand.replaceAll("V", "");
            if (verbose)
                verbose = false;
            else
                verbose = true;
        }

        if (receivedCommand == null || receivedCommand.matches(""))
            return "ERROR no command";

        if (receivedCommands == 1) {
            commandResult = createSurfaceCommand(receivedCommand);
            if (commandResult.matches("ERROR: command not surface specification")) {
                receivedCommands--;
            }
        }

        if (receivedCommands == 2 || receivedCommand.matches("[ ]*([\\d]*)[ ]*([\\d]*)[ ]* [NESW][ ]*")) {
            commandResult = landRoverCommand(receivedCommand);
            if (commandResult.matches("ERROR: command not rover landing command")) {
                receivedCommands--;
            }
        } else if (receivedCommands > 2)
            commandResult = runTimeCommand(receivedCommand);

        if (!commandResult.contains("ERROR:") && (!verbose && commandResult.contains("VERBOSE: ")))
            commandResult="";
        else
            commandResult = commandResult.replace("VERBOSE: ", "");

        return commandResult;
    }
}
