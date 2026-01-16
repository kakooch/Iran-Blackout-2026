package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public interface WO5 {

    public static final class a implements WO5 {
        private final List a;

        public a(List list) {
            AbstractC13042fc3.i(list, "replyKeyboardMarkupRows");
            this.a = list;
        }

        @Override // ir.nasim.WO5
        public List a() {
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
            return "HideReplyKeyboard(replyKeyboardMarkupRows=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements WO5 {
        private final List a;

        public b(List list) {
            AbstractC13042fc3.i(list, "replyKeyboardMarkupRows");
            this.a = list;
        }

        @Override // ir.nasim.WO5
        public List a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ShowReplyKeyboard(replyKeyboardMarkupRows=" + this.a + Separators.RPAREN;
        }
    }

    List a();
}
