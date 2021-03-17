package formula.racecalculator.models;

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
    public int hashCode() {
        return Objects.hash(name, team, lapTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Racer other = (Racer) obj;
        if (!Objects.equals(name, other.name)) {
            return false;
        }
        if (!Objects.equals(team, other.team)) {
            return false;
        }
        if (!Objects.equals(lapTime, other.lapTime)) {
            return false;
        }
        return true;
    }
}