package ir.nasim;

import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.Map;

/* loaded from: classes8.dex */
public final class EY7 {
    public static final EY7 a = new EY7();
    private static final Map b;
    private static final h c;

    public static final class a extends GY7 {
        public static final a c = new a();

        private a() {
            super("inherited", false);
        }
    }

    public static final class b extends GY7 {
        public static final b c = new b();

        private b() {
            super("internal", false);
        }
    }

    public static final class c extends GY7 {
        public static final c c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    public static final class d extends GY7 {
        public static final d c = new d();

        private d() {
            super("local", false);
        }
    }

    public static final class e extends GY7 {
        public static final e c = new e();

        private e() {
            super("private", false);
        }
    }

    public static final class f extends GY7 {
        public static final f c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // ir.nasim.GY7
        public String b() {
            return "private/*private to this*/";
        }
    }

    public static final class g extends GY7 {
        public static final g c = new g();

        private g() {
            super("protected", true);
        }
    }

    public static final class h extends GY7 {
        public static final h c = new h();

        private h() {
            super(BuildConfig.SDK_BUILD_FLAVOR, true);
        }
    }

    public static final class i extends GY7 {
        public static final i c = new i();

        private i() {
            super(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, false);
        }
    }

    static {
        Map mapD = AbstractC19460qO3.d();
        mapD.put(f.c, 0);
        mapD.put(e.c, 0);
        mapD.put(b.c, 1);
        mapD.put(g.c, 1);
        h hVar = h.c;
        mapD.put(hVar, 2);
        b = AbstractC19460qO3.c(mapD);
        c = hVar;
    }

    private EY7() {
    }

    public final Integer a(GY7 gy7, GY7 gy72) {
        AbstractC13042fc3.i(gy7, "first");
        AbstractC13042fc3.i(gy72, "second");
        if (gy7 == gy72) {
            return 0;
        }
        Map map = b;
        Integer num = (Integer) map.get(gy7);
        Integer num2 = (Integer) map.get(gy72);
        if (num == null || num2 == null || AbstractC13042fc3.d(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(GY7 gy7) {
        AbstractC13042fc3.i(gy7, "visibility");
        return gy7 == e.c || gy7 == f.c;
    }
}
