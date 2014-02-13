import java.awt.Color;
import java.util.List;

public class View {
    
    private BoardView boardView;
    private PlayerView playerView;
    private String[] playerNames;
    
    public View (List<String> playerNames) {
        this.playerNames = playerNames.toArray(new String[playerNames.size()]);
        boardView = new BoardView(this.playerNames);
        playerView = new PlayerView(this.playerNames);
    }
    
    //Order of display on single space is 
	//Type, Height, Developer, Palace Height (if there)
	
	//Update space w/ no palace
    public void updateSpace(int x, int y, Tile tile, int height) {
    	if(tile != null)
    	System.out.println("sachit is bineg call with " + x + " " + y + tile.getClass().getSimpleName());
        boardView.updateSpace(x, y, tile, height);
        System.out.println("sachit was calleddd.");
    }
    
    //Update space w/ palace
    public void updateSpace(int x, int y, Tile tile, int height,
                            int palaceLevel) {
        boardView.updateSpace(x, y, tile, height, palaceLevel);
    }
    
    //Put a developer here
    public void updateDeveloper(int x, int y, String playerName) {
        boardView.updateDeveloper(x, y, getColor(playerName));
    }
    
    //Remove a developer from here
    public void removeDeveloper(int x, int y) {
        boardView.removeDeveloper(x, y);
    }
    
    //When tabbing through developers, switch to this one
    public void switchToDeveloper(int x, int y) {
        boardView.switchToDeveloper(x, y);
    }
    
    //When tabbing through developers, switch away from this one
    public void switchFromDeveloper(int x, int y) {
        boardView.switchFromDeveloper(x, y);
    }
    
    //Method for decrementing 1 block counts
    public void updateOneBlockCount(String playerName, boolean isCity) {
        playerView.updateOneBlockCount(playerName, isCity);
    }
    
    //Method for decrementing 2 block counts
    public void updateTwoBlockCount(String playerName) {
        playerView.updateTwoBlockCount(playerName);
    }
    
    //Method for incrementing/decrementing developer count
    public void developerCount(String playerName, int increment) {
        playerView.developerCount(playerName, increment);
    }
    
    //Highlight a space for selection
    public void highlightSpace(int x, int y) {
        boardView.highlightSpace(x, y);
    }
    
    //De-highlight a space for selection
    public void unHighlightSpace(int x, int y) {
        boardView.unHighlightSpace(x, y);
    }
    
    //Update the score for a player
    public void updateScore(String playerName, int score) {
    	playerView.updateScore(playerName, score);
    }
    
    //Map players to their colors
    private Color getColor(String playerName) {
        if (playerName.equals(playerNames[0]))
            return Color.RED;
        else if (playerName.equals(playerNames[1]))
            return Color.ORANGE;
        else if (playerName.equals(playerNames[2]))
            return Color.YELLOW;
        else if (playerName.equals(playerNames[3]))
            return Color.BLUE;
        else 
            return Color.BLACK;
    }
}
