package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_getParticipants extends TLObject {
    public static int constructor = 2010044880;
    public TLRPC$InputChannel channel;
    public TLRPC$ChannelParticipantsFilter filter;
    public long hash;
    public int limit;
    public int offset;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$channels_ChannelParticipants.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.filter.serializeToStream(stream);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.limit);
        stream.writeInt64(this.hash);
    }
}
