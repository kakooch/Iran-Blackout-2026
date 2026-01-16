package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fq4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13210fq4 {

    /* renamed from: ir.nasim.fq4$a */
    public static final class a extends AbstractC13210fq4 {
        private final int a;

        public a(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "AppRating(peerId=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC13210fq4() {
    }

    public /* synthetic */ AbstractC13210fq4(ED1 ed1) {
        this();
    }
}
