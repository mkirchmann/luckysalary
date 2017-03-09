package de.killbuqs.salary.model;

/**
 * Salary representation.
 */

public class Salary {

    /**
     * Constructor.
     *
     * @param theAnnual
     * @param theMonthly
     * @param theNumberofsalariesperyear
     */
    public Salary(final double theNumberofsalariesperyear, final double theMonthly, final double theAnnual) {
        numberofsalariesperyear = theNumberofsalariesperyear;
        monthly = theMonthly;
        annual = theAnnual;
    }

    /**
     * @return the {@link #annual}
     */
    public double getAnnual() {
        return annual;
    }

    /**
     * @return the {@link #monthly}
     */
    public double getMonthly() {
        return monthly;
    }

    /**
     * @return the {@link #numberofsalariesperyear}
     */
    public double getNumberofsalariesperyear() {
        return numberofsalariesperyear;
    }

    /**
     * {@inheritDoc}.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return numberofsalariesperyear + " x " + monthly + " = " + annual;
    }

    private final double annual;

    private final double monthly;

    private final double numberofsalariesperyear;
}
