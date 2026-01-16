package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C2587hb;
import io.appmetrica.analytics.impl.C2797q6;
import io.appmetrica.analytics.impl.C2962x4;
import io.appmetrica.analytics.impl.C2971xd;
import io.appmetrica.analytics.impl.C2993yb;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import io.appmetrica.analytics.impl.Ph;
import io.appmetrica.analytics.impl.Yj;

/* loaded from: classes3.dex */
public final class NumberAttribute {
    private final C2797q6 a;

    NumberAttribute(String str, C2587hb c2587hb, C2993yb c2993yb) {
        this.a = new C2797q6(str, c2587hb, c2993yb);
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValue(double d) {
        return new UserProfileUpdate<>(new C2971xd(this.a.c, d, new C2587hb(), new D4(new C2993yb(new C2962x4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new C2971xd(this.a.c, d, new C2587hb(), new Yj(new C2993yb(new C2962x4(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueReset() {
        return new UserProfileUpdate<>(new Ph(1, this.a.c, new C2587hb(), new C2993yb(new C2962x4(100))));
    }
}
