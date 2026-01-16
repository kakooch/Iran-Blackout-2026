package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC8614Ws3;
import ir.nasim.UA2;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Rc extends AbstractC8614Ws3 implements UA2 {
    public final /* synthetic */ Xa a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rc(Xa xa) {
        super(1);
        this.a = xa;
    }

    @Override // ir.nasim.UA2
    public final Object invoke(Object obj) {
        Fc fc = (Fc) ((Map.Entry) obj).getValue();
        return fc.b.parse(this.a);
    }
}
