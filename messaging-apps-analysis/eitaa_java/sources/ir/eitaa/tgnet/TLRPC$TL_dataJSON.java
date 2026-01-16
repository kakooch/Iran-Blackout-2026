package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_dataJSON extends TLObject {
    public static int constructor = 2104790276;
    public String data;

    public static TLRPC$TL_dataJSON TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_dataJSON", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
        tLRPC$TL_dataJSON.readParams(stream, exception);
        return tLRPC$TL_dataJSON;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.data = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.data);
    }
}
