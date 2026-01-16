package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class GetGroupMessageReadParticipantsInput {
    public String group_guid;
    public long message_id;

    public GetGroupMessageReadParticipantsInput(String str, long j) {
        this.group_guid = str;
        this.message_id = j;
    }
}
