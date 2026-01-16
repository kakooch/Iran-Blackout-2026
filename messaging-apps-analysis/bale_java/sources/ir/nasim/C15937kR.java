package ir.nasim;

import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.Build;
import ir.nasim.C3520Bf0;
import ir.nasim.C3837Co2;

/* renamed from: ir.nasim.kR, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C15937kR {
    private BiometricPrompt$AuthenticationCallback a;
    private C3837Co2.c b;
    final d c;

    /* renamed from: ir.nasim.kR$a */
    class a extends C3837Co2.c {
        a() {
        }

        @Override // ir.nasim.C3837Co2.c
        public void a(int i, CharSequence charSequence) {
            C15937kR.this.c.a(i, charSequence);
        }

        @Override // ir.nasim.C3837Co2.c
        public void b() {
            C15937kR.this.c.b();
        }

        @Override // ir.nasim.C3837Co2.c
        public void c(int i, CharSequence charSequence) {
            C15937kR.this.c.c(charSequence);
        }

        @Override // ir.nasim.C3837Co2.c
        public void d(C3837Co2.d dVar) {
            C15937kR.this.c.d(new C3520Bf0.b(dVar != null ? AbstractC8405Vv1.c(dVar.a()) : null, 2));
        }
    }

    /* renamed from: ir.nasim.kR$c */
    private static class c {
        static int a(BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    /* renamed from: ir.nasim.kR$d */
    static class d {
        d() {
        }

        abstract void a(int i, CharSequence charSequence);

        abstract void b();

        abstract void c(CharSequence charSequence);

        abstract void d(C3520Bf0.b bVar);
    }

    C15937kR(d dVar) {
        this.c = dVar;
    }

    BiometricPrompt$AuthenticationCallback a() {
        if (this.a == null) {
            this.a = b.a(this.c);
        }
        return this.a;
    }

    C3837Co2.c b() {
        if (this.b == null) {
            this.b = new a();
        }
        return this.b;
    }

    /* renamed from: ir.nasim.kR$b */
    private static class b {
        static BiometricPrompt$AuthenticationCallback a(d dVar) {
            return new a(dVar);
        }

        /* renamed from: ir.nasim.kR$b$a */
        class a extends BiometricPrompt$AuthenticationCallback {
            final /* synthetic */ d a;

            a(d dVar) {
                this.a = dVar;
            }

            public void onAuthenticationError(int i, CharSequence charSequence) {
                this.a.a(i, charSequence);
            }

            public void onAuthenticationFailed() {
                this.a.b();
            }

            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                C3520Bf0.c cVarB = authenticationResult != null ? AbstractC8405Vv1.b(authenticationResult.getCryptoObject()) : null;
                int i = Build.VERSION.SDK_INT;
                int iA = -1;
                if (i >= 30) {
                    if (authenticationResult != null) {
                        iA = c.a(authenticationResult);
                    }
                } else if (i != 29) {
                    iA = 2;
                }
                this.a.d(new C3520Bf0.b(cVarB, iA));
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
            }
        }
    }
}
