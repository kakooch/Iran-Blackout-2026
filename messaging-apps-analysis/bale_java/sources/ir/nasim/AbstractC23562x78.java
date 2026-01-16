package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.x78, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC23562x78 {

    /* renamed from: ir.nasim.x78$a */
    public static final class a extends AbstractC23562x78 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1917297208;
        }

        public String toString() {
            return "Hide";
        }
    }

    /* renamed from: ir.nasim.x78$b */
    public static final class b extends AbstractC23562x78 {
        private final boolean a;

        public b(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public String toString() {
            return "Show(isWebViewDebuggingEnable=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC23562x78() {
    }

    public /* synthetic */ AbstractC23562x78(ED1 ed1) {
        this();
    }
}
