package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateFoldersReordered;
import java.util.List;

/* loaded from: classes5.dex */
public final class ED7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DD7 a(MessagingOuterClass$UpdateFoldersReordered messagingOuterClass$UpdateFoldersReordered) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateFoldersReordered, "input");
        List<Integer> folderIdsList = messagingOuterClass$UpdateFoldersReordered.getFolderIdsList();
        AbstractC13042fc3.h(folderIdsList, "getFolderIdsList(...)");
        return new DD7(folderIdsList);
    }
}
