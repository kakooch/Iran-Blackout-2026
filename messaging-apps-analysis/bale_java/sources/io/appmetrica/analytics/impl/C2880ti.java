package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import io.appmetrica.analytics.coreapi.internal.model.AppVersionInfo;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreapi.internal.model.SdkEnvironment;
import io.appmetrica.analytics.coreapi.internal.model.SdkInfo;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.coreutils.internal.services.FrameworkDetector;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import ir.nasim.AbstractC13042fc3;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.appmetrica.analytics.impl.ti, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2880ti implements SdkEnvironmentProvider {
    public final Context a;
    public final C3017zb b = new C3017zb();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public SdkEnvironment d;
    public String e;

    public C2880ti(Context context) {
        this.a = context;
        this.d = new SdkEnvironment(new AppVersionInfo(PackageManagerUtils.getAppVersionName(context), PackageManagerUtils.getAppVersionCodeString(context)), FrameworkDetector.framework(), new ScreenInfo(0, 0, 0, 0.0f), new SdkInfo("7.1.0", "50089575", AbstractC2904ui.a()), "phone", C3017zb.a(context.getResources().getConfiguration()));
    }

    public final synchronized void a(ScreenInfo screenInfo) {
        float f;
        if (screenInfo != null) {
            try {
                if (!AbstractC13042fc3.d(screenInfo, getSdkEnvironment().getScreenInfo())) {
                    String str = this.e;
                    if (str == null) {
                        Context context = this.a;
                        Point point = new Point(screenInfo.getWidth(), screenInfo.getHeight());
                        SafePackageManager safePackageManager = Vd.a;
                        try {
                            f = context.getResources().getDisplayMetrics().density;
                        } catch (Throwable unused) {
                            f = 0.0f;
                        }
                        if (f == 0.0f) {
                            str = "phone";
                        } else {
                            float f2 = point.x;
                            float f3 = point.y;
                            float fMin = Math.min(f2 / f, f3 / f);
                            float f4 = f * 160.0f;
                            float f5 = f2 / f4;
                            float f6 = f3 / f4;
                            double dSqrt = Math.sqrt((f6 * f6) + (f5 * f5));
                            str = (dSqrt < 15.0d || Vd.a.hasSystemFeature(context, "android.hardware.touchscreen")) ? (dSqrt >= 7.0d || fMin >= 600.0f) ? "tablet" : "phone" : "tv";
                        }
                    }
                    this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, screenInfo, null, str, null, 43, null);
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        ((AbstractC2819r5) ((InterfaceC2856si) it.next())).d();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(InterfaceC2856si interfaceC2856si) {
        this.c.remove(interfaceC2856si);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider
    public final SdkEnvironment getSdkEnvironment() {
        SdkEnvironment sdkEnvironment = this.d;
        if (sdkEnvironment != null) {
            return sdkEnvironment;
        }
        AbstractC13042fc3.y("sdkEnvironment");
        return null;
    }

    public final synchronized void a(String str) {
        if (str != null) {
            if (!AbstractC13042fc3.d(str, this.e)) {
                this.e = str;
                if (!AbstractC13042fc3.d(str, getSdkEnvironment().getDeviceType())) {
                    this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, null, null, str, null, 47, null);
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        ((AbstractC2819r5) ((InterfaceC2856si) it.next())).d();
                    }
                }
            }
        }
    }

    public final synchronized void a(String str, String str2) {
        if (str == null) {
            try {
                str = getSdkEnvironment().getAppVersionInfo().getAppVersionName();
            } finally {
            }
        }
        if (str2 == null) {
            str2 = getSdkEnvironment().getAppVersionInfo().getAppBuildNumber();
        }
        AppVersionInfo appVersionInfo = getSdkEnvironment().getAppVersionInfo();
        if (!AbstractC13042fc3.d(appVersionInfo.getAppVersionName(), str) || !AbstractC13042fc3.d(appVersionInfo.getAppBuildNumber(), str2)) {
            this.d = SdkEnvironment.copy$default(getSdkEnvironment(), new AppVersionInfo(str, str2), null, null, null, null, null, 62, null);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((AbstractC2819r5) ((InterfaceC2856si) it.next())).d();
            }
        }
    }

    public final synchronized void a(Configuration configuration) {
        this.b.getClass();
        List listA = C3017zb.a(configuration);
        if (!AbstractC13042fc3.d(getSdkEnvironment().getLocales(), listA)) {
            this.d = SdkEnvironment.copy$default(getSdkEnvironment(), null, null, null, null, null, listA, 31, null);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((AbstractC2819r5) ((InterfaceC2856si) it.next())).d();
            }
        }
    }

    public final void a(InterfaceC2856si interfaceC2856si) {
        this.c.add(interfaceC2856si);
    }
}
