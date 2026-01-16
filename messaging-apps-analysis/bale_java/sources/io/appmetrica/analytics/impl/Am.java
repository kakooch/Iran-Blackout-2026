package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;

/* loaded from: classes3.dex */
public class Am implements on {
    public final on a;

    public Am(on onVar) {
        this.a = onVar;
    }

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Object obj) {
        mn mnVarA = this.a.a(obj);
        if (mnVarA.a) {
            return mnVarA;
        }
        throw new ValidationException(mnVarA.b);
    }

    public final on a() {
        return this.a;
    }
}
