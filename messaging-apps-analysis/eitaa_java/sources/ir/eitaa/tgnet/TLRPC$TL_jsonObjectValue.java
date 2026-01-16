package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_jsonObjectValue extends TLObject {
    public static int constructor = -1059185703;
    public String key;
    public TLRPC$JSONValue value;

    public static TLRPC$TL_jsonObjectValue TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_jsonObjectValue", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValue = new TLRPC$TL_jsonObjectValue();
        tLRPC$TL_jsonObjectValue.readParams(stream, exception);
        return tLRPC$TL_jsonObjectValue;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.key = stream.readString(exception);
        this.value = TLRPC$JSONValue.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.key);
        this.value.serializeToStream(stream);
    }
}
