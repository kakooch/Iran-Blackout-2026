package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockBlockquote extends TLRPC$PageBlock {
    public static int constructor = 641563686;
    public TLRPC$RichText caption;
    public TLRPC$RichText text;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.caption = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.text.serializeToStream(stream);
        this.caption.serializeToStream(stream);
    }
}
