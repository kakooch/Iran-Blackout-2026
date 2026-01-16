package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChannelWebPage extends TLRPC$Update {
    public static int constructor = 791390623;
    public long channel_id;
    public int pts;
    public int pts_count;
    public TLRPC$WebPage webpage;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
        this.webpage = TLRPC$WebPage.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
        this.webpage.serializeToStream(stream);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
