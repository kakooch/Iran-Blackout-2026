package ir.nasim;

/* renamed from: ir.nasim.xG2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC23640xG2 {

    /* renamed from: ir.nasim.xG2$a */
    public static final class a extends AbstractC23640xG2 {
        private final Exception a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Exception exc) {
            super(null);
            AbstractC13042fc3.i(exc, "exception");
            this.a = exc;
        }

        public final Exception a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.xG2$b */
    public static final class b extends AbstractC23640xG2 {
        private final Object a;

        public b(Object obj) {
            super(null);
            this.a = obj;
        }

        public final Object a() {
            return this.a;
        }
    }

    private AbstractC23640xG2() {
    }

    public /* synthetic */ AbstractC23640xG2(ED1 ed1) {
        this();
    }
}
