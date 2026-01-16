package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class GetChannelAdminAccessInput {
    public String channel_guid;
    public String member_guid;

    public GetChannelAdminAccessInput(String str, String str2) {
        this.channel_guid = str;
        this.member_guid = str2;
    }
}
