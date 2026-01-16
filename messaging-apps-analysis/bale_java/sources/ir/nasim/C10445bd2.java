package ir.nasim;

import java.util.concurrent.Executor;

/* renamed from: ir.nasim.bd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10445bd2 implements InterfaceC20817sf2 {

    /* renamed from: ir.nasim.bd2$a */
    private static final class a {
        private static final C10445bd2 a = new C10445bd2();
    }

    public static C10445bd2 a() {
        return a.a;
    }

    public static Executor b() {
        return (Executor) AbstractC3561Bj5.c(AbstractC9825ad2.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
