package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.mG0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC17021mG0 {

    /* renamed from: ir.nasim.mG0$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KQ7.valuesCustom().length];
            iArr[KQ7.INVARIANT.ordinal()] = 1;
            iArr[KQ7.IN_VARIANCE.ordinal()] = 2;
            iArr[KQ7.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.mG0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC18174oC7 abstractC18174oC7) {
            AbstractC13042fc3.h(abstractC18174oC7, "it");
            return Boolean.valueOf(AbstractC18794pG0.d(abstractC18174oC7));
        }
    }

    /* renamed from: ir.nasim.mG0$c */
    public static final class c extends AbstractC15082iy7 {
        c() {
        }

        @Override // ir.nasim.AbstractC15082iy7
        public InterfaceC3932Cy7 j(InterfaceC13882gy7 interfaceC13882gy7) {
            AbstractC13042fc3.i(interfaceC13882gy7, "key");
            InterfaceC17612nG0 interfaceC17612nG0 = interfaceC13882gy7 instanceof InterfaceC17612nG0 ? (InterfaceC17612nG0) interfaceC13882gy7 : null;
            if (interfaceC17612nG0 == null) {
                return null;
            }
            return interfaceC17612nG0.c().b() ? new C4400Ey7(KQ7.OUT_VARIANCE, interfaceC17612nG0.c().getType()) : interfaceC17612nG0.c();
        }
    }

    public static final C18202oG a(AbstractC4099Dr3 abstractC4099Dr3) {
        Object objE;
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        if (AbstractC7411Rp2.b(abstractC4099Dr3)) {
            C18202oG c18202oGA = a(AbstractC7411Rp2.c(abstractC4099Dr3));
            C18202oG c18202oGA2 = a(AbstractC7411Rp2.d(abstractC4099Dr3));
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            return new C18202oG(AbstractC8692Wy7.b(C4567Fr3.d(AbstractC7411Rp2.c((AbstractC4099Dr3) c18202oGA.c()), AbstractC7411Rp2.d((AbstractC4099Dr3) c18202oGA2.c())), abstractC4099Dr3), AbstractC8692Wy7.b(C4567Fr3.d(AbstractC7411Rp2.c((AbstractC4099Dr3) c18202oGA.d()), AbstractC7411Rp2.d((AbstractC4099Dr3) c18202oGA2.d())), abstractC4099Dr3));
        }
        InterfaceC13882gy7 interfaceC13882gy7K0 = abstractC4099Dr3.K0();
        if (AbstractC18794pG0.d(abstractC4099Dr3)) {
            InterfaceC3932Cy7 interfaceC3932Cy7C = ((InterfaceC17612nG0) interfaceC13882gy7K0).c();
            AbstractC4099Dr3 type = interfaceC3932Cy7C.getType();
            AbstractC13042fc3.h(type, "typeProjection.type");
            AbstractC4099Dr3 abstractC4099Dr3B = b(type, abstractC4099Dr3);
            int i = a.a[interfaceC3932Cy7C.c().ordinal()];
            if (i == 2) {
                XC6 xc6I = AbstractC7731Sy7.e(abstractC4099Dr3).I();
                AbstractC13042fc3.h(xc6I, "type.builtIns.nullableAnyType");
                return new C18202oG(abstractC4099Dr3B, xc6I);
            }
            if (i != 3) {
                throw new AssertionError(AbstractC13042fc3.q("Only nontrivial projections should have been captured, not: ", interfaceC3932Cy7C));
            }
            XC6 xc6H = AbstractC7731Sy7.e(abstractC4099Dr3).H();
            AbstractC13042fc3.h(xc6H, "type.builtIns.nothingType");
            return new C18202oG(b(xc6H, abstractC4099Dr3), abstractC4099Dr3B);
        }
        if (abstractC4099Dr3.J0().isEmpty() || abstractC4099Dr3.J0().size() != interfaceC13882gy7K0.getParameters().size()) {
            return new C18202oG(abstractC4099Dr3, abstractC4099Dr3);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listJ0 = abstractC4099Dr3.J0();
        List parameters = interfaceC13882gy7K0.getParameters();
        AbstractC13042fc3.h(parameters, "typeConstructor.parameters");
        for (XV4 xv4 : AbstractC15401jX0.v1(listJ0, parameters)) {
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) xv4.a();
            InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) xv4.b();
            AbstractC13042fc3.h(interfaceC22882vy7, "typeParameter");
            C8949Xx7 c8949Xx7G = g(interfaceC3932Cy7, interfaceC22882vy7);
            if (interfaceC3932Cy7.b()) {
                arrayList.add(c8949Xx7G);
                arrayList2.add(c8949Xx7G);
            } else {
                C18202oG c18202oGD = d(c8949Xx7G);
                C8949Xx7 c8949Xx7 = (C8949Xx7) c18202oGD.a();
                C8949Xx7 c8949Xx72 = (C8949Xx7) c18202oGD.b();
                arrayList.add(c8949Xx7);
                arrayList2.add(c8949Xx72);
            }
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!((C8949Xx7) it.next()).d()) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            objE = AbstractC7731Sy7.e(abstractC4099Dr3).H();
            AbstractC13042fc3.h(objE, "type.builtIns.nothingType");
        } else {
            objE = e(abstractC4099Dr3, arrayList);
        }
        return new C18202oG(objE, e(abstractC4099Dr3, arrayList2));
    }

    private static final AbstractC4099Dr3 b(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        AbstractC4099Dr3 abstractC4099Dr3Q = AbstractC7497Ry7.q(abstractC4099Dr3, abstractC4099Dr32.L0());
        AbstractC13042fc3.h(abstractC4099Dr3Q, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return abstractC4099Dr3Q;
    }

    public static final InterfaceC3932Cy7 c(InterfaceC3932Cy7 interfaceC3932Cy7, boolean z) {
        if (interfaceC3932Cy7 == null) {
            return null;
        }
        if (interfaceC3932Cy7.b()) {
            return interfaceC3932Cy7;
        }
        AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
        AbstractC13042fc3.h(type, "typeProjection.type");
        if (!AbstractC7497Ry7.c(type, b.e)) {
            return interfaceC3932Cy7;
        }
        KQ7 kq7C = interfaceC3932Cy7.c();
        AbstractC13042fc3.h(kq7C, "typeProjection.projectionKind");
        return kq7C == KQ7.OUT_VARIANCE ? new C4400Ey7(kq7C, (AbstractC4099Dr3) a(type).d()) : z ? new C4400Ey7(kq7C, (AbstractC4099Dr3) a(type).c()) : f(interfaceC3932Cy7);
    }

    private static final C18202oG d(C8949Xx7 c8949Xx7) {
        C18202oG c18202oGA = a(c8949Xx7.a());
        AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) c18202oGA.a();
        AbstractC4099Dr3 abstractC4099Dr32 = (AbstractC4099Dr3) c18202oGA.b();
        C18202oG c18202oGA2 = a(c8949Xx7.b());
        return new C18202oG(new C8949Xx7(c8949Xx7.c(), abstractC4099Dr32, (AbstractC4099Dr3) c18202oGA2.a()), new C8949Xx7(c8949Xx7.c(), abstractC4099Dr3, (AbstractC4099Dr3) c18202oGA2.b()));
    }

    private static final AbstractC4099Dr3 e(AbstractC4099Dr3 abstractC4099Dr3, List list) {
        abstractC4099Dr3.J0().size();
        list.size();
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(h((C8949Xx7) it.next()));
        }
        return AbstractC5351Iy7.e(abstractC4099Dr3, arrayList, null, null, 6, null);
    }

    private static final InterfaceC3932Cy7 f(InterfaceC3932Cy7 interfaceC3932Cy7) {
        C5585Jy7 c5585Jy7G = C5585Jy7.g(new c());
        AbstractC13042fc3.h(c5585Jy7G, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return c5585Jy7G.t(interfaceC3932Cy7);
    }

    private static final C8949Xx7 g(InterfaceC3932Cy7 interfaceC3932Cy7, InterfaceC22882vy7 interfaceC22882vy7) {
        int i = a.a[C5585Jy7.c(interfaceC22882vy7.m(), interfaceC3932Cy7).ordinal()];
        if (i == 1) {
            AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
            AbstractC13042fc3.h(type, "type");
            AbstractC4099Dr3 type2 = interfaceC3932Cy7.getType();
            AbstractC13042fc3.h(type2, "type");
            return new C8949Xx7(interfaceC22882vy7, type, type2);
        }
        if (i == 2) {
            AbstractC4099Dr3 type3 = interfaceC3932Cy7.getType();
            AbstractC13042fc3.h(type3, "type");
            XC6 xc6I = PI1.g(interfaceC22882vy7).I();
            AbstractC13042fc3.h(xc6I, "typeParameter.builtIns.nullableAnyType");
            return new C8949Xx7(interfaceC22882vy7, type3, xc6I);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        XC6 xc6H = PI1.g(interfaceC22882vy7).H();
        AbstractC13042fc3.h(xc6H, "typeParameter.builtIns.nothingType");
        AbstractC4099Dr3 type4 = interfaceC3932Cy7.getType();
        AbstractC13042fc3.h(type4, "type");
        return new C8949Xx7(interfaceC22882vy7, xc6H, type4);
    }

    private static final InterfaceC3932Cy7 h(C8949Xx7 c8949Xx7) {
        c8949Xx7.d();
        if (!AbstractC13042fc3.d(c8949Xx7.a(), c8949Xx7.b())) {
            KQ7 kq7M = c8949Xx7.c().m();
            KQ7 kq7 = KQ7.IN_VARIANCE;
            if (kq7M != kq7) {
                return (!AbstractC19738qr3.t0(c8949Xx7.a()) || c8949Xx7.c().m() == kq7) ? AbstractC19738qr3.v0(c8949Xx7.b()) ? new C4400Ey7(i(c8949Xx7, kq7), c8949Xx7.a()) : new C4400Ey7(i(c8949Xx7, KQ7.OUT_VARIANCE), c8949Xx7.b()) : new C4400Ey7(i(c8949Xx7, KQ7.OUT_VARIANCE), c8949Xx7.b());
            }
        }
        return new C4400Ey7(c8949Xx7.a());
    }

    private static final KQ7 i(C8949Xx7 c8949Xx7, KQ7 kq7) {
        return kq7 == c8949Xx7.c().m() ? KQ7.INVARIANT : kq7;
    }
}
