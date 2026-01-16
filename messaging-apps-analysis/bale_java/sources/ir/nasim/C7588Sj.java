package ir.nasim;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: ir.nasim.Sj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7588Sj extends JJ1 {
    private final int a;
    private final c b;

    /* renamed from: ir.nasim.Sj$b */
    public static final class b {
        private Integer a;
        private c b;

        public C7588Sj a() throws GeneralSecurityException {
            Integer num = this.a;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.b != null) {
                return new C7588Sj(num.intValue(), this.b);
            }
            throw new GeneralSecurityException("Variant is not set");
        }

        public b b(int i) throws InvalidAlgorithmParameterException {
            if (i != 32 && i != 48 && i != 64) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", Integer.valueOf(i)));
            }
            this.a = Integer.valueOf(i);
            return this;
        }

        public b c(c cVar) {
            this.b = cVar;
            return this;
        }

        private b() {
            this.a = null;
            this.b = c.d;
        }
    }

    /* renamed from: ir.nasim.Sj$c */
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
        return this.b != c.d;
    }

    public int c() {
        return this.a;
    }

    public c d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7588Sj)) {
            return false;
        }
        C7588Sj c7588Sj = (C7588Sj) obj;
        return c7588Sj.c() == c() && c7588Sj.d() == d();
    }

    public int hashCode() {
        return Objects.hash(C7588Sj.class, Integer.valueOf(this.a), this.b);
    }

    public String toString() {
        return "AesSiv Parameters (variant: " + this.b + ", " + this.a + "-byte key)";
    }

    private C7588Sj(int i, c cVar) {
        this.a = i;
        this.b = cVar;
    }
}
