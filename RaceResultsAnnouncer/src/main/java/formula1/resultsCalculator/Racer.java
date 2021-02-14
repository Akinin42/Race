package formula1.resultsCalculator;

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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lapTime == null) ? 0 : lapTime.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((team == null) ? 0 : team.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Racer)) {
            return false;
        }
        Racer racer = (Racer) o;
        return Objects.equals(name, racer.getName()) && Objects.equals(team, racer.getTeam())
                && Objects.equals(lapTime, racer.getLapTime());
    }
}