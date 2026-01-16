package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class agh extends agj implements Iterable<agj> {
    private final List<agj> a = new ArrayList();

    public final void a(agj agjVar) {
        this.a.add(agjVar);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof agh) && ((agh) obj).a.equals(this.a));
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<agj> iterator() {
        return this.a.iterator();
    }
}
