package io.sentry;

import io.sentry.UncaughtExceptionHandlerIntegration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.sentry.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3146m implements D {
    private final Map a = Collections.synchronizedMap(new HashMap());
    private final C3155n3 b;

    public C3146m(C3155n3 c3155n3) {
        this.b = c3155n3;
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, I i) {
        io.sentry.protocol.q qVarY0;
        String strK;
        Long lJ;
        if (!io.sentry.util.m.h(i, UncaughtExceptionHandlerIntegration.a.class) || (qVarY0 = l2.y0()) == null || (strK = qVarY0.k()) == null || (lJ = qVarY0.j()) == null) {
            return l2;
        }
        Long l = (Long) this.a.get(strK);
        if (l == null || l.equals(lJ)) {
            this.a.put(strK, lJ);
            return l2;
        }
        this.b.getLogger().c(Y2.INFO, "Event %s has been dropped due to multi-threaded deduplication", l2.G());
        io.sentry.util.m.r(i, io.sentry.hints.h.MULTITHREADED_DEDUPLICATION);
        return null;
    }
}
