package ir.nasim;

/* renamed from: ir.nasim.sS0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20693sS0 {
    private final boolean a;

    /* renamed from: ir.nasim.sS0$a */
    public static final class a extends AbstractC20693sS0 {
        public static final a b = new a();

        private a() {
            super(false, null);
        }
    }

    /* renamed from: ir.nasim.sS0$b */
    public static final class b extends AbstractC20693sS0 {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, null);
            AbstractC13042fc3.i(str, "error");
            this.b = str;
        }
    }

    /* renamed from: ir.nasim.sS0$c */
    public static final class c extends AbstractC20693sS0 {
        public static final c b = new c();

        private c() {
            super(true, null);
        }
    }

    public /* synthetic */ AbstractC20693sS0(boolean z, ED1 ed1) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }

    private AbstractC20693sS0(boolean z) {
        this.a = z;
    }
}
