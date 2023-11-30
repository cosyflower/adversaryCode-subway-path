package subway.domain.subwayPath;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class TimeSubwayPath {
    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceTimeGraph;

    public TimeSubwayPath() {
        this.distanceTimeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        setUpDistance();
    }

    private void setUpDistance() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            distanceTimeGraph.addVertex(station);
        }

        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<TimeEdge> timeEdges = line.getTimeEdges();
            for (TimeEdge timeEdge : timeEdges) {
                DefaultWeightedEdge edge = distanceTimeGraph.addEdge(timeEdge.getSource(),
                        timeEdge.getTarget());
                distanceTimeGraph.setEdgeWeight(edge, timeEdge.getWeight());
            }
        }
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceTimeGraph() {
        return distanceTimeGraph;
    }
}
