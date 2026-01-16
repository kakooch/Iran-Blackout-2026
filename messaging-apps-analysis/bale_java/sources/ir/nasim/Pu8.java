package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class Pu8 {
    protected final C16237kv8 a;
    private final IntentFilter b;
    private final Context c;
    protected final Set d = new HashSet();
    private Fu8 e = null;
    private volatile boolean f = false;

    protected Pu8(C16237kv8 c16237kv8, IntentFilter intentFilter, Context context) {
        this.a = c16237kv8;
        this.b = intentFilter;
        this.c = AbstractC16718lk8.a(context);
    }

    private final void d() {
        Fu8 fu8;
        if ((this.f || !this.d.isEmpty()) && this.e == null) {
            Fu8 fu82 = new Fu8(this, null);
            this.e = fu82;
            if (Build.VERSION.SDK_INT >= 33) {
                this.c.registerReceiver(fu82, this.b, 2);
            }
            this.c.registerReceiver(this.e, this.b);
        }
        if (this.f || !this.d.isEmpty() || (fu8 = this.e) == null) {
            return;
        }
        this.c.unregisterReceiver(fu8);
        this.e = null;
    }

    protected abstract void a(Context context, Intent intent);

    public final synchronized void b(boolean z) {
        this.f = true;
        d();
    }

    public final synchronized void c(Object obj) {
        Iterator it = new HashSet(this.d).iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }
}
