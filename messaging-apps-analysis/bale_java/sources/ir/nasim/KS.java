package ir.nasim;

/* loaded from: classes2.dex */
public final class KS implements InterfaceC10444bd1 {
    public static final InterfaceC10444bd1 a = new KS();

    private static final class a implements InterfaceC19389qG4 {
        static final a a = new a();
        private static final C24510yk2 b = C24510yk2.a("window").b(LL.b().c(1).a()).a();
        private static final C24510yk2 c = C24510yk2.a("logSourceMetrics").b(LL.b().c(2).a()).a();
        private static final C24510yk2 d = C24510yk2.a("globalMetrics").b(LL.b().c(3).a()).a();
        private static final C24510yk2 e = C24510yk2.a("appNamespace").b(LL.b().c(4).a()).a();

        private a() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C23183wV0 c23183wV0, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, c23183wV0.d());
            interfaceC19980rG4.c(c, c23183wV0.c());
            interfaceC19980rG4.c(d, c23183wV0.b());
            interfaceC19980rG4.c(e, c23183wV0.a());
        }
    }

    private static final class b implements InterfaceC19389qG4 {
        static final b a = new b();
        private static final C24510yk2 b = C24510yk2.a("storageMetrics").b(LL.b().c(1).a()).a();

        private b() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C15277jJ2 c15277jJ2, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, c15277jJ2.a());
        }
    }

    private static final class c implements InterfaceC19389qG4 {
        static final c a = new c();
        private static final C24510yk2 b = C24510yk2.a("eventsDroppedCount").b(LL.b().c(1).a()).a();
        private static final C24510yk2 c = C24510yk2.a("reason").b(LL.b().c(3).a()).a();

        private c() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C22473vI3 c22473vI3, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.b(b, c22473vI3.a());
            interfaceC19980rG4.c(c, c22473vI3.b());
        }
    }

    private static final class d implements InterfaceC19389qG4 {
        static final d a = new d();
        private static final C24510yk2 b = C24510yk2.a("logSource").b(LL.b().c(1).a()).a();
        private static final C24510yk2 c = C24510yk2.a("logEventDropped").b(LL.b().c(2).a()).a();

        private d() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(DI3 di3, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, di3.b());
            interfaceC19980rG4.c(c, di3.a());
        }
    }

    private static final class e implements InterfaceC19389qG4 {
        static final e a = new e();
        private static final C24510yk2 b = C24510yk2.d("clientMetrics");

        private e() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            b(null, (InterfaceC19980rG4) obj2);
        }

        public void b(AbstractC17435mx5 abstractC17435mx5, InterfaceC19980rG4 interfaceC19980rG4) {
            throw null;
        }
    }

    private static final class f implements InterfaceC19389qG4 {
        static final f a = new f();
        private static final C24510yk2 b = C24510yk2.a("currentCacheSizeBytes").b(LL.b().c(1).a()).a();
        private static final C24510yk2 c = C24510yk2.a("maxCacheSizeBytes").b(LL.b().c(2).a()).a();

        private f() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(KO6 ko6, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.b(b, ko6.a());
            interfaceC19980rG4.b(c, ko6.b());
        }
    }

    private static final class g implements InterfaceC19389qG4 {
        static final g a = new g();
        private static final C24510yk2 b = C24510yk2.a("startMs").b(LL.b().c(1).a()).a();
        private static final C24510yk2 c = C24510yk2.a("endMs").b(LL.b().c(2).a()).a();

        private g() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C19141pq7 c19141pq7, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.b(b, c19141pq7.b());
            interfaceC19980rG4.b(c, c19141pq7.a());
        }
    }

    private KS() {
    }

    @Override // ir.nasim.InterfaceC10444bd1
    public void a(InterfaceC9541a82 interfaceC9541a82) {
        interfaceC9541a82.a(AbstractC17435mx5.class, e.a);
        interfaceC9541a82.a(C23183wV0.class, a.a);
        interfaceC9541a82.a(C19141pq7.class, g.a);
        interfaceC9541a82.a(DI3.class, d.a);
        interfaceC9541a82.a(C22473vI3.class, c.a);
        interfaceC9541a82.a(C15277jJ2.class, b.a);
        interfaceC9541a82.a(KO6.class, f.a);
    }
}
