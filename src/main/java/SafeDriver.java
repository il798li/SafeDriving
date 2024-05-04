import Modifiers.Connections;
import Modifiers.Pedals;
import Modifiers.Settings;
import Modifiers.Steering;

public class SafeDriver {
    private Pedals pedals;
    private Steering steering;
    private Settings settings;
    private Connections connections;
    private boolean started = false;

    public SafeDriver (Pedals pedals, Steering steering, Settings settings, Connections connections) {
        this.pedals = pedals;
        this.steering = steering;
        this.settings = settings;
        this.connections = connections;
    }

    public void start () {
        started = true;
        while (started) {
            if (maxSpeed() < pedals.speedMilesPerHour()) {
                connections.communicate("You are travelling at " + pedals.speedMilesPerHour() + " MPH, more than your maximum speed of " + settings.maxSpeed(connections) + "MPH!\nPlease slow down!");
            }
        }
    }

    public double maxSpeed () {
        return settings.maxSpeed(connections);
    }
}
