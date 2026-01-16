package ir.nasim;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzav;
import com.google.android.gms.internal.gtm.zzba;
import com.google.android.gms.internal.gtm.zzfs;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class Gu8 {
    private static volatile Gu8 g;
    private final Context a;
    private final List b;
    private final C21600to8 c;
    private final Bs8 d;
    private volatile zzav e;
    private Thread.UncaughtExceptionHandler f;

    Gu8(Context context) {
        Context applicationContext = context.getApplicationContext();
        AbstractC3795Cj5.j(applicationContext);
        this.a = applicationContext;
        this.d = new Bs8(this);
        this.b = new CopyOnWriteArrayList();
        this.c = new C21600to8();
    }

    public static Gu8 a(Context context) {
        AbstractC3795Cj5.j(context);
        if (g == null) {
            synchronized (Gu8.class) {
                try {
                    if (g == null) {
                        g = new Gu8(context);
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public static void e() {
        if (!(Thread.currentThread() instanceof C23436wu8)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final zzav b() {
        String packageName;
        if (this.e == null) {
            synchronized (this) {
                try {
                } catch (PackageManager.NameNotFoundException unused) {
                    String strValueOf = String.valueOf(packageName);
                    Log.e("GAv4", strValueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(strValueOf) : new String("Error retrieving package info: appName set to "));
                } finally {
                }
                if (this.e == null) {
                    zzav zzavVar = new zzav();
                    PackageManager packageManager = this.a.getPackageManager();
                    packageName = this.a.getPackageName();
                    zzavVar.zzi(packageName);
                    zzavVar.zzj(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.a.getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        if (!TextUtils.isEmpty(applicationLabel)) {
                            packageName = applicationLabel.toString();
                        }
                        str = packageInfo.versionName;
                    }
                    zzavVar.zzk(packageName);
                    zzavVar.zzl(str);
                    this.e = zzavVar;
                }
            }
        }
        return this.e;
    }

    public final zzba c() {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        zzba zzbaVar = new zzba();
        zzbaVar.zze(zzfs.zzd(Locale.getDefault()));
        zzbaVar.zza = displayMetrics.widthPixels;
        zzbaVar.zzb = displayMetrics.heightPixels;
        return zzbaVar;
    }

    public final void f(Runnable runnable) {
        AbstractC3795Cj5.j(runnable);
        this.d.submit(runnable);
    }

    public final void g(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f = uncaughtExceptionHandler;
    }
}
