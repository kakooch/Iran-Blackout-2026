package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class je {
    public final int a;
    public final tw b;
    private final CopyOnWriteArrayList<mz> c;

    public je() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private je(CopyOnWriteArrayList<mz> copyOnWriteArrayList, int i, tw twVar) {
        this.c = copyOnWriteArrayList;
        this.a = i;
        this.b = twVar;
    }

    public final je a(int i, tw twVar) {
        return new je(this.c, i, twVar);
    }

    public final void b(Handler handler, jf jfVar) {
        ary.t(handler);
        ary.t(jfVar);
        this.c.add(new mz());
    }
}
