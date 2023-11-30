package subway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.domain.SubwayPathApplication;
import subway.domain.subwayPath.DistanceSubwayPath;
import subway.domain.subwayPath.TimeSubwayPath;

public class SubwayPathTest {
    private TimeSubwayPath timeSubwayPath;
    private DistanceSubwayPath distanceSubwayPath;

    @Test
    void createSubwayPathWithDistance() {
        new SubwayPathApplication().setUpLineAndStation();
        distanceSubwayPath = new DistanceSubwayPath();
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = distanceSubwayPath.getDistanceSubwayGraph();

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
        timeSubwayPath = new TimeSubwayPath();
        WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph = timeSubwayPath.getDistanceTimeGraph();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        List<Station> vertexList =
                dijkstraShortestPath.getPath(new Station("교대역"), new Station("양재역")).getVertexList();

        assertThat(vertexList).containsExactly(
                new Station("교대역"),
                new Station("남부터미널역"),
                new Station("양재역")
        );
    }
}
