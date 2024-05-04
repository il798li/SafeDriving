package Modifiers;

public interface Steering {
    double wheelAngleDegrees(); //At what angle is the steering wheel? Assume that a positive angle refers to a clockwise turn, and vice versa.
    double wheelAngleSpeedDegreesPerSecond(); //How fast is the steering wheel being turned by the driver, in degrees per second?
    double steeringRatio(); //For degree the driver turns the steering wheel, how many degrees do the front wheels turn? For most American cars, this function should return a value more than 1.
}
