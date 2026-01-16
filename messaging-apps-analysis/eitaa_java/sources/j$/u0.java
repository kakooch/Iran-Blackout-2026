package j$;

import java.util.function.ObjIntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class u0 implements ObjIntConsumer {
    final /* synthetic */ j$.util.function.J a;

    private /* synthetic */ u0(j$.util.function.J j) {
        this.a = j;
    }

    public static /* synthetic */ ObjIntConsumer a(j$.util.function.J j) {
        if (j == null) {
            return null;
        }
        return j instanceof t0 ? ((t0) j).a : new u0(j);
    }

    @Override // java.util.function.ObjIntConsumer
    public /* synthetic */ void accept(Object obj, int i) {
        this.a.accept(obj, i);
    }
}
