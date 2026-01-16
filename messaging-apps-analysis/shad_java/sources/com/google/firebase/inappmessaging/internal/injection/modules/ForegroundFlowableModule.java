package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import io.reactivex.flowables.ConnectableFlowable;

/* loaded from: classes3.dex */
public class ForegroundFlowableModule {
    public ConnectableFlowable<String> providesAppForegroundEventStream(Application application) {
        ForegroundNotifier foregroundNotifier = new ForegroundNotifier();
        ConnectableFlowable<String> connectableFlowableForegroundFlowable = foregroundNotifier.foregroundFlowable();
        connectableFlowableForegroundFlowable.connect();
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        return connectableFlowableForegroundFlowable;
    }
}
