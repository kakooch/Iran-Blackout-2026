package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class SC4 {

    public static final class a extends SC4 {
        public static final int b = 0;
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "titleText");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Active(titleText=" + this.a + Separators.RPAREN;
        }
    }

    private SC4() {
    }

    public /* synthetic */ SC4(ED1 ed1) {
        this();
    }
}
