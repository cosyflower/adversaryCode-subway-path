package subway.domain;

import java.util.Collections;
import java.util.List;
import subway.domain.subwayPath.DistanceEdge;
import subway.domain.subwayPath.TimeEdge;

public class Line { // 노선 이름, 그리고 연결되어 있는 Station(순서가 존재한다)
    private String name;
    private final List<DistanceEdge> distanceEdges;
    private final List<TimeEdge> timeEdges;

    public Line(String name, List<DistanceEdge> distanceEdges, List<TimeEdge> timeEdges) {
        this.name = name;
        this.distanceEdges = distanceEdges;
        this.timeEdges = timeEdges;
    }

    public String getName() {
        return name;
    }

    public List<DistanceEdge> getDistanceEdges() {
        return Collections.unmodifiableList(distanceEdges);
    }

    public List<TimeEdge> getTimeEdges() {
        return timeEdges;
    }
}
