package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;

/* loaded from: classes3.dex */
public abstract class K9 {
    public final L9 a(FeatureInfo featureInfo) {
        if (featureInfo.name != null) {
            return b(featureInfo);
        }
        int i = featureInfo.reqGlEsVersion;
        if (i == 0) {
            return b(featureInfo);
        }
        return new L9("openGlFeature", i, (featureInfo.flags & 1) != 0);
    }

    public abstract L9 b(FeatureInfo featureInfo);
}
