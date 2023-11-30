package subway.domain.system;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.SubwayTable;
import subway.domain.subwayPath.DistanceSubwayPath;
import subway.domain.subwayPath.TimeSubwayPath;

public class OptimalPathFinder { // 핵심 서비스 로직
    private static final TimeSubwayPath timeSubwayPath = new TimeSubwayPath();
    private static final DistanceSubwayPath distanceSubwayPath = new DistanceSubwayPath();

    public static GraphPath findOptimalPathByDistance(Station srcStation, Station dstStation) {
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = distanceSubwayPath.getDistanceSubwayGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

        return dijkstraShortestPath.getPath(srcStation, dstStation);
    }

    public static GraphPath findOptimalPathByTime(Station srcStation, Station dstStation) {
        WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = timeSubwayPath.getTimeGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

        return dijkstraShortestPath.getPath(srcStation, dstStation);
    }

    public static List<Station> fineComposedVertex(GraphPath graphPath) {
        return graphPath.getVertexList();
    }

    // 모든 테이블들을 구할 수 있다
    public static List<SubwayTable> findTables(List<Station> stations) {
        return IntStream.range(0, stations.size() - 1)
                .mapToObj((num) -> findEachTable(stations.get(num), stations.get(num + 1)))
                .collect(Collectors.toList());
    }

    private static SubwayTable findEachTable(Station oneStation, Station otherStation) {
        return SubwayTable.findTableBySrcAndDest(oneStation, otherStation);
    }

}
