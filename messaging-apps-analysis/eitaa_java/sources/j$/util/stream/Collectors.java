package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class Collectors {
    static final Set a;

    static class a<T, A, R> implements Collector<T, A, R> {
        private final j$.util.function.L a;
        private final Set b;

        a(j$.util.function.L l, BiConsumer biConsumer, j$.util.function.p pVar, Function function, Set set) {
            this.a = l;
            this.b = set;
        }

        @Override // j$.util.stream.Collector
        public BiConsumer accumulator() {
            return C0144k1.a;
        }

        @Override // j$.util.stream.Collector
        public Set characteristics() {
            return this.b;
        }

        @Override // j$.util.stream.Collector
        public j$.util.function.p combiner() {
            return N.a;
        }

        @Override // j$.util.stream.Collector
        public Function finisher() {
            return R0.a;
        }

        @Override // j$.util.stream.Collector
        public j$.util.function.L supplier() {
            return this.a;
        }
    }

    static {
        Collector.a aVar = Collector.a.CONCURRENT;
        Collector.a aVar2 = Collector.a.UNORDERED;
        Collector.a aVar3 = Collector.a.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(aVar, aVar2, aVar3));
        Collections.unmodifiableSet(EnumSet.of(aVar, aVar2));
        Collections.unmodifiableSet(EnumSet.of(aVar3));
        Collections.unmodifiableSet(EnumSet.of(aVar2, aVar3));
        a = Collections.emptySet();
    }

    private Collectors() {
    }

    static double a(double[] dArr) {
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (Double.isNaN(d) && Double.isInfinite(d2)) ? d2 : d;
    }

    static double[] b(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
        return dArr;
    }

    public static Collector joining(final CharSequence charSequence) {
        final String str = "";
        return new a(new j$.util.function.L() { // from class: j$.util.stream.m
            @Override // j$.util.function.L
            public final Object get() {
                CharSequence charSequence2 = charSequence;
                CharSequence charSequence3 = str;
                CharSequence charSequence4 = str;
                Set set = Collectors.a;
                return new j$.util.v(charSequence2, charSequence3, charSequence4);
            }
        }, C0144k1.a, N.a, R0.a, a);
    }
}
