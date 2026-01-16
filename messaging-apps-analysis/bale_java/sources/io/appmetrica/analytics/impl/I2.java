package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.C12275eL0;

/* loaded from: classes3.dex */
public class I2 implements ExternalAttribution {
    public final C2895u9 a;

    public I2(C2895u9 c2895u9) {
        this.a = c2895u9;
    }

    @Override // io.appmetrica.analytics.ExternalAttribution
    public final byte[] toBytes() {
        return MessageNano.toByteArray(this.a);
    }

    public final String toString() {
        return "ExternalAttribution(type=`" + E9.a(this.a.a) + "`value=`" + new String(this.a.b, C12275eL0.b) + "`)";
    }
}
