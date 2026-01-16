package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatFromServer;
import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class GetUserInfoOutput {
    public boolean can_receive_call;
    public boolean can_video_call;
    public ChatFromServer chat;
    public long count_common_groups;
    public boolean is_in_contact;
    public long timestamp;
    public UserInfoFromServer user;
}
