package ir.nasim;

import android.content.res.Resources;
import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public interface H8 {

    public static final class a implements H8 {
        public static final a a = new a();

        private a() {
        }

        public String a(Resources resources) throws Resources.NotFoundException {
            AbstractC13042fc3.i(resources, "resources");
            String string = resources.getString(ED5.add_contact_failed);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1402897230;
        }

        public String toString() {
            return "AddContactFailed";
        }
    }

    public static final class b implements H8 {
        private final String a;
        private final int b;

        public b(String str, int i) {
            AbstractC13042fc3.i(str, "contactName");
            this.a = str;
            this.b = i;
        }

        public String a(Resources resources) throws Resources.NotFoundException {
            AbstractC13042fc3.i(resources, "resources");
            String string = resources.getString(ED5.add_contact_succeeded, this.a);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "AddContactSucceeded(contactName=" + this.a + ", userId=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c implements H8 {
        private final String a;

        public c(String str) {
            AbstractC13042fc3.i(str, "contactPhoneNumber");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public String b(Resources resources) throws Resources.NotFoundException {
            AbstractC13042fc3.i(resources, "resources");
            String string = resources.getString(ED5.invite_contact_to_bale_alert_body, this.a);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "IsNotBaleMember(contactPhoneNumber=" + this.a + Separators.RPAREN;
        }
    }
}
