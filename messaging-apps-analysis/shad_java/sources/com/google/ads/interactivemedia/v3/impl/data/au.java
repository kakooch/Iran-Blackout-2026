package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = r.class)
/* loaded from: classes.dex */
public abstract class au {
    public static au create(String str, String str2, String str3, String str4) {
        return new r(str, str2, str3, str4);
    }

    public abstract String addtlConsent();

    public abstract String gdprApplies();

    public abstract String tcString();

    public abstract String uspString();
}
