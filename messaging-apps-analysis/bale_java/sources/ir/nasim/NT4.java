package ir.nasim;

import ir.nasim.VS4;
import java.util.List;

/* loaded from: classes2.dex */
public final class NT4 {
    public static final d e = new d(null);
    private static final MA7 f = new c();
    private static final InterfaceC14823iY2 g = new b();
    private final InterfaceC4557Fq2 a;
    private final MA7 b;
    private final InterfaceC14823iY2 c;
    private final SA2 d;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    public static final class b implements InterfaceC14823iY2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC14823iY2
        public void a(AbstractC20754sY7 abstractC20754sY7) {
            AbstractC13042fc3.i(abstractC20754sY7, "viewportHint");
        }
    }

    public static final class d {

        static final class a extends AbstractC8614Ws3 implements SA2 {
            public static final a e = new a();

            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final VS4.b invoke() {
                return VS4.b.g.c(AbstractC9766aX0.e(new C15054iv7(0, AbstractC10360bX0.m())), 0, 0, C14653iG3.f.a(), null);
            }
        }

        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(List list) {
                super(0);
                this.e = list;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final VS4.b invoke() {
                return VS4.b.g.c(AbstractC9766aX0.e(new C15054iv7(0, this.e)), 0, 0, C14653iG3.f.a(), null);
            }
        }

        private d() {
        }

        public final NT4 a() {
            return new NT4(AbstractC6459Nq2.T(new VS4.d(AbstractC10360bX0.m(), null, null)), d(), c(), a.e);
        }

        public final NT4 b(List list) {
            AbstractC13042fc3.i(list, "data");
            return new NT4(AbstractC6459Nq2.T(new VS4.d(list, null, null)), d(), c(), new b(list));
        }

        public final InterfaceC14823iY2 c() {
            return NT4.g;
        }

        public final MA7 d() {
            return NT4.f;
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    public NT4(InterfaceC4557Fq2 interfaceC4557Fq2, MA7 ma7, InterfaceC14823iY2 interfaceC14823iY2, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "flow");
        AbstractC13042fc3.i(ma7, "uiReceiver");
        AbstractC13042fc3.i(interfaceC14823iY2, "hintReceiver");
        AbstractC13042fc3.i(sa2, "cachedPageEvent");
        this.a = interfaceC4557Fq2;
        this.b = ma7;
        this.c = interfaceC14823iY2;
        this.d = sa2;
    }

    public final VS4.b c() {
        return (VS4.b) this.d.invoke();
    }

    public final InterfaceC4557Fq2 d() {
        return this.a;
    }

    public final InterfaceC14823iY2 e() {
        return this.c;
    }

    public final MA7 f() {
        return this.b;
    }

    public /* synthetic */ NT4(InterfaceC4557Fq2 interfaceC4557Fq2, MA7 ma7, InterfaceC14823iY2 interfaceC14823iY2, SA2 sa2, int i, ED1 ed1) {
        this(interfaceC4557Fq2, ma7, interfaceC14823iY2, (i & 8) != 0 ? a.e : sa2);
    }

    public static final class c implements MA7 {
        c() {
        }

        @Override // ir.nasim.MA7
        public void a() {
        }

        @Override // ir.nasim.MA7
        public void b() {
        }
    }
}
