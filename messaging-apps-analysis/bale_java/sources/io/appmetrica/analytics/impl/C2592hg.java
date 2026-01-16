package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.hg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2592hg implements Consumer {
    public final /* synthetic */ C2687lg a;

    public C2592hg(C2687lg c2687lg) {
        this.a = c2687lg;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        C2440bb c2440bb = (C2440bb) obj;
        C2687lg c2687lg = this.a;
        String str = c2440bb.h;
        String str2 = c2440bb.e;
        Integer num = c2440bb.f;
        String str3 = c2440bb.g;
        C2508e4 c2508e4 = new C2508e4(str, str2, num, str3, c2440bb.i);
        String str4 = c2440bb.b;
        byte[] bArr = c2440bb.a;
        int i = c2440bb.c;
        HashMap map = c2440bb.d;
        String str5 = c2440bb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(bArr, str4, 5889, orCreatePublicLogger);
        c2433b4.q = map;
        c2433b4.g = i;
        c2433b4.c = str5;
        A4 a4 = new A4(new Yk(), new C3010z4(), null);
        c2687lg.c.a(c2508e4, a4).a(c2433b4, a4);
        c2687lg.c.a(num.intValue(), str2, str3);
    }
}
