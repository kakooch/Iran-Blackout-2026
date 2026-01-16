package ir.nasim;

/* renamed from: ir.nasim.rN5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20044rN5 {

    /* renamed from: ir.nasim.rN5$a */
    public enum a {
        LAUNCH_INITIAL_REFRESH,
        SKIP_INITIAL_REFRESH
    }

    /* renamed from: ir.nasim.rN5$b */
    public static abstract class b {

        /* renamed from: ir.nasim.rN5$b$a */
        public static final class a extends b {
            private final Throwable a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Throwable th) {
                super(null);
                AbstractC13042fc3.i(th, "throwable");
                this.a = th;
            }

            public final Throwable a() {
                return this.a;
            }
        }

        /* renamed from: ir.nasim.rN5$b$b, reason: collision with other inner class name */
        public static final class C1495b extends b {
            private final boolean a;

            public C1495b(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean a() {
                return this.a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public abstract Object a(InterfaceC20295rm1 interfaceC20295rm1);

    public abstract Object b(EnumC16433lG3 enumC16433lG3, ZT4 zt4, InterfaceC20295rm1 interfaceC20295rm1);
}
