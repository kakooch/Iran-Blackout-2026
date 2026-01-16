package androidx.compose.material3;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC22920w26;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6535Nx5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17784nZ1;
import ir.nasim.C18666p26;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC16339l63;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class a {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(b.e);
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.d(null, C0054a.e, 1, null);
    private static final androidx.compose.material3.b c;
    private static final androidx.compose.material3.b d;

    /* renamed from: androidx.compose.material3.a$a, reason: collision with other inner class name */
    static final class C0054a extends AbstractC8614Ws3 implements SA2 {
        public static final C0054a e = new C0054a();

        C0054a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C18666p26 invoke() {
            return new C18666p26(0L, null, 3, null);
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    static {
        C17784nZ1.a aVar = C17784nZ1.b;
        float fC = aVar.c();
        C24381yX0.a aVar2 = C24381yX0.b;
        c = new androidx.compose.material3.b(true, fC, aVar2.i(), (ED1) null);
        d = new androidx.compose.material3.b(false, aVar.c(), aVar2.i(), (ED1) null);
    }

    public static final AbstractC6535Nx5 a() {
        return b;
    }

    public static final AbstractC6535Nx5 b() {
        return a;
    }

    public static final InterfaceC17521n63 c(boolean z, float f, long j) {
        return (C17784nZ1.s(f, C17784nZ1.b.c()) && C24381yX0.q(j, C24381yX0.b.i())) ? z ? c : d : new androidx.compose.material3.b(z, f, j, (ED1) null);
    }

    public static /* synthetic */ InterfaceC17521n63 d(boolean z, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f = C17784nZ1.b.c();
        }
        if ((i & 4) != 0) {
            j = C24381yX0.b.i();
        }
        return c(z, f, j);
    }

    public static final InterfaceC16339l63 e(boolean z, float f, long j, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            f = C17784nZ1.b.c();
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            j = C24381yX0.b.i();
        }
        long j2 = j;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1315814667, i, -1, "androidx.compose.material3.rippleOrFallbackImplementation (Ripple.kt:230)");
        }
        interfaceC22053ub1.W(-1280632857);
        InterfaceC16339l63 interfaceC16339l63F = ((Boolean) interfaceC22053ub1.H(a)).booleanValue() ? AbstractC22920w26.f(z2, f2, j2, interfaceC22053ub1, (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896), 0) : c(z2, f2, j2);
        interfaceC22053ub1.Q();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC16339l63F;
    }
}
