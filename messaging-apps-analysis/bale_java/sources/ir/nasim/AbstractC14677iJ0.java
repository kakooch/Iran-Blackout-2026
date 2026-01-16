package ir.nasim;

import ir.nasim.AbstractC14677iJ0;

/* renamed from: ir.nasim.iJ0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14677iJ0 {

    /* renamed from: ir.nasim.iJ0$a */
    public static final class a extends AbstractC14677iJ0 {
        public static final a a = new a();
        private static final String b = "AgreeTermsScreen";

        private a() {
            super(null);
        }

        public String a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1827990627;
        }

        public String toString() {
            return "AgreeTermsScreen";
        }
    }

    /* renamed from: ir.nasim.iJ0$b */
    public static class b extends AbstractC14677iJ0 {
        private final String a;

        /* renamed from: ir.nasim.iJ0$b$a */
        public static final class a extends b {
            public static final a b = new a();
            private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jJ0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC14677iJ0.b.a.c();
                }
            });
            private static final String d = "ChooseCountryScreenRoute";
            public static final int e = 8;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C12561ep1 c() {
                return C12561ep1.a.b();
            }

            @Override // ir.nasim.AbstractC14677iJ0.b
            public String a() {
                return d;
            }

            public final C12561ep1 d() {
                return (C12561ep1) c.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return 1887853621;
            }

            public String toString() {
                return "ChooseCountryScreen";
            }
        }

        /* renamed from: ir.nasim.iJ0$b$b, reason: collision with other inner class name */
        public static final class C1290b extends b {
            public static final C1290b b = new C1290b();
            private static final String c = "InitPhoneNumberScreenRoute";

            private C1290b() {
            }

            @Override // ir.nasim.AbstractC14677iJ0.b
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C1290b);
            }

            public int hashCode() {
                return 623983965;
            }

            public String toString() {
                return "InitPhoneNumberScreen";
            }
        }

        /* renamed from: ir.nasim.iJ0$b$c */
        public static final class c extends b {
            public static final c b = new c();
            private static final String c = "ValidationCodeScreenRoute";

            private c() {
            }

            @Override // ir.nasim.AbstractC14677iJ0.b
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof c);
            }

            public int hashCode() {
                return 1861024232;
            }

            public String toString() {
                return "ValidationCodeScreen";
            }
        }

        public b() {
            super(null);
            this.a = "SignInScreensRoute";
        }

        public String a() {
            return this.a;
        }
    }

    private AbstractC14677iJ0() {
    }

    public /* synthetic */ AbstractC14677iJ0(ED1 ed1) {
        this();
    }
}
