package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.GroupCallModels;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class UpdateGroupVoiceChatUsecase {
    private final CoreMainClassImpl coreMainClass;

    public UpdateGroupVoiceChatUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void processGroupVoiceChatParticipants(GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate) {
        if (groupVoiceChatParticipantUpdate != null) {
            this.coreMainClass.processGroupVoiceChatParticipantUpdate(new ArrayList<>(Collections.singletonList(groupVoiceChatParticipantUpdate)), false);
        }
    }

    public void processGroupVoiceChatParticipants(GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate, GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate) {
        if (groupVoiceChatParticipantUpdate != null) {
            this.coreMainClass.processGroupVoiceChatParticipantUpdate(new ArrayList<>(Collections.singletonList(groupVoiceChatParticipantUpdate)), false);
        }
        if (groupVoiceChatUpdate != null) {
            this.coreMainClass.processGroupVoiceChatUpdates(new ArrayList<>(Collections.singletonList(groupVoiceChatUpdate)));
        }
    }
}
