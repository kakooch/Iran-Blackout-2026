package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.StartupParamsCallback;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class Kk extends HashMap {
    public Kk() {
        put(Ik.UNKNOWN, StartupParamsCallback.Reason.UNKNOWN);
        put(Ik.NETWORK, StartupParamsCallback.Reason.NETWORK);
        put(Ik.PARSE, StartupParamsCallback.Reason.INVALID_RESPONSE);
    }
}
