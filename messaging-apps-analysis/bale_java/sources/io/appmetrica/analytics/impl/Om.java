package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Om {
    public final C2490db a;

    public Om() {
        this(new C2490db());
    }

    public final Ng a(Mm mm, Wg wg) {
        String str;
        Cm cm = mm.a;
        String str2 = cm == null ? "" : (String) WrapUtils.getOrDefault(cm.a, "");
        byte[] bArrFromModel = this.a.fromModel(mm);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(wg.b.getApiKey());
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(bArrFromModel, str2, 5891, orCreatePublicLogger);
        c2433b4.c = wg.d();
        HashMap map = c2433b4.q;
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str = wg.f;
        }
        return new Ng(c2433b4, true, 1, map, new Wg(oe, counterConfiguration, str));
    }

    public Om(C2490db c2490db) {
        this.a = c2490db;
    }
}
