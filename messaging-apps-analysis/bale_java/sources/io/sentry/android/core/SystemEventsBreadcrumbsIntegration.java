package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.android.core.X;
import io.sentry.util.C3202a;
import java.io.Closeable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class SystemEventsBreadcrumbsIntegration implements InterfaceC3157o0, Closeable, X.a {
    private final Context a;
    volatile b b;
    private SentryAndroidOptions c;
    private io.sentry.Z d;
    private final String[] e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile IntentFilter h;
    private volatile HandlerThread i;
    private final AtomicBoolean j;
    private final C3202a k;
    private a l;

    static final class a {
        private final Integer a;
        private final Boolean b;

        a(Integer num, Boolean bool) {
            this.a = num;
            this.b = bool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return io.sentry.util.u.a(this.a, aVar.a) && io.sentry.util.u.a(this.b, aVar.b);
        }

        public int hashCode() {
            return io.sentry.util.u.b(this.a, this.b);
        }
    }

    final class b extends BroadcastReceiver {
        private final io.sentry.Z a;
        private final SentryAndroidOptions b;
        private final io.sentry.android.core.internal.util.m c = new io.sentry.android.core.internal.util.m(io.sentry.android.core.internal.util.g.b(), 60000, 0);
        private final char[] d = new char[64];

        b(io.sentry.Z z, SentryAndroidOptions sentryAndroidOptions) {
            this.a = z;
            this.b = sentryAndroidOptions;
        }

        private C3106e a(long j, Intent intent, String str, a aVar) {
            Bundle extras;
            C3106e c3106e = new C3106e(j);
            c3106e.C("system");
            c3106e.y("device.event");
            String strB = b(str);
            if (strB != null) {
                c3106e.z("action", strB);
            }
            if (aVar != null) {
                if (aVar.a != null) {
                    c3106e.z("level", aVar.a);
                }
                if (aVar.b != null) {
                    c3106e.z("charging", aVar.b);
                }
            } else if (this.b.isEnableSystemEventBreadcrumbsExtras() && (extras = intent.getExtras()) != null && !extras.isEmpty()) {
                HashMap map = new HashMap(extras.size());
                for (String str2 : extras.keySet()) {
                    try {
                        Object obj = extras.get(str2);
                        if (obj != null) {
                            map.put(str2, obj.toString());
                        }
                    } catch (Throwable th) {
                        this.b.getLogger().a(Y2.ERROR, th, "%s key of the %s action threw an error.", str2, str);
                    }
                }
                c3106e.z("extras", map);
            }
            c3106e.A(Y2.INFO);
            return c3106e;
        }

        String b(String str) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            int length2 = this.d.length;
            for (int i = length - 1; i >= 0; i--) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '.') {
                    char[] cArr = this.d;
                    return new String(cArr, length2, cArr.length - length2);
                }
                if (length2 == 0) {
                    return io.sentry.util.B.d(str);
                }
                length2--;
                this.d[length2] = cCharAt;
            }
            return str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar;
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                aVar = null;
            } else {
                if (this.c.a()) {
                    return;
                }
                Float fC = C3072q0.c(intent, this.b);
                a aVar2 = new a(fC != null ? Integer.valueOf(fC.intValue()) : null, C3072q0.t(intent, this.b));
                if (aVar2.equals(SystemEventsBreadcrumbsIntegration.this.l)) {
                    return;
                }
                SystemEventsBreadcrumbsIntegration.this.l = aVar2;
                aVar = aVar2;
            }
            C3106e c3106eA = a(System.currentTimeMillis(), intent, action, aVar);
            io.sentry.I i = new io.sentry.I();
            i.k("android:intent", intent);
            this.a.b(c3106eA, i);
        }
    }

    public SystemEventsBreadcrumbsIntegration(Context context) {
        this(context, k());
    }

    private static String[] k() {
        return new String[]{"android.intent.action.ACTION_SHUTDOWN", "android.intent.action.AIRPLANE_MODE", "android.intent.action.BATTERY_CHANGED", "android.intent.action.CAMERA_BUTTON", "android.intent.action.CONFIGURATION_CHANGED", "android.intent.action.DATE_CHANGED", "android.intent.action.DEVICE_STORAGE_LOW", "android.intent.action.DEVICE_STORAGE_OK", "android.intent.action.DOCK_EVENT", "android.intent.action.DREAMING_STARTED", "android.intent.action.DREAMING_STOPPED", "android.intent.action.INPUT_METHOD_CHANGED", "android.intent.action.LOCALE_CHANGED", "android.intent.action.SCREEN_OFF", "android.intent.action.SCREEN_ON", "android.intent.action.TIMEZONE_CHANGED", "android.intent.action.TIME_SET", "android.os.action.DEVICE_IDLE_MODE_CHANGED", "android.os.action.POWER_SAVE_MODE_CHANGED"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(io.sentry.Z z, SentryAndroidOptions sentryAndroidOptions) {
        InterfaceC3102d0 interfaceC3102d0A = this.k.a();
        try {
            if (!this.f && !this.g && this.b == null) {
                this.b = new b(z, sentryAndroidOptions);
                if (this.h == null) {
                    this.h = new IntentFilter();
                    for (String str : this.e) {
                        this.h.addAction(str);
                    }
                }
                if (this.i == null) {
                    this.i = new HandlerThread("SystemEventsReceiver", 10);
                    this.i.start();
                }
                try {
                    AbstractC3060k0.y(this.a, sentryAndroidOptions, this.b, this.h, new Handler(this.i.getLooper()));
                    if (!this.j.getAndSet(true)) {
                        sentryAndroidOptions.getLogger().c(Y2.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                        io.sentry.util.o.a("SystemEventsBreadcrumbs");
                    }
                } catch (Throwable th) {
                    sentryAndroidOptions.setEnableSystemEventBreadcrumbs(false);
                    sentryAndroidOptions.getLogger().b(Y2.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th);
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th2) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        InterfaceC3102d0 interfaceC3102d0A = this.k.a();
        try {
            this.g = true;
            b bVar = this.b;
            this.b = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            if (bVar != null) {
                this.a.unregisterReceiver(bVar);
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

    private void n(final io.sentry.Z z, final SentryAndroidOptions sentryAndroidOptions) {
        if (sentryAndroidOptions.isEnableSystemEventBreadcrumbs() && !this.f && !this.g && this.b == null) {
            try {
                sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.Z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l(z, sentryAndroidOptions);
                    }
                });
            } catch (Throwable unused) {
                sentryAndroidOptions.getLogger().c(Y2.WARNING, "Failed to start SystemEventsBreadcrumbsIntegration on executor thread.", new Object[0]);
            }
        }
    }

    private void p() {
        SentryAndroidOptions sentryAndroidOptions = this.c;
        if (sentryAndroidOptions == null) {
            return;
        }
        sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.Y0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m();
            }
        });
    }

    @Override // io.sentry.android.core.X.a
    public void a() {
        if (this.d == null || this.c == null) {
            return;
        }
        this.g = false;
        n(this.d, this.c);
    }

    @Override // io.sentry.android.core.X.a
    public void b() {
        p();
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.c = sentryAndroidOptions;
        this.d = z;
        sentryAndroidOptions.getLogger().c(Y2.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.c.isEnableSystemEventBreadcrumbs()));
        if (this.c.isEnableSystemEventBreadcrumbs()) {
            X.j().d(this);
            if (AbstractC3060k0.s()) {
                n(this.d, this.c);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC3102d0 interfaceC3102d0A = this.k.a();
        try {
            this.f = true;
            this.h = null;
            if (this.i != null) {
                this.i.quit();
            }
            this.i = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            X.j().p(this);
            p();
            SentryAndroidOptions sentryAndroidOptions = this.c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(Y2.DEBUG, "SystemEventsBreadcrumbsIntegration removed.", new Object[0]);
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

    SystemEventsBreadcrumbsIntegration(Context context, String[] strArr) {
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = new AtomicBoolean(false);
        this.k = new C3202a();
        this.a = AbstractC3060k0.g(context);
        this.e = strArr;
    }
}
