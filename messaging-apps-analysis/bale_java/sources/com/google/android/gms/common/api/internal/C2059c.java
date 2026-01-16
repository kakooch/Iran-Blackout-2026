package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC16717lk7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20013rK1;
import ir.nasim.C13104ff8;
import ir.nasim.C13695gf8;
import ir.nasim.C46;
import ir.nasim.C4982Hj7;
import ir.nasim.C9205Yy;
import ir.nasim.If8;
import ir.nasim.InterfaceC17308mk7;
import ir.nasim.InterfaceC21248tM6;
import ir.nasim.PJ;
import ir.nasim.Vf8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.api.internal.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2059c implements Handler.Callback {
    public static final Status r = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status s = new Status(4, "The user must be signed in to make this API call.");
    private static final Object t = new Object();
    private static C2059c u;
    private TelemetryData e;
    private InterfaceC17308mk7 f;
    private final Context g;
    private final com.google.android.gms.common.a h;
    private final If8 i;
    private final Handler p;
    private volatile boolean q;
    private long a = 5000;
    private long b = 120000;
    private long c = 10000;
    private boolean d = false;
    private final AtomicInteger j = new AtomicInteger(1);
    private final AtomicInteger k = new AtomicInteger(0);
    private final Map l = new ConcurrentHashMap(5, 0.75f, 1);
    private C2069m m = null;
    private final Set n = new PJ();
    private final Set o = new PJ();

    private C2059c(Context context, Looper looper, com.google.android.gms.common.a aVar) {
        this.q = true;
        this.g = context;
        Vf8 vf8 = new Vf8(looper, this);
        this.p = vf8;
        this.h = aVar;
        this.i = new If8(aVar);
        if (AbstractC20013rK1.a(context)) {
            this.q = false;
        }
        vf8.sendMessage(vf8.obtainMessage(6));
    }

    public static void a() {
        synchronized (t) {
            try {
                C2059c c2059c = u;
                if (c2059c != null) {
                    c2059c.k.incrementAndGet();
                    Handler handler = c2059c.p;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status i(C9205Yy c9205Yy, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + c9205Yy.b() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    private final s j(com.google.android.gms.common.api.b bVar) {
        C9205Yy c9205YyQ = bVar.q();
        s sVar = (s) this.l.get(c9205YyQ);
        if (sVar == null) {
            sVar = new s(this, bVar);
            this.l.put(c9205YyQ, sVar);
        }
        if (sVar.I()) {
            this.o.add(c9205YyQ);
        }
        sVar.A();
        return sVar;
    }

    private final InterfaceC17308mk7 k() {
        if (this.f == null) {
            this.f = AbstractC16717lk7.a(this.g);
        }
        return this.f;
    }

    private final void l() {
        TelemetryData telemetryData = this.e;
        if (telemetryData != null) {
            if (telemetryData.P() > 0 || g()) {
                k().a(telemetryData);
            }
            this.e = null;
        }
    }

    private final void m(C4982Hj7 c4982Hj7, int i, com.google.android.gms.common.api.b bVar) {
        x xVarA;
        if (i == 0 || (xVarA = x.a(this, i, bVar.q())) == null) {
            return;
        }
        Task taskA = c4982Hj7.a();
        final Handler handler = this.p;
        handler.getClass();
        taskA.c(new Executor() { // from class: ir.nasim.Ve8
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, xVarA);
    }

    public static C2059c y(Context context) {
        C2059c c2059c;
        synchronized (t) {
            try {
                if (u == null) {
                    u = new C2059c(context.getApplicationContext(), com.google.android.gms.common.internal.d.b().getLooper(), com.google.android.gms.common.a.m());
                }
                c2059c = u;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2059c;
    }

    public final Task A(com.google.android.gms.common.api.b bVar, AbstractC2062f abstractC2062f, AbstractC2065i abstractC2065i, Runnable runnable) {
        C4982Hj7 c4982Hj7 = new C4982Hj7();
        m(c4982Hj7, abstractC2062f.e(), bVar);
        E e = new E(new C13695gf8(abstractC2062f, abstractC2065i, runnable), c4982Hj7);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(8, new C13104ff8(e, this.k.get(), bVar)));
        return c4982Hj7.a();
    }

    public final Task B(com.google.android.gms.common.api.b bVar, C2060d.a aVar, int i) {
        C4982Hj7 c4982Hj7 = new C4982Hj7();
        m(c4982Hj7, i, bVar);
        G g = new G(aVar, c4982Hj7);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(13, new C13104ff8(g, this.k.get(), bVar)));
        return c4982Hj7.a();
    }

    public final void G(com.google.android.gms.common.api.b bVar, int i, AbstractC2058b abstractC2058b) {
        D d = new D(i, abstractC2058b);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(4, new C13104ff8(d, this.k.get(), bVar)));
    }

    public final void H(com.google.android.gms.common.api.b bVar, int i, AbstractC2064h abstractC2064h, C4982Hj7 c4982Hj7, InterfaceC21248tM6 interfaceC21248tM6) {
        m(c4982Hj7, abstractC2064h.d(), bVar);
        F f = new F(i, abstractC2064h, c4982Hj7, interfaceC21248tM6);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(4, new C13104ff8(f, this.k.get(), bVar)));
    }

    final void I(MethodInvocation methodInvocation, int i, long j, int i2) {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(18, new y(methodInvocation, i, j, i2)));
    }

    public final void J(ConnectionResult connectionResult, int i) {
        if (h(connectionResult, i)) {
            return;
        }
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void b() {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void c(com.google.android.gms.common.api.b bVar) {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(7, bVar));
    }

    public final void d(C2069m c2069m) {
        synchronized (t) {
            try {
                if (this.m != c2069m) {
                    this.m = c2069m;
                    this.n.clear();
                }
                this.n.addAll(c2069m.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final void e(C2069m c2069m) {
        synchronized (t) {
            try {
                if (this.m == c2069m) {
                    this.m = null;
                    this.n.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final boolean g() {
        if (this.d) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = C46.b().a();
        if (rootTelemetryConfigurationA != null && !rootTelemetryConfigurationA.d0()) {
            return false;
        }
        int iA = this.i.a(this.g, 203400000);
        return iA == -1 || iA == 0;
    }

    final boolean h(ConnectionResult connectionResult, int i) {
        return this.h.w(this.g, connectionResult, i);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        s sVar = null;
        switch (i) {
            case 1:
                this.c = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.p.removeMessages(12);
                for (C9205Yy c9205Yy : this.l.keySet()) {
                    Handler handler = this.p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c9205Yy), this.c);
                }
                return true;
            case 2:
                AbstractC18350oW3.a(message.obj);
                throw null;
            case 3:
                for (s sVar2 : this.l.values()) {
                    sVar2.z();
                    sVar2.A();
                }
                return true;
            case 4:
            case 8:
            case 13:
                C13104ff8 c13104ff8 = (C13104ff8) message.obj;
                s sVarJ = (s) this.l.get(c13104ff8.c.q());
                if (sVarJ == null) {
                    sVarJ = j(c13104ff8.c);
                }
                if (!sVarJ.I() || this.k.get() == c13104ff8.b) {
                    sVarJ.B(c13104ff8.a);
                } else {
                    c13104ff8.a.a(r);
                    sVarJ.G();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it = this.l.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        s sVar3 = (s) it.next();
                        if (sVar3.o() == i2) {
                            sVar = sVar3;
                        }
                    }
                }
                if (sVar == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.P() == 13) {
                    sVar.d(new Status(17, "Error resolution was canceled by the user, original error message: " + this.h.e(connectionResult.P()) + ": " + connectionResult.S()));
                } else {
                    sVar.d(i(sVar.i, connectionResult));
                }
                return true;
            case 6:
                if (this.g.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C2057a.c((Application) this.g.getApplicationContext());
                    ComponentCallbacks2C2057a.b().a(new n(this));
                    if (!ComponentCallbacks2C2057a.b().e(true)) {
                        this.c = 300000L;
                    }
                }
                return true;
            case 7:
                j((com.google.android.gms.common.api.b) message.obj);
                return true;
            case 9:
                if (this.l.containsKey(message.obj)) {
                    ((s) this.l.get(message.obj)).F();
                }
                return true;
            case 10:
                Iterator it2 = this.o.iterator();
                while (it2.hasNext()) {
                    s sVar4 = (s) this.l.remove((C9205Yy) it2.next());
                    if (sVar4 != null) {
                        sVar4.G();
                    }
                }
                this.o.clear();
                return true;
            case 11:
                if (this.l.containsKey(message.obj)) {
                    ((s) this.l.get(message.obj)).H();
                }
                return true;
            case 12:
                if (this.l.containsKey(message.obj)) {
                    ((s) this.l.get(message.obj)).a();
                }
                return true;
            case 14:
                AbstractC18350oW3.a(message.obj);
                throw null;
            case 15:
                t tVar = (t) message.obj;
                if (this.l.containsKey(tVar.a)) {
                    s.x((s) this.l.get(tVar.a), tVar);
                }
                return true;
            case 16:
                t tVar2 = (t) message.obj;
                if (this.l.containsKey(tVar2.a)) {
                    s.y((s) this.l.get(tVar2.a), tVar2);
                }
                return true;
            case 17:
                l();
                return true;
            case 18:
                y yVar = (y) message.obj;
                if (yVar.c == 0) {
                    k().a(new TelemetryData(yVar.b, Arrays.asList(yVar.a)));
                } else {
                    TelemetryData telemetryData = this.e;
                    if (telemetryData != null) {
                        List listS = telemetryData.S();
                        if (telemetryData.P() != yVar.b || (listS != null && listS.size() >= yVar.d)) {
                            this.p.removeMessages(17);
                            l();
                        } else {
                            this.e.d0(yVar.a);
                        }
                    }
                    if (this.e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(yVar.a);
                        this.e = new TelemetryData(yVar.b, arrayList);
                        Handler handler2 = this.p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), yVar.c);
                    }
                }
                return true;
            case 19:
                this.d = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    public final int n() {
        return this.j.getAndIncrement();
    }

    final s x(C9205Yy c9205Yy) {
        return (s) this.l.get(c9205Yy);
    }
}
