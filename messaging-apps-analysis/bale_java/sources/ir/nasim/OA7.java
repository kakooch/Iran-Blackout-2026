package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class OA7 {

    public static final class a extends OA7 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1271989555;
        }

        public String toString() {
            return "Failure";
        }
    }

    public static final class b extends OA7 {
        private final boolean a;
        private final boolean b;

        public b(boolean z, boolean z2) {
            super(null);
            this.a = z;
            this.b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "HasDiscussionGroup(discussionGroupIsEnable=" + this.a + ", isMember=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c extends OA7 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -628045791;
        }

        public String toString() {
            return "HasNotDiscussionGroup";
        }
    }

    public static final class d extends OA7 {
        public static final d a = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 1561330357;
        }

        public String toString() {
            return "InitialLoading";
        }
    }

    public static final class e extends OA7 {
        public static final e a = new e();

        private e() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 151235199;
        }

        public String toString() {
            return "Loading";
        }
    }

    private OA7() {
    }

    public /* synthetic */ OA7(ED1 ed1) {
        this();
    }
}
