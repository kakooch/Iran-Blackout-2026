package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$auth_SentCodeType extends TLObject {
    public int length;
    public String pattern;

    public static TLRPC$auth_SentCodeType TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$auth_SentCodeType tLRPC$TL_auth_sentCodeTypeSms;
        switch (i) {
            case -1425815847:
                tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$auth_SentCodeType() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall
                    public static int constructor = -1425815847;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.pattern = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeString(this.pattern);
                    }
                };
                break;
            case -1073693790:
                tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$TL_auth_sentCodeTypeSms();
                break;
            case 1035688326:
                tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$auth_SentCodeType() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeApp
                    public static int constructor = 1035688326;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.length = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.length);
                    }
                };
                break;
            case 1398007207:
                tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$auth_SentCodeType() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeCall
                    public static int constructor = 1398007207;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.length = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.length);
                    }
                };
                break;
            default:
                tLRPC$TL_auth_sentCodeTypeSms = null;
                break;
        }
        if (tLRPC$TL_auth_sentCodeTypeSms == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in auth_SentCodeType", Integer.valueOf(i)));
        }
        if (tLRPC$TL_auth_sentCodeTypeSms != null) {
            tLRPC$TL_auth_sentCodeTypeSms.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_auth_sentCodeTypeSms;
    }
}
