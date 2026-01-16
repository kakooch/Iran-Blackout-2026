package com.google.firebase.inappmessaging.internal;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class DataCollectionHelper {
    private AtomicBoolean isGlobalAutomaticDataCollectionEnabled;
    private SharedPreferencesUtils sharedPreferencesUtils;

    public DataCollectionHelper(FirebaseApp firebaseApp, SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
        this.isGlobalAutomaticDataCollectionEnabled = new AtomicBoolean(firebaseApp.isDataCollectionDefaultEnabled());
        subscriber.subscribe(DataCollectionDefaultChange.class, new EventHandler() { // from class: com.google.firebase.inappmessaging.internal.DataCollectionHelper$$ExternalSyntheticLambda0
            @Override // com.google.firebase.events.EventHandler
            public final void handle(Event event) {
                this.f$0.lambda$new$0(event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Event event) {
        this.isGlobalAutomaticDataCollectionEnabled.set(((DataCollectionDefaultChange) event.getPayload()).enabled);
    }

    public boolean isAutomaticDataCollectionEnabled() {
        if (isProductManuallySet()) {
            return this.sharedPreferencesUtils.getBooleanPreference("auto_init", true);
        }
        if (isProductManifestSet()) {
            return this.sharedPreferencesUtils.getBooleanManifestValue("firebase_inapp_messaging_auto_data_collection_enabled", true);
        }
        return this.isGlobalAutomaticDataCollectionEnabled.get();
    }

    private boolean isProductManuallySet() {
        return this.sharedPreferencesUtils.isPreferenceSet("auto_init");
    }

    private boolean isProductManifestSet() {
        return this.sharedPreferencesUtils.isManifestSet("firebase_inapp_messaging_auto_data_collection_enabled");
    }
}
