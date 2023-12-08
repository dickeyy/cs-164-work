class GameController {

    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    /*
     * start
     * public void start()
     * Starts the game, causing it to run until a client exits. Starts with
     * splashScreen, loops as long as processCommand returns true, prints endgame
     * when loop is done.
     * See Also:
     * GameView.displayMainMenu()
     */
    public void start() {
        view.splashScreen();
        boolean running = true;
        while (running) {
            String command = view.displayMainMenu();
            running = processCommand(command);
        }
        view.endGame();
    }

    /*
     * processCommand
     * protected boolean processCommand(String command)
     * Setup as a helper method for start() }, processes commands the client passes
     * in through GameView.displayMainMenu(). The following command combinations are
     * allowed:
     * exit or bye (contains) - causes processCommand to return false
     * ls or list all - list all knights. For example,
     * view.listKnights(data.getKnights())
     * list active - list active knights via GameData.getActiveKnights()
     * show (name or id) - if the command starts with show, take the remainder and
     * show the knight card
     * set active (name or id) - if command starts with set active, grabs the
     * remainder of the line, and try to add the knight to the active knight list.
     * remove (name or id) - if command starts with remove, grabs the remainder of
     * the line, attempts to remove the knight from active status.
     * save (filename - optional) - saves the game. If a file name is provided saves
     * the knights to the file. If a file name is left off, saves out to
     * saveData.csv
     * explore, adventure or quest - if any three of these words are used, it starts
     * a combat sequence. For example.
     * 
     * engine.initialize();
     * engine.runCombat();
     * engine.clear();
     * }
     * any other input, print the help menu.
     * Parameters:
     * command - command to process.
     * Returns:
     * true unless exit or bye is used.
     */

    protected boolean processCommand(String command) {
        switch (command.toLowerCase()) {
            case "exit":
            case "bye":
                return false;
            case "ls":
            case "list all":
                view.listKnights(data.getKnights());
                break;
            case "list active":
                view.listKnights(data.getActiveKnights());
                break;
            case "explore":
            case "adventure":
            case "quest":
                engine.initialize();
                engine.runCombat();
                engine.clear();
                break;
            case "save":
                data.save("saveData.csv");
                break;
            default:
                if (command.startsWith("show ")) {
                    processShowKnight(command.substring(5));
                } else if (command.startsWith("set active ")) {
                    processSetActive(command.substring(11).trim());
                } else if (command.startsWith("remove ")) {
                    processRemoveActive(command.substring(7));
                } else {
                    view.printHelp();
                }
        }
        return true;
    }

    /*
     * processSetActive
     * private void processSetActive(String active)
     * Optional helper method that helped keep processCommand(String) cleaner. sets
     * a knight to 'active' by calling .getKnight(String), and then
     * setActive(Knight) if the knight exists Prints knightNotFound() if an invalid
     * knight is given, and setActiveFailed() if it can't add the knight.
     * Parameters:
     * active -
     */

    private void processSetActive(String active) {
        Knight knight = data.getKnight(active);
        if (knight != null) {
            if (!data.setActive(knight)) {
                view.setActiveFailed();
            }
        } else {
            view.knightNotFound();
        }
    }

    /*
     * processShowKnight
     * private void processShowKnight(String nameOrId)
     * Optional helper method that helped keep processCommand(String) cleaner. Uses
     * data.getKnight(nameOrId) to ge ta knight, and then call the
     * showKnight(knight) method in GameView. If the knight wasn't found, print
     * knightNotFound()
     * Parameters:
     * nameOrId -
     */

    private void processShowKnight(String nameOrId) {
        Knight knight = data.getKnight(nameOrId);
        if (knight != null) {
            view.showKnight(knight);
        } else {
            view.knightNotFound();
        }
    }

    private void processRemoveActive(String remove) {
        Knight knight = data.getKnight(remove);
        if (knight != null) {
            data.removeActive(knight);
        } else {
            view.knightNotFound();
        }
    }

}