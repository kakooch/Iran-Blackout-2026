package ir.nasim;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* renamed from: ir.nasim.gS, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13564gS implements InterfaceC10444bd1 {
    public static final InterfaceC10444bd1 a = new C13564gS();

    /* renamed from: ir.nasim.gS$a */
    private static final class a implements InterfaceC19389qG4 {
        static final a a = new a();
        private static final C24510yk2 b = C24510yk2.d("sdkVersion");
        private static final C24510yk2 c = C24510yk2.d(CommonUrlParts.MODEL);
        private static final C24510yk2 d = C24510yk2.d("hardware");
        private static final C24510yk2 e = C24510yk2.d("device");
        private static final C24510yk2 f = C24510yk2.d("product");
        private static final C24510yk2 g = C24510yk2.d("osBuild");
        private static final C24510yk2 h = C24510yk2.d(CommonUrlParts.MANUFACTURER);
        private static final C24510yk2 i = C24510yk2.d("fingerprint");
        private static final C24510yk2 j = C24510yk2.d(CommonUrlParts.LOCALE);
        private static final C24510yk2 k = C24510yk2.d("country");
        private static final C24510yk2 l = C24510yk2.d("mccMnc");
        private static final C24510yk2 m = C24510yk2.d("applicationBuild");

        private a() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC7863Tn abstractC7863Tn, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, abstractC7863Tn.m());
            interfaceC19980rG4.c(c, abstractC7863Tn.j());
            interfaceC19980rG4.c(d, abstractC7863Tn.f());
            interfaceC19980rG4.c(e, abstractC7863Tn.d());
            interfaceC19980rG4.c(f, abstractC7863Tn.l());
            interfaceC19980rG4.c(g, abstractC7863Tn.k());
            interfaceC19980rG4.c(h, abstractC7863Tn.h());
            interfaceC19980rG4.c(i, abstractC7863Tn.e());
            interfaceC19980rG4.c(j, abstractC7863Tn.g());
            interfaceC19980rG4.c(k, abstractC7863Tn.c());
            interfaceC19980rG4.c(l, abstractC7863Tn.i());
            interfaceC19980rG4.c(m, abstractC7863Tn.b());
        }
    }

    /* renamed from: ir.nasim.gS$b */
    private static final class b implements InterfaceC19389qG4 {
        static final b a = new b();
        private static final C24510yk2 b = C24510yk2.d("logRequest");

        private b() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC22662vd0 abstractC22662vd0, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, abstractC22662vd0.c());
        }
    }

    /* renamed from: ir.nasim.gS$c */
    private static final class c implements InterfaceC19389qG4 {
        static final c a = new c();
        private static final C24510yk2 b = C24510yk2.d("clientType");
        private static final C24510yk2 c = C24510yk2.d("androidClientInfo");

        private c() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC21997uV0 abstractC21997uV0, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, abstractC21997uV0.c());
            interfaceC19980rG4.c(c, abstractC21997uV0.b());
        }
    }

    /* renamed from: ir.nasim.gS$d */
    private static final class d implements InterfaceC19389qG4 {
        static final d a = new d();
        private static final C24510yk2 b = C24510yk2.d("eventTimeMs");
        private static final C24510yk2 c = C24510yk2.d("eventCode");
        private static final C24510yk2 d = C24510yk2.d("eventUptimeMs");
        private static final C24510yk2 e = C24510yk2.d("sourceExtension");
        private static final C24510yk2 f = C24510yk2.d("sourceExtensionJsonProto3");
        private static final C24510yk2 g = C24510yk2.d("timezoneOffsetSeconds");
        private static final C24510yk2 h = C24510yk2.d("networkConnectionInfo");

        private d() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC21883uI3 abstractC21883uI3, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.b(b, abstractC21883uI3.c());
            interfaceC19980rG4.c(c, abstractC21883uI3.b());
            interfaceC19980rG4.b(d, abstractC21883uI3.d());
            interfaceC19980rG4.c(e, abstractC21883uI3.f());
            interfaceC19980rG4.c(f, abstractC21883uI3.g());
            interfaceC19980rG4.b(g, abstractC21883uI3.h());
            interfaceC19980rG4.c(h, abstractC21883uI3.e());
        }
    }

    /* renamed from: ir.nasim.gS$e */
    private static final class e implements InterfaceC19389qG4 {
        static final e a = new e();
        private static final C24510yk2 b = C24510yk2.d("requestTimeMs");
        private static final C24510yk2 c = C24510yk2.d("requestUptimeMs");
        private static final C24510yk2 d = C24510yk2.d("clientInfo");
        private static final C24510yk2 e = C24510yk2.d("logSource");
        private static final C24510yk2 f = C24510yk2.d("logSourceName");
        private static final C24510yk2 g = C24510yk2.d("logEvent");
        private static final C24510yk2 h = C24510yk2.d("qosTier");

        private e() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AI3 ai3, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.b(b, ai3.g());
            interfaceC19980rG4.b(c, ai3.h());
            interfaceC19980rG4.c(d, ai3.b());
            interfaceC19980rG4.c(e, ai3.d());
            interfaceC19980rG4.c(f, ai3.e());
            interfaceC19980rG4.c(g, ai3.c());
            interfaceC19980rG4.c(h, ai3.f());
        }
    }

    /* renamed from: ir.nasim.gS$f */
    private static final class f implements InterfaceC19389qG4 {
        static final f a = new f();
        private static final C24510yk2 b = C24510yk2.d("networkType");
        private static final C24510yk2 c = C24510yk2.d("mobileSubtype");

        private f() {
        }

        @Override // ir.nasim.InterfaceC19389qG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC7895Tq4 abstractC7895Tq4, InterfaceC19980rG4 interfaceC19980rG4) {
            interfaceC19980rG4.c(b, abstractC7895Tq4.c());
            interfaceC19980rG4.c(c, abstractC7895Tq4.b());
        }
    }

    private C13564gS() {
    }

    @Override // ir.nasim.InterfaceC10444bd1
    public void a(InterfaceC9541a82 interfaceC9541a82) {
        b bVar = b.a;
        interfaceC9541a82.a(AbstractC22662vd0.class, bVar);
        interfaceC9541a82.a(QS.class, bVar);
        e eVar = e.a;
        interfaceC9541a82.a(AI3.class, eVar);
        interfaceC9541a82.a(C18319oT.class, eVar);
        c cVar = c.a;
        interfaceC9541a82.a(AbstractC21997uV0.class, cVar);
        interfaceC9541a82.a(XS.class, cVar);
        a aVar = a.a;
        interfaceC9541a82.a(AbstractC7863Tn.class, aVar);
        interfaceC9541a82.a(NS.class, aVar);
        d dVar = d.a;
        interfaceC9541a82.a(AbstractC21883uI3.class, dVar);
        interfaceC9541a82.a(C17728nT.class, dVar);
        f fVar = f.a;
        interfaceC9541a82.a(AbstractC7895Tq4.class, fVar);
        interfaceC9541a82.a(C19501qT.class, fVar);
    }
}
