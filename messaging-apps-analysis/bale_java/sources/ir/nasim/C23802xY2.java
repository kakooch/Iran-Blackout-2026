package ir.nasim;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: ir.nasim.xY2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23802xY2 extends ZL3 {
    private final int a;
    private final int b;
    private final d c;
    private final c d;

    /* renamed from: ir.nasim.xY2$b */
    public static final class b {
        private Integer a;
        private Integer b;
        private c c;
        private d d;

        private static void f(int i, c cVar) throws GeneralSecurityException {
            if (i < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
            }
            if (cVar == c.b) {
                if (i > 20) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(i)));
                }
                return;
            }
            if (cVar == c.c) {
                if (i > 28) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(i)));
                }
                return;
            }
            if (cVar == c.d) {
                if (i > 32) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(i)));
                }
            } else if (cVar == c.e) {
                if (i > 48) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(i)));
                }
            } else {
                if (cVar != c.f) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                }
                if (i > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(i)));
                }
            }
        }

        public C23802xY2 a() throws GeneralSecurityException {
            Integer num = this.a;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.b == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.c == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.d == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            if (num.intValue() < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.a));
            }
            f(this.b.intValue(), this.c);
            return new C23802xY2(this.a.intValue(), this.b.intValue(), this.d, this.c);
        }

        public b b(c cVar) {
            this.c = cVar;
            return this;
        }

        public b c(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        public b d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public b e(d dVar) {
            this.d = dVar;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = d.e;
        }
    }

    /* renamed from: ir.nasim.xY2$c */
    public static final class c {
        public static final c b = new c("SHA1");
        public static final c c = new c("SHA224");
        public static final c d = new c("SHA256");
        public static final c e = new c("SHA384");
        public static final c f = new c("SHA512");
        private final String a;

        private c(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.xY2$d */
    public static final class d {
        public static final d b = new d("TINK");
        public static final d c = new d("CRUNCHY");
        public static final d d = new d("LEGACY");
        public static final d e = new d("NO_PREFIX");
        private final String a;

        private d(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    public static b b() {
        return new b();
    }

    @Override // ir.nasim.AbstractC20124rW4
    public boolean a() {
        return this.c != d.e;
    }

    public int c() {
        return this.b;
    }

    public c d() {
        return this.d;
    }

    public int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C23802xY2)) {
            return false;
        }
        C23802xY2 c23802xY2 = (C23802xY2) obj;
        return c23802xY2.e() == e() && c23802xY2.f() == f() && c23802xY2.g() == g() && c23802xY2.d() == d();
    }

    public int f() {
        d dVar = this.c;
        if (dVar == d.e) {
            return c();
        }
        if (dVar != d.b && dVar != d.c && dVar != d.d) {
            throw new IllegalStateException("Unknown variant");
        }
        int iC = c();
        return iC + 5;
    }

    public d g() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hash(C23802xY2.class, Integer.valueOf(this.a), Integer.valueOf(this.b), this.c, this.d);
    }

    public String toString() {
        return "HMAC Parameters (variant: " + this.c + ", hashType: " + this.d + ", " + this.b + "-byte tags, and " + this.a + "-byte key)";
    }

    private C23802xY2(int i, int i2, d dVar, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = dVar;
        this.d = cVar;
    }
}
