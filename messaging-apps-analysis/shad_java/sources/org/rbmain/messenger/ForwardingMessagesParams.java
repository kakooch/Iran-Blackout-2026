package org.rbmain.messenger;

import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import org.rbmain.messenger.MessageObject;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_pollAnswerVoters;

/* loaded from: classes4.dex */
public class ForwardingMessagesParams {
    public boolean hasCaption;
    public boolean hasSenders;
    public boolean hasSpoilers;
    public boolean hideCaption;
    public boolean hideForwardSendersName;
    public boolean isSecret;
    public ArrayList<MessageObject> messages;
    public boolean multiplyUsers;
    public boolean willSeeSenders;
    public LongSparseArray<MessageObject.GroupedMessages> groupedMessagesMap = new LongSparseArray<>();
    public ArrayList<MessageObject> previewMessages = new ArrayList<>();
    public LongSparseArray<Boolean> selectedIds = new LongSparseArray<>();
    public ArrayList<TLRPC$TL_pollAnswerVoters> pollChoosenAnswers = new ArrayList<>();

    /* JADX WARN: Removed duplicated region for block: B:41:0x011c  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ForwardingMessagesParams(java.util.ArrayList<org.rbmain.messenger.MessageObject> r18, long r19) {
        /*
            Method dump skipped, instructions count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ForwardingMessagesParams.<init>(java.util.ArrayList, long):void");
    }

    public void getSelectedMessages(ArrayList<MessageObject> arrayList) {
        arrayList.clear();
        for (int i = 0; i < this.messages.size(); i++) {
            MessageObject messageObject = this.messages.get(i);
            if (this.selectedIds.get(messageObject.getId(), Boolean.FALSE).booleanValue()) {
                arrayList.add(messageObject);
            }
        }
    }

    public class PreviewMediaPoll extends TLRPC$TL_messageMediaPoll {
        public int totalVotersCached;

        public PreviewMediaPoll() {
        }
    }
}
