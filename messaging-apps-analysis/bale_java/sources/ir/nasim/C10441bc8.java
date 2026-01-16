package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Objects;

/* renamed from: ir.nasim.bc8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10441bc8 extends AbstractC4482Fi {
    private final a a;

    /* renamed from: ir.nasim.bc8$a */
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

    private C10441bc8(a aVar) {
        this.a = aVar;
    }

    public static C10441bc8 b(a aVar) {
        return new C10441bc8(aVar);
    }

    @Override // ir.nasim.AbstractC20124rW4
    public boolean a() {
        return this.a != a.d;
    }

    public a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C10441bc8) && ((C10441bc8) obj).c() == c();
    }

    public int hashCode() {
        return Objects.hash(C10441bc8.class, this.a);
    }

    public String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.a + Separators.RPAREN;
    }
}
