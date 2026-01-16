package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionParticipantVolume extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1048537159;
    public TLRPC$TL_groupCallParticipant participant;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.participant = TLRPC$TL_groupCallParticipant.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.participant.serializeToStream(stream);
    }
}
