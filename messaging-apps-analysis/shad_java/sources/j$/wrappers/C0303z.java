package j$.wrappers;

import java.util.function.DoubleConsumer;

/* renamed from: j$.wrappers.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0303z implements j$.util.function.f {
    final /* synthetic */ DoubleConsumer a;

    private /* synthetic */ C0303z(DoubleConsumer doubleConsumer) {
        this.a = doubleConsumer;
    }

    public static /* synthetic */ j$.util.function.f a(DoubleConsumer doubleConsumer) {
        if (doubleConsumer == null) {
            return null;
        }
        return doubleConsumer instanceof A ? ((A) doubleConsumer).a : new C0303z(doubleConsumer);
    }

    @Override // j$.util.function.f
    public /* synthetic */ void accept(double d) {
        this.a.accept(d);
    }

    @Override // j$.util.function.f
    public /* synthetic */ j$.util.function.f k(j$.util.function.f fVar) {
        return a(this.a.andThen(A.a(fVar)));
    }
}
