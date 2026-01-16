package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.internal.time.SystemClock;

/* loaded from: classes3.dex */
public class SystemClockModule {
    public Clock providesSystemClockModule() {
        return new SystemClock();
    }
}
