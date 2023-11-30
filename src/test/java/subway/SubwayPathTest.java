package subway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
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
        List<Station> vertexList =
                dijkstraShortestPath.getPath(new Station("교대역"), new Station("양재역")).getVertexList();

        assertThat(vertexList).containsExactly(
                new Station("교대역"),
                new Station("강남역"),
                new Station("양재역")
        );
    }

    @Test
    void createSubwayPathWithTime() {
        new SubwayPathApplication().setUpLineAndStation();

    }
}
