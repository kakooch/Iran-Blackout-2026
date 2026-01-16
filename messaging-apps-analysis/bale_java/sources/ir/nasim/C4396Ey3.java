package ir.nasim;

import android.gov.nist.core.Separators;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: ir.nasim.Ey3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4396Ey3 extends AbstractC4482Fi {
    private final String a;
    private final c b;
    private final AbstractC4482Fi c;

    /* renamed from: ir.nasim.Ey3$b */
    public static class b {
        private String a;
        private c b;
        private AbstractC4482Fi c;

        private b() {
        }

        private static boolean b(c cVar, AbstractC4482Fi abstractC4482Fi) {
            if (cVar.equals(c.b) && (abstractC4482Fi instanceof C24497yj)) {
                return true;
            }
            if (cVar.equals(c.d) && (abstractC4482Fi instanceof XH0)) {
                return true;
            }
            if (cVar.equals(c.c) && (abstractC4482Fi instanceof C10441bc8)) {
                return true;
            }
            if (cVar.equals(c.e) && (abstractC4482Fi instanceof C8786Xi)) {
                return true;
            }
            if (cVar.equals(c.f) && (abstractC4482Fi instanceof C17881nj)) {
                return true;
            }
            return cVar.equals(c.g) && (abstractC4482Fi instanceof C5208Ij);
        }

        public C4396Ey3 a() throws GeneralSecurityException {
            if (this.a == null) {
                throw new GeneralSecurityException("kekUri must be set");
            }
            if (this.b == null) {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
            AbstractC4482Fi abstractC4482Fi = this.c;
            if (abstractC4482Fi == null) {
                throw new GeneralSecurityException("dekParametersForNewKeys must be set");
            }
            if (abstractC4482Fi.a()) {
                throw new GeneralSecurityException("dekParametersForNewKeys must note have ID Requirements");
            }
            if (b(this.b, this.c)) {
                return new C4396Ey3(this.a, this.b, this.c);
            }
            throw new GeneralSecurityException("Cannot use parsing strategy " + this.b.toString() + " when new keys are picked according to " + this.c + Separators.DOT);
        }

        public b c(AbstractC4482Fi abstractC4482Fi) {
            this.c = abstractC4482Fi;
            return this;
        }

        public b d(c cVar) {
            this.b = cVar;
            return this;
        }

        public b e(String str) {
            this.a = str;
            return this;
        }
    }

    /* renamed from: ir.nasim.Ey3$c */
    public static final class c {
        public static final c b = new c("ASSUME_AES_GCM");
        public static final c c = new c("ASSUME_XCHACHA20POLY1305");
        public static final c d = new c("ASSUME_CHACHA20POLY1305");
        public static final c e = new c("ASSUME_AES_CTR_HMAC");
        public static final c f = new c("ASSUME_AES_EAX");
        public static final c g = new c("ASSUME_AES_GCM_SIV");
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
        return false;
    }

    public AbstractC4482Fi c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4396Ey3)) {
            return false;
        }
        C4396Ey3 c4396Ey3 = (C4396Ey3) obj;
        return c4396Ey3.b.equals(this.b) && c4396Ey3.c.equals(this.c) && c4396Ey3.a.equals(this.a);
    }

    public int hashCode() {
        return Objects.hash(C4396Ey3.class, this.a, this.b, this.c);
    }

    public String toString() {
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.a + ", dekParsingStrategy: " + this.b + ", dekParametersForNewKeys: " + this.c + Separators.RPAREN;
    }

    private C4396Ey3(String str, c cVar, AbstractC4482Fi abstractC4482Fi) {
        this.a = str;
        this.b = cVar;
        this.c = abstractC4482Fi;
    }
}
