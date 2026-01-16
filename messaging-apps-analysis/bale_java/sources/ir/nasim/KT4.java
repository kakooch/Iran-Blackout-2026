package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class KT4 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final Integer a(int i) {
            return Integer.valueOf(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ HT4 g;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC13042fc3.i(aVar, "$this$layout");
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.KT4$b$b, reason: collision with other inner class name */
        static final class C0465b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC21430te5 e;
            final /* synthetic */ int f;
            final /* synthetic */ long g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0465b(AbstractC21430te5 abstractC21430te5, int i, long j) {
                super(1);
                this.e = abstractC21430te5;
                this.f = i;
                this.g = j;
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC13042fc3.i(aVar, "$this$layout");
                AbstractC21430te5.a.l(aVar, this.e, this.f, Math.max(C17833ne1.m(this.g) - this.e.A0(), 0), 0.0f, 4, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, UA2 ua2, HT4 ht4) {
            super(3);
            this.e = list;
            this.f = ua2;
            this.g = ht4;
        }

        public final InterfaceC11734dW3 a(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
            AbstractC13042fc3.i(interfaceC12377eW3, "$this$layout");
            AbstractC13042fc3.i(zv3, "measurable");
            if (this.e.isEmpty()) {
                return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.l(j), 0, null, a.e, 4, null);
            }
            int iMin = Math.min(AbstractC10360bX0.o(this.e), ((Number) this.f.invoke(Integer.valueOf(this.g.k()))).intValue());
            C8060Ui7 c8060Ui7 = (C8060Ui7) this.e.get(iMin);
            C8060Ui7 c8060Ui72 = (C8060Ui7) AbstractC15401jX0.t0(this.e, iMin - 1);
            C8060Ui7 c8060Ui73 = (C8060Ui7) AbstractC15401jX0.t0(this.e, iMin + 1);
            float fM = this.g.m();
            float f = 0;
            int iB0 = (fM <= f || c8060Ui73 == null) ? (fM >= f || c8060Ui72 == null) ? interfaceC12377eW3.B0(c8060Ui7.c()) : interfaceC12377eW3.B0(AbstractC18966pZ1.c(c8060Ui7.c(), c8060Ui72.c(), -fM)) : interfaceC12377eW3.B0(AbstractC18966pZ1.c(c8060Ui7.c(), c8060Ui73.c(), fM));
            int iB02 = (fM <= f || c8060Ui73 == null) ? (fM >= f || c8060Ui72 == null) ? interfaceC12377eW3.B0(c8060Ui7.a()) : interfaceC12377eW3.B0(AbstractC18966pZ1.c(c8060Ui7.a(), c8060Ui72.a(), -fM)) : interfaceC12377eW3.B0(AbstractC18966pZ1.c(c8060Ui7.a(), c8060Ui73.a(), fM));
            AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.a(iB0, iB0, 0, C17833ne1.k(j)));
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.l(j), Math.max(abstractC21430te5L0.A0(), C17833ne1.m(j)), null, new C0465b(abstractC21430te5L0, iB02, j), 4, null);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((InterfaceC12377eW3) obj, (ZV3) obj2, ((C17833ne1) obj3).r());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, HT4 ht4, List list, UA2 ua2) {
        AbstractC13042fc3.i(eVar, "<this>");
        AbstractC13042fc3.i(ht4, "pagerState");
        AbstractC13042fc3.i(list, "tabPositions");
        AbstractC13042fc3.i(ua2, "pageIndexMapping");
        return androidx.compose.ui.layout.b.a(eVar, new b(list, ua2, ht4));
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, HT4 ht4, List list, UA2 ua2, int i, Object obj) {
        if ((i & 4) != 0) {
            ua2 = a.e;
        }
        return a(eVar, ht4, list, ua2);
    }
}
