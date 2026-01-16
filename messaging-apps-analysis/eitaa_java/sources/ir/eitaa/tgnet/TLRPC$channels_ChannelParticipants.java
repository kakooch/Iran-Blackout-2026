package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$channels_ChannelParticipants extends TLObject {
    public ArrayList<TLRPC$ChannelParticipant> participants = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$channels_ChannelParticipants TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$channels_ChannelParticipants tLRPC$TL_channels_channelParticipants;
        if (constructor == -1699676497) {
            tLRPC$TL_channels_channelParticipants = new TLRPC$TL_channels_channelParticipants();
        } else {
            tLRPC$TL_channels_channelParticipants = constructor != -266911767 ? null : new TLRPC$channels_ChannelParticipants() { // from class: ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipantsNotModified
                public static int constructor = -266911767;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_channels_channelParticipants == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in channels_ChannelParticipants", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_channels_channelParticipants != null) {
            tLRPC$TL_channels_channelParticipants.readParams(stream, exception);
        }
        return tLRPC$TL_channels_channelParticipants;
    }
}
