package subway.domain;

import java.util.Arrays;
import subway.domain.subwayPath.DistanceEdge;
import subway.domain.subwayPath.TimeEdge;
import subway.domain.subwayWeight.Distance;
import subway.domain.subwayWeight.Time;

public class SubwayPathApplication {
    public void run() {
        init();
    }
    private void init() {
        setUpLineAndStation();
    }

    public void setUpLineAndStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));

        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));

        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));

        LineRepository.addLine(new Line("2호선",
                Arrays.asList(
                        new DistanceEdge(new Station("교대역"), new Station("강남역"),
                                new Distance(2)),
                        new DistanceEdge(new Station("강남역"), new Station("역삼역"),
                                new Distance(2))
                ),
                Arrays.asList(
                        new TimeEdge(new Station("교대역"), new Station("강남역"),
                                new Time(3)),
                        new TimeEdge(new Station("교대역"), new Station("강남역"),
                                new Time(3))
                )
        ));

        LineRepository.addLine(new Line("3호선",
                Arrays.asList(
                        new DistanceEdge(new Station("교대역"), new Station("남부터미널역"),
                                new Distance(3)),
                        new DistanceEdge(new Station("남부터미널역"), new Station("양재역"),
                                new Distance(6)),
                        new DistanceEdge(new Station("양재역"), new Station("매봉역"),
                                new Distance(1))
                ),
                Arrays.asList(
                        new TimeEdge(new Station("교대역"), new Station("남부터미널역"),
                                new Time(2)),
                        new TimeEdge(new Station("남부터미널역"), new Station("양재역"),
                                new Time(5)),
                        new TimeEdge(new Station("양재역"), new Station("매봉역"),
                                new Time(1))
                )
        ));

        LineRepository.addLine(new Line("신분당선",
                Arrays.asList(
                        new DistanceEdge(new Station("강남역"), new Station("양재역"),
                                new Distance(2)),
                        new DistanceEdge(new Station("양재역"), new Station("양재시민의숲역"),
                                new Distance(10))
                ),
                Arrays.asList(
                        new TimeEdge(new Station("강남역"), new Station("양재역"),
                                new Time(8)),
                        new TimeEdge(new Station("양재역"), new Station("양재시민의숲역"),
                                new Time(3))
                )
        ));
    }
}
