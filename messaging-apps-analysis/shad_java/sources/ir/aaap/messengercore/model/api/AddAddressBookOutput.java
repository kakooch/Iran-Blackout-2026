package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.Link;
import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class AddAddressBookOutput {
    public ChatUpdateObject chat_update;
    public Link invite_link;
    public long timestamp;
    public UserInfoFromServer user;
    public boolean user_exist;
}
