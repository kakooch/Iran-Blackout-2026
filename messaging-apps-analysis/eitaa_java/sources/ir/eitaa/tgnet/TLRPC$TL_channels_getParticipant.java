package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_getParticipant extends TLObject {
    public static int constructor = -1599378234;
    public TLRPC$InputChannel channel;
    public TLRPC$InputPeer participant;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_channels_channelParticipant.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.participant.serializeToStream(stream);
    }
}
