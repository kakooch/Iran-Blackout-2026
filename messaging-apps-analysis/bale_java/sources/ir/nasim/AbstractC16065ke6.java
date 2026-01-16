package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC16065ke6;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.ke6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16065ke6 {
    private static final InterfaceC5766Kt a = AbstractC5999Lt.l(Type.TSIG, 0, T22.d(), 2, null);
    private static final InterfaceC5766Kt b = AbstractC5999Lt.l(Type.TSIG, 0, T22.d(), 2, null);

    /* renamed from: ir.nasim.ke6$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public final void a(List list, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(list, "tabPositions");
            C8528Wi7.a.b(AbstractC16065ke6.o(androidx.compose.ui.e.a, (C7824Ti7) list.get(this.a)), 0.0f, 0L, interfaceC22053ub1, C8528Wi7.c << 9, 6);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((List) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ke6$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C9023Yd6 a;
        final /* synthetic */ int b;
        final /* synthetic */ float c;
        final /* synthetic */ InterfaceC14603iB2 d;
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ InterfaceC15796kB2 f;
        final /* synthetic */ int g;

        /* renamed from: ir.nasim.ke6$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C9023Yd6 c;
            final /* synthetic */ float d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C9023Yd6 c9023Yd6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c9023Yd6;
                this.d = f;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C9023Yd6 c9023Yd6 = this.c;
                    float f = this.d;
                    this.b = 1;
                    if (AbstractC7778Td6.c(c9023Yd6, f, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ke6$b$b, reason: collision with other inner class name */
        static final class C1358b implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC15796kB2 a;
            final /* synthetic */ List b;

            C1358b(InterfaceC15796kB2 interfaceC15796kB2, List list) {
                this.a = interfaceC15796kB2;
                this.b = list;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.q(this.b, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(C9023Yd6 c9023Yd6, int i, float f, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2, int i2) {
            this.a = c9023Yd6;
            this.b = i;
            this.c = f;
            this.d = interfaceC14603iB2;
            this.e = interfaceC14603iB22;
            this.f = interfaceC15796kB2;
            this.g = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC11734dW3 k(float f, InterfaceC14603iB2 interfaceC14603iB2, final InterfaceC14603iB2 interfaceC14603iB22, final C12456ee6 c12456ee6, final int i, final InterfaceC15796kB2 interfaceC15796kB2, final UZ6 uz6, final C17833ne1 c17833ne1) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$tabs");
            AbstractC13042fc3.i(c12456ee6, "$scrollableTabData");
            AbstractC13042fc3.i(interfaceC15796kB2, "$indicator");
            AbstractC13042fc3.i(uz6, "$this$SubcomposeLayout");
            final int iB0 = uz6.B0(f);
            List listL0 = uz6.L0(EnumC9890aj7.a, interfaceC14603iB2);
            Integer numValueOf = 0;
            List list = listL0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                numValueOf = Integer.valueOf(Math.max(numValueOf.intValue(), ((ZV3) listL0.get(i2)).z(Integer.MAX_VALUE)));
            }
            final int iIntValue = numValueOf.intValue();
            long jD = C17833ne1.d(c17833ne1.r(), 0, 0, iIntValue, iIntValue, 3, null);
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ZV3 zv3 = (ZV3) listL0.get(i3);
                AbstractC21430te5 abstractC21430te5L0 = zv3.l0(jD);
                float fQ = C17784nZ1.q(uz6.D(Math.min(zv3.k0(abstractC21430te5L0.A0()), abstractC21430te5L0.P0())) - C17784nZ1.q(C17784nZ1.q(16) * 2));
                arrayList.add(abstractC21430te5L0);
                arrayList2.add(C17784nZ1.j(fQ));
            }
            Integer numValueOf2 = Integer.valueOf(iB0 * 2);
            int size3 = arrayList.size();
            for (int i4 = 0; i4 < size3; i4++) {
                numValueOf2 = Integer.valueOf(numValueOf2.intValue() + ((AbstractC21430te5) arrayList.get(i4)).P0());
            }
            final int iIntValue2 = numValueOf2.intValue();
            return InterfaceC12377eW3.Q1(uz6, iIntValue2, iIntValue, null, new UA2() { // from class: ir.nasim.ne6
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC16065ke6.b.n(iB0, arrayList, uz6, interfaceC14603iB22, c12456ee6, i, arrayList2, c17833ne1, iIntValue2, iIntValue, interfaceC15796kB2, (AbstractC21430te5.a) obj);
                }
            }, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(int i, List list, UZ6 uz6, InterfaceC14603iB2 interfaceC14603iB2, C12456ee6 c12456ee6, int i2, List list2, C17833ne1 c17833ne1, int i3, int i4, InterfaceC15796kB2 interfaceC15796kB2, AbstractC21430te5.a aVar) {
            List list3 = list;
            AbstractC13042fc3.i(list3, "$tabPlaceables");
            AbstractC13042fc3.i(uz6, "$this_SubcomposeLayout");
            AbstractC13042fc3.i(c12456ee6, "$scrollableTabData");
            AbstractC13042fc3.i(list2, "$tabContentWidths");
            AbstractC13042fc3.i(interfaceC15796kB2, "$indicator");
            AbstractC13042fc3.i(aVar, "$this$layout");
            ArrayList arrayList = new ArrayList();
            int size = list3.size();
            int iP0 = i;
            int i5 = 0;
            while (i5 < size) {
                AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) list3.get(i5);
                int i6 = iP0;
                int i7 = i5;
                AbstractC21430te5.a.l(aVar, abstractC21430te5, iP0, 0, 0.0f, 4, null);
                arrayList.add(new C7824Ti7(uz6.D(i6), uz6.D(abstractC21430te5.P0()), ((C17784nZ1) list2.get(i7)).v(), null));
                iP0 = i6 + abstractC21430te5.P0();
                i5 = i7 + 1;
                list3 = list;
            }
            List listL0 = uz6.L0(EnumC9890aj7.b, interfaceC14603iB2);
            int size2 = listL0.size();
            for (int i8 = 0; i8 < size2; i8++) {
                AbstractC21430te5 abstractC21430te5L0 = ((ZV3) listL0.get(i8)).l0(C17833ne1.d(c17833ne1.r(), i3, i3, 0, 0, 8, null));
                AbstractC21430te5.a.l(aVar, abstractC21430te5L0, 0, i4 - abstractC21430te5L0.A0(), 0.0f, 4, null);
            }
            List listL02 = uz6.L0(EnumC9890aj7.c, AbstractC19242q11.c(-1294232689, true, new C1358b(interfaceC15796kB2, arrayList)));
            int size3 = listL02.size();
            for (int i9 = 0; i9 < size3; i9++) {
                AbstractC21430te5.a.l(aVar, ((ZV3) listL02.get(i9)).l0(C17833ne1.b.c(i3, i4)), 0, 0, 0.0f, 4, null);
            }
            c12456ee6.c(uz6, i, arrayList, i2);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(int i, final InterfaceC20315ro1 interfaceC20315ro1, final C9023Yd6 c9023Yd6, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$coroutineScope");
            AbstractC13042fc3.i(c9023Yd6, "$scrollState");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.V(interfaceC11943do6, null, new InterfaceC14603iB2() { // from class: ir.nasim.oe6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(AbstractC16065ke6.b.p(interfaceC20315ro1, c9023Yd6, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
                }
            }, 1, null);
            AbstractC9939ao6.i0(interfaceC11943do6, new C5629Kd6(new SA2() { // from class: ir.nasim.pe6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return Float.valueOf(AbstractC16065ke6.b.t(c9023Yd6));
                }
            }, new SA2() { // from class: ir.nasim.qe6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return Float.valueOf(AbstractC16065ke6.b.v(c9023Yd6));
                }
            }, false, 4, null));
            AbstractC9939ao6.a0(interfaceC11943do6, new OW0(1, i));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean p(InterfaceC20315ro1 interfaceC20315ro1, C9023Yd6 c9023Yd6, float f, float f2) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$coroutineScope");
            AbstractC13042fc3.i(c9023Yd6, "$scrollState");
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c9023Yd6, f, null), 3, null);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float t(C9023Yd6 c9023Yd6) {
            AbstractC13042fc3.i(c9023Yd6, "$scrollState");
            return c9023Yd6.o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float v(C9023Yd6 c9023Yd6) {
            AbstractC13042fc3.i(c9023Yd6, "$scrollState");
            return c9023Yd6.n();
        }

        public final void i(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
            interfaceC22053ub1.W(-208198875);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(interfaceC20315ro1);
            C9023Yd6 c9023Yd6 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new C12456ee6(c9023Yd6, interfaceC20315ro1);
                interfaceC22053ub1.s(objB2);
            }
            final C12456ee6 c12456ee6 = (C12456ee6) objB2;
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarB = FV0.b(AbstractC8095Um6.a(AbstractC8014Ud6.b(androidx.compose.foundation.layout.t.E(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), InterfaceC12529em.a.h(), false, 2, null), this.a, false, null, false, 14, null)));
            interfaceC22053ub1.W(-208183477);
            boolean zD = interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(this.a) | interfaceC22053ub1.e(this.b);
            final int i2 = this.b;
            final C9023Yd6 c9023Yd62 = this.a;
            Object objB3 = interfaceC22053ub1.B();
            if (zD || objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.le6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16065ke6.b.o(i2, interfaceC20315ro1, c9023Yd62, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarC = AbstractC6919Pn6.c(eVarB, true, (UA2) objB3);
            interfaceC22053ub1.W(-208155599);
            boolean zC = interfaceC22053ub1.c(this.c) | interfaceC22053ub1.V(this.d) | interfaceC22053ub1.V(this.e) | interfaceC22053ub1.V(this.f) | interfaceC22053ub1.D(c12456ee6) | interfaceC22053ub1.e(this.g);
            final float f = this.c;
            final InterfaceC14603iB2 interfaceC14603iB2 = this.d;
            final InterfaceC14603iB2 interfaceC14603iB22 = this.e;
            final int i3 = this.g;
            final InterfaceC15796kB2 interfaceC15796kB2 = this.f;
            Object objB4 = interfaceC22053ub1.B();
            if (zC || objB4 == aVar.a()) {
                objB4 = new InterfaceC14603iB2() { // from class: ir.nasim.me6
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC16065ke6.b.k(f, interfaceC14603iB2, interfaceC14603iB22, c12456ee6, i3, interfaceC15796kB2, (UZ6) obj, (C17833ne1) obj2);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            SZ6.a(eVarC, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            i((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ke6$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        public final void a(List list, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(list, "tabPositions");
            if (this.a < list.size()) {
                C8528Wi7.a.b(AbstractC16065ke6.o(androidx.compose.ui.e.a, (C7824Ti7) list.get(this.a)), 0.0f, 0L, interfaceC22053ub1, C8528Wi7.c << 9, 6);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((List) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ke6$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ InterfaceC14603iB2 b;
        final /* synthetic */ InterfaceC15796kB2 c;

        /* renamed from: ir.nasim.ke6$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC15796kB2 a;
            final /* synthetic */ List b;

            a(InterfaceC15796kB2 interfaceC15796kB2, List list) {
                this.a = interfaceC15796kB2;
                this.b = list;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.q(this.b, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = eVar;
            this.b = interfaceC14603iB2;
            this.c = interfaceC15796kB2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC11734dW3 d(InterfaceC14603iB2 interfaceC14603iB2, final InterfaceC15796kB2 interfaceC15796kB2, final UZ6 uz6, final C17833ne1 c17833ne1) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$tabs");
            AbstractC13042fc3.i(interfaceC15796kB2, "$indicator");
            AbstractC13042fc3.i(uz6, "$this$SubcomposeLayout");
            List listL0 = uz6.L0("TabsFirst", interfaceC14603iB2);
            List list = listL0;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((ZV3) it.next()).k0(Integer.MAX_VALUE)));
            }
            int iP0 = 0;
            int iE = AbstractC23053wG5.e(C17833ne1.l(c17833ne1.r()) - AbstractC15401jX0.d1(arrayList), 0);
            int size = listL0.size();
            int i = size > 0 ? iE / size : 0;
            List listL02 = uz6.L0("TabsSecond", interfaceC14603iB2);
            final ArrayList<AbstractC21430te5> arrayList2 = new ArrayList(AbstractC10976cX0.x(listL02, 10));
            int i2 = 0;
            for (Object obj : listL02) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    AbstractC10360bX0.w();
                }
                arrayList2.add(((ZV3) obj).l0(C17833ne1.b.e(((Number) arrayList.get(i2)).intValue() + i)));
                i2 = i3;
            }
            List listC = AbstractC9766aX0.c();
            for (AbstractC21430te5 abstractC21430te5 : arrayList2) {
                listC.add(new C7824Ti7(uz6.D(iP0), uz6.D(abstractC21430te5.P0()), uz6.D(abstractC21430te5.P0()), null));
                iP0 += abstractC21430te5.P0();
            }
            final List listA = AbstractC9766aX0.a(listC);
            Iterator it2 = arrayList2.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            int iA0 = ((AbstractC21430te5) it2.next()).A0();
            while (true) {
                final int i4 = iA0;
                while (it2.hasNext()) {
                    iA0 = ((AbstractC21430te5) it2.next()).A0();
                    if (i4 < iA0) {
                        break;
                    }
                }
                return InterfaceC12377eW3.Q1(uz6, C17833ne1.l(c17833ne1.r()), i4, null, new UA2() { // from class: ir.nasim.se6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return AbstractC16065ke6.d.f(arrayList2, uz6, interfaceC15796kB2, listA, c17833ne1, i4, (AbstractC21430te5.a) obj2);
                    }
                }, 4, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(List list, UZ6 uz6, InterfaceC15796kB2 interfaceC15796kB2, List list2, C17833ne1 c17833ne1, int i, AbstractC21430te5.a aVar) {
            AbstractC13042fc3.i(list, "$tabPlaceables");
            AbstractC13042fc3.i(uz6, "$this_SubcomposeLayout");
            AbstractC13042fc3.i(interfaceC15796kB2, "$indicator");
            AbstractC13042fc3.i(list2, "$tabPositions");
            AbstractC13042fc3.i(aVar, "$this$layout");
            Iterator it = list.iterator();
            int iP0 = 0;
            while (it.hasNext()) {
                AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) it.next();
                AbstractC21430te5.a.l(aVar, abstractC21430te5, iP0, 0, 0.0f, 4, null);
                iP0 += abstractC21430te5.P0();
            }
            Iterator it2 = uz6.L0("Indicator", AbstractC19242q11.c(-119572968, true, new a(interfaceC15796kB2, list2))).iterator();
            while (it2.hasNext()) {
                AbstractC21430te5.a.l(aVar, ((ZV3) it2.next()).l0(C17833ne1.b.c(C17833ne1.l(c17833ne1.r()), i)), 0, 0, 0.0f, 4, null);
            }
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(this.a, 0.0f, 1, null);
            interfaceC22053ub1.W(978808536);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.V(this.c);
            final InterfaceC14603iB2 interfaceC14603iB2 = this.b;
            final InterfaceC15796kB2 interfaceC15796kB2 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC14603iB2() { // from class: ir.nasim.re6
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC16065ke6.d.d(interfaceC14603iB2, interfaceC15796kB2, (UZ6) obj, (C17833ne1) obj2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            SZ6.a(eVarH, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ke6$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C7824Ti7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C7824Ti7 c7824Ti7) {
            super(1);
            this.e = c7824Ti7;
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

    /* renamed from: ir.nasim.ke6$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ C7824Ti7 a;

        f(C7824Ti7 c7824Ti7) {
            this.a = c7824Ti7;
        }

        private static final float c(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C17784nZ1) interfaceC9664aL6.getValue()).v();
        }

        private static final float d(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C17784nZ1) interfaceC9664aL6.getValue()).v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C22045ua3 f(InterfaceC9664aL6 interfaceC9664aL6, WH1 wh1) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$indicatorOffset$delegate");
            AbstractC13042fc3.i(wh1, "$this$offset");
            return C22045ua3.c(C22045ua3.f((wh1.B0(d(interfaceC9664aL6)) << 32) | (0 & 4294967295L)));
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(881516582);
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC4572Fs.c(this.a.c(), AbstractC16065ke6.b, null, null, interfaceC22053ub1, 0, 12);
            final InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC4572Fs.c(this.a.a(), AbstractC16065ke6.b, null, null, interfaceC22053ub1, 0, 12);
            androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(androidx.compose.foundation.layout.t.h(eVar, 0.0f, 1, null), InterfaceC12529em.a.d(), false, 2, null);
            interfaceC22053ub1.W(-1833871976);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.te6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16065ke6.f.f(interfaceC9664aL6C2, (WH1) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.n.a(eVarE, (UA2) objB), c(interfaceC9664aL6C));
            interfaceC22053ub1.Q();
            return eVarY;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final int r28, final int r29, androidx.compose.ui.e r30, long r31, long r33, float r35, ir.nasim.InterfaceC15796kB2 r36, ir.nasim.InterfaceC14603iB2 r37, final ir.nasim.InterfaceC14603iB2 r38, ir.nasim.InterfaceC22053ub1 r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16065ke6.e(int, int, androidx.compose.ui.e, long, long, float, ir.nasim.kB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void f(final int r34, final int r35, final ir.nasim.InterfaceC15796kB2 r36, androidx.compose.ui.e r37, long r38, long r40, float r42, ir.nasim.InterfaceC14603iB2 r43, final ir.nasim.InterfaceC14603iB2 r44, final ir.nasim.C9023Yd6 r45, ir.nasim.InterfaceC22053ub1 r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16065ke6.f(int, int, ir.nasim.kB2, androidx.compose.ui.e, long, long, float, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.Yd6, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(int i, int i2, InterfaceC15796kB2 interfaceC15796kB2, androidx.compose.ui.e eVar, long j, long j2, float f2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, C9023Yd6 c9023Yd6, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(interfaceC15796kB2, "$indicator");
        AbstractC13042fc3.i(interfaceC14603iB22, "$tabs");
        AbstractC13042fc3.i(c9023Yd6, "$scrollState");
        f(i, i2, interfaceC15796kB2, eVar, j, j2, f2, interfaceC14603iB2, interfaceC14603iB22, c9023Yd6, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(int i, int i2, androidx.compose.ui.e eVar, long j, long j2, float f2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(interfaceC14603iB22, "$tabs");
        e(i, i2, eVar, j, j2, f2, interfaceC15796kB2, interfaceC14603iB2, interfaceC14603iB22, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final int r21, androidx.compose.ui.e r22, long r23, long r25, ir.nasim.InterfaceC15796kB2 r27, ir.nasim.InterfaceC14603iB2 r28, final ir.nasim.InterfaceC14603iB2 r29, ir.nasim.InterfaceC22053ub1 r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16065ke6.i(int, androidx.compose.ui.e, long, long, ir.nasim.kB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    private static final void j(final androidx.compose.ui.e eVar, final long j, final long j2, final InterfaceC15796kB2 interfaceC15796kB2, final InterfaceC14603iB2 interfaceC14603iB2, final InterfaceC14603iB2 interfaceC14603iB22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1614574005);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.f(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.f(j2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 2048 : 1024;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 131072 : 65536;
        }
        if ((66707 & i2) == 66706 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i3 = i2 << 3;
            F27.a(AbstractC8095Um6.a(eVar), null, j, j2, 0.0f, 0.0f, null, AbstractC19242q11.e(2077426128, true, new d(eVar, interfaceC14603iB22, interfaceC15796kB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, (i3 & 896) | 12582912 | (i3 & 7168), 114);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ie6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16065ke6.k(eVar, j, j2, interfaceC15796kB2, interfaceC14603iB2, interfaceC14603iB22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(androidx.compose.ui.e eVar, long j, long j2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(interfaceC15796kB2, "$indicator");
        AbstractC13042fc3.i(interfaceC14603iB2, "$divider");
        AbstractC13042fc3.i(interfaceC14603iB22, "$tabs");
        j(eVar, j, j2, interfaceC15796kB2, interfaceC14603iB2, interfaceC14603iB22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, androidx.compose.ui.e eVar, long j, long j2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC14603iB22, "$tabs");
        i(i, eVar, j, j2, interfaceC15796kB2, interfaceC14603iB2, interfaceC14603iB22, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e o(androidx.compose.ui.e eVar, C7824Ti7 c7824Ti7) {
        AbstractC13042fc3.i(eVar, "<this>");
        AbstractC13042fc3.i(c7824Ti7, "currentTabPosition");
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new e(c7824Ti7) : Q93.a(), new f(c7824Ti7));
    }
}
