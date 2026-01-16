package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.BiConsumer;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class V2 implements BiConsumer {
    public final /* synthetic */ W2 a;

    public V2(W2 w2) {
        this.a = w2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.BiConsumer
    public final void consume(Object obj, Object obj2) {
        Intent intent = (Intent) obj2;
        synchronized (this.a) {
            try {
                W2 w2 = this.a;
                w2.b = intent;
                Iterator it = w2.a.iterator();
                while (it.hasNext()) {
                    ((Consumer) it.next()).consume(intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
