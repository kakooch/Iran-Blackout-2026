package ir.nasim;

/* loaded from: classes3.dex */
public final class LS implements InterfaceC10444bd1 {
    public static final InterfaceC10444bd1 a = new LS();

    private static final class a implements InterfaceC19389qG4 {
        static final a a = new a();
        private static final C24510yk2 b = C24510yk2.a("projectNumber").b(LL.b().c(1).a()).a();
        private static final C24510yk2 c = C24510yk2.a("messageId").b(LL.b().c(2).a()).a();
        private static final C24510yk2 d = C24510yk2.a("instanceId").b(LL.b().c(3).a()).a();
        private static final C24510yk2 e = C24510yk2.a("messageType").b(LL.b().c(4).a()).a();
        private static final C24510yk2 f = C24510yk2.a("sdkPlatform").b(LL.b().c(5).a()).a();
        private static final C24510yk2 g = C24510yk2.a("packageName").b(LL.b().c(6).a()).a();
        private static final C24510yk2 h = C24510yk2.a("collapseKey").b(LL.b().c(7).a()).a();
        private static final C24510yk2 i = C24510yk2.a("priority").b(LL.b().c(8).a()).a();
        private static final C24510yk2 j = C24510yk2.a("ttl").b(LL.b().c(9).a()).a();
        private static final C24510yk2 k = C24510yk2.a("topic").b(LL.b().c(10).a()).a();
        private static final C24510yk2 l = C24510yk2.a("bulkId").b(LL.b().c(11).a()).a();
        private static final C24510yk2 m = C24510yk2.a("event").b(LL.b().c(12).a()).a();
        private static final C24510yk2 n = C24510yk2.a("analyticsLabel").b(LL.b().c(13).a()).a();
        private static final C24510yk2 o = C24510yk2.a("campaignId").b(LL.b().c(14).a()).a();
        private static final C24510yk2 p = C24510yk2.a("composerLabel").b(LL.b().c(15).a()).a();

        private a() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(V84 v84, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.b(b, v84.l());
            interfaceC19980rG4.c(c, v84.h());
            interfaceC19980rG4.c(d, v84.g());
            interfaceC19980rG4.c(e, v84.i());
            interfaceC19980rG4.c(f, v84.m());
            interfaceC19980rG4.c(g, v84.j());
            interfaceC19980rG4.c(h, v84.d());
            interfaceC19980rG4.a(i, v84.k());
            interfaceC19980rG4.a(j, v84.o());
            interfaceC19980rG4.c(k, v84.n());
            interfaceC19980rG4.b(l, v84.b());
            interfaceC19980rG4.c(m, v84.f());
            interfaceC19980rG4.c(n, v84.a());
            interfaceC19980rG4.b(o, v84.c());
            interfaceC19980rG4.c(p, v84.e());
        }
    }

    private static final class b implements InterfaceC19389qG4 {
        static final b a = new b();
        private static final C24510yk2 b = C24510yk2.a("messagingClientEvent").b(LL.b().c(1).a()).a();

        private b() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(W84 w84, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, w84.a());
        }
    }

    private static final class c implements InterfaceC19389qG4 {
        static final c a = new c();
        private static final C24510yk2 b = C24510yk2.d("messagingClientEventExtension");

        private c() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            AbstractC18350oW3.a(obj);
            b(null, (InterfaceC19980rG4) obj2);
        }

        public void b(AbstractC16844lx5 abstractC16844lx5, InterfaceC19980rG4 interfaceC19980rG4) {
            throw null;
        }
    }

    private LS() {
    }

    @Override // ir.nasim.InterfaceC10444bd1
    public void a(InterfaceC9541a82 interfaceC9541a82) {
        interfaceC9541a82.a(AbstractC16844lx5.class, c.a);
        interfaceC9541a82.a(W84.class, b.a);
        interfaceC9541a82.a(V84.class, a.a);
    }
}
