package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateFolderCreated;
import ai.bale.proto.MessagingStruct$Folder;

/* renamed from: ir.nasim.yD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24208yD7 implements InterfaceC14123hO3 {
    private final C5292Is2 a;

    public C24208yD7(C5292Is2 c5292Is2) {
        AbstractC13042fc3.i(c5292Is2, "folderMapper");
        this.a = c5292Is2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C23618xD7 a(MessagingOuterClass$UpdateFolderCreated messagingOuterClass$UpdateFolderCreated) {
        C7429Rr2 c7429Rr2A;
        AbstractC13042fc3.i(messagingOuterClass$UpdateFolderCreated, "input");
        if (messagingOuterClass$UpdateFolderCreated.hasFolder()) {
            C5292Is2 c5292Is2 = this.a;
            MessagingStruct$Folder folder = messagingOuterClass$UpdateFolderCreated.getFolder();
            AbstractC13042fc3.h(folder, "getFolder(...)");
            c7429Rr2A = c5292Is2.a(folder);
        } else {
            c7429Rr2A = null;
        }
        return new C23618xD7(c7429Rr2A, messagingOuterClass$UpdateFolderCreated.getIndex());
    }
}
