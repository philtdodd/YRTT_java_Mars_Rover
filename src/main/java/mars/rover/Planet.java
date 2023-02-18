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
        StringBuilder returnResult = new StringBuilder();
        String mapHeader = "+---";

        mapHeader = mapHeader.repeat(planetSurface.getXSize() + 1);
        mapHeader += "+\n";

        returnResult.append(mapHeader);
        for (int y = planetSurface.getYSize(); y >= 0; y--) {
            for (int x = 0; x <= planetSurface.getXSize(); x++) {
                if (x == selectedVehicle.getX() && y == selectedVehicle.getY()) {
                    StringBuilder vehicleDetails = new StringBuilder();
                    vehicleDetails.append("|R");
                    vehicleDetails.append(selectedVehicle.getId());
                    vehicleDetails.append(" ".repeat(4 - vehicleDetails.length()));
                    returnResult.append(vehicleDetails);
                } else
                    returnResult.append("|   ");
            }

            returnResult.append("|\n");
            returnResult.append(mapHeader);
        }

        return returnResult.toString();
    }

    private String displayHelp() {
        return """
                 Help:
                  Initial command string specifies the surface grid.
                    x y
                  To land a vehicle enter:
                    x y h
                  where h is the heading N E S W, this will return the vehicles ID.
                  To add a capability:
                    C capabilityType,name,description,...
                      DRILL,name,description,minDepth,maxDepth
                      COLLECTOR,name,description,capacity
                      SPECTROMETER,name,description,capacity
                      ARM,name,description
                      CAMERANIGHTVISION,name,description,minFocalLength,maxFocalLength
                      CAMERAINFRARED,name,description,minFocalLength,maxFocalLength
                      CAMERAVISIBLELIGHT,name,description,minFocalLength,maxFocalLength
                      CAMERABLACKWHITE,name,description,minFocalLength,maxFocalLength
                  where capabilityType and extra parameters are:
                  V - Display verbose messages.
                  D - Display Map.
                  I - Display Vehicle Info.
                  R - Turn Right 90 degrees.
                  L - turn Left 90 Degrees.
                  M - Move vehicle.
                  P - Perform Capability.
                  S - Send Results.
                  [vehicle ID] - Select vehicle.
                  [capability ID],... - Select capability and set parameters.
                      DRILL:depth
                      COLLECTOR:none
                      SPECTROMETER:none
                      ARM:none
                      CAMERA,ISO,FocalLength,Aperture
                """;
    }

    private String runTimeCommand(String receivedCommand) {
        if (!receivedCommand.matches("[ ]*(([LRMD]*)[ ]*)*[ ]*"))
            return "ERROR: command not rover landing command";
        else {
            String heading;
            String commandTidied = receivedCommand.replaceAll(" ", "");
            boolean displayMap = false;
            String returnResult = "";

            // Check if Display Map requested.
            if (receivedCommand.contains("D"))
                displayMap = true;

            for (int i = 0; i < commandTidied.length(); i++) {
                switch (commandTidied.substring(i, i + 1)) {
                    case "L" -> selectedVehicle.rotateLeft();
                    case "R" -> selectedVehicle.rotateRight();
                    case "M" -> selectedVehicle.move();
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

        if (receivedCommand == null || receivedCommand.matches(""))
            return "ERROR: no command";

        receivedCommand = receivedCommand.trim();

        // Check for help message
        if (receivedCommand.matches("\\?"))
            return displayHelp();

        // Check for Verbose Response and toggle setting
        if (receivedCommand.matches("V")) {
            receivedCommand = receivedCommand.replaceAll("V", "");
            verbose = !verbose;
        }

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
            commandResult = "";
        else
            commandResult = commandResult.replace("VERBOSE: ", "");

        return commandResult;
    }
}
