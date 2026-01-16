package ir.nasim;

import java.util.List;

/* loaded from: classes.dex */
final class GE1 extends GT4 {
    public static final c M = new c(null);
    private static final InterfaceC8230Vb6 N = WB3.a(a.e, b.e);
    private InterfaceC9102Ym4 L;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(InterfaceC8730Xb6 interfaceC8730Xb6, GE1 ge1) {
            return AbstractC10360bX0.p(Integer.valueOf(ge1.v()), Float.valueOf(AbstractC23053wG5.l(ge1.w(), -0.5f, 0.5f)), Integer.valueOf(ge1.H()));
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list) {
                super(0);
                this.e = list;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                Object obj = this.e.get(2);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Int");
                return (Integer) obj;
            }
        }

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GE1 invoke(List list) {
            Object obj = list.get(0);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new GE1(iIntValue, ((Float) obj2).floatValue(), new a(list));
        }
    }

    public static final class c {
        private c() {
        }

        public final InterfaceC8230Vb6 a() {
            return GE1.N;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public GE1(int i, float f, SA2 sa2) {
        super(i, f);
        this.L = AbstractC13472gH6.d(sa2, null, 2, null);
    }

    @Override // ir.nasim.GT4
    public int H() {
        return ((Number) ((SA2) this.L.getValue()).invoke()).intValue();
    }

    public final InterfaceC9102Ym4 q0() {
        return this.L;
    }
}
