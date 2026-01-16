package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes3.dex */
public abstract class Yu8 {
    private final Context a;
    private final String c;
    private final String d;
    private final String e;
    private Object h;
    private final Object b = new Object();
    private boolean f = false;
    private boolean g = false;

    public Yu8(Context context, String str, String str2) {
        this.a = context;
        this.c = str;
        String strValueOf = String.valueOf(str2);
        this.d = strValueOf.length() != 0 ? "com.google.android.gms.vision.dynamite.".concat(strValueOf) : new String("com.google.android.gms.vision.dynamite.");
        this.e = str2;
    }

    protected abstract Object a(DynamiteModule dynamiteModule, Context context);

    protected abstract void b();

    public final boolean c() {
        return e() != null;
    }

    public final void d() {
        synchronized (this.b) {
            if (this.h == null) {
                return;
            }
            try {
                b();
            } catch (RemoteException e) {
                Log.e(this.c, "Could not finalize native handle", e);
            }
        }
    }

    protected final Object e() {
        DynamiteModule dynamiteModuleE;
        synchronized (this.b) {
            Object obj = this.h;
            if (obj != null) {
                return obj;
            }
            try {
                dynamiteModuleE = DynamiteModule.e(this.a, DynamiteModule.g, this.d);
            } catch (DynamiteModule.LoadingException unused) {
                String str = String.format("%s.%s", "com.google.android.gms.vision", this.e);
                AbstractC5985Lr3.a("Cannot load thick client module, fall back to load optional module %s", str);
                try {
                    dynamiteModuleE = DynamiteModule.e(this.a, DynamiteModule.b, str);
                } catch (DynamiteModule.LoadingException e) {
                    AbstractC5985Lr3.c(e, "Error loading optional module %s", str);
                    if (!this.f) {
                        AbstractC5985Lr3.a("Broadcasting download intent for dependency %s", this.e);
                        String str2 = this.e;
                        Intent intent = new Intent();
                        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str2);
                        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                        this.a.sendBroadcast(intent);
                        this.f = true;
                    }
                    dynamiteModuleE = null;
                }
            }
            if (dynamiteModuleE != null) {
                try {
                    this.h = a(dynamiteModuleE, this.a);
                } catch (RemoteException | DynamiteModule.LoadingException e2) {
                    Log.e(this.c, "Error creating remote native handle", e2);
                }
            }
            boolean z = this.g;
            if (!z && this.h == null) {
                Log.w(this.c, "Native handle not yet available. Reverting to no-op handle.");
                this.g = true;
            } else if (z && this.h != null) {
                Log.w(this.c, "Native handle is now available.");
            }
            return this.h;
        }
    }
}
