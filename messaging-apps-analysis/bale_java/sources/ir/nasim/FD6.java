package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import ir.nasim.InterfaceC4439Fd1;
import ir.nasim.WI2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class FD6 {
    private static volatile FD6 d;
    private final c a;
    final Set b = new HashSet();
    private boolean c;

    class a implements WI2.b {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.WI2.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.a.getSystemService("connectivity");
        }
    }

    class b implements InterfaceC4439Fd1.a {
        b() {
        }

        @Override // ir.nasim.InterfaceC4439Fd1.a
        public void a(boolean z) {
            ArrayList arrayList;
            YM7.b();
            synchronized (FD6.this) {
                arrayList = new ArrayList(FD6.this.b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC4439Fd1.a) it.next()).a(z);
            }
        }
    }

    private interface c {
        void a();

        boolean b();
    }

    private static final class d implements c {
        boolean a;
        final InterfaceC4439Fd1.a b;
        private final WI2.b c;
        private final ConnectivityManager.NetworkCallback d = new a();

        class a extends ConnectivityManager.NetworkCallback {

            /* renamed from: ir.nasim.FD6$d$a$a, reason: collision with other inner class name */
            class RunnableC0357a implements Runnable {
                final /* synthetic */ boolean a;

                RunnableC0357a(boolean z) {
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.a);
                }
            }

            a() {
            }

            private void b(boolean z) {
                YM7.w(new RunnableC0357a(z));
            }

            void a(boolean z) {
                YM7.b();
                d dVar = d.this;
                boolean z2 = dVar.a;
                dVar.a = z;
                if (z2 != z) {
                    dVar.b.a(z);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                b(false);
            }
        }

        d(WI2.b bVar, InterfaceC4439Fd1.a aVar) {
            this.c = bVar;
            this.b = aVar;
        }

        @Override // ir.nasim.FD6.c
        public void a() {
            ((ConnectivityManager) this.c.get()).unregisterNetworkCallback(this.d);
        }

        @Override // ir.nasim.FD6.c
        public boolean b() {
            this.a = ((ConnectivityManager) this.c.get()).getActiveNetwork() != null;
            try {
                ((ConnectivityManager) this.c.get()).registerDefaultNetworkCallback(this.d);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    private FD6(Context context) {
        this.a = new d(WI2.a(new a(context)), new b());
    }

    static FD6 a(Context context) {
        if (d == null) {
            synchronized (FD6.class) {
                try {
                    if (d == null) {
                        d = new FD6(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private void b() {
        if (this.c || this.b.isEmpty()) {
            return;
        }
        this.c = this.a.b();
    }

    private void c() {
        if (this.c && this.b.isEmpty()) {
            this.a.a();
            this.c = false;
        }
    }

    synchronized void d(InterfaceC4439Fd1.a aVar) {
        this.b.add(aVar);
        b();
    }

    synchronized void e(InterfaceC4439Fd1.a aVar) {
        this.b.remove(aVar);
        c();
    }
}
