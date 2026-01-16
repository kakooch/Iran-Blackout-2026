package j$;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class B implements DoubleConsumer {
    final /* synthetic */ j$.util.function.s a;

    private /* synthetic */ B(j$.util.function.s sVar) {
        this.a = sVar;
    }

    public static /* synthetic */ DoubleConsumer a(j$.util.function.s sVar) {
        if (sVar == null) {
            return null;
        }
        return sVar instanceof A ? ((A) sVar).a : new B(sVar);
    }

    @Override // java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d) {
        this.a.accept(d);
    }

    @Override // java.util.function.DoubleConsumer
    public /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a(this.a.j(A.b(doubleConsumer)));
    }
}
