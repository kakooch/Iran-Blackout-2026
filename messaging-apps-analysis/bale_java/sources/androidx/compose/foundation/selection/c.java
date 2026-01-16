package androidx.compose.foundation.selection;

import androidx.compose.foundation.m;
import androidx.compose.ui.e;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC23831xb3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.B26;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16339l63;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.Q93;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class c {

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ B26 g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, boolean z2, B26 b26, UA2 ua2) {
            super(3);
            this.e = z;
            this.f = z2;
            this.g = b26;
            this.h = ua2;
        }

        public final e a(e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            InterfaceC18507om4 interfaceC18507om4;
            interfaceC22053ub1.W(290332169);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(290332169, i, -1, "androidx.compose.foundation.selection.toggleable.<anonymous> (Toggleable.kt:74)");
            }
            InterfaceC16339l63 interfaceC16339l63 = (InterfaceC16339l63) interfaceC22053ub1.H(m.a());
            if (interfaceC16339l63 instanceof InterfaceC17521n63) {
                interfaceC22053ub1.W(-2130062114);
                interfaceC22053ub1.Q();
                interfaceC18507om4 = null;
            } else {
                interfaceC22053ub1.W(-2129929496);
                Object objB = interfaceC22053ub1.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = AbstractC23831xb3.a();
                    interfaceC22053ub1.s(objB);
                }
                interfaceC18507om4 = (InterfaceC18507om4) objB;
                interfaceC22053ub1.Q();
            }
            e eVarA = c.a(e.a, this.e, interfaceC18507om4, interfaceC16339l63, this.f, this.g, this.h);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarA;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC16339l63 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ B26 h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC16339l63 interfaceC16339l63, boolean z, boolean z2, B26 b26, UA2 ua2) {
            super(3);
            this.e = interfaceC16339l63;
            this.f = z;
            this.g = z2;
            this.h = b26;
            this.i = ua2;
        }

        public final e a(e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1525724089);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
            }
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
            e eVarI = m.b(e.a, interfaceC18507om4, this.e).i(new ToggleableElement(this.f, interfaceC18507om4, null, this.g, this.h, this.i, null));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarI;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: androidx.compose.foundation.selection.c$c, reason: collision with other inner class name */
    public static final class C0049c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ B26 g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0049c(boolean z, boolean z2, B26 b26, UA2 ua2) {
            super(1);
            this.e = z;
            this.f = z2;
            this.g = b26;
            this.h = ua2;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    public static final e a(e eVar, boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC16339l63 interfaceC16339l63, boolean z2, B26 b26, UA2 ua2) {
        e eVarC;
        if (interfaceC16339l63 instanceof InterfaceC17521n63) {
            eVarC = new ToggleableElement(z, interfaceC18507om4, (InterfaceC17521n63) interfaceC16339l63, z2, b26, ua2, null);
        } else if (interfaceC16339l63 == null) {
            eVarC = new ToggleableElement(z, interfaceC18507om4, null, z2, b26, ua2, null);
        } else if (interfaceC18507om4 != null) {
            eVarC = m.b(e.a, interfaceC18507om4, interfaceC16339l63).i(new ToggleableElement(z, interfaceC18507om4, null, z2, b26, ua2, null));
        } else {
            eVarC = androidx.compose.ui.c.c(e.a, null, new b(interfaceC16339l63, z, z2, b26, ua2), 1, null);
        }
        return eVar.i(eVarC);
    }

    public static final e b(e eVar, boolean z, boolean z2, B26 b26, UA2 ua2) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new C0049c(z, z2, b26, ua2) : Q93.a(), new a(z, z2, b26, ua2));
    }

    public static /* synthetic */ e c(e eVar, boolean z, boolean z2, B26 b26, UA2 ua2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            b26 = null;
        }
        return b(eVar, z, z2, b26, ua2);
    }
}
