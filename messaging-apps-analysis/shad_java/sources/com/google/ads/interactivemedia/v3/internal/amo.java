package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class amo {
    private final List<AdErrorEvent.AdErrorListener> a = new ArrayList(1);

    public final void a(AdErrorEvent.AdErrorListener adErrorListener) {
        this.a.add(adErrorListener);
    }

    public final void b(AdErrorEvent.AdErrorListener adErrorListener) {
        this.a.remove(adErrorListener);
    }

    public final void c() {
        this.a.clear();
    }

    public final void d(AdErrorEvent adErrorEvent) {
        Iterator<AdErrorEvent.AdErrorListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onAdError(adErrorEvent);
        }
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
        sb.append("ErrorListenerSupport [errorListeners=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }
}
