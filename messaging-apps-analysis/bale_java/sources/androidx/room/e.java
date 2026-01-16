package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.b;
import androidx.room.c;
import androidx.room.d;
import androidx.room.e;
import ir.nasim.AbstractC13042fc3;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class e {
    private final String a;
    private final d b;
    private final Executor c;
    private final Context d;
    private int e;
    public d.c f;
    private androidx.room.c g;
    private final androidx.room.b h;
    private final AtomicBoolean i;
    private final ServiceConnection j;
    private final Runnable k;
    private final Runnable l;

    public static final class a extends d.c {
        a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.d.c
        public boolean b() {
            return true;
        }

        @Override // androidx.room.d.c
        public void c(Set set) {
            AbstractC13042fc3.i(set, "tables");
            if (e.this.j().get()) {
                return;
            }
            try {
                androidx.room.c cVarH = e.this.h();
                if (cVarH != null) {
                    cVarH.V0(e.this.c(), (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot broadcast invalidation", e);
            }
        }
    }

    public static final class b extends b.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D2(e eVar, String[] strArr) {
            AbstractC13042fc3.i(eVar, "this$0");
            AbstractC13042fc3.i(strArr, "$tables");
            eVar.e().l((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @Override // androidx.room.b
        public void Q(final String[] strArr) {
            AbstractC13042fc3.i(strArr, "tables");
            Executor executorD = e.this.d();
            final e eVar = e.this;
            executorD.execute(new Runnable() { // from class: ir.nasim.vl4
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.D2(eVar, strArr);
                }
            });
        }
    }

    public static final class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AbstractC13042fc3.i(componentName, "name");
            AbstractC13042fc3.i(iBinder, ReferencesHeader.SERVICE);
            e.this.m(c.a.B2(iBinder));
            e.this.d().execute(e.this.i());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC13042fc3.i(componentName, "name");
            e.this.d().execute(e.this.g());
            e.this.m(null);
        }
    }

    public e(Context context, String str, Intent intent, d dVar, Executor executor) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(intent, "serviceIntent");
        AbstractC13042fc3.i(dVar, "invalidationTracker");
        AbstractC13042fc3.i(executor, "executor");
        this.a = str;
        this.b = dVar;
        this.c = executor;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        this.h = new b();
        this.i = new AtomicBoolean(false);
        c cVar = new c();
        this.j = cVar;
        this.k = new Runnable() { // from class: ir.nasim.tl4
            @Override // java.lang.Runnable
            public final void run() {
                androidx.room.e.n(this.a);
            }
        };
        this.l = new Runnable() { // from class: ir.nasim.ul4
            @Override // java.lang.Runnable
            public final void run() {
                androidx.room.e.k(this.a);
            }
        };
        l(new a((String[]) dVar.j().keySet().toArray(new String[0])));
        applicationContext.bindService(intent, cVar, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e eVar) {
        AbstractC13042fc3.i(eVar, "this$0");
        eVar.b.p(eVar.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(e eVar) {
        AbstractC13042fc3.i(eVar, "this$0");
        try {
            androidx.room.c cVar = eVar.g;
            if (cVar != null) {
                eVar.e = cVar.z1(eVar.h, eVar.a);
                eVar.b.c(eVar.f());
            }
        } catch (RemoteException e) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
        }
    }

    public final int c() {
        return this.e;
    }

    public final Executor d() {
        return this.c;
    }

    public final d e() {
        return this.b;
    }

    public final d.c f() {
        d.c cVar = this.f;
        if (cVar != null) {
            return cVar;
        }
        AbstractC13042fc3.y("observer");
        return null;
    }

    public final Runnable g() {
        return this.l;
    }

    public final androidx.room.c h() {
        return this.g;
    }

    public final Runnable i() {
        return this.k;
    }

    public final AtomicBoolean j() {
        return this.i;
    }

    public final void l(d.c cVar) {
        AbstractC13042fc3.i(cVar, "<set-?>");
        this.f = cVar;
    }

    public final void m(androidx.room.c cVar) {
        this.g = cVar;
    }

    public final void o() {
        if (this.i.compareAndSet(false, true)) {
            this.b.p(f());
            try {
                androidx.room.c cVar = this.g;
                if (cVar != null) {
                    cVar.x2(this.h, this.e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            this.d.unbindService(this.j);
        }
    }
}
