package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;

/* loaded from: classes5.dex */
public abstract class NP1 {

    public static final class a extends NP1 {
        private final Spannable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Spannable spannable) {
            super(null);
            AbstractC13042fc3.i(spannable, "value");
            this.a = spannable;
        }

        @Override // ir.nasim.NP1
        public String a() {
            return this.a.toString();
        }

        @Override // ir.nasim.NP1
        public boolean b(NP1 np1) {
            return (np1 instanceof a) && AbstractC3410At3.b(this.a, ((a) np1).a);
        }

        public final Spannable c() {
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
            return "SpannableText(value=" + ((Object) this.a) + Separators.RPAREN;
        }
    }

    private NP1() {
    }

    public abstract String a();

    public abstract boolean b(NP1 np1);

    public /* synthetic */ NP1(ED1 ed1) {
        this();
    }
}
