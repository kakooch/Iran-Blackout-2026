package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import ir.nasim.AbstractC10360bX0;

/* loaded from: classes3.dex */
public final class Gm {
    public final V3 a;
    public final yn b;
    public final ConjunctiveCompositeThreadSafeToggle c;

    public Gm(Toggle toggle) {
        V3 v3 = new V3(C2586ha.h().w());
        this.a = v3;
        yn ynVar = new yn();
        this.b = ynVar;
        this.c = new ConjunctiveCompositeThreadSafeToggle(AbstractC10360bX0.p(v3, ynVar, toggle == null ? new rn() : toggle), "loc-def");
    }
}
