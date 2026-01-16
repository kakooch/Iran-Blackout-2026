package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.pG0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18794pG0 {

    /* renamed from: ir.nasim.pG0$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC3932Cy7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC3932Cy7 interfaceC3932Cy7) {
            super(0);
            this.e = interfaceC3932Cy7;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke() {
            AbstractC4099Dr3 type = this.e.getType();
            AbstractC13042fc3.h(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* renamed from: ir.nasim.pG0$b */
    public static final class b extends PG1 {
        final /* synthetic */ boolean d;
        final /* synthetic */ AbstractC5117Hy7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, AbstractC5117Hy7 abstractC5117Hy7) {
            super(abstractC5117Hy7);
            this.d = z;
            this.e = abstractC5117Hy7;
        }

        @Override // ir.nasim.AbstractC5117Hy7
        public boolean b() {
            return this.d;
        }

        @Override // ir.nasim.PG1, ir.nasim.AbstractC5117Hy7
        public InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "key");
            InterfaceC3932Cy7 interfaceC3932Cy7E = super.e(abstractC4099Dr3);
            if (interfaceC3932Cy7E == null) {
                return null;
            }
            MU0 mu0D = abstractC4099Dr3.K0().t();
            return AbstractC18794pG0.b(interfaceC3932Cy7E, mu0D instanceof InterfaceC22882vy7 ? (InterfaceC22882vy7) mu0D : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3932Cy7 b(InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC22882vy7 interfaceC22882vy7) {
        if (interfaceC22882vy7 == null || interfaceC3932Cy7.c() == KQ7.INVARIANT) {
            return interfaceC3932Cy7;
        }
        if (interfaceC22882vy7.m() != interfaceC3932Cy7.c()) {
            return new C4400Ey7(c(interfaceC3932Cy7));
        }
        if (!interfaceC3932Cy7.b()) {
            return new C4400Ey7(interfaceC3932Cy7.getType());
        }
        ON6 on6 = C14671iI3.e;
        AbstractC13042fc3.h(on6, "NO_LOCKS");
        return new C4400Ey7(new C5572Jx3(on6, new a(interfaceC3932Cy7)));
    }

    public static final AbstractC4099Dr3 c(InterfaceC3932Cy7 interfaceC3932Cy7) {
        AbstractC13042fc3.i(interfaceC3932Cy7, "typeProjection");
        return new C16430lG0(interfaceC3932Cy7, null, false, null, 14, null);
    }

    public static final boolean d(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return abstractC4099Dr3.K0() instanceof InterfaceC17612nG0;
    }

    public static final AbstractC5117Hy7 e(AbstractC5117Hy7 abstractC5117Hy7, boolean z) {
        AbstractC13042fc3.i(abstractC5117Hy7, "<this>");
        if (!(abstractC5117Hy7 instanceof C13957h63)) {
            return new b(z, abstractC5117Hy7);
        }
        C13957h63 c13957h63 = (C13957h63) abstractC5117Hy7;
        InterfaceC22882vy7[] interfaceC22882vy7ArrI = c13957h63.i();
        List<XV4> listU1 = AbstractC10242bK.u1(c13957h63.h(), c13957h63.i());
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listU1, 10));
        for (XV4 xv4 : listU1) {
            arrayList.add(b((InterfaceC3932Cy7) xv4.e(), (InterfaceC22882vy7) xv4.f()));
        }
        Object[] array = arrayList.toArray(new InterfaceC3932Cy7[0]);
        if (array != null) {
            return new C13957h63(interfaceC22882vy7ArrI, (InterfaceC3932Cy7[]) array, z);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static /* synthetic */ AbstractC5117Hy7 f(AbstractC5117Hy7 abstractC5117Hy7, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return e(abstractC5117Hy7, z);
    }
}
