package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class VF6 {
    private final UA2 a;

    public static final class a extends VF6 {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(String str) {
            super(null, 1, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(str, "errorMessage");
            this.b = str;
        }

        public final String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.b, ((a) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "ErrorMessage(errorMessage=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b extends VF6 {
        public static final b b = new b();

        /* JADX WARN: Multi-variable type inference failed */
        private b() {
            super(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -2076714478;
        }

        public String toString() {
            return "MultipleArchiveDialogs";
        }
    }

    public static final class c extends VF6 {
        private final SA2 b;
        private final UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2, UA2 ua2) {
            super(ua2, null);
            AbstractC13042fc3.i(sa2, "onActionClickListener");
            AbstractC13042fc3.i(ua2, "onDismiss");
            this.b = sa2;
            this.c = ua2;
        }

        public final SA2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c);
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "MultipleDeleteDialogs(onActionClickListener=" + this.b + ", onDismiss=" + this.c + Separators.RPAREN;
        }
    }

    public static final class d extends VF6 {
        private final int b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(int i) {
            super(null, 1, 0 == true ? 1 : 0);
            this.b = i;
        }

        public final int d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.b == ((d) obj).b;
        }

        public int hashCode() {
            return Integer.hashCode(this.b);
        }

        public String toString() {
            return "MultipleUnDeletableDialogs(count=" + this.b + Separators.RPAREN;
        }
    }

    public static final class e extends VF6 {
        private final int b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(int i) {
            super(null, 1, 0 == true ? 1 : 0);
            this.b = i;
        }

        public final int d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.b == ((e) obj).b;
        }

        public int hashCode() {
            return Integer.hashCode(this.b);
        }

        public String toString() {
            return "PinLimit(limitCount=" + this.b + Separators.RPAREN;
        }
    }

    public static final class f extends VF6 {
        public static final f b = new f();

        /* JADX WARN: Multi-variable type inference failed */
        private f() {
            super(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return 1867696393;
        }

        public String toString() {
            return "SingleArchiveDialog";
        }
    }

    public static final class g extends VF6 {
        private final SA2 b;
        private final UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, UA2 ua2) {
            super(ua2, null);
            AbstractC13042fc3.i(sa2, "onActionClickListener");
            AbstractC13042fc3.i(ua2, "onDismiss");
            this.b = sa2;
            this.c = ua2;
        }

        public final SA2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return AbstractC13042fc3.d(this.b, gVar.b) && AbstractC13042fc3.d(this.c, gVar.c);
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "SingleDeleteChannelDialog(onActionClickListener=" + this.b + ", onDismiss=" + this.c + Separators.RPAREN;
        }
    }

    public static final class h extends VF6 {
        private final SA2 b;
        private final UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, UA2 ua2) {
            super(ua2, null);
            AbstractC13042fc3.i(sa2, "onActionClickListener");
            AbstractC13042fc3.i(ua2, "onDismiss");
            this.b = sa2;
            this.c = ua2;
        }

        public final SA2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return AbstractC13042fc3.d(this.b, hVar.b) && AbstractC13042fc3.d(this.c, hVar.c);
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "SingleDeleteGroupDialog(onActionClickListener=" + this.b + ", onDismiss=" + this.c + Separators.RPAREN;
        }
    }

    public static final class i extends VF6 {
        private final SA2 b;
        private final UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2, UA2 ua2) {
            super(ua2, null);
            AbstractC13042fc3.i(sa2, "onActionClickListener");
            AbstractC13042fc3.i(ua2, "onDismiss");
            this.b = sa2;
            this.c = ua2;
        }

        public final SA2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return AbstractC13042fc3.d(this.b, iVar.b) && AbstractC13042fc3.d(this.c, iVar.c);
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public String toString() {
            return "SingleDeletePrivateDialog(onActionClickListener=" + this.b + ", onDismiss=" + this.c + Separators.RPAREN;
        }
    }

    public static final class j extends VF6 {
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(String str) {
            super(null, 1, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(str, "title");
            this.b = str;
        }

        public final String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && AbstractC13042fc3.d(this.b, ((j) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "SingleUnDeletableDialogs(title=" + this.b + Separators.RPAREN;
        }
    }

    public static final class k extends VF6 {
        public static final k b = new k();

        /* JADX WARN: Multi-variable type inference failed */
        private k() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    public static final class l extends VF6 {
        public static final l b = new l();

        /* JADX WARN: Multi-variable type inference failed */
        private l() {
            super(null, 1, 0 == true ? 1 : 0);
        }
    }

    public /* synthetic */ VF6(UA2 ua2, ED1 ed1) {
        this(ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b(boolean z) {
        return C19938rB7.a;
    }

    public final UA2 c() {
        return this.a;
    }

    private VF6(UA2 ua2) {
        this.a = ua2;
    }

    public /* synthetic */ VF6(UA2 ua2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? new UA2() { // from class: ir.nasim.UF6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return VF6.b(((Boolean) obj).booleanValue());
            }
        } : ua2, null);
    }
}
