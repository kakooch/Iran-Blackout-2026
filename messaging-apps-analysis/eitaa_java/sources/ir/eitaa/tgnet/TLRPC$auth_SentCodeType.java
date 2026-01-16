package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$auth_SentCodeType extends TLObject {
    public int length;
    public String pattern;

    public static TLRPC$auth_SentCodeType TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$auth_SentCodeType tLRPC$auth_SentCodeType;
        switch (constructor) {
            case -1425815847:
                tLRPC$auth_SentCodeType = new TLRPC$auth_SentCodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall
                    public static int constructor = -1425815847;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.pattern = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.pattern);
                    }
                };
                break;
            case -1073693790:
                tLRPC$auth_SentCodeType = new TLRPC$auth_SentCodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeSms
                    public static int constructor = -1073693790;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.length = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.length);
                    }
                };
                break;
            case 1035688326:
                tLRPC$auth_SentCodeType = new TLRPC$auth_SentCodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeApp
                    public static int constructor = 1035688326;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.length = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.length);
                    }
                };
                break;
            case 1398007207:
                tLRPC$auth_SentCodeType = new TLRPC$auth_SentCodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeCall
                    public static int constructor = 1398007207;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.length = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.length);
                    }
                };
                break;
            default:
                tLRPC$auth_SentCodeType = null;
                break;
        }
        if (tLRPC$auth_SentCodeType == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in auth_SentCodeType", Integer.valueOf(constructor)));
        }
        if (tLRPC$auth_SentCodeType != null) {
            tLRPC$auth_SentCodeType.readParams(stream, exception);
        }
        return tLRPC$auth_SentCodeType;
    }
}
