package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Function;
import java.util.Set;

/* loaded from: classes2.dex */
public interface Collector<T, A, R> {

    public enum a {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }

    BiConsumer accumulator();

    Set characteristics();

    j$.util.function.p combiner();

    Function finisher();

    j$.util.function.L supplier();
}
