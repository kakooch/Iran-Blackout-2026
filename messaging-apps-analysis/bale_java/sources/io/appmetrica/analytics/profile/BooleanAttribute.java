package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C2746o3;
import io.appmetrica.analytics.impl.C2797q6;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.InterfaceC2427an;
import io.appmetrica.analytics.impl.InterfaceC2649k2;
import io.appmetrica.analytics.impl.Ph;
import io.appmetrica.analytics.impl.Yj;
import io.appmetrica.analytics.impl.on;

/* loaded from: classes3.dex */
public class BooleanAttribute {
    private final C2797q6 a;

    BooleanAttribute(String str, on onVar, InterfaceC2649k2 interfaceC2649k2) {
        this.a = new C2797q6(str, onVar, interfaceC2649k2);
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValue(boolean z) {
        C2797q6 c2797q6 = this.a;
        return new UserProfileUpdate<>(new C2746o3(c2797q6.c, z, c2797q6.a, new D4(c2797q6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueIfUndefined(boolean z) {
        C2797q6 c2797q6 = this.a;
        return new UserProfileUpdate<>(new C2746o3(c2797q6.c, z, c2797q6.a, new Yj(c2797q6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC2427an> withValueReset() {
        C2797q6 c2797q6 = this.a;
        return new UserProfileUpdate<>(new Ph(3, c2797q6.c, c2797q6.a, c2797q6.b));
    }
}
