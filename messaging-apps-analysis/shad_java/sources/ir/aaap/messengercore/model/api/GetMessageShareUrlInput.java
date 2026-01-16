package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class GetMessageShareUrlInput {
    public long message_id;
    public String object_guid;

    public GetMessageShareUrlInput(String str, long j) {
        this.object_guid = str;
        this.message_id = j;
    }
}
