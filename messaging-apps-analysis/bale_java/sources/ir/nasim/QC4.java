package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public interface QC4 {

    public interface a {
        int a();
    }

    public static abstract class b implements QC4 {

        public static final class a extends b implements a {
            public static final a a = new a();
            public static final int b = 0;

            private a() {
                super(null);
            }

            @Override // ir.nasim.QC4.a
            public int a() {
                return AbstractC24188yB5.alert;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return 1753299415;
            }

            public String toString() {
                return "ActiveAlert";
            }
        }

        /* renamed from: ir.nasim.QC4$b$b, reason: collision with other inner class name */
        public static final class C0590b extends b {
            public static final C0590b a = new C0590b();
            public static final int b = 0;

            private C0590b() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0590b);
            }

            public int hashCode() {
                return -1411874990;
            }

            public String toString() {
                return "InactiveAlert";
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static abstract class c implements QC4 {

        public static final class a extends c implements a {
            public static final int b = 0;
            private final int a;

            public a(int i) {
                super(null);
                this.a = i;
            }

            @Override // ir.nasim.QC4.a
            public int a() {
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
                return "ActiveCustom(noticeIconRes=" + this.a + Separators.RPAREN;
            }
        }

        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public static abstract class d implements QC4 {

        public static final class a extends d implements a {
            public static final a a = new a();

            private a() {
                super(null);
            }

            @Override // ir.nasim.QC4.a
            public int a() {
                return AbstractC24188yB5.danger;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -1953959121;
            }

            public String toString() {
                return "ActiveError";
            }
        }

        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    public static abstract class e implements QC4 {

        public static final class a extends e implements a {
            public static final a a = new a();

            private a() {
                super(null);
            }

            @Override // ir.nasim.QC4.a
            public int a() {
                return AbstractC24188yB5.shield_done;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return -950355355;
            }

            public String toString() {
                return "ActiveSuccess";
            }
        }

        private e() {
        }

        public /* synthetic */ e(ED1 ed1) {
            this();
        }
    }
}
