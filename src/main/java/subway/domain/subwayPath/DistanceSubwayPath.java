package subway.domain.subwayPath;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DistanceSubwayPath {
    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceSubwayGraph;

    public DistanceSubwayPath() {
        this.distanceSubwayGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        setUpDistance();
    }

    private void setUpDistance() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            distanceSubwayGraph.addVertex(station);
        }

        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            List<DistanceEdge> distanceEdges = line.getDistanceEdges();
            for (DistanceEdge distanceEdge : distanceEdges) {
                DefaultWeightedEdge edge = distanceSubwayGraph.addEdge(distanceEdge.getSource(),
                        distanceEdge.getTarget());
                distanceSubwayGraph.setEdgeWeight(edge, distanceEdge.getWeight());
            }
        }
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceSubwayGraph() {
        return distanceSubwayGraph;
    }
}
