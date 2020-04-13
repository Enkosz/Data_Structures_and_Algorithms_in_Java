package com.base.chapter3.arrays;

public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        this.board = new GameEntry[capacity];
    }

    public void add(GameEntry gameEntry) {
        int newScore = gameEntry.getScore();

        // Check if there's space in the board or if the new score is less then the last score
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            // Check if there's space in the board to add the score without shifting anything
            if (numEntries < board.length) {
                numEntries++;
            }

            int j = numEntries - 1;
            // Start a loop from the end of the board and check if the score is higher then the board[j] score
            // if is higher then it moves the score to the right
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }

            // Saves the gameEntry into the board
            board[j] = gameEntry;
        }
    }

    public GameEntry remove(int index) throws IndexOutOfBoundsException {
        // Verify if the index is valid
        if (index < 0 || index >= numEntries)
            throw new IndexOutOfBoundsException();

        // Saves the game entry to remove
        GameEntry removedGameEntry = board[index];

        // Shift the items to the left
        for (int i = index; i < numEntries - 1; i++) {
            // Swap the items pushing the last item to the end
            board[i] = board[i + 1];
        }

        // Assign null to the last element
        board[numEntries - 1] = null;
        numEntries--;

        return removedGameEntry;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numEntries; i++) {
            GameEntry gameEntry = board[i];

            stringBuilder
                .append(i + 1)
                .append(") ")
                .append(gameEntry.toString())
                .append("\n");
        }

        return stringBuilder.toString();
    }
}
