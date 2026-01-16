package com.google.common.base;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
final class Java8Usage {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$performCheck$0() {
    }

    static String performCheck() {
        new Runnable() { // from class: com.google.common.base.Java8Usage$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Java8Usage.lambda$performCheck$0();
            }
        }.run();
        return BuildConfig.FLAVOR;
    }
}
