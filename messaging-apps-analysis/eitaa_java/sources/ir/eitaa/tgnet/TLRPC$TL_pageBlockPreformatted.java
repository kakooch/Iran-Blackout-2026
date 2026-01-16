package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockPreformatted extends TLRPC$PageBlock {
    public static int constructor = -1066346178;
    public String language;
    public TLRPC$RichText text;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.language = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.text.serializeToStream(stream);
        stream.writeString(this.language);
    }
}
