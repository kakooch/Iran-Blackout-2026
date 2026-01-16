package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.g5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2557g5 {
    public final String a;

    public C2557g5(String str) {
        this.a = str;
    }

    public final PublicLogger a() {
        return LoggerStorage.getOrCreatePublicLogger(this.a);
    }
}
