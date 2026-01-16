package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.AbtExperimentInfo;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.ExperimentPayloadProto$ExperimentPayload;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class AbtIntegrationHelper {
    private final FirebaseABTesting abTesting;
    Executor executor = Executors.newSingleThreadExecutor();

    public AbtIntegrationHelper(FirebaseABTesting firebaseABTesting) {
        this.abTesting = firebaseABTesting;
    }

    void setExperimentActive(final ExperimentPayloadProto$ExperimentPayload experimentPayloadProto$ExperimentPayload) {
        this.executor.execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.AbtIntegrationHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setExperimentActive$1(experimentPayloadProto$ExperimentPayload);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setExperimentActive$1(ExperimentPayloadProto$ExperimentPayload experimentPayloadProto$ExperimentPayload) {
        try {
            Logging.logd("Updating active experiment: " + experimentPayloadProto$ExperimentPayload.toString());
            this.abTesting.reportActiveExperiment(new AbtExperimentInfo(experimentPayloadProto$ExperimentPayload.getExperimentId(), experimentPayloadProto$ExperimentPayload.getVariantId(), experimentPayloadProto$ExperimentPayload.getTriggerEvent(), new Date(experimentPayloadProto$ExperimentPayload.getExperimentStartTimeMillis()), experimentPayloadProto$ExperimentPayload.getTriggerTimeoutMillis(), experimentPayloadProto$ExperimentPayload.getTimeToLiveMillis()));
        } catch (AbtException e) {
            Logging.loge("Unable to set experiment as active with ABT, missing analytics?\n" + e.getMessage());
        }
    }
}
