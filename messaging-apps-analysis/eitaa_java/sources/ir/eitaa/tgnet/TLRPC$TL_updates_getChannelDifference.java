package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updates_getChannelDifference extends TLObject {
    public static int constructor = 51854712;
    public TLRPC$InputChannel channel;
    public TLRPC$ChannelMessagesFilter filter;
    public int flags;
    public boolean force;
    public int limit;
    public int pts;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$updates_ChannelDifference.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.force ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.channel.serializeToStream(stream);
        serializeToStream(stream);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.limit);
    }
}
