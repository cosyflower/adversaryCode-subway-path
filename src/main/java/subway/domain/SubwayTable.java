package subway.domain;

import java.util.Arrays;
import subway.domain.subwayWeight.Distance;
import subway.domain.subwayWeight.Time;

public enum SubwayTable {
    GYODAE_GANGNAM(new Station("교대역"), new Station("강남역"),
            new Distance(2), new Time(3)),
    GANGNAM_YUKSAM(new Station("강남역"), new Station("역삼역"),
            new Distance(2), new Time(3)),

    GYODAE_NAMBUTERMINAL(new Station("교대역"), new Station("남부터미널역"),
            new Distance(3), new Time(2)),
    NAMBUTERMINAL_YANGJAE(new Station("남부터미널역"), new Station("양재역"),
            new Distance(6), new Time(5)),
    YANGJE_MAEBONG(new Station("양재역"), new Station("매봉역"),
            new Distance(1), new Time(1)),

    GANGNAM_YANGJAE(new Station("강남역"), new Station("양재역"),
            new Distance(2), new Time(8)),
    YANGJAE_YANGJAEFOREST(new Station("양재역"), new Station("양재시민의숲역"),
            new Distance(10), new Time(3)),
    ;

    private final Station srcStation;
    private final Station destStation;
    private final Distance distance;
    private final Time time;

    SubwayTable(Station srcStation, Station destStation, Distance distance, Time time) {
        this.srcStation = srcStation;
        this.destStation = destStation;
        this.distance = distance;
        this.time = time;
    }

    public static SubwayTable findTableBySrcAndDest(Station oneStation, Station otherStation) {
        return Arrays.stream(values())
                .filter(subwayTable -> subwayTable.hasSameComposedStations(oneStation, otherStation))
                .findFirst()
                .get();
    }

    private boolean hasSameComposedStations(Station oneStation, Station otherStation) {
        return (srcStation == oneStation && destStation == otherStation) ||
                (srcStation == otherStation && destStation == oneStation);
    }
}
