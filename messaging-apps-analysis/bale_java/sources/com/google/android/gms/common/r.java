package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import ir.nasim.AbstractC21342tV2;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC7899Tr;
import ir.nasim.CG4;
import ir.nasim.Jh8;
import ir.nasim.Mh8;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
abstract class r {
    private static volatile Mh8 e;
    private static Context g;
    static final p a = new j(n.D2("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final p b = new k(n.D2("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final p c = new l(n.D2("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final p d = new m(n.D2("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object f = new Object();

    static w a(String str, n nVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, nVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static w b(String str, boolean z, boolean z2, boolean z3) {
        return g(str, z, false, false, true);
    }

    static /* synthetic */ String c(boolean z, String str, n nVar) throws NoSuchAlgorithmException {
        String str2 = (z || !f(str, nVar, true, false).a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = AbstractC7899Tr.b("SHA-256");
        AbstractC3795Cj5.j(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, AbstractC21342tV2.a(messageDigestB.digest(nVar.E2())), Boolean.valueOf(z), "12451000.false");
    }

    static synchronized void d(Context context) {
        if (g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            g = context.getApplicationContext();
        }
    }

    static boolean e() {
        boolean zJ;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                zJ = e.j();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            zJ = false;
        }
        return zJ;
    }

    private static w f(final String str, final n nVar, final boolean z, boolean z2) {
        try {
            h();
            AbstractC3795Cj5.j(g);
            try {
                return e.f0(new zzs(str, nVar, z, z2), CG4.E2(g.getPackageManager())) ? w.b() : new v(new Callable() { // from class: com.google.android.gms.common.i
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return r.c(z, str, nVar);
                    }
                }, null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return w.d("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return w.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, ir.nasim.XZ2] */
    private static w g(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        w wVarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            AbstractC3795Cj5.j(g);
            try {
                h();
                zzo zzoVar = new zzo(str, z, false, CG4.E2(g), false, true);
                try {
                    zzq zzqVarN1 = z4 ? e.N1(zzoVar) : e.Y1(zzoVar);
                    if (zzqVarN1.S()) {
                        wVarD = w.f(zzqVarN1.d0());
                    } else {
                        String strP = zzqVarN1.P();
                        PackageManager.NameNotFoundException nameNotFoundException = zzqVarN1.s0() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strP == null) {
                            strP = "error checking package certificate";
                        }
                        wVarD = w.g(zzqVarN1.d0(), zzqVarN1.s0(), strP, nameNotFoundException);
                    }
                } catch (RemoteException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    wVarD = w.d("module call", e2);
                }
            } catch (DynamiteModule.LoadingException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                wVarD = w.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return wVarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    private static void h() {
        if (e != null) {
            return;
        }
        AbstractC3795Cj5.j(g);
        synchronized (f) {
            try {
                if (e == null) {
                    e = Jh8.C2(DynamiteModule.e(g, DynamiteModule.f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
