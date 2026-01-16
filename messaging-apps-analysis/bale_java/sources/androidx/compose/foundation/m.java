package androidx.compose.foundation;

import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6535Nx5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16339l63;
import ir.nasim.InterfaceC16930m63;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.Q93;
import ir.nasim.SA2;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class m {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC16339l63 invoke() {
            return h.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC23241wb3 e;
        final /* synthetic */ InterfaceC16339l63 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC23241wb3 interfaceC23241wb3, InterfaceC16339l63 interfaceC16339l63) {
            super(1);
            this.e = interfaceC23241wb3;
            this.f = interfaceC16339l63;
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

    static final class c extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC16339l63 e;
        final /* synthetic */ InterfaceC23241wb3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC16339l63 interfaceC16339l63, InterfaceC23241wb3 interfaceC23241wb3) {
            super(3);
            this.e = interfaceC16339l63;
            this.f = interfaceC23241wb3;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-353972293);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-353972293, i, -1, "androidx.compose.foundation.indication.<anonymous> (Indication.kt:176)");
            }
            InterfaceC16930m63 interfaceC16930m63A = this.e.a(this.f, interfaceC22053ub1, 0);
            boolean zV = interfaceC22053ub1.V(interfaceC16930m63A);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new n(interfaceC16930m63A);
                interfaceC22053ub1.s(objB);
            }
            n nVar = (n) objB;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return nVar;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final AbstractC6535Nx5 a() {
        return a;
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC16339l63 interfaceC16339l63) {
        if (interfaceC16339l63 == null) {
            return eVar;
        }
        if (interfaceC16339l63 instanceof InterfaceC17521n63) {
            return eVar.i(new IndicationModifierElement(interfaceC23241wb3, (InterfaceC17521n63) interfaceC16339l63));
        }
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new b(interfaceC23241wb3, interfaceC16339l63) : Q93.a(), new c(interfaceC16339l63, interfaceC23241wb3));
    }
}
