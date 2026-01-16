package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes7.dex */
public abstract class ZF6 {

    public static final class a extends ZF6 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
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
            return "Message(message=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends ZF6 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 837230731;
        }

        public String toString() {
            return "TimeOutResponse";
        }
    }

    public static final class c extends ZF6 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1622515563;
        }

        public String toString() {
            return "UnknownError";
        }
    }

    private ZF6() {
    }

    public /* synthetic */ ZF6(ED1 ed1) {
        this();
    }
}
