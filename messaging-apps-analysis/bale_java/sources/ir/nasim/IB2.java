package ir.nasim;

/* loaded from: classes8.dex */
public abstract class IB2 {
    private static final UA2 a = f.e;
    private static final UA2 b = b.e;
    private static final UA2 c = a.e;
    private static final UA2 d = c.e;
    private static final InterfaceC14603iB2 e = d.e;
    private static final InterfaceC15796kB2 f = e.e;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final boolean a(Object obj) {
            return true;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a(obj));
        }
    }

    public static final UA2 a() {
        return b;
    }

    public static final InterfaceC15796kB2 b() {
        return f;
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }

        public final void a(Object obj) {
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return obj;
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(obj, obj2);
            return C19938rB7.a;
        }

        public final void a(Object obj, Object obj2) {
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final e e = new e();

        e() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a(obj, obj2, obj3);
            return C19938rB7.a;
        }

        public final void a(Object obj, Object obj2, Object obj3) {
        }
    }
}
