package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatType;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class GetChatAccessUseCase {
    private CoreMainClassImpl coreMainClass;

    public GetChatAccessUseCase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public HashSet<Chat.ChatAccessEnum> getChatAccess(String str, ChatType chatType) {
        return this.coreMainClass.getChatAccess(str, chatType);
    }
}
