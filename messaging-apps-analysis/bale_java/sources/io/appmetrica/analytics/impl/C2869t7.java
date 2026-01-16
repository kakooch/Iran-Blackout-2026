package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.XV4;
import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: io.appmetrica.analytics.impl.t7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2869t7 implements ProtobufConverter {
    public final BigDecimal a(C2437b8 c2437b8) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2437b8 fromModel(BigDecimal bigDecimal) {
        BigInteger bigInteger = AbstractC2917v7.a;
        int i = -bigDecimal.scale();
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (bigIntegerUnscaledValue.compareTo(AbstractC2917v7.a) <= 0 && bigIntegerUnscaledValue.compareTo(AbstractC2917v7.b) >= 0) {
                XV4 xv4A = AbstractC4616Fw7.a(Long.valueOf(bigIntegerUnscaledValue.longValue()), Integer.valueOf(i));
                C2893u7 c2893u7 = new C2893u7(((Number) xv4A.f()).intValue(), ((Number) xv4A.e()).longValue());
                C2437b8 c2437b8 = new C2437b8();
                c2437b8.a = c2893u7.a;
                c2437b8.b = c2893u7.b;
                return c2437b8;
            }
            bigIntegerUnscaledValue = bigIntegerUnscaledValue.divide(BigInteger.TEN);
            i++;
        }
    }
}
