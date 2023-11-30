package subway.domain.subwayWeight;

public abstract class AbstractWeight <T> implements Comparable<T> {
    @Override
    public abstract int compareTo(T o);
}
