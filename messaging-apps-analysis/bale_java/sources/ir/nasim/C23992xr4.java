package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.xr4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23992xr4 {
    private static C23992xr4 e;
    private final Handler a = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private final Object c = new Object();
    private int d = 0;

    /* renamed from: ir.nasim.xr4$b */
    private static final class b {

        /* renamed from: ir.nasim.xr4$b$a */
        private static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
            private final C23992xr4 b;

            public a(C23992xr4 c23992xr4) {
                this.b = c23992xr4;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.b.k(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, C23992xr4 c23992xr4) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) AbstractC20011rK.e((TelephonyManager) context.getSystemService("phone"));
                a aVar = new a(c23992xr4);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                c23992xr4.k(5);
            }
        }
    }

    /* renamed from: ir.nasim.xr4$c */
    public interface c {
        void a(int i);
    }

    /* renamed from: ir.nasim.xr4$d */
    private final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iG = C23992xr4.g(context);
            if (AbstractC9683aN7.a < 31 || iG != 5) {
                C23992xr4.this.k(iG);
            } else {
                b.a(context, C23992xr4.this);
            }
        }
    }

    private C23992xr4(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        AbstractC9683aN7.L0(context, new d(), intentFilter);
    }

    public static synchronized C23992xr4 d(Context context) {
        try {
            if (e == null) {
                e = new C23992xr4(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    private static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return AbstractC9683aN7.a >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        cVar.a(f());
    }

    private void j() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.b.remove(weakReference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        synchronized (this.c) {
            try {
                if (this.d == i) {
                    return;
                }
                this.d = i;
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    c cVar = (c) weakReference.get();
                    if (cVar != null) {
                        cVar.a(i);
                    } else {
                        this.b.remove(weakReference);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int f() {
        int i;
        synchronized (this.c) {
            i = this.d;
        }
        return i;
    }

    public void i(final c cVar) {
        j();
        this.b.add(new WeakReference(cVar));
        this.a.post(new Runnable() { // from class: ir.nasim.wr4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(cVar);
            }
        });
    }
}
