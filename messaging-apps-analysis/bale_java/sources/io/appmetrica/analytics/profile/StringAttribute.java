package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C2797q6;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.Hm;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import io.appmetrica.analytics.impl.InterfaceC2649k2;
import io.appmetrica.analytics.impl.Ph;
import io.appmetrica.analytics.impl.Wl;
import io.appmetrica.analytics.impl.Xl;
import io.appmetrica.analytics.impl.Yj;
import io.appmetrica.analytics.impl.on;

/* loaded from: classes3.dex */
public class StringAttribute {
    private final Hm a;
    private final C2797q6 b;

    StringAttribute(String str, Wl wl, on onVar, InterfaceC2649k2 interfaceC2649k2) {
        this.b = new C2797q6(str, onVar, interfaceC2649k2);
        this.a = wl;
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValue(String str) {
        C2797q6 c2797q6 = this.b;
        return new UserProfileUpdate<>(new Xl(c2797q6.c, str, this.a, c2797q6.a, new D4(c2797q6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueIfUndefined(String str) {
        C2797q6 c2797q6 = this.b;
        return new UserProfileUpdate<>(new Xl(c2797q6.c, str, this.a, c2797q6.a, new Yj(c2797q6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueReset() {
        C2797q6 c2797q6 = this.b;
        return new UserProfileUpdate<>(new Ph(0, c2797q6.c, c2797q6.a, c2797q6.b));
    }
}
