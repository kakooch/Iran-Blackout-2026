package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageUpdateResult;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class UpdateMessageUsecase {
    private CoreMainClassImpl coreMainClass;

    public UpdateMessageUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void onMessagesAdded(String str, ChatType chatType, ArrayList<Message> arrayList, boolean z, boolean z2) {
        this.coreMainClass.onMessageAdded(str, chatType, arrayList, z, z2);
    }

    public void onMessagesDeleted(String str, ChatType chatType, ArrayList<Long> arrayList, boolean z) {
        this.coreMainClass.onMessageDeleted(str, chatType, arrayList, z);
    }

    public void onMessagesUpdated(String str, ChatType chatType, ArrayList<MessageUpdateResult> arrayList, boolean z) {
        this.coreMainClass.onMessageUpdated(str, chatType, arrayList, z);
    }
}
