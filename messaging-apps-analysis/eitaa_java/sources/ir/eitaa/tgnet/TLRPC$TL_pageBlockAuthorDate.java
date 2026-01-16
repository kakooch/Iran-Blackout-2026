package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockAuthorDate extends TLRPC$PageBlock {
    public static int constructor = -1162877472;
    public TLRPC$RichText author;
    public int published_date;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.author = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.published_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.author.serializeToStream(stream);
        stream.writeInt32(this.published_date);
    }
}
