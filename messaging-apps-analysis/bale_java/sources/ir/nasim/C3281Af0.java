package ir.nasim;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.Af0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3281Af0 {
    private final d a;
    private final BiometricManager b;
    private final C3837Co2 c;

    /* renamed from: ir.nasim.Af0$a */
    private static class a {
        static int a(BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        static BiometricManager b(Context context) {
            return (BiometricManager) context.getSystemService(BiometricManager.class);
        }

        static Method c() {
            try {
                return BiometricManager.class.getMethod("canAuthenticate", BiometricPrompt.CryptoObject.class);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    /* renamed from: ir.nasim.Af0$b */
    private static class b {
        static int a(BiometricManager biometricManager, int i) {
            return biometricManager.canAuthenticate(i);
        }
    }

    /* renamed from: ir.nasim.Af0$c */
    private static class c implements d {
        private final Context a;

        c(Context context) {
            this.a = context.getApplicationContext();
        }

        @Override // ir.nasim.C3281Af0.d
        public boolean a() {
            return AbstractC4549Fp3.a(this.a) != null;
        }

        @Override // ir.nasim.C3281Af0.d
        public boolean b() {
            return AbstractC4549Fp3.b(this.a);
        }

        @Override // ir.nasim.C3281Af0.d
        public boolean c() {
            return AbstractC24859zK1.a(this.a, Build.MODEL);
        }

        @Override // ir.nasim.C3281Af0.d
        public C3837Co2 d() {
            return C3837Co2.c(this.a);
        }

        @Override // ir.nasim.C3281Af0.d
        public BiometricManager e() {
            return a.b(this.a);
        }

        @Override // ir.nasim.C3281Af0.d
        public boolean f() {
            return NS4.a(this.a);
        }
    }

    /* renamed from: ir.nasim.Af0$d */
    interface d {
        boolean a();

        boolean b();

        boolean c();

        C3837Co2 d();

        BiometricManager e();

        boolean f();
    }

    C3281Af0(d dVar) {
        this.a = dVar;
        int i = Build.VERSION.SDK_INT;
        this.b = i >= 29 ? dVar.e() : null;
        this.c = i <= 29 ? dVar.d() : null;
    }

    private int b(int i) {
        if (!UR.e(i)) {
            return -2;
        }
        if (i == 0 || !this.a.a()) {
            return 12;
        }
        if (UR.c(i)) {
            return this.a.b() ? 0 : 11;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 29) {
            return UR.f(i) ? f() : e();
        }
        if (i2 != 28) {
            return c();
        }
        if (this.a.f()) {
            return d();
        }
        return 12;
    }

    private int c() {
        C3837Co2 c3837Co2 = this.c;
        if (c3837Co2 == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        }
        if (c3837Co2.f()) {
            return !this.c.e() ? 11 : 0;
        }
        return 12;
    }

    private int d() {
        return !this.a.b() ? c() : c() == 0 ? 0 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int e() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            java.lang.String r0 = "BiometricManager"
            java.lang.reflect.Method r1 = ir.nasim.C3281Af0.a.c()
            if (r1 == 0) goto L38
            ir.nasim.Bf0$c r2 = ir.nasim.AbstractC8405Vv1.a()
            android.hardware.biometrics.BiometricPrompt$CryptoObject r2 = ir.nasim.AbstractC8405Vv1.d(r2)
            if (r2 == 0) goto L38
            android.hardware.biometrics.BiometricManager r3 = r4.b     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            if (r2 == 0) goto L2d
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            int r0 = r1.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            return r0
        L27:
            r1 = move-exception
            goto L33
        L29:
            r1 = move-exception
            goto L33
        L2b:
            r1 = move-exception
            goto L33
        L2d:
            java.lang.String r1 = "Invalid return type for canAuthenticate(CryptoObject)."
            android.util.Log.w(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            goto L38
        L33:
            java.lang.String r2 = "Failed to invoke canAuthenticate(CryptoObject)."
            android.util.Log.w(r0, r2, r1)
        L38:
            int r0 = r4.f()
            ir.nasim.Af0$d r1 = r4.a
            boolean r1 = r1.c()
            if (r1 != 0) goto L4b
            if (r0 == 0) goto L47
            goto L4b
        L47:
            int r0 = r4.d()
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3281Af0.e():int");
    }

    private int f() {
        BiometricManager biometricManager = this.b;
        if (biometricManager != null) {
            return a.a(biometricManager);
        }
        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }

    public static C3281Af0 g(Context context) {
        return new C3281Af0(new c(context));
    }

    public int a(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            return b(i);
        }
        BiometricManager biometricManager = this.b;
        if (biometricManager != null) {
            return b.a(biometricManager, i);
        }
        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }
}
