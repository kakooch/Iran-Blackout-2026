package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_jsonString extends TLRPC$JSONValue {
    public static int constructor = -1222740358;
    public String value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.value = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.value);
    }
}
