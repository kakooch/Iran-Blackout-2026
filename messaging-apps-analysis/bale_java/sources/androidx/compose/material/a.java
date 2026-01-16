package androidx.compose.material;

import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC6535Nx5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17484n26;
import ir.nasim.C17784nZ1;
import ir.nasim.C19257q26;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class a {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.d(null, C0051a.e, 1, null);
    private static final b b;
    private static final b c;
    private static final C17484n26 d;
    private static final C17484n26 e;
    private static final C17484n26 f;

    /* renamed from: androidx.compose.material.a$a, reason: collision with other inner class name */
    static final class C0051a extends AbstractC8614Ws3 implements SA2 {
        public static final C0051a e = new C0051a();

        C0051a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19257q26 invoke() {
            return new C19257q26(0L, null, 3, null);
        }
    }

    static {
        C17784nZ1.a aVar = C17784nZ1.b;
        float fC = aVar.c();
        C24381yX0.a aVar2 = C24381yX0.b;
        b = new b(true, fC, aVar2.i(), (ED1) null);
        c = new b(false, aVar.c(), aVar2.i(), (ED1) null);
        d = new C17484n26(0.16f, 0.24f, 0.08f, 0.24f);
        e = new C17484n26(0.08f, 0.12f, 0.04f, 0.12f);
        f = new C17484n26(0.08f, 0.12f, 0.04f, 0.1f);
    }

    public static final AbstractC6535Nx5 d() {
        return a;
    }

    public static final InterfaceC17521n63 e(boolean z, float f2, long j) {
        return (C17784nZ1.s(f2, C17784nZ1.b.c()) && C24381yX0.q(j, C24381yX0.b.i())) ? z ? b : c : new b(z, f2, j, (ED1) null);
    }

    public static /* synthetic */ InterfaceC17521n63 f(boolean z, float f2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.b.c();
        }
        if ((i & 4) != 0) {
            j = C24381yX0.b.i();
        }
        return e(z, f2, j);
    }
}
