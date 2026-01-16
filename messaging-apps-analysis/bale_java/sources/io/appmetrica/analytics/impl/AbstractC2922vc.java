package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;

/* renamed from: io.appmetrica.analytics.impl.vc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2922vc {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ModuleAdType.values().length];
        iArr[ModuleAdType.NATIVE.ordinal()] = 1;
        iArr[ModuleAdType.BANNER.ordinal()] = 2;
        iArr[ModuleAdType.REWARDED.ordinal()] = 3;
        iArr[ModuleAdType.INTERSTITIAL.ordinal()] = 4;
        iArr[ModuleAdType.MREC.ordinal()] = 5;
        iArr[ModuleAdType.OTHER.ordinal()] = 6;
        a = iArr;
    }
}
