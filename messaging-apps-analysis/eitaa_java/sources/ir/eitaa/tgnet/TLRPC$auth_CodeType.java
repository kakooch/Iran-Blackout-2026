package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$auth_CodeType extends TLObject {
    public static TLRPC$auth_CodeType TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$auth_CodeType tLRPC$auth_CodeType;
        if (constructor == 577556219) {
            tLRPC$auth_CodeType = new TLRPC$auth_CodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeFlashCall
                public static int constructor = 577556219;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else if (constructor == 1923290508) {
            tLRPC$auth_CodeType = new TLRPC$auth_CodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeSms
                public static int constructor = 1923290508;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$auth_CodeType = constructor != 1948046307 ? null : new TLRPC$auth_CodeType() { // from class: ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeCall
                public static int constructor = 1948046307;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$auth_CodeType == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in auth_CodeType", Integer.valueOf(constructor)));
        }
        if (tLRPC$auth_CodeType != null) {
            tLRPC$auth_CodeType.readParams(stream, exception);
        }
        return tLRPC$auth_CodeType;
    }
}
