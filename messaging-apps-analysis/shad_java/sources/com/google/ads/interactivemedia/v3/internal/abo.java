package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abo {
    private final CopyOnWriteArrayList<abn> a = new CopyOnWriteArrayList<>();

    public final void a(Handler handler, abp abpVar) {
        b(abpVar);
        this.a.add(new abn(handler, abpVar));
    }

    public final void b(abp abpVar) {
        Iterator<abn> it = this.a.iterator();
        while (it.hasNext()) {
            abn next = it.next();
            if (next.b == abpVar) {
                next.a();
                this.a.remove(next);
            }
        }
    }

    public final void c(final int i, final long j, final long j2) {
        Iterator<abn> it = this.a.iterator();
        while (it.hasNext()) {
            final abn next = it.next();
            if (!next.c) {
                next.a.post(new Runnable(next, i, j, j2) { // from class: com.google.ads.interactivemedia.v3.internal.abm
                    private final abn a;
                    private final int b;
                    private final long c;
                    private final long d;

                    {
                        this.a = next;
                        this.b = i;
                        this.c = j;
                        this.d = j2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        abn abnVar = this.a;
                        abnVar.b.N(this.b, this.c, this.d);
                    }
                });
            }
        }
    }
}
