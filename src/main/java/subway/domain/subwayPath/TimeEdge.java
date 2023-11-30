package subway.domain.subwayPath;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.Station;
import subway.domain.subwayWeight.Time;

public class TimeEdge extends DefaultWeightedEdge {
    private final Station srcStation;
    private final Station destStation;
    private final Time time;

    public TimeEdge(Station srcStation, Station destStation, Time time) {
        this.srcStation = srcStation;
        this.destStation = destStation;
        this.time = time;
    }

    @Override
    protected Station getSource() {
        return srcStation;
    }

    @Override
    protected Station getTarget() {
        return destStation;
    }

    @Override
    protected double getWeight() {
        return time.getTimeValue();
    }
}
