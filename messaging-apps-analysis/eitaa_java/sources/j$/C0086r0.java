package j$;

import java.util.function.ObjDoubleConsumer;

/* renamed from: j$.r0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0086r0 implements j$.util.function.I {
    final /* synthetic */ ObjDoubleConsumer a;

    private /* synthetic */ C0086r0(ObjDoubleConsumer objDoubleConsumer) {
        this.a = objDoubleConsumer;
    }

    public static /* synthetic */ j$.util.function.I a(ObjDoubleConsumer objDoubleConsumer) {
        if (objDoubleConsumer == null) {
            return null;
        }
        return objDoubleConsumer instanceof s0 ? ((s0) objDoubleConsumer).a : new C0086r0(objDoubleConsumer);
    }

    @Override // j$.util.function.I
    public /* synthetic */ void accept(Object obj, double d) {
        this.a.accept(obj, d);
    }
}
