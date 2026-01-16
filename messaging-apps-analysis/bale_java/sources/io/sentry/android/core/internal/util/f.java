package io.sentry.android.core.internal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.N;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.android.core.X;
import io.sentry.android.core.Y;
import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class f implements N, X.a {
    private static volatile ConnectivityManager m;
    private final Context a;
    private final C3155n3 b;
    private final Y c;
    private final io.sentry.transport.p d;
    private volatile ConnectivityManager.NetworkCallback g;
    private volatile NetworkCapabilities h;
    private volatile Network i;
    private static final C3202a l = new C3202a();
    private static final C3202a n = new C3202a();
    private static final List o = new ArrayList();
    private static final int[] p = {1, 0, 3, 2};
    private static final int[] q = new int[2];
    private final C3202a f = new C3202a();
    private volatile long j = 0;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private final List e = new ArrayList();

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        private void a() {
            f.this.k.set(false);
            InterfaceC3102d0 interfaceC3102d0A = f.this.f.a();
            try {
                f.this.h = null;
                f.this.i = null;
                f fVar = f.this;
                fVar.j = fVar.d.a();
                f.this.b.getLogger().c(Y2.DEBUG, "Cache cleared - network lost/unavailable", new Object[0]);
                Iterator it = f.this.e.iterator();
                while (it.hasNext()) {
                    ((N.b) it.next()).b(N.a.DISCONNECTED);
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

        private boolean b(NetworkCapabilities networkCapabilities, NetworkCapabilities networkCapabilities2) {
            for (int i : f.q) {
                if (i != 0 && networkCapabilities.hasCapability(i) != networkCapabilities2.hasCapability(i)) {
                    return true;
                }
            }
            return false;
        }

        private boolean c(NetworkCapabilities networkCapabilities, NetworkCapabilities networkCapabilities2) {
            for (int i : f.p) {
                if (networkCapabilities.hasTransport(i) != networkCapabilities2.hasTransport(i)) {
                    return true;
                }
            }
            return false;
        }

        private boolean d(NetworkCapabilities networkCapabilities) {
            NetworkCapabilities networkCapabilities2 = f.this.h;
            if ((networkCapabilities2 == null) != (networkCapabilities == null)) {
                return true;
            }
            if (networkCapabilities2 == null && networkCapabilities == null) {
                return false;
            }
            return b(networkCapabilities2, networkCapabilities) || c(networkCapabilities2, networkCapabilities);
        }

        private void e(Network network, NetworkCapabilities networkCapabilities) {
            if (d(networkCapabilities)) {
                f.this.I0(networkCapabilities);
                N.a aVarU = f.this.U();
                InterfaceC3102d0 interfaceC3102d0A = f.this.f.a();
                try {
                    Iterator it = f.this.e.iterator();
                    while (it.hasNext()) {
                        ((N.b) it.next()).b(aVarU);
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

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            f.this.i = network;
            if (f.this.k.getAndSet(true)) {
                return;
            }
            InterfaceC3102d0 interfaceC3102d0A = f.n.a();
            try {
                Iterator it = f.o.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onAvailable(network);
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

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network.equals(f.this.i)) {
                e(network, networkCapabilities);
                InterfaceC3102d0 interfaceC3102d0A = f.n.a();
                try {
                    Iterator it = f.o.iterator();
                    while (it.hasNext()) {
                        ((ConnectivityManager.NetworkCallback) it.next()).onCapabilitiesChanged(network, networkCapabilities);
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

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (network.equals(f.this.i)) {
                a();
                InterfaceC3102d0 interfaceC3102d0A = f.n.a();
                try {
                    Iterator it = f.o.iterator();
                    while (it.hasNext()) {
                        ((ConnectivityManager.NetworkCallback) it.next()).onLost(network);
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

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            a();
            InterfaceC3102d0 interfaceC3102d0A = f.n.a();
            try {
                Iterator it = f.o.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onUnavailable();
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

    public f(Context context, C3155n3 c3155n3, Y y, io.sentry.transport.p pVar) {
        this.a = AbstractC3060k0.g(context);
        this.b = c3155n3;
        this.c = y;
        this.d = pVar;
        int[] iArr = q;
        iArr[0] = 12;
        if (y.d() >= 23) {
            iArr[1] = 16;
        }
        C0(new Runnable() { // from class: io.sentry.android.core.internal.util.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s0();
            }
        });
        X.j().d(this);
    }

    static boolean A0(Context context, ILogger iLogger, Y y, ConnectivityManager.NetworkCallback networkCallback) {
        if (y.d() < 24) {
            iLogger.c(Y2.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager connectivityManagerE0 = e0(context, iLogger);
        if (connectivityManagerE0 == null) {
            return false;
        }
        if (!r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.c(Y2.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            connectivityManagerE0.registerDefaultNetworkCallback(networkCallback);
            return true;
        } catch (Throwable th) {
            iLogger.b(Y2.WARNING, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    public static void B0(ConnectivityManager.NetworkCallback networkCallback) {
        InterfaceC3102d0 interfaceC3102d0A = n.a();
        try {
            o.remove(networkCallback);
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

    private void C0(Runnable runnable) {
        try {
            this.b.getExecutorService().submit(runnable);
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "AndroidConnectionStatusProvider submit failed", th);
        }
    }

    static void D0(Context context, ILogger iLogger, ConnectivityManager.NetworkCallback networkCallback) {
        ConnectivityManager connectivityManagerE0 = e0(context, iLogger);
        if (connectivityManagerE0 == null) {
            return;
        }
        try {
            connectivityManagerE0.unregisterNetworkCallback(networkCallback);
        } catch (Throwable th) {
            iLogger.b(Y2.WARNING, "unregisterNetworkCallback failed", th);
        }
    }

    private void F0(boolean z) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        if (z) {
            try {
                this.e.clear();
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
        ConnectivityManager.NetworkCallback networkCallback = this.g;
        this.g = null;
        if (networkCallback != null) {
            D0(this.a, this.b.getLogger(), networkCallback);
        }
        this.h = null;
        this.i = null;
        this.j = 0L;
        if (interfaceC3102d0A != null) {
            interfaceC3102d0A.close();
        }
        this.b.getLogger().c(Y2.DEBUG, "Network callback unregistered", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(NetworkCapabilities networkCapabilities) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            if (networkCapabilities != null) {
                this.h = networkCapabilities;
            } else {
                if (!r.a(this.a, "android.permission.ACCESS_NETWORK_STATE")) {
                    this.b.getLogger().c(Y2.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
                    this.h = null;
                    this.j = this.d.a();
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                        return;
                    }
                    return;
                }
                if (this.c.d() < 23) {
                    this.h = null;
                    this.j = this.d.a();
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                        return;
                    }
                    return;
                }
                ConnectivityManager connectivityManagerE0 = e0(this.a, this.b.getLogger());
                if (connectivityManagerE0 != null) {
                    Network activeNetwork = connectivityManagerE0.getActiveNetwork();
                    this.h = activeNetwork != null ? connectivityManagerE0.getNetworkCapabilities(activeNetwork) : null;
                } else {
                    this.h = null;
                }
            }
            this.j = this.d.a();
            this.b.getLogger().c(Y2.DEBUG, "Cache updated - Status: " + U() + ", Type: " + d0(), new Object[0]);
        } catch (Throwable th) {
            try {
                this.b.getLogger().b(Y2.WARNING, "Failed to update connection status cache", th);
                this.h = null;
                this.j = this.d.a();
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
        if (interfaceC3102d0A != null) {
            interfaceC3102d0A.close();
        }
    }

    public static boolean P(Context context, ILogger iLogger, Y y, ConnectivityManager.NetworkCallback networkCallback) {
        if (y.d() < 24) {
            iLogger.c(Y2.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        if (!r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.c(Y2.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        InterfaceC3102d0 interfaceC3102d0A = n.a();
        try {
            o.add(networkCallback);
            if (interfaceC3102d0A == null) {
                return true;
            }
            interfaceC3102d0A.close();
            return true;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void s0() {
        if (AbstractC3060k0.s() && this.g == null) {
            InterfaceC3102d0 interfaceC3102d0A = this.f.a();
            try {
                if (this.g != null) {
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                        return;
                    }
                    return;
                }
                a aVar = new a();
                if (A0(this.a, this.b.getLogger(), this.c, aVar)) {
                    this.g = aVar;
                    this.b.getLogger().c(Y2.DEBUG, "Network callback registered successfully", new Object[0]);
                } else {
                    this.b.getLogger().c(Y2.WARNING, "Failed to register network callback", new Object[0]);
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

    private static N.a T(Context context, ConnectivityManager connectivityManager, ILogger iLogger) {
        if (!r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.c(Y2.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return N.a.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() ? N.a.CONNECTED : N.a.DISCONNECTED;
            }
            iLogger.c(Y2.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return N.a.DISCONNECTED;
        } catch (Throwable th) {
            iLogger.b(Y2.WARNING, "Could not retrieve Connection Status", th);
            return N.a.UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public N.a U() {
        if (this.h != null) {
            return k0(this.h) ? N.a.CONNECTED : N.a.DISCONNECTED;
        }
        ConnectivityManager connectivityManagerE0 = e0(this.a, this.b.getLogger());
        return connectivityManagerE0 != null ? T(this.a, connectivityManagerE0, this.b.getLogger()) : N.a.UNKNOWN;
    }

    public static String X(Context context, ILogger iLogger, Y y) {
        boolean zHasTransport;
        boolean zHasTransport2;
        ConnectivityManager connectivityManagerE0 = e0(context, iLogger);
        if (connectivityManagerE0 == null) {
            return null;
        }
        boolean z = false;
        if (!r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.c(Y2.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        try {
            zHasTransport = true;
            if (y.d() >= 23) {
                Network activeNetwork = connectivityManagerE0.getActiveNetwork();
                if (activeNetwork == null) {
                    iLogger.c(Y2.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities = connectivityManagerE0.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    iLogger.c(Y2.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean zHasTransport3 = networkCapabilities.hasTransport(3);
                zHasTransport2 = networkCapabilities.hasTransport(1);
                zHasTransport = networkCapabilities.hasTransport(0);
                z = zHasTransport3;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManagerE0.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    iLogger.c(Y2.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                    return null;
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    zHasTransport2 = false;
                } else if (type != 1) {
                    if (type != 9) {
                        zHasTransport2 = false;
                    } else {
                        zHasTransport2 = false;
                        z = true;
                    }
                    zHasTransport = zHasTransport2;
                } else {
                    zHasTransport2 = true;
                    zHasTransport = false;
                }
            }
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "Failed to retrieve network info", th);
        }
        if (z) {
            return "ethernet";
        }
        if (zHasTransport2) {
            return "wifi";
        }
        if (zHasTransport) {
            return "cellular";
        }
        return null;
    }

    public static String Z(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }

    private String d0() {
        NetworkCapabilities networkCapabilities = this.h;
        return networkCapabilities != null ? Z(networkCapabilities) : X(this.a, this.b.getLogger(), this.c);
    }

    private static ConnectivityManager e0(Context context, ILogger iLogger) {
        if (m != null) {
            return m;
        }
        InterfaceC3102d0 interfaceC3102d0A = l.a();
        try {
            if (m != null) {
                ConnectivityManager connectivityManager = m;
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return connectivityManager;
            }
            m = (ConnectivityManager) context.getSystemService("connectivity");
            if (m == null) {
                iLogger.c(Y2.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
            }
            ConnectivityManager connectivityManager2 = m;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return connectivityManager2;
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

    private boolean f0() {
        return this.d.a() - this.j < 120000;
    }

    private boolean k0(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        boolean zHasCapability = networkCapabilities.hasCapability(12);
        if (this.c.d() >= 23) {
            zHasCapability = zHasCapability && networkCapabilities.hasCapability(16);
        }
        if (!zHasCapability) {
            return false;
        }
        for (int i : p) {
            if (networkCapabilities.hasTransport(i)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        F0(true);
        InterfaceC3102d0 interfaceC3102d0A = n.a();
        try {
            o.clear();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            interfaceC3102d0A = l.a();
            try {
                m = null;
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                X.j().p(this);
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0() {
        F0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        InterfaceC3102d0 interfaceC3102d0A;
        I0(null);
        N.a aVarU = U();
        if (aVarU == N.a.DISCONNECTED) {
            this.k.set(false);
            interfaceC3102d0A = n.a();
            try {
                Iterator it = o.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onLost(null);
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } finally {
            }
        }
        interfaceC3102d0A = this.f.a();
        try {
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                ((N.b) it2.next()).b(aVarU);
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            s0();
        } finally {
        }
    }

    @Override // io.sentry.N
    public void L1(N.b bVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            this.e.remove(bVar);
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

    @Override // io.sentry.N
    public String W() {
        if (!f0()) {
            I0(null);
        }
        return d0();
    }

    @Override // io.sentry.android.core.X.a
    public void a() {
        if (this.g != null) {
            return;
        }
        C0(new Runnable() { // from class: io.sentry.android.core.internal.util.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z0();
            }
        });
    }

    @Override // io.sentry.android.core.X.a
    public void b() {
        if (this.g == null) {
            return;
        }
        C0(new Runnable() { // from class: io.sentry.android.core.internal.util.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x0();
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C0(new Runnable() { // from class: io.sentry.android.core.internal.util.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m0();
            }
        });
    }

    @Override // io.sentry.N
    public boolean v1(N.b bVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            this.e.add(bVar);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            s0();
            return this.g != null;
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

    @Override // io.sentry.N
    public N.a w0() {
        if (!f0()) {
            I0(null);
        }
        return U();
    }
}
