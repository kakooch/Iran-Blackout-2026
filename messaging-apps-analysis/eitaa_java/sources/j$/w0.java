package j$;

import java.util.function.ObjLongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class w0 implements ObjLongConsumer {
    final /* synthetic */ j$.util.function.K a;

    private /* synthetic */ w0(j$.util.function.K k) {
        this.a = k;
    }

    public static /* synthetic */ ObjLongConsumer a(j$.util.function.K k) {
        if (k == null) {
            return null;
        }
        return k instanceof v0 ? ((v0) k).a : new w0(k);
    }

    @Override // java.util.function.ObjLongConsumer
    public /* synthetic */ void accept(Object obj, long j) {
        this.a.accept(obj, j);
    }
}
