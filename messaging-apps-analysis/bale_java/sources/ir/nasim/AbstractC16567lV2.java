package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC9998au2;

/* renamed from: ir.nasim.lV2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16567lV2 {

    /* renamed from: ir.nasim.lV2$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ C9348Zn7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, C9348Zn7 c9348Zn7) {
            super(1);
            this.e = i;
            this.f = i2;
            this.g = c9348Zn7;
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

    /* renamed from: ir.nasim.lV2$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ C9348Zn7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, C9348Zn7 c9348Zn7) {
            super(3);
            this.e = i;
            this.f = i2;
            this.g = c9348Zn7;
        }

        private static final Object b(InterfaceC9664aL6 interfaceC9664aL6) {
            return interfaceC9664aL6.getValue();
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(408240218);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(408240218, i, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:62)");
            }
            AbstractC16567lV2.b(this.e, this.f);
            if (this.e == 1 && this.f == Integer.MAX_VALUE) {
                e.a aVar = androidx.compose.ui.e.a;
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
                interfaceC22053ub1.Q();
                return aVar;
            }
            WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
            AbstractC9998au2.b bVar = (AbstractC9998au2.b) interfaceC22053ub1.H(AbstractC13040fc1.i());
            EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1.H(AbstractC13040fc1.n());
            boolean zV = interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(enumC12613eu3);
            C9348Zn7 c9348Zn7 = this.g;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10560bo7.d(c9348Zn7, enumC12613eu3);
                interfaceC22053ub1.s(objB);
            }
            C9348Zn7 c9348Zn72 = (C9348Zn7) objB;
            boolean zV2 = interfaceC22053ub1.V(bVar) | interfaceC22053ub1.V(c9348Zn72);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                AbstractC9998au2 abstractC9998au2J = c9348Zn72.j();
                C4593Fu2 c4593Fu2O = c9348Zn72.o();
                if (c4593Fu2O == null) {
                    c4593Fu2O = C4593Fu2.b.d();
                }
                C3418Au2 c3418Au2M = c9348Zn72.m();
                int i2 = c3418Au2M != null ? c3418Au2M.i() : C3418Au2.b.b();
                C3657Bu2 c3657Bu2N = c9348Zn72.n();
                objB2 = bVar.b(abstractC9998au2J, c4593Fu2O, i2, c3657Bu2N != null ? c3657Bu2N.m() : C3657Bu2.b.a());
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB2;
            boolean zV3 = interfaceC22053ub1.V(b(interfaceC9664aL6)) | interfaceC22053ub1.V(wh1) | interfaceC22053ub1.V(bVar) | interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(enumC12613eu3);
            Object objB3 = interfaceC22053ub1.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = Integer.valueOf((int) (AbstractC9330Zl7.a(c9348Zn72, wh1, bVar, AbstractC9330Zl7.c(), 1) & 4294967295L));
                interfaceC22053ub1.s(objB3);
            }
            int iIntValue = ((Number) objB3).intValue();
            boolean zV4 = interfaceC22053ub1.V(enumC12613eu3) | interfaceC22053ub1.V(wh1) | interfaceC22053ub1.V(bVar) | interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(b(interfaceC9664aL6));
            Object objB4 = interfaceC22053ub1.B();
            if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = Integer.valueOf((int) (AbstractC9330Zl7.a(c9348Zn72, wh1, bVar, AbstractC9330Zl7.c() + '\n' + AbstractC9330Zl7.c(), 2) & 4294967295L));
                interfaceC22053ub1.s(objB4);
            }
            int iIntValue2 = ((Number) objB4).intValue() - iIntValue;
            int i3 = this.e;
            Integer numValueOf = i3 == 1 ? null : Integer.valueOf(((i3 - 1) * iIntValue2) + iIntValue);
            int i4 = this.f;
            Integer numValueOf2 = i4 != Integer.MAX_VALUE ? Integer.valueOf(iIntValue + (iIntValue2 * (i4 - 1))) : null;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.t.j(androidx.compose.ui.e.a, numValueOf != null ? wh1.D(numValueOf.intValue()) : C17784nZ1.b.c(), numValueOf2 != null ? wh1.D(numValueOf2.intValue()) : C17784nZ1.b.c());
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarJ;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, C9348Zn7 c9348Zn7, int i, int i2) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new a(i, i2, c9348Zn7) : Q93.a(), new b(i, i2, c9348Zn7));
    }

    public static final void b(int i, int i2) {
        if (!(i > 0 && i2 > 0)) {
            P73.a("both minLines " + i + " and maxLines " + i2 + " must be greater than zero");
        }
        if (i <= i2) {
            return;
        }
        P73.a("minLines " + i + " must be less than or equal to maxLines " + i2);
    }
}
