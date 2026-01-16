package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_error extends TLObject {
    public static int constructor = -994444869;
    public int code;
    public String text;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.code = stream.readInt32(exception);
        this.text = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.code);
        stream.writeString(this.text);
    }
}
