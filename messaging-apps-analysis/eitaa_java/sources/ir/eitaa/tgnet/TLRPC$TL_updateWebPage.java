package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateWebPage extends TLRPC$Update {
    public static int constructor = 2139689491;
    public int pts;
    public int pts_count;
    public TLRPC$WebPage webpage;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.webpage = TLRPC$WebPage.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.webpage.serializeToStream(stream);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
