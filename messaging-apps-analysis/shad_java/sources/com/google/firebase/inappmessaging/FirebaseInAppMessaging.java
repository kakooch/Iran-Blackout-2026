package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import io.reactivex.functions.Consumer;

/* loaded from: classes3.dex */
public class FirebaseInAppMessaging {
    private final DisplayCallbacksFactory displayCallbacksFactory;
    private FirebaseInAppMessagingDisplay fiamDisplay;
    private final FirebaseInstallationsApi firebaseInstallations;

    FirebaseInAppMessaging(InAppMessageStreamManager inAppMessageStreamManager, ProgramaticContextualTriggers programaticContextualTriggers, DataCollectionHelper dataCollectionHelper, FirebaseInstallationsApi firebaseInstallationsApi, DisplayCallbacksFactory displayCallbacksFactory, DeveloperListenerManager developerListenerManager) {
        this.firebaseInstallations = firebaseInstallationsApi;
        this.displayCallbacksFactory = displayCallbacksFactory;
        firebaseInstallationsApi.getId().addOnSuccessListener(new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.FirebaseInAppMessaging$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseInAppMessaging.lambda$new$0((String) obj);
            }
        });
        inAppMessageStreamManager.createFirebaseInAppMessageStream().subscribe(new Consumer() { // from class: com.google.firebase.inappmessaging.FirebaseInAppMessaging$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.triggerInAppMessage((TriggeredInAppMessage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(String str) {
        Logging.logi("Starting InAppMessaging runtime with Installation ID " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerInAppMessage(TriggeredInAppMessage triggeredInAppMessage) {
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = this.fiamDisplay;
        if (firebaseInAppMessagingDisplay != null) {
            firebaseInAppMessagingDisplay.displayMessage(triggeredInAppMessage.getInAppMessage(), this.displayCallbacksFactory.generateDisplayCallback(triggeredInAppMessage.getInAppMessage(), triggeredInAppMessage.getTriggeringEvent()));
        }
    }
}
