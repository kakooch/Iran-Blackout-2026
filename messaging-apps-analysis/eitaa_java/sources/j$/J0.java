package j$;

import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Set;

/* loaded from: classes2.dex */
public final /* synthetic */ class J0 implements Collector {
    final /* synthetic */ java.util.stream.Collector a;

    private /* synthetic */ J0(java.util.stream.Collector collector) {
        this.a = collector;
    }

    public static /* synthetic */ Collector a(java.util.stream.Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof K0 ? ((K0) collector).a : new J0(collector);
    }

    @Override // j$.util.stream.Collector
    public /* synthetic */ BiConsumer accumulator() {
        return C0084q.b(this.a.accumulator());
    }

    @Override // j$.util.stream.Collector
    public /* synthetic */ Set characteristics() {
        return this.a.characteristics();
    }

    @Override // j$.util.stream.Collector
    public /* synthetic */ j$.util.function.p combiner() {
        return C0089u.a(this.a.combiner());
    }

    @Override // j$.util.stream.Collector
    public /* synthetic */ Function finisher() {
        return M.a(this.a.finisher());
    }

    @Override // j$.util.stream.Collector
    public /* synthetic */ j$.util.function.L supplier() {
        return z0.a(this.a.supplier());
    }
}
