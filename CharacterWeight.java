package de.killbuqs.salary.model;

/**
 * An interface for getting the score for a certain character.
 */

public interface CharacterWeight {
    /**
     * Returns a score for a given character.
     *
     * @param c
     *            given character.
     * @return returns the score.
     */
    int getScore(char c);
}
