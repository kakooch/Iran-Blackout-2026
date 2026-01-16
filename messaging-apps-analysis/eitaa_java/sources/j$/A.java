package j$;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class A implements j$.util.function.s {
    final /* synthetic */ DoubleConsumer a;

    private /* synthetic */ A(DoubleConsumer doubleConsumer) {
        this.a = doubleConsumer;
    }

    public static /* synthetic */ j$.util.function.s b(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return doubleConsumer instanceof B ? ((B) doubleConsumer).a : new A(doubleConsumer);
    }

    @Override // j$.util.function.s
    public /* synthetic */ void accept(double d) {
        this.a.accept(d);
    }

    @Override // j$.util.function.s
    public /* synthetic */ j$.util.function.s j(j$.util.function.s sVar) {
        return b(this.a.andThen(B.a(sVar)));
    }
}
