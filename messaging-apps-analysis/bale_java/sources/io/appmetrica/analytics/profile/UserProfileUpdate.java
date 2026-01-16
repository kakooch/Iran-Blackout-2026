package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.AbstractC2417ad;
import io.appmetrica.analytics.impl.InterfaceC2427an;

/* loaded from: classes3.dex */
public class UserProfileUpdate<T extends InterfaceC2427an> {
    private final InterfaceC2427an a;

    UserProfileUpdate(AbstractC2417ad abstractC2417ad) {
        this.a = abstractC2417ad;
    }

    public T getUserProfileUpdatePatcher() {
        return (T) this.a;
    }
}
