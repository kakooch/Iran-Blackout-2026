package ir.eitaa.messenger;

import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$DraftMessage;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_dialogFolder;

/* loaded from: classes.dex */
public class DialogObject {
    public static int getEncryptedChatId(long dialogId) {
        return (int) (dialogId & 4294967295L);
    }

    public static int getFolderId(long dialogId) {
        return (int) dialogId;
    }

    public static boolean isEncryptedDialog(long dialogId) {
        return (4611686018427387904L & dialogId) != 0 && (dialogId & Long.MIN_VALUE) == 0;
    }

    public static boolean isFolderDialogId(long dialogId) {
        return (2305843009213693952L & dialogId) != 0 && (dialogId & Long.MIN_VALUE) == 0;
    }

    public static long makeEncryptedDialogId(long chatId) {
        return (chatId & 4294967295L) | 4611686018427387904L;
    }

    public static long makeFolderDialogId(int folderId) {
        return folderId | 2305843009213693952L;
    }

    public static boolean isChannel(TLRPC$Dialog dialog) {
        return (dialog == null || (dialog.flags & 1) == 0) ? false : true;
    }

    public static void initDialog(TLRPC$Dialog dialog) {
        if (dialog == null || dialog.id != 0) {
            return;
        }
        if (dialog instanceof TLRPC$TL_dialog) {
            TLRPC$Peer tLRPC$Peer = dialog.peer;
            if (tLRPC$Peer == null) {
                return;
            }
            long j = tLRPC$Peer.user_id;
            if (j != 0) {
                dialog.id = j;
                return;
            }
            long j2 = tLRPC$Peer.chat_id;
            if (j2 != 0) {
                dialog.id = -j2;
                return;
            } else {
                dialog.id = -tLRPC$Peer.channel_id;
                return;
            }
        }
        if (dialog instanceof TLRPC$TL_dialogFolder) {
            dialog.id = makeFolderDialogId(((TLRPC$TL_dialogFolder) dialog).folder.id);
        }
    }

    public static long getPeerDialogId(TLRPC$Peer peer) {
        if (peer == null) {
            return 0L;
        }
        long j = peer.user_id;
        if (j != 0) {
            return j;
        }
        long j2 = peer.chat_id;
        return j2 != 0 ? -j2 : -peer.channel_id;
    }

    public static long getPeerDialogId(TLRPC$InputPeer peer) {
        if (peer == null) {
            return 0L;
        }
        long j = peer.user_id;
        if (j != 0) {
            return j;
        }
        long j2 = peer.chat_id;
        return j2 != 0 ? -j2 : -peer.channel_id;
    }

    public static long getLastMessageOrDraftDate(TLRPC$Dialog dialog, TLRPC$DraftMessage draftMessage) {
        int i;
        return (draftMessage == null || (i = draftMessage.date) < dialog.last_message_date) ? dialog.last_message_date : i;
    }

    public static boolean isChatDialog(long dialogId) {
        return (isEncryptedDialog(dialogId) || isFolderDialogId(dialogId) || dialogId >= 0) ? false : true;
    }

    public static boolean isUserDialog(long dialogId) {
        return (isEncryptedDialog(dialogId) || isFolderDialogId(dialogId) || dialogId <= 0) ? false : true;
    }
}
