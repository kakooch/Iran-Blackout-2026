package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class abr implements abx {
    private final boolean a;
    private final ArrayList<adh> b = new ArrayList<>(1);
    private int c;
    private acb d;

    protected abr(boolean z) {
        this.a = z;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void b(adh adhVar) {
        ary.t(adhVar);
        if (this.b.contains(adhVar)) {
            return;
        }
        this.b.add(adhVar);
        this.c++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public Map e() {
        return Collections.emptyMap();
    }

    protected final void g(acb acbVar) {
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).i();
        }
    }

    protected final void h(acb acbVar) {
        this.d = acbVar;
        for (int i = 0; i < this.c; i++) {
            this.b.get(i).j(acbVar, this.a);
        }
    }

    protected final void i(int i) {
        acb acbVar = this.d;
        int i2 = aeu.a;
        for (int i3 = 0; i3 < this.c; i3++) {
            this.b.get(i3).g(acbVar, this.a, i);
        }
    }

    protected final void j() {
        acb acbVar = this.d;
        int i = aeu.a;
        for (int i2 = 0; i2 < this.c; i2++) {
            this.b.get(i2).h(acbVar, this.a);
        }
        this.d = null;
    }
}
