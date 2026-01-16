package ir.eitaa.messenger;

import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswerVoters;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ForwardingMessagesParams {
    public boolean hasCaption;
    public boolean hasSenders;
    public boolean hideCaption;
    public boolean hideForwardSendersName;
    public boolean isSecret;
    public ArrayList<MessageObject> messages;
    public boolean multiplyUsers;
    public boolean willSeeSenders;
    public LongSparseArray<MessageObject.GroupedMessages> groupedMessagesMap = new LongSparseArray<>();
    public ArrayList<MessageObject> previewMessages = new ArrayList<>();
    public SparseBooleanArray selectedIds = new SparseBooleanArray();
    public ArrayList<TLRPC$TL_pollAnswerVoters> pollChoosenAnswers = new ArrayList<>();

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ForwardingMessagesParams(java.util.ArrayList<ir.eitaa.messenger.MessageObject> r20, long r21) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ForwardingMessagesParams.<init>(java.util.ArrayList, long):void");
    }

    public void getSelectedMessages(ArrayList<MessageObject> messagesToForward) {
        messagesToForward.clear();
        for (int i = 0; i < this.messages.size(); i++) {
            MessageObject messageObject = this.messages.get(i);
            if (this.selectedIds.get(messageObject.getId(), false)) {
                messagesToForward.add(messageObject);
            }
        }
    }

    public class PreviewMediaPoll extends TLRPC$TL_messageMediaPoll {
        public int totalVotersCached;

        public PreviewMediaPoll() {
        }
    }
}
