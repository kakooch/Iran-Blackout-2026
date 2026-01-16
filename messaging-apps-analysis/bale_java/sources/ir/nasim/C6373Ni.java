package ir.nasim;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: ir.nasim.Ni, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6373Ni extends ZL3 {
    private final int a;
    private final int b;
    private final c c;

    /* renamed from: ir.nasim.Ni$b */
    public static final class b {
        private Integer a;
        private Integer b;
        private c c;

        public C6373Ni a() throws GeneralSecurityException {
            Integer num = this.a;
            if (num == null) {
                throw new GeneralSecurityException("key size not set");
            }
            if (this.b == null) {
                throw new GeneralSecurityException("tag size not set");
            }
            if (this.c != null) {
                return new C6373Ni(num.intValue(), this.b.intValue(), this.c);
            }
            throw new GeneralSecurityException("variant not set");
        }

        public b b(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
            }
            this.a = Integer.valueOf(i);
            return this;
        }

        public b c(int i) throws GeneralSecurityException {
            if (i >= 10 && 16 >= i) {
                this.b = Integer.valueOf(i);
                return this;
            }
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
        }

        public b d(c cVar) {
            this.c = cVar;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = c.e;
        }
    }

    /* renamed from: ir.nasim.Ni$c */
    public static final class c {
        public static final c b = new c("TINK");
        public static final c c = new c("CRUNCHY");
        public static final c d = new c("LEGACY");
        public static final c e = new c("NO_PREFIX");
        private final String a;

        private c(String str) {
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
        return this.c != c.e;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        c cVar = this.c;
        if (cVar == c.e) {
            return c();
        }
        if (cVar != c.b && cVar != c.c && cVar != c.d) {
            throw new IllegalStateException("Unknown variant");
        }
        int iC = c();
        return iC + 5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6373Ni)) {
            return false;
        }
        C6373Ni c6373Ni = (C6373Ni) obj;
        return c6373Ni.d() == d() && c6373Ni.e() == e() && c6373Ni.f() == f();
    }

    public c f() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hash(C6373Ni.class, Integer.valueOf(this.a), Integer.valueOf(this.b), this.c);
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.c + ", " + this.b + "-byte tags, and " + this.a + "-byte key)";
    }

    private C6373Ni(int i, int i2, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = cVar;
    }
}
