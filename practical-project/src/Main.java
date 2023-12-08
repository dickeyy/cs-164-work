class Main {
    private static String gameData = "gamedata.csv";
    private static String saveData = "knights.csv";

    /*
     * public static void main(String[] args)
     * Takes in command line parameters, looks through the program arguments. Builds
     * the objects to run the game, and passes control over to the GameController.
     * Example code includes
     * parseArgs(args); // method that parses the args, optional but cleaned up the
     * code
     * GameData data = new CSVGameData(gamedata, saveData);
     * GameView view = new ConsoleView();
     * CombatEngine engine = new CombatEngine(data, view);
     * GameController controller = new GameController(data, view, engine);
     * controller.start();
     * 
     * Hint: first write a loop that looks at the arguments, and then worry about
     * processing. We also suggest getting the entire programming working first, and
     * work on this part last.
     * Parameters:
     * args - the command line arguments option
     */

    public static void main(String[] args) {
        parseArgs(args); // method that parses the args, optional but cleaned up the code
        GameData data = new CSVGameData(gameData, saveData);
        GameView view = new ConsoleView();
        CombatEngine engine = new CombatEngine(data, view);
        GameController controller = new GameController(data, view, engine);
        controller.start();
    }

    /*
     * processArgs
     * private static void processArgs(String[] args)
     * loops through each each program argument (args). checks to see if the
     * argument starts with --data. If it starts with data, takes the substring of
     * the argument (after the = sign) to set the gamedata. else, any other argument
     * sets the saveData value (even if it has been set)
     * Parameters:
     * args -
     */

    private static void parseArgs(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("--data")) {
                int equals = arg.indexOf("=");
                gameData = arg.substring(equals + 1);
            }
        }
    }
}