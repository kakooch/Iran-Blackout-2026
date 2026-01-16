package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.MessageUpdateObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class UpdateChatAndMessageUsecase {
    private CoreMainClassImpl coreMainClass;

    public UpdateChatAndMessageUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void processMessageAndChatUpdate(MessageUpdateObject messageUpdateObject, ChatUpdateObject chatUpdateObject, boolean z, boolean z2) {
        this.coreMainClass.processMessageAndChatUpdate(messageUpdateObject, chatUpdateObject, z, z2);
    }

    public void processMessageAndChatUpdate(ArrayList<MessageUpdateObject> arrayList, ChatUpdateObject chatUpdateObject, boolean z, boolean z2) {
        this.coreMainClass.processMessageAndChatUpdate(arrayList, chatUpdateObject, z, z2);
    }

    public void processChatUpdate(ChatUpdateObject chatUpdateObject) {
        this.coreMainClass.processChatUpdate(chatUpdateObject);
    }
}
