package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter;

/* loaded from: classes3.dex */
public final class Cc implements ModuleEventServiceHandlerReporter {
    public final C2537f9 a;
    public final Q5 b;

    public Cc(C2537f9 c2537f9, Q5 q5) {
        this.a = c2537f9;
        this.b = q5;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerReporter
    public final void report(CounterReportApi counterReportApi) {
        Q5 q5D = Q5.d(this.b);
        q5D.d = counterReportApi.getType();
        q5D.e = counterReportApi.getCustomType();
        q5D.setName(counterReportApi.getName());
        q5D.setValue(counterReportApi.getValue());
        q5D.setValueBytes(counterReportApi.getValueBytes());
        q5D.g = counterReportApi.getBytesTruncated();
        C2537f9 c2537f9 = this.a;
        c2537f9.a(q5D, Sj.a(c2537f9.c.b(q5D), q5D.i));
    }
}
