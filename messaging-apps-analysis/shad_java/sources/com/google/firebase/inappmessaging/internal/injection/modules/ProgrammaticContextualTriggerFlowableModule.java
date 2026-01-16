package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;

/* loaded from: classes3.dex */
public class ProgrammaticContextualTriggerFlowableModule {
    private ProgramaticContextualTriggers triggers;

    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        this.triggers = programaticContextualTriggers;
    }

    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }

    public ConnectableFlowable<String> providesProgramaticContextualTriggerStream() {
        ConnectableFlowable<String> connectableFlowablePublish = Flowable.create(new FlowableOnSubscribe() { // from class: com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule$$ExternalSyntheticLambda1
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) throws Exception {
                this.f$0.lambda$providesProgramaticContextualTriggerStream$1(flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER).publish();
        connectableFlowablePublish.connect();
        return connectableFlowablePublish;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$providesProgramaticContextualTriggerStream$1(final FlowableEmitter flowableEmitter) throws Exception {
        this.triggers.setListener(new ProgramaticContextualTriggers.Listener(flowableEmitter) { // from class: com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule$$ExternalSyntheticLambda0
        });
    }
}
