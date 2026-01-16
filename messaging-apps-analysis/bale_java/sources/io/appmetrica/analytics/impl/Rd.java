package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;

/* loaded from: classes3.dex */
public final class Rd extends C2707mc {
    public Rd() {
        super(Ud.UNDEFINED);
        a(1, Ud.WIFI);
        a(0, Ud.CELL);
        a(3, Ud.ETHERNET);
        a(2, Ud.BLUETOOTH);
        a(4, Ud.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, Ud.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, Ud.WIFI_AWARE);
        }
    }
}
