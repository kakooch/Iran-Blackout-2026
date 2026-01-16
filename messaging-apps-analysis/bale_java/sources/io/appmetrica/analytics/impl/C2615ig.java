package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.UnsupportedEncodingException;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.ig, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2615ig implements Function {
    public final /* synthetic */ C2934w0 a;

    public C2615ig(C2934w0 c2934w0) {
        this.a = c2934w0;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    public final Object apply(Object obj) throws UnsupportedEncodingException {
        String str = (String) obj;
        C2934w0 c2934w0 = this.a;
        String str2 = c2934w0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c2934w0.f.a);
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str2);
        C2433b4 c2433b4 = new C2433b4("", "", 5897, 0, orCreatePublicLogger);
        if (str != null) {
            c2433b4.f(str);
        }
        c2433b4.m = bundle;
        c2433b4.c = this.a.f.f;
        return c2433b4;
    }
}
