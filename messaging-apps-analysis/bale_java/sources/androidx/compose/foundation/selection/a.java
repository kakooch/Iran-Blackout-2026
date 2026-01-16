package androidx.compose.foundation.selection;

import androidx.compose.foundation.m;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23831xb3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.B26;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16339l63;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.compose.foundation.selection.a$a, reason: collision with other inner class name */
    public static final class C0048a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC16339l63 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ B26 h;
        final /* synthetic */ SA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0048a(InterfaceC16339l63 interfaceC16339l63, boolean z, boolean z2, B26 b26, SA2 sa2) {
            super(3);
            this.e = interfaceC16339l63;
            this.f = z;
            this.g = z2;
            this.h = b26;
            this.i = sa2;
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
            e eVarI = m.b(e.a, interfaceC18507om4, this.e).i(new SelectableElement(this.f, interfaceC18507om4, null, this.g, this.h, this.i, null));
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

    public static final e a(e eVar, boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC16339l63 interfaceC16339l63, boolean z2, B26 b26, SA2 sa2) {
        return eVar.i(interfaceC16339l63 instanceof InterfaceC17521n63 ? new SelectableElement(z, interfaceC18507om4, (InterfaceC17521n63) interfaceC16339l63, z2, b26, sa2, null) : interfaceC16339l63 == null ? new SelectableElement(z, interfaceC18507om4, null, z2, b26, sa2, null) : interfaceC18507om4 != null ? m.b(e.a, interfaceC18507om4, interfaceC16339l63).i(new SelectableElement(z, interfaceC18507om4, null, z2, b26, sa2, null)) : androidx.compose.ui.c.c(e.a, null, new C0048a(interfaceC16339l63, z, z2, b26, sa2), 1, null));
    }

    public static /* synthetic */ e b(e eVar, boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC16339l63 interfaceC16339l63, boolean z2, B26 b26, SA2 sa2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            b26 = null;
        }
        return a(eVar, z, interfaceC18507om4, interfaceC16339l63, z3, b26, sa2);
    }
}
