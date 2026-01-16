package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.ChatFromServer;
import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class GetObjectByUsernameOutput {
    public BotInfoFromServer bot;
    public boolean can_receive_call;
    public boolean can_video_call;
    public ChannelInfoFromServer channel;
    public ChatFromServer chat;
    public long count_common_groups;
    public boolean exist;
    public long timestamp;
    public Type type;
    public UserInfoFromServer user;

    public enum Type {
        User,
        Channel,
        Bot
    }
}
