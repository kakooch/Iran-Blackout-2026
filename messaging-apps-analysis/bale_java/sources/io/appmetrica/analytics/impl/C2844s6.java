package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* renamed from: io.appmetrica.analytics.impl.s6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2844s6 implements ProtobufConverter {
    public final Tf a;

    public C2844s6() {
        this(new Tf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y5 fromModel(C2820r6 c2820r6) {
        Y5 y5FromModel = this.a.fromModel(c2820r6.a);
        y5FromModel.g = 1;
        X5 x5 = new X5();
        y5FromModel.h = x5;
        x5.a = StringUtils.correctIllFormedString(c2820r6.b);
        return y5FromModel;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2844s6(Tf tf) {
        this.a = tf;
    }

    public final C2820r6 a(Y5 y5) {
        throw new UnsupportedOperationException();
    }
}
