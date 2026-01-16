package ir.nasim;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: ir.nasim.Bf0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3520Bf0 {
    private FragmentManager a;

    /* renamed from: ir.nasim.Bf0$b */
    public static class b {
        private final c a;
        private final int b;

        b(c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        public int a() {
            return this.b;
        }

        public c b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Bf0$d */
    public static class d {
        private final CharSequence a;
        private final CharSequence b;
        private final CharSequence c;
        private final CharSequence d;
        private final boolean e;
        private final boolean f;
        private final int g;

        /* renamed from: ir.nasim.Bf0$d$a */
        public static class a {
            private CharSequence a = null;
            private CharSequence b = null;
            private CharSequence c = null;
            private CharSequence d = null;
            private boolean e = true;
            private boolean f = false;
            private int g = 0;

            public d a() {
                if (TextUtils.isEmpty(this.a)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                }
                if (!UR.e(this.g)) {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + UR.a(this.g));
                }
                int i = this.g;
                boolean zC = i != 0 ? UR.c(i) : this.f;
                if (TextUtils.isEmpty(this.d) && !zC) {
                    throw new IllegalArgumentException("Negative text must be set and non-empty.");
                }
                if (TextUtils.isEmpty(this.d) || !zC) {
                    return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
                }
                throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
            }

            public a b(int i) {
                this.g = i;
                return this;
            }

            public a c(CharSequence charSequence) {
                this.c = charSequence;
                return this;
            }

            public a d(CharSequence charSequence) {
                this.d = charSequence;
                return this;
            }

            public a e(CharSequence charSequence) {
                this.a = charSequence;
                return this;
            }
        }

        d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, boolean z2, int i) {
            this.a = charSequence;
            this.b = charSequence2;
            this.c = charSequence3;
            this.d = charSequence4;
            this.e = z;
            this.f = z2;
            this.g = i;
        }

        public int a() {
            return this.g;
        }

        public CharSequence b() {
            return this.c;
        }

        public CharSequence c() {
            CharSequence charSequence = this.d;
            return charSequence != null ? charSequence : "";
        }

        public CharSequence d() {
            return this.b;
        }

        public CharSequence e() {
            return this.a;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.f;
        }
    }

    public C3520Bf0(FragmentActivity fragmentActivity, Executor executor, a aVar) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        }
        if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null.");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
        f(fragmentActivity.B0(), e(fragmentActivity), executor, aVar);
    }

    private void b(d dVar, c cVar) {
        FragmentManager fragmentManager = this.a;
        if (fragmentManager == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
        } else if (fragmentManager.X0()) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
        } else {
            d(this.a).r8(dVar, cVar);
        }
    }

    private static C25052zf0 c(FragmentManager fragmentManager) {
        return (C25052zf0) fragmentManager.p0("androidx.biometric.BiometricFragment");
    }

    private static C25052zf0 d(FragmentManager fragmentManager) {
        C25052zf0 c25052zf0C = c(fragmentManager);
        if (c25052zf0C != null) {
            return c25052zf0C;
        }
        C25052zf0 c25052zf0H8 = C25052zf0.H8();
        fragmentManager.s().e(c25052zf0H8, "androidx.biometric.BiometricFragment").i();
        fragmentManager.l0();
        return c25052zf0H8;
    }

    private static C3754Cf0 e(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            return (C3754Cf0) new androidx.lifecycle.G(fragmentActivity).b(C3754Cf0.class);
        }
        return null;
    }

    private void f(FragmentManager fragmentManager, C3754Cf0 c3754Cf0, Executor executor, a aVar) {
        this.a = fragmentManager;
        if (c3754Cf0 != null) {
            if (executor != null) {
                c3754Cf0.C1(executor);
            }
            c3754Cf0.B1(aVar);
        }
    }

    public void a(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("PromptInfo cannot be null.");
        }
        b(dVar, null);
    }

    /* renamed from: ir.nasim.Bf0$c */
    public static class c {
        private final Signature a;
        private final Cipher b;
        private final Mac c;
        private final IdentityCredential d;

        public c(Signature signature) {
            this.a = signature;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public Cipher a() {
            return this.b;
        }

        public IdentityCredential b() {
            return this.d;
        }

        public Mac c() {
            return this.c;
        }

        public Signature d() {
            return this.a;
        }

        public c(Cipher cipher) {
            this.a = null;
            this.b = cipher;
            this.c = null;
            this.d = null;
        }

        public c(Mac mac) {
            this.a = null;
            this.b = null;
            this.c = mac;
            this.d = null;
        }

        public c(IdentityCredential identityCredential) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = identityCredential;
        }
    }

    /* renamed from: ir.nasim.Bf0$a */
    public static abstract class a {
        public void b() {
        }

        public void c(b bVar) {
        }

        public void a(int i, CharSequence charSequence) {
        }
    }
}
