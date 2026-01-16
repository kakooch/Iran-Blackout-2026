package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_textAnchor extends TLRPC$RichText {
    public static int constructor = 894777186;
    public String name;
    public TLRPC$RichText text;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.name = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.text.serializeToStream(stream);
        stream.writeString(this.name);
    }
}
