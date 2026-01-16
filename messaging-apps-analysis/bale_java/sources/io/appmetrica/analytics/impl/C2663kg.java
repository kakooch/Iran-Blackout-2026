package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;

/* renamed from: io.appmetrica.analytics.impl.kg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2663kg implements Consumer {
    public final C2958x0 a;
    public final Function b;
    public final /* synthetic */ C2687lg c;

    public C2663kg(C2687lg c2687lg, C2958x0 c2958x0, Function<String, Q5> function) {
        this.c = c2687lg;
        this.a = c2958x0;
        this.b = function;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void consume(String str) {
        C2687lg c2687lg = this.c;
        C2958x0 c2958x0 = this.a;
        String str2 = c2958x0.a;
        String str3 = c2958x0.b;
        int i = c2958x0.d;
        Integer numValueOf = Integer.valueOf(i);
        C2958x0 c2958x02 = this.a;
        String str4 = c2958x02.e;
        C2508e4 c2508e4 = new C2508e4(str2, str3, numValueOf, str4, c2958x02.c);
        Q5 q5 = (Q5) this.b.apply(str);
        A4 a4 = new A4(new Yk(), new C3010z4(), null);
        c2687lg.c.a(c2508e4, a4).a(q5, a4);
        c2687lg.c.a(i, str3, str4);
    }
}
