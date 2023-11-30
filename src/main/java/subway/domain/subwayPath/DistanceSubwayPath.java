package subway.domain.subwayPath;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DistanceSubwayPath {
    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph;

    public DistanceSubwayPath() {
        this.distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        setUpDistance();
    }

    private void setUpDistance() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            distanceGraph.addVertex(station);
        }

        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<DistanceEdge> distanceEdges = line.getDistanceEdges();
            for (DistanceEdge distanceEdge : distanceEdges) {
                DefaultWeightedEdge edge = distanceGraph.addEdge(distanceEdge.getSource(),
                        distanceEdge.getTarget());
                distanceGraph.setEdgeWeight(edge, distanceEdge.getWeight());
            }
        }
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceGraph() {
        return distanceGraph;
    }
}
