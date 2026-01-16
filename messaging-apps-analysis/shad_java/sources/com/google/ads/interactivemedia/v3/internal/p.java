package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class p {
    private static final p a = new p();
    private final ArrayList<i> b = new ArrayList<>();
    private final ArrayList<i> c = new ArrayList<>();

    private p() {
    }

    public static p a() {
        return a;
    }

    public final void b(i iVar) {
        this.b.add(iVar);
    }

    public final void c(i iVar) {
        boolean zG = g();
        this.c.add(iVar);
        if (zG) {
            return;
        }
        w.a().c();
    }

    public final void d(i iVar) {
        boolean zG = g();
        this.b.remove(iVar);
        this.c.remove(iVar);
        if (!zG || g()) {
            return;
        }
        w.a().d();
    }

    public final Collection<i> e() {
        return Collections.unmodifiableCollection(this.b);
    }

    public final Collection<i> f() {
        return Collections.unmodifiableCollection(this.c);
    }

    public final boolean g() {
        return this.c.size() > 0;
    }
}
