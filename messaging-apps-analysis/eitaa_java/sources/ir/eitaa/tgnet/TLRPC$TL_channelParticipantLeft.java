package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelParticipantLeft extends TLRPC$ChannelParticipant {
    public static int constructor = 453242886;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
    }
}
