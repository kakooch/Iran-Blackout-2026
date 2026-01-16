package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Lazy;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;

/* loaded from: classes3.dex */
public class ApiClientModule {
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public ApiClientModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock;
    }

    FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    SharedPreferencesUtils providesSharedPreferencesUtils() {
        return new SharedPreferencesUtils(this.firebaseApp);
    }

    DataCollectionHelper providesDataCollectionHelper(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(this.firebaseApp, sharedPreferencesUtils, subscriber);
    }

    TestDeviceHelper providesTestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }

    ApiClient providesApiClient(Lazy<GrpcClient> lazy, Application application, ProviderInstaller providerInstaller) {
        return new ApiClient(lazy, this.firebaseApp, application, this.clock, providerInstaller);
    }
}
