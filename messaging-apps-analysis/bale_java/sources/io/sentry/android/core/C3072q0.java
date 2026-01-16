package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gov.nist.core.Separators;
import android.os.Build;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.sentry.AbstractC3141l;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3102d0;
import io.sentry.N;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.protocol.C3170e;
import io.sentry.util.C3202a;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: io.sentry.android.core.q0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3072q0 {
    private static volatile C3072q0 i;
    private static final C3202a j = new C3202a();
    private final Context a;
    private final SentryAndroidOptions b;
    private final Y c;
    private final Boolean d;
    private final AbstractC3060k0.a e;
    private final AbstractC3060k0.b f;
    private final io.sentry.protocol.l g;
    private final Long h;

    /* renamed from: io.sentry.android.core.q0$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[N.a.values().length];
            a = iArr;
            try {
                iArr[N.a.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[N.a.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C3072q0(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.a = context;
        this.b = sentryAndroidOptions;
        Y y = new Y(sentryAndroidOptions.getLogger());
        this.c = y;
        io.sentry.android.core.internal.util.l.a().c();
        this.g = u();
        this.d = y.f();
        this.e = AbstractC3060k0.A(context, sentryAndroidOptions.getLogger(), y);
        this.f = AbstractC3060k0.B(context, y);
        ActivityManager.MemoryInfo memoryInfoN = AbstractC3060k0.n(context, sentryAndroidOptions.getLogger());
        if (memoryInfoN != null) {
            this.h = Long.valueOf(memoryInfoN.totalMem);
        } else {
            this.h = null;
        }
    }

    private Intent b() {
        return AbstractC3060k0.z(this.a, this.c, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null);
    }

    public static Float c(Intent intent, C3155n3 c3155n3) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    private Float d(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting battery temperature.", th);
            return null;
        }
    }

    private Date e() {
        try {
            return AbstractC3141l.e(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e) {
            this.b.getLogger().a(Y2.ERROR, e, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private String f() {
        try {
            return AbstractC3081v0.a(this.a);
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    private File g(File file) {
        File[] externalFilesDirs = this.a.getExternalFilesDirs(null);
        if (externalFilesDirs != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : externalFilesDirs) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.b.getLogger().c(Y2.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private StatFs h(File file) {
        try {
            File fileG = g(file);
            if (fileG != null) {
                return new StatFs(fileG.getPath());
            }
            return null;
        } catch (Throwable unused) {
            this.b.getLogger().c(Y2.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
    }

    public static C3072q0 i(Context context, SentryAndroidOptions sentryAndroidOptions) {
        if (i == null) {
            InterfaceC3102d0 interfaceC3102d0A = j.a();
            try {
                if (i == null) {
                    i = new C3072q0(AbstractC3060k0.g(context), sentryAndroidOptions);
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return i;
    }

    private C3170e.b k() {
        C3170e.b bVarA;
        Throwable th;
        try {
            bVarA = io.sentry.android.core.internal.util.n.a(this.a.getResources().getConfiguration().orientation);
            if (bVarA == null) {
                try {
                    this.b.getLogger().c(Y2.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    this.b.getLogger().b(Y2.ERROR, "Error getting device orientation.", th);
                    return bVarA;
                }
            }
        } catch (Throwable th3) {
            bVarA = null;
            th = th3;
        }
        return bVarA;
    }

    private TimeZone n() {
        if (this.c.d() >= 24) {
            LocaleList locales = this.a.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Long o(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting total external storage amount.", th);
            return null;
        }
    }

    private Long p(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting total internal storage amount.", th);
            return null;
        }
    }

    private Long r(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting unused external storage amount.", th);
            return null;
        }
    }

    private Long s(StatFs statFs) {
        try {
            return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting unused internal storage amount.", th);
            return null;
        }
    }

    public static Boolean t(Intent intent, C3155n3 c3155n3) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    private io.sentry.protocol.l u() throws IOException {
        io.sentry.protocol.l lVar = new io.sentry.protocol.l();
        lVar.j("Android");
        lVar.m(Build.VERSION.RELEASE);
        lVar.h(Build.DISPLAY);
        String strM = AbstractC3060k0.m(this.b.getLogger());
        if (strM != null) {
            lVar.i(strM);
        }
        if (this.b.isEnableRootCheck()) {
            lVar.k(Boolean.valueOf(new io.sentry.android.core.internal.util.s(this.a, this.c, this.b.getLogger()).e()));
        }
        return lVar;
    }

    private void v(C3170e c3170e, boolean z) {
        Intent intentB = b();
        if (intentB != null) {
            c3170e.M(c(intentB, this.b));
            c3170e.Q(t(intentB, this.b));
            c3170e.N(d(intentB));
        }
        int i2 = a.a[this.b.getConnectionStatusProvider().w0().ordinal()];
        c3170e.f0(i2 != 1 ? i2 != 2 ? null : Boolean.TRUE : Boolean.FALSE);
        ActivityManager.MemoryInfo memoryInfoN = AbstractC3060k0.n(this.a, this.b.getLogger());
        if (memoryInfoN != null && z) {
            c3170e.W(Long.valueOf(memoryInfoN.availMem));
            c3170e.a0(Boolean.valueOf(memoryInfoN.lowMemory));
        }
        File externalFilesDir = this.a.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            c3170e.o0(p(statFs));
            c3170e.X(s(statFs));
        }
        StatFs statFsH = h(externalFilesDir);
        if (statFsH != null) {
            c3170e.U(o(statFsH));
            c3170e.T(r(statFsH));
        }
        if (c3170e.I() == null) {
            c3170e.S(this.b.getConnectionStatusProvider().W());
        }
    }

    public C3170e a(boolean z, boolean z2) {
        C3170e c3170e = new C3170e();
        c3170e.b0(Build.MANUFACTURER);
        c3170e.P(Build.BRAND);
        c3170e.V(AbstractC3060k0.l(this.b.getLogger()));
        c3170e.d0(Build.MODEL);
        c3170e.e0(Build.ID);
        c3170e.L(AbstractC3060k0.j());
        if (this.c.d() >= 31) {
            c3170e.R(Build.SOC_MANUFACTURER + Separators.SP + Build.SOC_MODEL);
        }
        c3170e.g0(k());
        Boolean bool = this.d;
        if (bool != null) {
            c3170e.n0(bool);
        }
        DisplayMetrics displayMetricsK = AbstractC3060k0.k(this.a, this.b.getLogger());
        if (displayMetricsK != null) {
            c3170e.m0(Integer.valueOf(displayMetricsK.widthPixels));
            c3170e.l0(Integer.valueOf(displayMetricsK.heightPixels));
            c3170e.j0(Float.valueOf(displayMetricsK.density));
            c3170e.k0(Integer.valueOf(displayMetricsK.densityDpi));
        }
        c3170e.O(e());
        c3170e.p0(n());
        if (c3170e.J() == null) {
            c3170e.Y(f());
        }
        Locale locale = Locale.getDefault();
        if (c3170e.K() == null) {
            c3170e.Z(locale.toString());
        }
        List listC = io.sentry.android.core.internal.util.l.a().c();
        if (!listC.isEmpty()) {
            c3170e.i0(Double.valueOf(((Integer) Collections.max(listC)).doubleValue()));
            c3170e.h0(Integer.valueOf(listC.size()));
        }
        c3170e.c0(this.h);
        if (z && this.b.isCollectAdditionalContext()) {
            v(c3170e, z2);
        }
        return c3170e;
    }

    public io.sentry.protocol.l j() {
        return this.g;
    }

    public AbstractC3060k0.a l() {
        return this.e;
    }

    public AbstractC3060k0.b m() {
        return this.f;
    }

    public Long q() {
        return this.h;
    }
}
