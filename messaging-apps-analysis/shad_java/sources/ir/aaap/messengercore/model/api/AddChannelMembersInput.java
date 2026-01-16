package ir.aaap.messengercore.model.api;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddChannelMembersInput {
    public String channel_guid;
    public ArrayList<String> member_guids;

    public AddChannelMembersInput(String str, ArrayList<String> arrayList) {
        this.channel_guid = str;
        this.member_guids = arrayList;
    }
}
