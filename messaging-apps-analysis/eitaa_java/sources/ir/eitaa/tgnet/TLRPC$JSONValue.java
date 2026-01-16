package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$JSONValue extends TLObject {
    public static TLRPC$JSONValue TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$JSONValue tLRPC$TL_jsonObject;
        switch (constructor) {
            case -1715350371:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonObject();
                break;
            case -1222740358:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonString();
                break;
            case -952869270:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonBool();
                break;
            case -146520221:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonArray();
                break;
            case 736157604:
                tLRPC$TL_jsonObject = new TLRPC$TL_jsonNumber();
                break;
            case 1064139624:
                tLRPC$TL_jsonObject = new TLRPC$JSONValue() { // from class: ir.eitaa.tgnet.TLRPC$TL_jsonNull
                    public static int constructor = 1064139624;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_jsonObject = null;
                break;
        }
        if (tLRPC$TL_jsonObject == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in JSONValue", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_jsonObject != null) {
            tLRPC$TL_jsonObject.readParams(stream, exception);
        }
        return tLRPC$TL_jsonObject;
    }
}
