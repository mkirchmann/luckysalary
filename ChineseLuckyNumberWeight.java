package de.killbuqs.salary.model;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link CharacterWeight} for Chinese lucky (and unlucky) numbers. 8 is the most lucky number, 6
 * and 9 are less lucky but still, 0, 1 and 3 are less lucky but still, 5 is less lucky but still, 2 is a little bit
 * unlucky, 7 is more unlucky and 4 is a completely unlucky number.
 */

public class ChineseLuckyNumberWeight implements CharacterWeight {
    private static final ChineseLuckyNumberWeight INSTANCE = new ChineseLuckyNumberWeight();

    /**
     * Get the single instance of {@link CharacterWeight}.
     * 
     * @return the singleton {@link CharacterWeight}.
     */
    public static CharacterWeight getInstance() {
        return INSTANCE;
    }

    /**
     * Constructor.
     */
    private ChineseLuckyNumberWeight() {
        scoreMap = new HashMap<>();
        scoreMap.put('0', 20);
        scoreMap.put('1', 40);
        scoreMap.put('2', -10);
        scoreMap.put('3', 30);
        scoreMap.put('4', -20);
        scoreMap.put('5', 20);
        scoreMap.put('6', 90);
        scoreMap.put('7', -10);
        scoreMap.put('8', 100);
        scoreMap.put('9', 90);
        scoreMap.put(',', 0);
        scoreMap.put('.', 0);
    }

    /**
     * {@inheritDoc}.
     *
     * @see de.killbuqs.salary.model.CharacterWeight#getScore(char)
     */
    @Override
    public int getScore(final char theC) {
        final Integer integer = scoreMap.get(theC);
        if (integer != null) {
            return integer;
        }
        return 0;
    }

    final Map<Character, Integer> scoreMap;
}
