package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.vh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2927vh implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C2951wh c;

    public RunnableC2927vh(C2951wh c2951wh, String str, List list) {
        this.c = c2951wh;
        this.a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.c;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportEvent(this.a, CollectionUtils.getMapFromList(this.b));
    }
}
