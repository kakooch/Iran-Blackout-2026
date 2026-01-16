package ir.nasim;

/* loaded from: classes2.dex */
public interface DT1 {
    public static final b a = b.a;

    public interface a extends DT1 {
    }

    public static final class b {
        static final /* synthetic */ b a = new b();

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ET1 invoke(TK6 tk6) {
                AbstractC13042fc3.i(tk6, "it");
                ET1 et1C = ET1.c(ET1.k);
                AbstractC13042fc3.h(et1C, "Suggested(SPREAD_DIMENSION)");
                return et1C;
            }
        }

        /* renamed from: ir.nasim.DT1$b$b, reason: collision with other inner class name */
        static final class C0321b extends AbstractC8614Ws3 implements UA2 {
            public static final C0321b e = new C0321b();

            C0321b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ET1 invoke(TK6 tk6) {
                AbstractC13042fc3.i(tk6, "it");
                ET1 et1B = ET1.b(ET1.j);
                AbstractC13042fc3.h(et1B, "Fixed(WRAP_DIMENSION)");
                return et1B;
            }
        }

        private b() {
        }

        public final a a() {
            return new HT1(a.e);
        }

        public final DT1 b() {
            return new HT1(C0321b.e);
        }
    }
}
