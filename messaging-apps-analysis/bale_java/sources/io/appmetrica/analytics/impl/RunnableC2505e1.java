package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.e1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2505e1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C2601i1 c;

    public RunnableC2505e1(C2601i1 c2601i1, String str, List list) {
        this.c = c2601i1;
        this.a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.c).reportEvent(this.a, CollectionUtils.getMapFromList(this.b));
    }
}
