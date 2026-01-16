package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;

/* loaded from: classes3.dex */
public class UpdateChannelUsernameOutput {
    public ChannelInfoFromServer channel;
    public StatusEnum status;
    public long timestamp;

    public enum StatusEnum {
        OK,
        UsernameExist
    }
}
