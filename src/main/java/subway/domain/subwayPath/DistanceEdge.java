package subway.domain.subwayPath;

import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.Station;
import subway.domain.subwayWeight.Distance;

public class DistanceEdge extends DefaultWeightedEdge {
    private final Station srcStation;
    private final Station destStation;
    private final Distance distance;

    public DistanceEdge(Station srcStation, Station destStation, Distance distance) {
        this.srcStation = srcStation;
        this.destStation = destStation;
        this.distance = distance;
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
        return distance.getDistanceValue();
    }
}
