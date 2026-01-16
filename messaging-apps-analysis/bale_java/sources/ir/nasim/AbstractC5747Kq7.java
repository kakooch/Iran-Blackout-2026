package ir.nasim;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* renamed from: ir.nasim.Kq7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC5747Kq7 {
    private static final Logger a = Logger.getLogger(AbstractC5747Kq7.class.getName());
    private static final AtomicBoolean b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Kq7$b */
    public static abstract class b {
        public static final b a;
        public static final b b;
        private static final /* synthetic */ b[] c;

        /* renamed from: ir.nasim.Kq7$b$a */
        enum a extends b {
            a(String str, int i) {
                super(str, i);
            }

            @Override // ir.nasim.AbstractC5747Kq7.b
            public boolean a() {
                return !AbstractC5747Kq7.c();
            }
        }

        /* renamed from: ir.nasim.Kq7$b$b, reason: collision with other inner class name */
        enum C0470b extends b {
            C0470b(String str, int i) {
                super(str, i);
            }

            @Override // ir.nasim.AbstractC5747Kq7.b
            public boolean a() {
                return !AbstractC5747Kq7.c() || AbstractC5747Kq7.b();
            }
        }

        static {
            a aVar = new a("ALGORITHM_NOT_FIPS", 0);
            a = aVar;
            C0470b c0470b = new C0470b("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            b = c0470b;
            c = new b[]{aVar, c0470b};
        }

        private b(String str, int i) {
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }

        public abstract boolean a();
    }

    static Boolean a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
        } catch (Exception unused) {
            a.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean b() {
        return a().booleanValue();
    }

    public static boolean c() {
        return AbstractC5513Jq7.a() || b.get();
    }
}
