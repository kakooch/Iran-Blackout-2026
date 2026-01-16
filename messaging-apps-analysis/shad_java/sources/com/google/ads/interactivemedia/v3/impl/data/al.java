package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.internal.ars;
import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class al implements TestingConfiguration.Builder {
    private Boolean disableExperiments;
    private Boolean disableOnScreenDetection;
    private Boolean disableSkipFadeTransition;
    private Boolean enableMonitorAppLifecycle;
    private ars<String, Object> extraParams;
    private Boolean forceTvMode;
    private Boolean ignoreStrictModeFalsePositives;
    private Boolean useTestStreamManager;
    private Boolean useVideoElementMock;
    private Float videoElementMockDuration;

    al() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration build() {
        Boolean bool = this.disableExperiments;
        String strConcat = BuildConfig.FLAVOR;
        if (bool == null) {
            strConcat = BuildConfig.FLAVOR.concat(" disableExperiments");
        }
        if (this.disableOnScreenDetection == null) {
            strConcat = String.valueOf(strConcat).concat(" disableOnScreenDetection");
        }
        if (this.disableSkipFadeTransition == null) {
            strConcat = String.valueOf(strConcat).concat(" disableSkipFadeTransition");
        }
        if (this.useVideoElementMock == null) {
            strConcat = String.valueOf(strConcat).concat(" useVideoElementMock");
        }
        if (this.videoElementMockDuration == null) {
            strConcat = String.valueOf(strConcat).concat(" videoElementMockDuration");
        }
        if (this.useTestStreamManager == null) {
            strConcat = String.valueOf(strConcat).concat(" useTestStreamManager");
        }
        if (this.enableMonitorAppLifecycle == null) {
            strConcat = String.valueOf(strConcat).concat(" enableMonitorAppLifecycle");
        }
        if (this.forceTvMode == null) {
            strConcat = String.valueOf(strConcat).concat(" forceTvMode");
        }
        if (this.ignoreStrictModeFalsePositives == null) {
            strConcat = String.valueOf(strConcat).concat(" ignoreStrictModeFalsePositives");
        }
        if (strConcat.isEmpty()) {
            return new am(this.disableExperiments.booleanValue(), this.disableOnScreenDetection.booleanValue(), this.disableSkipFadeTransition.booleanValue(), this.useVideoElementMock.booleanValue(), this.videoElementMockDuration.floatValue(), this.useTestStreamManager.booleanValue(), this.enableMonitorAppLifecycle.booleanValue(), this.forceTvMode.booleanValue(), this.ignoreStrictModeFalsePositives.booleanValue(), this.extraParams);
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableExperiments(boolean z) {
        this.disableExperiments = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableOnScreenDetection(boolean z) {
        this.disableOnScreenDetection = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableSkipFadeTransition(boolean z) {
        this.disableSkipFadeTransition = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder enableMonitorAppLifecycle(boolean z) {
        this.enableMonitorAppLifecycle = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder extraParams(ars<String, Object> arsVar) {
        this.extraParams = arsVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder forceTvMode(boolean z) {
        this.forceTvMode = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder ignoreStrictModeFalsePositives(boolean z) {
        this.ignoreStrictModeFalsePositives = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder useTestStreamManager(boolean z) {
        this.useTestStreamManager = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder useVideoElementMock(boolean z) {
        this.useVideoElementMock = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder videoElementMockDuration(float f) {
        this.videoElementMockDuration = Float.valueOf(f);
        return this;
    }
}
