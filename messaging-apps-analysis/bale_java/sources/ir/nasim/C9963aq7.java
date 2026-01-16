package ir.nasim;

/* renamed from: ir.nasim.aq7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9963aq7 {
    public static final C9963aq7 a = new C9963aq7();
    private static SA2 b = a.a;

    /* renamed from: ir.nasim.aq7$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    private C9963aq7() {
    }

    public final long a() {
        return ((Number) b.invoke()).longValue();
    }
}
