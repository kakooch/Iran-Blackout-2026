package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;

/* loaded from: classes3.dex */
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    public Application providesApplication() {
        return this.application;
    }

    public DeveloperListenerManager developerListenerManager() {
        return new DeveloperListenerManager();
    }
}
