package ir.nasim;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: ir.nasim.Ij, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5208Ij extends AbstractC4482Fi {
    private final int a;
    private final c b;

    /* renamed from: ir.nasim.Ij$b */
    public static final class b {
        private Integer a;
        private c b;

        public C5208Ij a() throws GeneralSecurityException {
            Integer num = this.a;
            if (num == null) {
                throw new GeneralSecurityException("Key size is not set");
            }
            if (this.b != null) {
                return new C5208Ij(num.intValue(), this.b);
            }
            throw new GeneralSecurityException("Variant is not set");
        }

        public b b(int i) throws InvalidAlgorithmParameterException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
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

    /* renamed from: ir.nasim.Ij$c */
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
        if (!(obj instanceof C5208Ij)) {
            return false;
        }
        C5208Ij c5208Ij = (C5208Ij) obj;
        return c5208Ij.c() == c() && c5208Ij.d() == d();
    }

    public int hashCode() {
        return Objects.hash(C5208Ij.class, Integer.valueOf(this.a), this.b);
    }

    public String toString() {
        return "AesGcmSiv Parameters (variant: " + this.b + ", " + this.a + "-byte key)";
    }

    private C5208Ij(int i, c cVar) {
        this.a = i;
        this.b = cVar;
    }
}
