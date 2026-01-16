package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.Chat;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SetGroupAdminInput {
    public ArrayList<Chat.EnumSetGroupAdminAccess> access_list;
    public AdminActionEnum action;
    public String custom_title;
    public String group_guid;
    public String member_guid;

    public enum AdminActionEnum {
        SetAdmin,
        UnsetAdmin
    }
}
