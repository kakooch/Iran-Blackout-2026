package ir.aaap.messengercore.model.api;

/* loaded from: classes3.dex */
public class GetGroupAdminAccessListInput {
    public String group_guid;
    public String member_guid;

    public GetGroupAdminAccessListInput(String str, String str2) {
        this.group_guid = str;
        this.member_guid = str2;
    }
}
