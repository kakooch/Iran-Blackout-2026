package ir.nasim;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ir.nasim.C3520Bf0;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.zf0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C25052zf0 extends Fragment {
    Handler W0 = new Handler(Looper.getMainLooper());
    C3754Cf0 X0;

    /* renamed from: ir.nasim.zf0$a */
    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ CharSequence b;

        a(int i, CharSequence charSequence) {
            this.a = i;
            this.b = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            C25052zf0.this.X0.X0().a(this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.zf0$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C25052zf0.this.X0.X0().b();
        }
    }

    /* renamed from: ir.nasim.zf0$c */
    class c implements QG4 {
        c() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C3520Bf0.b bVar) {
            if (bVar != null) {
                C25052zf0.this.L8(bVar);
                C25052zf0.this.X0.y1(null);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$d */
    class d implements QG4 {
        d() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C24458yf0 c24458yf0) {
            if (c24458yf0 != null) {
                C25052zf0.this.I8(c24458yf0.b(), c24458yf0.c());
                C25052zf0.this.X0.v1(null);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$e */
    class e implements QG4 {
        e() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CharSequence charSequence) {
            if (charSequence != null) {
                C25052zf0.this.K8(charSequence);
                C25052zf0.this.X0.v1(null);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$f */
    class f implements QG4 {
        f() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                C25052zf0.this.J8();
                C25052zf0.this.X0.w1(false);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$g */
    class g implements QG4 {
        g() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                if (C25052zf0.this.E8()) {
                    C25052zf0.this.N8();
                } else {
                    C25052zf0.this.M8();
                }
                C25052zf0.this.X0.M1(false);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$h */
    class h implements QG4 {
        h() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                C25052zf0.this.u8(1);
                C25052zf0.this.x8();
                C25052zf0.this.X0.G1(false);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$i */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C25052zf0.this.X0.H1(false);
        }
    }

    /* renamed from: ir.nasim.zf0$j */
    class j implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ CharSequence b;

        j(int i, CharSequence charSequence) {
            this.a = i;
            this.b = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            C25052zf0.this.O8(this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.zf0$k */
    class k implements Runnable {
        final /* synthetic */ C3520Bf0.b a;

        k(C3520Bf0.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C25052zf0.this.X0.X0().c(this.a);
        }
    }

    /* renamed from: ir.nasim.zf0$l */
    private static class l {
        static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
            return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        }
    }

    /* renamed from: ir.nasim.zf0$m */
    private static class m {
        static void a(BiometricPrompt biometricPrompt, BiometricPrompt.CryptoObject cryptoObject, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallback) {
            biometricPrompt.authenticate(cryptoObject, cancellationSignal, executor, biometricPrompt$AuthenticationCallback);
        }

        static void b(BiometricPrompt biometricPrompt, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallback) {
            biometricPrompt.authenticate(cancellationSignal, executor, biometricPrompt$AuthenticationCallback);
        }

        static BiometricPrompt c(BiometricPrompt.Builder builder) {
            return builder.build();
        }

        static BiometricPrompt.Builder d(Context context) {
            return new BiometricPrompt.Builder(context);
        }

        static void e(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        static void f(BiometricPrompt.Builder builder, CharSequence charSequence, Executor executor, DialogInterface.OnClickListener onClickListener) {
            builder.setNegativeButton(charSequence, executor, onClickListener);
        }

        static void g(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        static void h(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* renamed from: ir.nasim.zf0$n */
    private static class n {
        static void a(BiometricPrompt.Builder builder, boolean z) {
            builder.setConfirmationRequired(z);
        }

        static void b(BiometricPrompt.Builder builder, boolean z) {
            builder.setDeviceCredentialAllowed(z);
        }
    }

    /* renamed from: ir.nasim.zf0$o */
    private static class o {
        static void a(BiometricPrompt.Builder builder, int i) {
            builder.setAllowedAuthenticators(i);
        }
    }

    /* renamed from: ir.nasim.zf0$p */
    private static class p implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        p() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* renamed from: ir.nasim.zf0$q */
    private static class q implements Runnable {
        private final WeakReference a;

        q(C25052zf0 c25052zf0) {
            this.a = new WeakReference(c25052zf0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.get() != null) {
                ((C25052zf0) this.a.get()).W8();
            }
        }
    }

    /* renamed from: ir.nasim.zf0$r */
    private static class r implements Runnable {
        private final WeakReference a;

        r(C3754Cf0 c3754Cf0) {
            this.a = new WeakReference(c3754Cf0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.get() != null) {
                ((C3754Cf0) this.a.get()).F1(false);
            }
        }
    }

    /* renamed from: ir.nasim.zf0$s */
    private static class s implements Runnable {
        private final WeakReference a;

        s(C3754Cf0 c3754Cf0) {
            this.a = new WeakReference(c3754Cf0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.get() != null) {
                ((C3754Cf0) this.a.get()).L1(false);
            }
        }
    }

    private void A8(int i2) {
        if (i2 == -1) {
            R8(new C3520Bf0.b(null, 1));
        } else {
            O8(10, h6(ND5.generic_error_user_canceled));
        }
    }

    private boolean B8() {
        FragmentActivity fragmentActivityA5 = A5();
        return fragmentActivityA5 != null && fragmentActivityA5.isChangingConfigurations();
    }

    private boolean C8() {
        FragmentActivity fragmentActivityA5 = A5();
        return (fragmentActivityA5 == null || this.X0.Z0() == null || !AbstractC24859zK1.g(fragmentActivityA5, Build.MANUFACTURER, Build.MODEL)) ? false : true;
    }

    private boolean D8() {
        return Build.VERSION.SDK_INT == 28 && !NS4.a(G5());
    }

    private boolean F8() {
        return Build.VERSION.SDK_INT < 28 || C8() || D8();
    }

    private void G8() {
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 == null) {
            Log.e("BiometricFragment", "Failed to check device credential. Client FragmentActivity not found.");
            return;
        }
        KeyguardManager keyguardManagerA = AbstractC4549Fp3.a(fragmentActivityA5);
        if (keyguardManagerA == null) {
            O8(12, h6(ND5.generic_error_no_keyguard));
            return;
        }
        CharSequence charSequenceI1 = this.X0.i1();
        CharSequence charSequenceH1 = this.X0.h1();
        CharSequence charSequenceA1 = this.X0.a1();
        if (charSequenceH1 == null) {
            charSequenceH1 = charSequenceA1;
        }
        Intent intentA = l.a(keyguardManagerA, charSequenceI1, charSequenceH1);
        if (intentA == null) {
            O8(14, h6(ND5.generic_error_no_device_credential));
            return;
        }
        this.X0.D1(true);
        if (F8()) {
            y8();
        }
        intentA.setFlags(134742016);
        startActivityForResult(intentA, 1);
    }

    static C25052zf0 H8() {
        return new C25052zf0();
    }

    private void P8(int i2, CharSequence charSequence) {
        if (this.X0.m1()) {
            Log.v("BiometricFragment", "Error not sent to client. User is confirming their device credential.");
        } else if (!this.X0.k1()) {
            Log.w("BiometricFragment", "Error not sent to client. Client is not awaiting a result.");
        } else {
            this.X0.z1(false);
            this.X0.Y0().execute(new a(i2, charSequence));
        }
    }

    private void Q8() {
        if (this.X0.k1()) {
            this.X0.Y0().execute(new b());
        } else {
            Log.w("BiometricFragment", "Failure not sent to client. Client is not awaiting a result.");
        }
    }

    private void R8(C3520Bf0.b bVar) {
        S8(bVar);
        x8();
    }

    private void S8(C3520Bf0.b bVar) {
        if (!this.X0.k1()) {
            Log.w("BiometricFragment", "Success not sent to client. Client is not awaiting a result.");
        } else {
            this.X0.z1(false);
            this.X0.Y0().execute(new k(bVar));
        }
    }

    private void T8() {
        BiometricPrompt.Builder builderD = m.d(S7().getApplicationContext());
        CharSequence charSequenceI1 = this.X0.i1();
        CharSequence charSequenceH1 = this.X0.h1();
        CharSequence charSequenceA1 = this.X0.a1();
        if (charSequenceI1 != null) {
            m.h(builderD, charSequenceI1);
        }
        if (charSequenceH1 != null) {
            m.g(builderD, charSequenceH1);
        }
        if (charSequenceA1 != null) {
            m.e(builderD, charSequenceA1);
        }
        CharSequence charSequenceG1 = this.X0.g1();
        if (!TextUtils.isEmpty(charSequenceG1)) {
            m.f(builderD, charSequenceG1, this.X0.Y0(), this.X0.f1());
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            n.a(builderD, this.X0.l1());
        }
        int iP0 = this.X0.P0();
        if (i2 >= 30) {
            o.a(builderD, iP0);
        } else if (i2 >= 29) {
            n.b(builderD, UR.c(iP0));
        }
        s8(m.c(builderD), G5());
    }

    private void U8() {
        Context applicationContext = S7().getApplicationContext();
        C3837Co2 c3837Co2C = C3837Co2.c(applicationContext);
        int iV8 = v8(c3837Co2C);
        if (iV8 != 0) {
            O8(iV8, AbstractC14841ia2.a(applicationContext, iV8));
            return;
        }
        if (u6()) {
            this.X0.H1(true);
            if (!AbstractC24859zK1.f(applicationContext, Build.MODEL)) {
                this.W0.postDelayed(new i(), 500L);
                C3603Bo2.P8().K8(V5(), "androidx.biometric.FingerprintDialogFragment");
            }
            this.X0.A1(0);
            t8(c3837Co2C, applicationContext);
        }
    }

    private void V8(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = h6(ND5.default_error_msg);
        }
        this.X0.K1(2);
        this.X0.I1(charSequence);
    }

    private static int v8(C3837Co2 c3837Co2) {
        if (c3837Co2.f()) {
            return !c3837Co2.e() ? 11 : 0;
        }
        return 12;
    }

    private void w8() {
        if (A5() == null) {
            return;
        }
        C3754Cf0 c3754Cf0 = (C3754Cf0) new androidx.lifecycle.G(A5()).b(C3754Cf0.class);
        this.X0 = c3754Cf0;
        c3754Cf0.U0().j(this, new c());
        this.X0.S0().j(this, new d());
        this.X0.T0().j(this, new e());
        this.X0.j1().j(this, new f());
        this.X0.t1().j(this, new g());
        this.X0.p1().j(this, new h());
    }

    private void y8() {
        this.X0.P1(false);
        if (u6()) {
            FragmentManager fragmentManagerV5 = V5();
            C3603Bo2 c3603Bo2 = (C3603Bo2) fragmentManagerV5.p0("androidx.biometric.FingerprintDialogFragment");
            if (c3603Bo2 != null) {
                if (c3603Bo2.u6()) {
                    c3603Bo2.v8();
                } else {
                    fragmentManagerV5.s().p(c3603Bo2).i();
                }
            }
        }
    }

    private int z8() {
        Context contextG5 = G5();
        return (contextG5 == null || !AbstractC24859zK1.f(contextG5, Build.MODEL)) ? 2000 : 0;
    }

    boolean E8() {
        return Build.VERSION.SDK_INT <= 28 && UR.c(this.X0.P0());
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int i2, int i3, Intent intent) {
        super.H6(i2, i3, intent);
        if (i2 == 1) {
            this.X0.D1(false);
            A8(i3);
        }
    }

    void I8(int i2, CharSequence charSequence) {
        if (!AbstractC14841ia2.b(i2)) {
            i2 = 8;
        }
        Context contextG5 = G5();
        if (Build.VERSION.SDK_INT < 29 && AbstractC14841ia2.c(i2) && contextG5 != null && AbstractC4549Fp3.b(contextG5) && UR.c(this.X0.P0())) {
            G8();
            return;
        }
        if (!F8()) {
            if (charSequence == null) {
                charSequence = h6(ND5.default_error_msg) + Separators.SP + i2;
            }
            O8(i2, charSequence);
            return;
        }
        if (charSequence == null) {
            charSequence = AbstractC14841ia2.a(G5(), i2);
        }
        if (i2 == 5) {
            int iV0 = this.X0.V0();
            if (iV0 == 0 || iV0 == 3) {
                P8(i2, charSequence);
            }
            x8();
            return;
        }
        if (this.X0.q1()) {
            O8(i2, charSequence);
        } else {
            V8(charSequence);
            this.W0.postDelayed(new j(i2, charSequence), z8());
        }
        this.X0.H1(true);
    }

    void J8() {
        if (F8()) {
            V8(h6(ND5.fingerprint_not_recognized));
        }
        Q8();
    }

    void K8(CharSequence charSequence) {
        if (F8()) {
            V8(charSequence);
        }
    }

    void L8(C3520Bf0.b bVar) {
        R8(bVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        w8();
    }

    void M8() {
        CharSequence charSequenceG1 = this.X0.g1();
        if (charSequenceG1 == null) {
            charSequenceG1 = h6(ND5.default_error_msg);
        }
        O8(13, charSequenceG1);
        u8(2);
    }

    void N8() {
        G8();
    }

    void O8(int i2, CharSequence charSequence) {
        P8(i2, charSequence);
        x8();
    }

    void W8() {
        if (this.X0.u1()) {
            return;
        }
        if (G5() == null) {
            Log.w("BiometricFragment", "Not showing biometric prompt. Context is null.");
            return;
        }
        this.X0.P1(true);
        this.X0.z1(true);
        if (F8()) {
            U8();
        } else {
            T8();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        if (Build.VERSION.SDK_INT == 29 && UR.c(this.X0.P0())) {
            this.X0.L1(true);
            this.W0.postDelayed(new s(this.X0), 250L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
        if (Build.VERSION.SDK_INT >= 29 || this.X0.m1() || B8()) {
            return;
        }
        u8(0);
    }

    void r8(C3520Bf0.d dVar, C3520Bf0.c cVar) {
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 == null) {
            Log.e("BiometricFragment", "Not launching prompt. Client activity was null.");
            return;
        }
        this.X0.O1(dVar);
        int iB = UR.b(dVar, cVar);
        if (Build.VERSION.SDK_INT < 30 && iB == 15 && cVar == null) {
            this.X0.E1(AbstractC8405Vv1.a());
        } else {
            this.X0.E1(cVar);
        }
        if (E8()) {
            this.X0.N1(h6(ND5.confirm_device_credential_password));
        } else {
            this.X0.N1(null);
        }
        if (E8() && C3281Af0.g(fragmentActivityA5).a(255) != 0) {
            this.X0.z1(true);
            G8();
        } else if (this.X0.o1()) {
            this.W0.postDelayed(new q(this), 600L);
        } else {
            W8();
        }
    }

    void s8(BiometricPrompt biometricPrompt, Context context) {
        BiometricPrompt.CryptoObject cryptoObjectD = AbstractC8405Vv1.d(this.X0.Z0());
        CancellationSignal cancellationSignalB = this.X0.W0().b();
        p pVar = new p();
        BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallbackA = this.X0.R0().a();
        try {
            if (cryptoObjectD == null) {
                m.b(biometricPrompt, cancellationSignalB, pVar, biometricPrompt$AuthenticationCallbackA);
            } else {
                m.a(biometricPrompt, cryptoObjectD, cancellationSignalB, pVar, biometricPrompt$AuthenticationCallbackA);
            }
        } catch (NullPointerException e2) {
            Log.e("BiometricFragment", "Got NPE while authenticating with biometric prompt.", e2);
            O8(1, context != null ? context.getString(ND5.default_error_msg) : "");
        }
    }

    void t8(C3837Co2 c3837Co2, Context context) {
        try {
            c3837Co2.b(AbstractC8405Vv1.e(this.X0.Z0()), 0, this.X0.W0().c(), this.X0.R0().b(), null);
        } catch (NullPointerException e2) {
            Log.e("BiometricFragment", "Got NPE while authenticating with fingerprint.", e2);
            O8(1, AbstractC14841ia2.a(context, 1));
        }
    }

    void u8(int i2) {
        if (i2 == 3 || !this.X0.s1()) {
            if (F8()) {
                this.X0.A1(i2);
                if (i2 == 1) {
                    P8(10, AbstractC14841ia2.a(G5(), 10));
                }
            }
            this.X0.W0().a();
        }
    }

    void x8() {
        this.X0.P1(false);
        y8();
        if (!this.X0.m1() && u6()) {
            V5().s().p(this).i();
        }
        Context contextG5 = G5();
        if (contextG5 == null || !AbstractC24859zK1.e(contextG5, Build.MODEL)) {
            return;
        }
        this.X0.F1(true);
        this.W0.postDelayed(new r(this.X0), 600L);
    }
}
