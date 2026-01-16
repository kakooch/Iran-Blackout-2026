package j$;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: classes2.dex */
public final /* synthetic */ class K0 implements Collector {
    final /* synthetic */ j$.util.stream.Collector a;

    private /* synthetic */ K0(j$.util.stream.Collector collector) {
        this.a = collector;
    }

    public static /* synthetic */ Collector a(j$.util.stream.Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof J0 ? ((J0) collector).a : new K0(collector);
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ BiConsumer accumulator() {
        return r.a(this.a.accumulator());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Set characteristics() {
        return this.a.characteristics();
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ BinaryOperator combiner() {
        return C0205v.a(this.a.combiner());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Function finisher() {
        return N.a(this.a.finisher());
    }

    @Override // java.util.stream.Collector
    public /* synthetic */ Supplier supplier() {
        return A0.a(this.a.supplier());
    }
}
