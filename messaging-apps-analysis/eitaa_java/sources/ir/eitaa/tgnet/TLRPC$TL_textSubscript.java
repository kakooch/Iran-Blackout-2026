package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_textSubscript extends TLRPC$RichText {
    public static int constructor = -311786236;
    public TLRPC$RichText text;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.text.serializeToStream(stream);
    }
}
