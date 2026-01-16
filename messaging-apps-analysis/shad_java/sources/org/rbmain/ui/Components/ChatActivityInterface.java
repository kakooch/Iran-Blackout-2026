package org.rbmain.ui.Components;

import org.rbmain.messenger.ChatObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$User;

/* loaded from: classes5.dex */
public interface ChatActivityInterface {
    TLRPC$Chat getCurrentChat();

    TLRPC$User getCurrentUser();

    long getDialogId();

    ChatObject.Call getGroupCall();

    boolean openedWithLivestream();

    void scrollToMessageId(long j, long j2, boolean z, int i, boolean z2, long j3);

    boolean shouldShowImport();
}
