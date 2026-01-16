package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class DD {

    public static final class a extends DD {
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
            return "Resource(animationRes=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends DD {
        private final String a;

        public b(String str) {
            super(null);
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Runtime(json=" + this.a + Separators.RPAREN;
        }
    }

    private DD() {
    }

    public /* synthetic */ DD(ED1 ed1) {
        this();
    }
}
