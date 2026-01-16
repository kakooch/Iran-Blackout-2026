package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddChannelInput {
    public ChannelInfoFromServer.ChannelTypeEnum channel_type;
    public String description;
    public String main_file_id;
    public ArrayList<String> member_guids;
    public String thumbnail_file_id;
    public String title;
}
