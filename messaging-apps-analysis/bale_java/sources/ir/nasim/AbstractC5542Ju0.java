package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ju0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC5542Ju0 {

    /* renamed from: ir.nasim.Ju0$a */
    public static final class a extends AbstractC5542Ju0 {
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
            return "ColorRes(res=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Ju0$b */
    public static final class b extends AbstractC5542Ju0 {
        private final int a;

        public b(int i) {
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
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "ColorValue(value=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC5542Ju0() {
    }

    public /* synthetic */ AbstractC5542Ju0(ED1 ed1) {
        this();
    }
}
