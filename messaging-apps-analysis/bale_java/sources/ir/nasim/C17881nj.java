package ir.nasim;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: ir.nasim.nj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17881nj extends AbstractC4482Fi {
    private final int a;
    private final int b;
    private final int c;
    private final c d;

    /* renamed from: ir.nasim.nj$b */
    public static final class b {
        private Integer a;
        private Integer b;
        private Integer c;
        private c d;

        public C17881nj a() throws GeneralSecurityException {
            Integer num = this.a;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.b == null) {
                throw new GeneralSecurityException("IV size is not set");
            }
            if (this.d == null) {
                throw new GeneralSecurityException("Variant is not set");
            }
            if (this.c != null) {
                return new C17881nj(num.intValue(), this.b.intValue(), this.c.intValue(), this.d);
            }
            throw new GeneralSecurityException("Tag size is not set");
        }

        public b b(int i) throws GeneralSecurityException {
            if (i != 12 && i != 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i)));
            }
            this.b = Integer.valueOf(i);
            return this;
        }

        public b c(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 24 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
            }
            this.a = Integer.valueOf(i);
            return this;
        }

        public b d(int i) throws GeneralSecurityException {
            if (i < 0 || i > 16) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; value must be at most 16 bytes", Integer.valueOf(i)));
            }
            this.c = Integer.valueOf(i);
            return this;
        }

        public b e(c cVar) {
            this.d = cVar;
            return this;
        }

        private b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = c.d;
        }
    }

    /* renamed from: ir.nasim.nj$c */
    public static final class c {
        public static final c b = new c("TINK");
        public static final c c = new c("CRUNCHY");
        public static final c d = new c("NO_PREFIX");
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
        return this.d != c.d;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C17881nj)) {
            return false;
        }
        C17881nj c17881nj = (C17881nj) obj;
        return c17881nj.d() == d() && c17881nj.c() == c() && c17881nj.e() == e() && c17881nj.f() == f();
    }

    public c f() {
        return this.d;
    }

    public int hashCode() {
        return Objects.hash(C17881nj.class, Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), this.d);
    }

    public String toString() {
        return "AesEax Parameters (variant: " + this.d + ", " + this.b + "-byte IV, " + this.c + "-byte tag, and " + this.a + "-byte key)";
    }

    private C17881nj(int i, int i2, int i3, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = cVar;
    }
}
