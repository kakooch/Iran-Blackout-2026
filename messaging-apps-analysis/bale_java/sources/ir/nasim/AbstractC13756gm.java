package ir.nasim;

/* renamed from: ir.nasim.gm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13756gm {
    private static final HY2 a = new HY2(a.a);
    private static final HY2 b = new HY2(b.a);

    /* renamed from: ir.nasim.gm$a */
    /* synthetic */ class a extends EB2 implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
            super(2, AbstractC19523qV3.class, "min", "min(II)I", 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return y(((Number) obj).intValue(), ((Number) obj2).intValue());
        }

        public final Integer y(int i, int i2) {
            return Integer.valueOf(Math.min(i, i2));
        }
    }

    /* renamed from: ir.nasim.gm$b */
    /* synthetic */ class b extends EB2 implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
            super(2, AbstractC19523qV3.class, "max", "max(II)I", 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return y(((Number) obj).intValue(), ((Number) obj2).intValue());
        }

        public final Integer y(int i, int i2) {
            return Integer.valueOf(Math.max(i, i2));
        }
    }

    public static final HY2 a() {
        return a;
    }

    public static final HY2 b() {
        return b;
    }

    public static final int c(AbstractC13165fm abstractC13165fm, int i, int i2) {
        return ((Number) abstractC13165fm.a().invoke(Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }
}
