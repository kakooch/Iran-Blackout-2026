package ir.nasim;

import ir.nasim.VI3;

/* loaded from: classes4.dex */
public abstract class VI3 {

    public static final class a extends VI3 {
        public static final a a = new a();
        private static final String b = "ChooseLanguageScreenRoute";

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
            return 1098434473;
        }

        public String toString() {
            return "ChooseLanguageScreen";
        }
    }

    public static final class b extends VI3 {
        public static final b a = new b();
        private static final String b = "IntroScreenRoute";

        private b() {
            super(null);
        }

        public String a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 936793706;
        }

        public String toString() {
            return "IntroScreen";
        }
    }

    public static class c extends VI3 {
        private final String a;

        public static final class a extends c {
            public static final a b = new a();
            private static final String c = "ConfirmSetNewPasswordScreen";

            private a() {
            }

            @Override // ir.nasim.VI3.c
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return 1633241914;
            }

            public String toString() {
                return "ConfirmSetNewPasswordScreen";
            }
        }

        public static final class b extends c {
            public static final b b = new b();
            private static final String c = "RecoveryEmailValidateCodeScreen";

            private b() {
            }

            @Override // ir.nasim.VI3.c
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof b);
            }

            public int hashCode() {
                return -1356106464;
            }

            public String toString() {
                return "RecoverPasswordScreen";
            }
        }

        /* renamed from: ir.nasim.VI3$c$c, reason: collision with other inner class name */
        public static final class C0700c extends c {
            public static final C0700c b = new C0700c();
            private static final String c = "SetNewPasswordScreen";

            private C0700c() {
            }

            @Override // ir.nasim.VI3.c
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0700c);
            }

            public int hashCode() {
                return -2114668016;
            }

            public String toString() {
                return "SetNewPasswordScreen";
            }
        }

        public c() {
            super(null);
            this.a = "RecoveryTwoFAScreens";
        }

        public String a() {
            return this.a;
        }
    }

    public static class d extends VI3 {
        private final String a;

        public static final class a extends d {
            public static final a b = new a();
            private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WI3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return VI3.d.a.c();
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

            @Override // ir.nasim.VI3.d
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
                return 608819604;
            }

            public String toString() {
                return "ChooseCountryScreen";
            }
        }

        public static final class b extends d {
            public static final b b = new b();
            private static final String c = "InitPhoneNumberScreenRoute";

            private b() {
            }

            @Override // ir.nasim.VI3.d
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof b);
            }

            public int hashCode() {
                return -167059716;
            }

            public String toString() {
                return "InitPhoneNumberScreen";
            }
        }

        public static final class c extends d {
            public static final c b = new c();
            private static final String c = "ValidationCodeScreenRoute";

            private c() {
            }

            @Override // ir.nasim.VI3.d
            public String a() {
                return c;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof c);
            }

            public int hashCode() {
                return 865675369;
            }

            public String toString() {
                return "ValidationCodeScreen";
            }
        }

        public d() {
            super(null);
            this.a = "SignInScreensRoute";
        }

        public String a() {
            return this.a;
        }
    }

    public static final class e extends VI3 {
        public static final e a = new e();
        private static final String b = "SignUpScreenRoute";

        private e() {
            super(null);
        }

        public String a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return -1011082862;
        }

        public String toString() {
            return "SignUpScreen";
        }
    }

    public static final class f extends VI3 {
        public static final f a = new f();
        private static final String b = "TwoFAScreen";

        private f() {
            super(null);
        }

        public String a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -220825659;
        }

        public String toString() {
            return "TwoFAScreen";
        }
    }

    private VI3() {
    }

    public /* synthetic */ VI3(ED1 ed1) {
        this();
    }
}
