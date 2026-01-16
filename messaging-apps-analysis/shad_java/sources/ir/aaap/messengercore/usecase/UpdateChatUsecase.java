package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.ChatType;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class UpdateChatUsecase {
    private CoreMainClassImpl coreMainClass;

    public UpdateChatUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void seenChat(String str, ChatType chatType, long j) {
        this.coreMainClass.onSeenChatChanged(str, chatType, j);
    }

    public void deleteChats(ArrayList<String> arrayList, boolean z) {
        this.coreMainClass.onChatsDeleted(arrayList, z);
    }

    public void chatsToLoad(Set<String> set) {
        this.coreMainClass.loadChatsByGuidIfNeeded(set, null);
    }

    public void onChatClearHistory(ArrayList<String> arrayList) {
        this.coreMainClass.onChatClearHistory(arrayList);
    }
}
