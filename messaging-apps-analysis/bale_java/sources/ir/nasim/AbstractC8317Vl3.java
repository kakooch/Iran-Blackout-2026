package ir.nasim;

/* renamed from: ir.nasim.Vl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8317Vl3 {
    public static final b a = new b(null);
    private static final d b = new d(EnumC7376Rl3.BOOLEAN);
    private static final d c = new d(EnumC7376Rl3.CHAR);
    private static final d d = new d(EnumC7376Rl3.BYTE);
    private static final d e = new d(EnumC7376Rl3.SHORT);
    private static final d f = new d(EnumC7376Rl3.INT);
    private static final d g = new d(EnumC7376Rl3.FLOAT);
    private static final d h = new d(EnumC7376Rl3.LONG);
    private static final d i = new d(EnumC7376Rl3.DOUBLE);

    /* renamed from: ir.nasim.Vl3$a */
    public static final class a extends AbstractC8317Vl3 {
        private final AbstractC8317Vl3 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC8317Vl3 abstractC8317Vl3) {
            super(null);
            AbstractC13042fc3.i(abstractC8317Vl3, "elementType");
            this.j = abstractC8317Vl3;
        }

        public final AbstractC8317Vl3 i() {
            return this.j;
        }
    }

    /* renamed from: ir.nasim.Vl3$b */
    public static final class b {
        private b() {
        }

        public final d a() {
            return AbstractC8317Vl3.b;
        }

        public final d b() {
            return AbstractC8317Vl3.d;
        }

        public final d c() {
            return AbstractC8317Vl3.c;
        }

        public final d d() {
            return AbstractC8317Vl3.i;
        }

        public final d e() {
            return AbstractC8317Vl3.g;
        }

        public final d f() {
            return AbstractC8317Vl3.f;
        }

        public final d g() {
            return AbstractC8317Vl3.h;
        }

        public final d h() {
            return AbstractC8317Vl3.e;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Vl3$c */
    public static final class c extends AbstractC8317Vl3 {
        private final String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            AbstractC13042fc3.i(str, "internalName");
            this.j = str;
        }

        public final String i() {
            return this.j;
        }
    }

    /* renamed from: ir.nasim.Vl3$d */
    public static final class d extends AbstractC8317Vl3 {
        private final EnumC7376Rl3 j;

        public d(EnumC7376Rl3 enumC7376Rl3) {
            super(null);
            this.j = enumC7376Rl3;
        }

        public final EnumC7376Rl3 i() {
            return this.j;
        }
    }

    private AbstractC8317Vl3() {
    }

    public String toString() {
        return C8817Xl3.a.c(this);
    }

    public /* synthetic */ AbstractC8317Vl3(ED1 ed1) {
        this();
    }
}
