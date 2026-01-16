package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class XH0 extends AbstractC4482Fi {
    private final a a;

    public static final class a {
        public static final a b = new a("TINK");
        public static final a c = new a("CRUNCHY");
        public static final a d = new a("NO_PREFIX");
        private final String a;

        private a(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    private XH0(a aVar) {
        this.a = aVar;
    }

    public static XH0 b(a aVar) {
        return new XH0(aVar);
    }

    @Override // ir.nasim.AbstractC20124rW4
    public boolean a() {
        return this.a != a.d;
    }

    public a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof XH0) && ((XH0) obj).c() == c();
    }

    public int hashCode() {
        return Objects.hash(XH0.class, this.a);
    }

    public String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.a + Separators.RPAREN;
    }
}
