package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class Cn {
    public final ArrayList a = new ArrayList();
    public PublicLogger b;

    public final synchronized void a(Consumer consumer) {
        try {
            PublicLogger publicLogger = this.b;
            if (publicLogger == null) {
                this.a.add(consumer);
            } else {
                consumer.consume(publicLogger);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
