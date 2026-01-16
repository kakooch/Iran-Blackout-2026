package io.sentry;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class A1 {
    private final W3 a;
    private final Double b;
    private final Map c;

    public A1(W3 w3, AbstractC3131j abstractC3131j, Double d, Map map) {
        this.a = (W3) io.sentry.util.u.c(w3, "transactionContexts is required");
        this.b = d;
        this.c = map == null ? Collections.emptyMap() : map;
    }

    public Double a() {
        return this.b;
    }

    public W3 b() {
        return this.a;
    }
}
