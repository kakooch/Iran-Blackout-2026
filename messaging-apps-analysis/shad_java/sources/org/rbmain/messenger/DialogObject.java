package org.rbmain.messenger;

import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$DraftMessage;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_dialogAd;
import org.rbmain.tgnet.TLRPC$TL_dialogFolder;

/* loaded from: classes4.dex */
public class DialogObject {
    public static int getEncryptedChatId(long j) {
        return (int) (j & 4294967295L);
    }

    public static boolean isChatDialog(long j) {
        return j < 0;
    }

    public static boolean isEncryptedDialog(long j) {
        return false;
    }

    public static boolean isFolderDialogId(long j) {
        return ((int) j) != 0 && ((int) (j >> 32)) == 2;
    }

    public static boolean isPeerDialogId(long j) {
        int i = (int) (j >> 32);
        return (((int) j) == 0 || i == 2 || i == 1) ? false : true;
    }

    public static boolean isSecretDialogId(long j) {
        return ((int) j) == 0;
    }

    public static boolean isUserDialog(long j) {
        return j > 0;
    }

    public static long makeEncryptedDialogId(int i) {
        return i;
    }

    public static long makeFolderDialogId(int i) {
        return i | 8589934592L;
    }

    public static long makeSecretDialogId(int i) {
        return i << 32;
    }

    public static boolean isChannel(TLRPC$Dialog tLRPC$Dialog) {
        return (tLRPC$Dialog == null || (tLRPC$Dialog.flags & 1) == 0) ? false : true;
    }

    public static void initDialog(TLRPC$Dialog tLRPC$Dialog) {
        if (tLRPC$Dialog == null || tLRPC$Dialog.id != 0) {
            return;
        }
        if (tLRPC$Dialog instanceof TLRPC$TL_dialog) {
            TLRPC$Peer tLRPC$Peer = tLRPC$Dialog.peer;
            if (tLRPC$Peer == null) {
                return;
            }
            int i = tLRPC$Peer.user_id;
            if (i != 0) {
                tLRPC$Dialog.id = i;
                return;
            }
            if (tLRPC$Peer.chat_id != 0) {
                tLRPC$Dialog.id = -r1;
                return;
            } else {
                tLRPC$Dialog.id = -tLRPC$Peer.channel_id;
                return;
            }
        }
        if (tLRPC$Dialog instanceof TLRPC$TL_dialogFolder) {
            tLRPC$Dialog.id = makeFolderDialogId(((TLRPC$TL_dialogFolder) tLRPC$Dialog).folder.id);
        }
    }

    public static long getPeerDialogId(TLRPC$Peer tLRPC$Peer) {
        if (tLRPC$Peer == null) {
            return 0L;
        }
        int i = tLRPC$Peer.user_id;
        if (i != 0) {
            return i;
        }
        return tLRPC$Peer.chat_id != 0 ? -r0 : -tLRPC$Peer.channel_id;
    }

    public static long getPeerDialogId(TLRPC$InputPeer tLRPC$InputPeer) {
        if (tLRPC$InputPeer == null) {
            return 0L;
        }
        int i = tLRPC$InputPeer.user_id;
        if (i != 0) {
            return i;
        }
        return tLRPC$InputPeer.chat_id != 0 ? -r0 : -tLRPC$InputPeer.channel_id;
    }

    public static long getLastMessageOrDraftDate(TLRPC$Dialog tLRPC$Dialog, TLRPC$DraftMessage tLRPC$DraftMessage) {
        int i;
        return (tLRPC$DraftMessage == null || (i = tLRPC$DraftMessage.date) < tLRPC$Dialog.last_message_date) ? tLRPC$Dialog.last_message_date : i;
    }

    public static boolean isAdsDialog(TLRPC$Dialog tLRPC$Dialog) {
        return tLRPC$Dialog instanceof TLRPC$TL_dialogAd;
    }
}
