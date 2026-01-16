package j$.wrappers;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class z0 implements Supplier {
    final /* synthetic */ j$.util.function.z a;

    private /* synthetic */ z0(j$.util.function.z zVar) {
        this.a = zVar;
    }

    public static /* synthetic */ Supplier a(j$.util.function.z zVar) {
        if (zVar == null) {
            return null;
        }
        return zVar instanceof y0 ? ((y0) zVar).a : new z0(zVar);
    }

    @Override // java.util.function.Supplier
    public /* synthetic */ Object get() {
        return this.a.get();
    }
}
