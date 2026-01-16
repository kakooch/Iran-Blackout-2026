package ir.nasim;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: ir.nasim.Xi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8786Xi extends AbstractC4482Fi {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final d e;
    private final c f;

    /* renamed from: ir.nasim.Xi$b */
    public static final class b {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;
        private c e;
        private d f;

        private static void h(int i, c cVar) throws GeneralSecurityException {
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
                    throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                }
                if (i > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(i)));
                }
            }
        }

        public C8786Xi a() throws GeneralSecurityException {
            if (this.a == null) {
                throw new GeneralSecurityException("AES key size is not set");
            }
            if (this.b == null) {
                throw new GeneralSecurityException("HMAC key size is not set");
            }
            if (this.c == null) {
                throw new GeneralSecurityException("iv size is not set");
            }
            Integer num = this.d;
            if (num == null) {
                throw new GeneralSecurityException("tag size is not set");
            }
            if (this.e == null) {
                throw new GeneralSecurityException("hash type is not set");
            }
            if (this.f == null) {
                throw new GeneralSecurityException("variant is not set");
            }
            h(num.intValue(), this.e);
            return new C8786Xi(this.a.intValue(), this.b.intValue(), this.c.intValue(), this.d.intValue(), this.f, this.e);
        }

        public b b(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
            }
            this.a = Integer.valueOf(i);
            return this;
        }

        public b c(c cVar) {
            this.e = cVar;
            return this;
        }

        public b d(int i) throws InvalidAlgorithmParameterException {
            if (i < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i)));
            }
            this.b = Integer.valueOf(i);
            return this;
        }

        public b e(int i) throws GeneralSecurityException {
            if (i < 12 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i)));
            }
            this.c = Integer.valueOf(i);
            return this;
        }

        public b f(int i) throws GeneralSecurityException {
            if (i < 10) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
            }
            this.d = Integer.valueOf(i);
            return this;
        }

        public b g(d dVar) {
            this.f = dVar;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = d.d;
        }
    }

    /* renamed from: ir.nasim.Xi$c */
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

    /* renamed from: ir.nasim.Xi$d */
    public static final class d {
        public static final d b = new d("TINK");
        public static final d c = new d("CRUNCHY");
        public static final d d = new d("NO_PREFIX");
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
        return this.e != d.d;
    }

    public int c() {
        return this.a;
    }

    public c d() {
        return this.f;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C8786Xi)) {
            return false;
        }
        C8786Xi c8786Xi = (C8786Xi) obj;
        return c8786Xi.c() == c() && c8786Xi.e() == e() && c8786Xi.f() == f() && c8786Xi.g() == g() && c8786Xi.h() == h() && c8786Xi.d() == d();
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.d;
    }

    public d h() {
        return this.e;
    }

    public int hashCode() {
        return Objects.hash(C8786Xi.class, Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), this.e, this.f);
    }

    public String toString() {
        return "AesCtrHmacAead Parameters (variant: " + this.e + ", hashType: " + this.f + ", " + this.c + "-byte IV, and " + this.d + "-byte tags, and " + this.a + "-byte AES key, and " + this.b + "-byte HMAC key)";
    }

    private C8786Xi(int i, int i2, int i3, int i4, d dVar, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = dVar;
        this.f = cVar;
    }
}
