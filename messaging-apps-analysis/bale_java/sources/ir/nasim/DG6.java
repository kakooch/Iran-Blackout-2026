package ir.nasim;

/* loaded from: classes3.dex */
public final class DG6 {
    public static final DG6 a = new DG6();
    private static final InterfaceC14603iB2 b = c.e;
    private static final InterfaceC14603iB2 c = a.e;
    private static final InterfaceC14603iB2 d = b.e;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(LG6 lg6, MG6 mg6) {
            AbstractC13042fc3.i(lg6, "layout");
            AbstractC13042fc3.i(mg6, "item");
            return Integer.valueOf(lg6.g() + (((lg6.f() - lg6.g()) - mg6.c()) / 2));
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(LG6 lg6, MG6 mg6) {
            AbstractC13042fc3.i(lg6, "layout");
            AbstractC13042fc3.i(mg6, "item");
            return Integer.valueOf(lg6.f() - mg6.c());
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(LG6 lg6, MG6 mg6) {
            AbstractC13042fc3.i(lg6, "layout");
            AbstractC13042fc3.i(mg6, "$noName_1");
            return Integer.valueOf(lg6.g());
        }
    }

    private DG6() {
    }

    public final InterfaceC14603iB2 a() {
        return c;
    }

    public final InterfaceC14603iB2 b() {
        return b;
    }
}
