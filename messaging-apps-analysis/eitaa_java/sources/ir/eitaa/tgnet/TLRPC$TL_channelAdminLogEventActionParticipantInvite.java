package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionParticipantInvite extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = -484690728;
    public TLRPC$ChannelParticipant participant;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.participant = TLRPC$ChannelParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.participant.serializeToStream(stream);
    }
}
