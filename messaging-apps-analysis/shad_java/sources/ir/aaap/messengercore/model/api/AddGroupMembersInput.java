package ir.aaap.messengercore.model.api;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddGroupMembersInput {
    public String group_guid;
    public ArrayList<String> member_guids;

    public AddGroupMembersInput(String str, ArrayList<String> arrayList) {
        this.group_guid = str;
        this.member_guids = arrayList;
    }
}
