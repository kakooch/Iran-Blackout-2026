package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xh implements Handler.Callback {
    private final xf a;
    private xj e;
    private long f;
    private boolean i;
    private boolean j;
    private final acc k;
    private final TreeMap<Long, Long> d = new TreeMap<>();
    private final Handler c = aeu.l(this);
    private final rd b = new rd();
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;

    public xh(xj xjVar, xf xfVar, acc accVar) {
        this.e = xjVar;
        this.a = xfVar;
        this.k = accVar;
    }

    private final void i() {
        long j = this.h;
        if (j == -9223372036854775807L || j != this.g) {
            this.i = true;
            this.h = this.g;
            ((wo) this.a).a.y();
        }
    }

    public final void a(xj xjVar) {
        this.i = false;
        this.f = -9223372036854775807L;
        this.e = xjVar;
        Iterator<Map.Entry<Long, Long>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.e.h) {
                it.remove();
            }
        }
    }

    final boolean b(long j) {
        xj xjVar = this.e;
        boolean z = false;
        if (!xjVar.d) {
            return false;
        }
        if (this.i) {
            return true;
        }
        Map.Entry<Long, Long> entryCeilingEntry = this.d.ceilingEntry(Long.valueOf(xjVar.h));
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().longValue() < j) {
            long jLongValue = entryCeilingEntry.getKey().longValue();
            this.f = jLongValue;
            ((wo) this.a).a.z(jLongValue);
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    final boolean c(vt vtVar) {
        if (!this.e.d) {
            return false;
        }
        if (this.i) {
            return true;
        }
        long j = this.g;
        if (j == -9223372036854775807L || j >= vtVar.i) {
            return false;
        }
        i();
        return true;
    }

    final void d(vt vtVar) {
        long j = this.g;
        if (j != -9223372036854775807L || vtVar.j > j) {
            this.g = vtVar.j;
        }
    }

    public final xg e() {
        return new xg(this, this.k);
    }

    public final void f() {
        this.j = true;
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (this.j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        xe xeVar = (xe) message.obj;
        long j = xeVar.a;
        long j2 = xeVar.b;
        TreeMap<Long, Long> treeMap = this.d;
        Long lValueOf = Long.valueOf(j2);
        Long l = treeMap.get(lValueOf);
        if (l == null || l.longValue() > j) {
            this.d.put(lValueOf, Long.valueOf(j));
        }
        return true;
    }
}
