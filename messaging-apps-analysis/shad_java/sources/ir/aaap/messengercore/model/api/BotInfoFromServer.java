package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.WarningObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BotInfoFromServer {
    public AvatarFileInline avatar_thumbnail;
    public String bot_guid;
    public String bot_title;
    public ArrayList<BotCommandObject> commands;
    public String description;
    public boolean is_deleted;
    public boolean is_verified;
    public String share_url;
    public String start_message;
    public long updated_time;
    public String username;
    public WarningObject warning_info;
}
