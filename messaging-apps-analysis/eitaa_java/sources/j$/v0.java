package j$;

import java.util.function.ObjLongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class v0 implements j$.util.function.K {
    final /* synthetic */ ObjLongConsumer a;

    private /* synthetic */ v0(ObjLongConsumer objLongConsumer) {
        this.a = objLongConsumer;
    }

    public static /* synthetic */ j$.util.function.K a(ObjLongConsumer objLongConsumer) {
        if (objLongConsumer == null) {
            return null;
        }
        return objLongConsumer instanceof w0 ? ((w0) objLongConsumer).a : new v0(objLongConsumer);
    }

    @Override // j$.util.function.K
    public /* synthetic */ void accept(Object obj, long j) {
        this.a.accept(obj, j);
    }
}
