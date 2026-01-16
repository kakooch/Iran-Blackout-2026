package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;

/* loaded from: classes3.dex */
public final class A1 implements Consumer {
    public final /* synthetic */ C1 a;

    public A1(C1 c1) {
        this.a = c1;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        this.a.a((File) obj);
    }
}
