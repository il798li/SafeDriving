package Modifiers;

public class Settings {
    private int maxSpeedOffsetNumeric;
    private double maxSpeedOffsetPercentage
    private int maxAcceleration;
    private int maxSteerAngle;
    private int maxSteerSpeed;
    final private SpeedOffset speedOffsetSetting;

    private static enum SpeedOffset {
        Numeric,
        Percentage
    }

    public Settings (int maxSpeedOffsetNumeric, int maxAcceleration, int maxSteerAngle, int maxSteerSpeed) {
        this.maxSpeedOffsetNumeric = maxSpeedOffsetNumeric;
        this.maxAcceleration = maxAcceleration;
        this.maxSteerAngle = maxSteerAngle;
        this.maxSteerSpeed = maxSteerSpeed;

        this.speedOffsetSetting = SpeedOffset.Numeric;
    }

    public Settings (double maxSpeedOffsetPercentage, int maxAcceleration, int maxSteerAngle, int maxSteerSpeed) {
        this.maxSpeedOffsetPercentage = maxSpeedOffsetPercentage;
        this.maxAcceleration = maxAcceleration;
        this.maxSteerAngle = maxSteerAngle;
        this.maxSteerSpeed = maxSteerSpeed;

        this.speedOffsetSetting = SpeedOffset.Percentage;
    }

    public double maxSpeed (Connections connections) {
        switch (speedOffsetSetting) {
            case Numeric: {
                return connections.speedLimit() + maxSpeedOffsetNumeric;
            }
            case Percentage: {
                double multiplier = 100.0;
                multiplier += maxSpeedOffsetPercentage;
                multiplier /= 100;
                return connections.speedLimit () + multiplier;
            }
            default: {
                return connections.speedLimit();
            }
        }
    }
}
