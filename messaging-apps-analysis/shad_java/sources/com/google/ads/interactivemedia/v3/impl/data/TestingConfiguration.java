package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;
import com.google.ads.interactivemedia.v3.internal.ars;

/* compiled from: IMASDK */
@aps(a = am.class, b = {"extraParams", "isTv", "ignoreStrictModeFalsePositives"})
/* loaded from: classes.dex */
public abstract class TestingConfiguration {
    public static final String PARAMETER_KEY = "tcnfp";

    /* compiled from: IMASDK */
    public interface Builder {
        TestingConfiguration build();

        Builder disableExperiments(boolean z);

        Builder disableOnScreenDetection(boolean z);

        Builder disableSkipFadeTransition(boolean z);

        Builder enableMonitorAppLifecycle(boolean z);

        Builder extraParams(ars<String, Object> arsVar);

        Builder forceTvMode(boolean z);

        Builder ignoreStrictModeFalsePositives(boolean z);

        Builder useTestStreamManager(boolean z);

        Builder useVideoElementMock(boolean z);

        Builder videoElementMockDuration(float f);
    }

    TestingConfiguration() {
    }

    public static Builder builder() {
        al alVar = new al();
        alVar.disableExperiments(true);
        alVar.disableOnScreenDetection(false);
        alVar.disableSkipFadeTransition(true);
        alVar.useVideoElementMock(false);
        alVar.videoElementMockDuration(30.0f);
        alVar.useTestStreamManager(false);
        alVar.ignoreStrictModeFalsePositives(false);
        alVar.forceTvMode(false);
        alVar.enableMonitorAppLifecycle(true);
        return alVar;
    }

    public Builder copy() {
        al alVar = new al();
        alVar.disableExperiments(disableExperiments());
        alVar.disableOnScreenDetection(disableOnScreenDetection());
        alVar.disableSkipFadeTransition(disableSkipFadeTransition());
        alVar.useVideoElementMock(useVideoElementMock());
        alVar.videoElementMockDuration(videoElementMockDuration());
        alVar.useTestStreamManager(useTestStreamManager());
        alVar.enableMonitorAppLifecycle(enableMonitorAppLifecycle());
        alVar.forceTvMode(forceTvMode());
        alVar.ignoreStrictModeFalsePositives(ignoreStrictModeFalsePositives());
        alVar.extraParams(extraParams());
        return alVar;
    }

    public abstract boolean disableExperiments();

    public abstract boolean disableOnScreenDetection();

    public abstract boolean disableSkipFadeTransition();

    public abstract boolean enableMonitorAppLifecycle();

    public abstract ars<String, Object> extraParams();

    public abstract boolean forceTvMode();

    public abstract boolean ignoreStrictModeFalsePositives();

    public abstract boolean useTestStreamManager();

    public abstract boolean useVideoElementMock();

    public abstract float videoElementMockDuration();
}
