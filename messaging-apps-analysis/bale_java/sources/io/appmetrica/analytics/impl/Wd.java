package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12275eL0;

/* loaded from: classes3.dex */
public final class Wd implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final byte[] fromModel(String str) {
        if (AbstractC13042fc3.d(PluginErrorDetails.Platform.NATIVE, str)) {
            str = "JVM";
        }
        return str.getBytes(C12275eL0.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
