package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$auth_CodeType extends TLObject {
    public static TLRPC$auth_CodeType TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$auth_CodeType tLRPC$TL_auth_codeTypeSms;
        if (i == 577556219) {
            tLRPC$TL_auth_codeTypeSms = new TLRPC$auth_CodeType() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_codeTypeFlashCall
                public static int constructor = 577556219;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else if (i == 1923290508) {
            tLRPC$TL_auth_codeTypeSms = new TLRPC$TL_auth_codeTypeSms();
        } else {
            tLRPC$TL_auth_codeTypeSms = i != 1948046307 ? null : new TLRPC$auth_CodeType() { // from class: org.rbmain.tgnet.TLRPC$TL_auth_codeTypeCall
                public static int constructor = 1948046307;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_auth_codeTypeSms == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in auth_CodeType", Integer.valueOf(i)));
        }
        if (tLRPC$TL_auth_codeTypeSms != null) {
            tLRPC$TL_auth_codeTypeSms.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_auth_codeTypeSms;
    }
}
