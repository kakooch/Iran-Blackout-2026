package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Ad1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3264Ad1 {
    private static final Object b = new Object();
    private static volatile C3264Ad1 c;
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    private C3264Ad1() {
    }

    public static C3264Ad1 b() {
        if (c == null) {
            synchronized (b) {
                try {
                    if (c == null) {
                        c = new C3264Ad1();
                    }
                } finally {
                }
            }
        }
        C3264Ad1 c3264Ad1 = c;
        AbstractC3795Cj5.j(c3264Ad1);
        return c3264Ad1;
    }

    private static void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Fb8.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!g(serviceConnection)) {
            return h(context, intent, serviceConnection, i, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zH = h(context, intent, serviceConnection, i, executor);
            if (zH) {
                return zH;
            }
            return false;
        } finally {
            this.a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean g(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof Uu8);
    }

    private static final boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!AbstractC3993Df5.j() || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return f(context, context.getClass().getName(), intent, serviceConnection, i, true, null);
    }

    public void c(Context context, ServiceConnection serviceConnection) {
        if (!g(serviceConnection) || !this.a.containsKey(serviceConnection)) {
            e(context, serviceConnection);
            return;
        }
        try {
            e(context, (ServiceConnection) this.a.get(serviceConnection));
        } finally {
            this.a.remove(serviceConnection);
        }
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        return f(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
