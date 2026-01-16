package io.sentry.android.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import io.sentry.AbstractC3141l;
import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3129i2;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class NetworkBreadcrumbsIntegration implements InterfaceC3157o0, Closeable {
    private final Context a;
    private final Y b;
    private final C3202a c = new C3202a();
    private C3155n3 d;
    volatile b e;

    static class a {
        final int a;
        final int b;
        final int c;
        private long d;
        final boolean e;
        final String f;

        a(NetworkCapabilities networkCapabilities, Y y, long j) {
            io.sentry.util.u.c(networkCapabilities, "NetworkCapabilities is required");
            io.sentry.util.u.c(y, "BuildInfoProvider is required");
            this.a = networkCapabilities.getLinkDownstreamBandwidthKbps();
            this.b = networkCapabilities.getLinkUpstreamBandwidthKbps();
            int signalStrength = y.d() >= 29 ? networkCapabilities.getSignalStrength() : 0;
            this.c = signalStrength > -100 ? signalStrength : 0;
            this.e = networkCapabilities.hasTransport(4);
            String strZ = io.sentry.android.core.internal.util.f.Z(networkCapabilities);
            this.f = strZ == null ? "" : strZ;
            this.d = j;
        }

        boolean a(a aVar) {
            int iAbs = Math.abs(this.c - aVar.c);
            int iAbs2 = Math.abs(this.a - aVar.a);
            int iAbs3 = Math.abs(this.b - aVar.b);
            boolean z = AbstractC3141l.l((double) Math.abs(this.d - aVar.d)) < 5000.0d;
            return this.e == aVar.e && this.f.equals(aVar.f) && (z || iAbs <= 5) && (z || (((double) iAbs2) > Math.max(1000.0d, ((double) Math.abs(this.a)) * 0.1d) ? 1 : (((double) iAbs2) == Math.max(1000.0d, ((double) Math.abs(this.a)) * 0.1d) ? 0 : -1)) <= 0) && (z || (((double) iAbs3) > Math.max(1000.0d, ((double) Math.abs(this.b)) * 0.1d) ? 1 : (((double) iAbs3) == Math.max(1000.0d, ((double) Math.abs(this.b)) * 0.1d) ? 0 : -1)) <= 0);
        }
    }

    static final class b extends ConnectivityManager.NetworkCallback {
        final io.sentry.Z a;
        final Y b;
        NetworkCapabilities c = null;
        long d = 0;
        final InterfaceC3129i2 e;

        b(io.sentry.Z z, Y y, InterfaceC3129i2 interfaceC3129i2) {
            this.a = (io.sentry.Z) io.sentry.util.u.c(z, "Scopes are required");
            this.b = (Y) io.sentry.util.u.c(y, "BuildInfoProvider is required");
            this.e = (InterfaceC3129i2) io.sentry.util.u.c(interfaceC3129i2, "SentryDateProvider is required");
        }

        private C3106e a(String str) {
            C3106e c3106e = new C3106e();
            c3106e.C("system");
            c3106e.y("network.event");
            c3106e.z("action", str);
            c3106e.A(Y2.INFO);
            return c3106e;
        }

        private a b(NetworkCapabilities networkCapabilities, NetworkCapabilities networkCapabilities2, long j, long j2) {
            if (networkCapabilities == null) {
                return new a(networkCapabilities2, this.b, j2);
            }
            a aVar = new a(networkCapabilities, this.b, j);
            a aVar2 = new a(networkCapabilities2, this.b, j2);
            if (aVar.a(aVar2)) {
                return null;
            }
            return aVar2;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            this.a.a(a("NETWORK_AVAILABLE"));
            this.c = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            long jP = this.e.a().p();
            a aVarB = b(this.c, networkCapabilities, this.d, jP);
            if (aVarB == null) {
                return;
            }
            this.c = networkCapabilities;
            this.d = jP;
            C3106e c3106eA = a("NETWORK_CAPABILITIES_CHANGED");
            c3106eA.z("download_bandwidth", Integer.valueOf(aVarB.a));
            c3106eA.z("upload_bandwidth", Integer.valueOf(aVarB.b));
            c3106eA.z("vpn_active", Boolean.valueOf(aVarB.e));
            c3106eA.z("network_type", aVarB.f);
            int i = aVarB.c;
            if (i != 0) {
                c3106eA.z("signal_strength", Integer.valueOf(i));
            }
            io.sentry.I i2 = new io.sentry.I();
            i2.k("android:networkCapabilities", aVarB);
            this.a.b(c3106eA, i2);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.a.a(a("NETWORK_LOST"));
            this.c = null;
        }
    }

    public NetworkBreadcrumbsIntegration(Context context, Y y) {
        this.a = (Context) io.sentry.util.u.c(AbstractC3060k0.g(context), "Context is required");
        this.b = (Y) io.sentry.util.u.c(y, "BuildInfoProvider is required");
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.d = c3155n3;
        ILogger logger = c3155n3.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "NetworkBreadcrumbsIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
        if (sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()) {
            if (this.b.d() < 24) {
                c3155n3.getLogger().c(y2, "NetworkCallbacks need Android N+.", new Object[0]);
                return;
            }
            InterfaceC3102d0 interfaceC3102d0A = this.c.a();
            try {
                this.e = new b(z, this.b, c3155n3.getDateProvider());
                if (io.sentry.android.core.internal.util.f.P(this.a, c3155n3.getLogger(), this.b, this.e)) {
                    c3155n3.getLogger().c(y2, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
                    io.sentry.util.o.a("NetworkBreadcrumbs");
                } else {
                    c3155n3.getLogger().c(y2, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
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
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            b bVar = this.e;
            this.e = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            if (bVar != null) {
                io.sentry.android.core.internal.util.f.B0(bVar);
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
}
