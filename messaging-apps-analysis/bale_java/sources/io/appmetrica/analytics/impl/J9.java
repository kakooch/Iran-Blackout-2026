package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;

/* loaded from: classes3.dex */
public final class J9 extends K9 {
    @Override // io.appmetrica.analytics.impl.K9
    public final L9 b(FeatureInfo featureInfo) {
        return new L9(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
