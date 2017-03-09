package de.killbuqs.salary.model;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Calculator for a salary that has certain numbers in it, both for the monthly salary and also for the yearly salary.
 * The salary with the most lucky score will be used.
 */
public class LuckySalaryCalculator {

    public static void main(final String[] args) throws ParseException {
        if (args.length != 2 && args.length != 3) {
            usage();
        }

        int x = 0;
        final int minSalary = Integer.parseInt(args[x++]);
        final int maxSalary = Integer.parseInt(args[x++]);
        final double numberofsalariesperyear;
        if (args.length == 3) {
            numberofsalariesperyear = Double.parseDouble(args[x]);
        } else {
            numberofsalariesperyear = 12.0;
        }
        if (minSalary <= 0 || maxSalary <= 0 || numberofsalariesperyear <= 0) {
            usage();
        }
        final LuckySalaryCalculator luckySalary = new LuckySalaryCalculator(ChineseLuckyNumberWeight.getInstance(),
                minSalary, maxSalary, numberofsalariesperyear);
        System.out.println(luckySalary.getBest());
    }

    /**
     *
     */
    private static void usage() {
        System.out.println("needs to be called with two or three parameters (as positive integers, last as double):");
        System.out.println("minsalary maxsalary [numberofsalariesperyear]");
        System.out.println("30000 35000 12.5");
        System.exit(-1);
    }

    /**
     * Constructor.
     */
    public LuckySalaryCalculator() {
    }

    /**
     * Constructor.
     *
     * @param theScoreMap
     */
    public LuckySalaryCalculator(final CharacterWeight theWeight, final int theMinSalary, final int theMaxSalary,
            final double theNumberofsalariesperyear) {
        weight = theWeight;
        minSalary = theMinSalary;
        maxSalary = theMaxSalary;
        numberofsalariesperyear = theNumberofsalariesperyear;
    }

    public int scoreFor(final double number) {
        return getScoreForNumber(number);
    }

    public int scoreFor(final int number) {
        return getScoreForNumber(number);
    }

    /**
     * Calculates the best {@link Salaray}.
     *
     * @return Returns the best {@link Salaray}.
     * @throws ParseException
     *
     */
    private Salary getBest() throws ParseException {
        int maxScore = 0;
        Salary bestResult = null;
        for (int i = minSalary; i <= maxSalary; i++) {
            final double monthly = i / numberofsalariesperyear;
            final String monthlyFormatted = getFormatter().format(monthly);
            final Number monthlyAsNumber = getFormatter().parse(monthlyFormatted);
            final double annual = monthlyAsNumber.doubleValue() * numberofsalariesperyear;
            final String annualFormatted = getFormatter().format(annual);
            final int score = scoreFor(annual) + scoreFor(monthlyFormatted);
            if (maxScore < score) {
                bestResult = new Salary(numberofsalariesperyear, monthly, annual);
                maxScore = score;
            }
        }
        return bestResult;
    }

    private DecimalFormat getFormatter() {
        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        return decimalFormat;
    }

    private int getScoreForNumber(final Number number) {
        final DecimalFormat decimalFormat = getFormatter();
        final String format = decimalFormat.format(number);
        return scoreFor(format);
    }

    private int scoreFor(final String format) {
        final char[] charArray = format.toCharArray();
        int result = 0;
        for (final char c : charArray) {
            result += weight.getScore(c);
        }
        return result;
    }

    private int maxSalary;

    private int minSalary;

    private double numberofsalariesperyear;

    private CharacterWeight weight;
}
