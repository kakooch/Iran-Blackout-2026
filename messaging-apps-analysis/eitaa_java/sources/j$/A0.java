package j$;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class A0 implements Supplier {
    final /* synthetic */ j$.util.function.L a;

    private /* synthetic */ A0(j$.util.function.L l) {
        this.a = l;
    }

    public static /* synthetic */ Supplier a(j$.util.function.L l) {
        if (l == null) {
            return null;
        }
        return l instanceof z0 ? ((z0) l).a : new A0(l);
    }

    @Override // java.util.function.Supplier
    public /* synthetic */ Object get() {
        return this.a.get();
    }
}
