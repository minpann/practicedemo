package com.mp.kalman;

/**
 * @author minpan
 * @date 2021/12/11 22:32
 */
public class KalmanFilterAlgorithm {
    private double A = 1;
    private double B = 0;
    private double C = 1;

    private double Q;
    private double R;

    private double cov = Double.NaN;
    private double x = Double.NaN;

    /**
     * Constructor
     *
     * @param Q Process noise
     * @param R Measurement noise
     */
    public KalmanFilterAlgorithm(double Q, double R){
        this.Q = Q;
        this.R = R;
    }

    /**
     * Filters a measurement
     *
     * @param measurement The measurement value to be filtered
     * @return The filtered value
     */
    public double filter(double measurement){
        double u = 0;
        if (Double.isNaN(this.x)) {
            this.x = (1 / this.C) * measurement;
            this.cov = (1 / this.C) * this.R * (1 / this.C);
        }else {
            double predX = (this.Q * this.x) + (this.B * u);
            double predCov = ((this.Q * this.cov) * this.Q) + this.Q;

            // Kalman gain
            double K = predCov * this.C * (1 / ((this.C * predCov * this.C) + this.R));

            // Correction
            this.x = predX + K * (measurement - (this.C * predX));
            this.cov = predCov - (K * this.C * predCov);
        }
        return this.x;
    }

    /**
     *
     * @return The last measurement fed into the filter
     */
    public double lastMeasurement(){
        return this.x;
    }

    /**
     * Sets measurement noise
     *
     * @param noise The new measurement noise
     */
    public void setMeasurementNoise(double noise){
        this.R = noise;
    }

    /**
     * Sets process noise
     *
     * @param noise The new process noise
     */
    public void setProcessNoise(double noise){
        this.Q = noise;
    }
}
