package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionParticipantToggleAdmin extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = -714643696;
    public TLRPC$ChannelParticipant new_participant;
    public TLRPC$ChannelParticipant prev_participant;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_participant = TLRPC$ChannelParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_participant = TLRPC$ChannelParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.prev_participant.serializeToStream(stream);
        this.new_participant.serializeToStream(stream);
    }
}
