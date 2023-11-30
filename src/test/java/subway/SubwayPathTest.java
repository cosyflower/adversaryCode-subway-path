package subway;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.SubwayPathApplication;
import subway.domain.subwayPath.DistanceEdge;
import subway.domain.subwayPath.DistanceSubwayPath;

public class SubwayPathTest {
    @Test
    void createSubwayPathWithDistance() {
        new SubwayPathApplication().setUpLineAndStation();

        DistanceSubwayPath distanceSubwayPath = new DistanceSubwayPath();
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = distanceSubwayPath.getDistanceGraph();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        double weight = dijkstraShortestPath.getPath(
                new Station("교대역"), new Station("양재역")).getWeight();

        List<Station> vertexList =
                dijkstraShortestPath.getPath(new Station("교대역"), new Station("양재역")).getVertexList();

        for (Station station : vertexList) {
            System.out.println(station.getName());
        }

        System.out.println(weight);
    }

    @Test
    void createSubwayPathWithTime() {
        new SubwayPathApplication().setUpLineAndStation();

    }
}
