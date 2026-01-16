package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.UA2;

/* loaded from: classes3.dex */
public final class Hb extends AbstractC8614Ws3 implements UA2 {
    public static final Hb a = new Hb();

    public Hb() {
        super(1);
    }

    @Override // ir.nasim.UA2
    public final Object invoke(Object obj) {
        ((LocationControllerObserver) obj).stopLocationTracking();
        return C19938rB7.a;
    }
}
