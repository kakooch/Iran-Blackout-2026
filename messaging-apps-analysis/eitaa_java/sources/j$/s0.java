package j$;

import java.util.function.ObjDoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class s0 implements ObjDoubleConsumer {
    final /* synthetic */ j$.util.function.I a;

    private /* synthetic */ s0(j$.util.function.I i) {
        this.a = i;
    }

    public static /* synthetic */ ObjDoubleConsumer a(j$.util.function.I i) {
        if (i == null) {
            return null;
        }
        return i instanceof C0086r0 ? ((C0086r0) i).a : new s0(i);
    }

    @Override // java.util.function.ObjDoubleConsumer
    public /* synthetic */ void accept(Object obj, double d) {
        this.a.accept(obj, d);
    }
}
