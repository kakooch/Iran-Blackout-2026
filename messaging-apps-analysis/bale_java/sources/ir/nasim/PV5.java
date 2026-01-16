package ir.nasim;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class PV5 {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());
    private final Set b = new HashSet();
    private boolean c;

    public boolean a(RP5 rp5) {
        boolean z = true;
        if (rp5 == null) {
            return true;
        }
        boolean zRemove = this.a.remove(rp5);
        if (!this.b.remove(rp5) && !zRemove) {
            z = false;
        }
        if (z) {
            rp5.clear();
        }
        return z;
    }

    public void b() {
        Iterator it = YM7.k(this.a).iterator();
        while (it.hasNext()) {
            a((RP5) it.next());
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        for (RP5 rp5 : YM7.k(this.a)) {
            if (rp5.isRunning() || rp5.g()) {
                rp5.clear();
                this.b.add(rp5);
            }
        }
    }

    public void d() {
        this.c = true;
        for (RP5 rp5 : YM7.k(this.a)) {
            if (rp5.isRunning()) {
                rp5.h();
                this.b.add(rp5);
            }
        }
    }

    public void e() {
        for (RP5 rp5 : YM7.k(this.a)) {
            if (!rp5.g() && !rp5.e()) {
                rp5.clear();
                if (this.c) {
                    this.b.add(rp5);
                } else {
                    rp5.i();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (RP5 rp5 : YM7.k(this.a)) {
            if (!rp5.g() && !rp5.isRunning()) {
                rp5.i();
            }
        }
        this.b.clear();
    }

    public void g(RP5 rp5) {
        this.a.add(rp5);
        if (!this.c) {
            rp5.i();
            return;
        }
        rp5.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(rp5);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
