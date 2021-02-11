package formula1.resultscounter;

import java.time.Duration;
import java.util.Objects;

public class Racer {

    private String name;
    private String team;
    private Duration lapTime;

    public Racer(String name, String team, Duration lapTime) {
        this.name = name;
        this.team = team;
        this.lapTime = lapTime;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Duration getLapTime() {
        return lapTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Racer)) {
            return false;
        }
        Racer racer = (Racer) o;
        return Objects.equals(this.name, racer.getName()) && Objects.equals(this.team, racer.getTeam())
                && Objects.equals(this.lapTime, racer.getLapTime());
    }
}