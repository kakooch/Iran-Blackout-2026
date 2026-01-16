package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C2587hb;
import io.appmetrica.analytics.impl.C2797q6;
import io.appmetrica.analytics.impl.C2993yb;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import io.appmetrica.analytics.impl.R5;

/* loaded from: classes3.dex */
public final class CounterAttribute {
    private final C2797q6 a;

    CounterAttribute(String str, C2587hb c2587hb, C2993yb c2993yb) {
        this.a = new C2797q6(str, c2587hb, c2993yb);
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withDelta(double d) {
        return new UserProfileUpdate<>(new R5(this.a.c, d));
    }
}
