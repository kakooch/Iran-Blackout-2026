package ir.nasim;

/* loaded from: classes3.dex */
public final class JG6 {
    public static final JG6 a = new JG6();
    private static final InterfaceC5766Kt b = AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null);
    private static final UA2 c = a.e;
    private static final InterfaceC15796kB2 d = b.e;
    public static final int e = 8;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke(LG6 lg6) {
            AbstractC13042fc3.i(lg6, "it");
            return Float.valueOf(Float.MAX_VALUE);
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final b e = new b();

        b() {
            super(3);
        }

        public final Integer a(LG6 lg6, int i, int i2) {
            AbstractC13042fc3.i(lg6, "$noName_0");
            return Integer.valueOf(i2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((LG6) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }
    }

    private JG6() {
    }

    public final UA2 a() {
        return c;
    }

    public final InterfaceC5766Kt b() {
        return b;
    }
}
