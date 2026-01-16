package ir.nasim;

import androidx.compose.material.MinimumInteractiveModifier;

/* renamed from: ir.nasim.zb3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC25015zb3 {
    private static final AbstractC6535Nx5 a;
    private static final AbstractC6535Nx5 b;
    private static final long c;

    /* renamed from: ir.nasim.zb3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    static {
        AbstractC6535Nx5 abstractC6535Nx5F = AbstractC11024cc1.f(a.e);
        a = abstractC6535Nx5F;
        b = abstractC6535Nx5F;
        float f = 48;
        c = AbstractC18966pZ1.b(C17784nZ1.q(f), C17784nZ1.q(f));
    }

    public static final AbstractC6535Nx5 b() {
        return a;
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar) {
        return eVar.i(MinimumInteractiveModifier.b);
    }
}
