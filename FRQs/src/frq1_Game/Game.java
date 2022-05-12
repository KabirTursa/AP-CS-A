package frq1_Game;

import frq1_Game.Level;

/**
 * Class Game is part of Question 1 from the FRQs in the
 * 2022 AP Computer Science A exam.
 * Problem definition from page 3 in:
 * https://apcentral.collegeboard.org/pdf/ap22-frq-computer-science-a.pdf
 */
public class Game {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;

    /** Postcondition: All instance variables have been initialized */
    public Game() {
        /* implementation not relevant */
    }

    /** Returns true if this game is a bonus game 
     * and returns false otherwise */
    public boolean isBonus() {
        /* implementation not relevant */
        /* return something to clear compiler errors */
        return false;
    }

    /** Simulates the play of this Game (consisting of three levels)
     * and updates all relevant game data
     */
    public void play() {
        /* implementation not relevant */
    }

    /** Returns the score earned in the most recently played game, 
     * as described in part (a) */
    public int getScore() {
        
        /* IMPLEMENTATION OF PART (A) */
        int score = 0;
        boolean done = levelOne.goalReached();

        if (done) {
            score += levelOne.getPoints();
            done = levelTwo.goalReached();
        }
        if (done) {
            score += levelTwo.getPoints();
            done = levelThree.goalReached();
        }
        if (done) {
            score += levelThree.getPoints();
            done = isBonus();
        }
        
        if (isBonus()) {
            score *= 3;
        }
        
        return score;
    }

    /** Simulates the play of num games and returns the highest
     * score earned, as described in part (b).
     * Precondition: num > 0
     */
    public int playManyTimes(int num) {
        
        /* IMPLEMENTATION OF PART (B) */
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            play();
            max = Math.max(max, getScore());
        }
        
        return max;
    }
}