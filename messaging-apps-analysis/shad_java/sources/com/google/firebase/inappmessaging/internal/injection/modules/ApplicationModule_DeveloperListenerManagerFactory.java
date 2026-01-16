package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;

/* loaded from: classes3.dex */
public final class ApplicationModule_DeveloperListenerManagerFactory implements Factory<DeveloperListenerManager> {
    private final ApplicationModule module;

    public ApplicationModule_DeveloperListenerManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    @Override // javax.inject.Provider
    public DeveloperListenerManager get() {
        return developerListenerManager(this.module);
    }

    public static ApplicationModule_DeveloperListenerManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_DeveloperListenerManagerFactory(applicationModule);
    }

    public static DeveloperListenerManager developerListenerManager(ApplicationModule applicationModule) {
        return (DeveloperListenerManager) Preconditions.checkNotNull(applicationModule.developerListenerManager(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
