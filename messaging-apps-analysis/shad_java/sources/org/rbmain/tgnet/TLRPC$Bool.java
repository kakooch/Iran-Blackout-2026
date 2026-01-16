package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$Bool extends TLObject {
    public static TLRPC$Bool TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Bool tLRPC$TL_boolTrue;
        if (i == -1720552011) {
            tLRPC$TL_boolTrue = new TLRPC$TL_boolTrue();
        } else {
            tLRPC$TL_boolTrue = i != -1132882121 ? null : new TLRPC$Bool() { // from class: org.rbmain.tgnet.TLRPC$TL_boolFalse
                public static int constructor = -1132882121;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_boolTrue == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Bool", Integer.valueOf(i)));
        }
        if (tLRPC$TL_boolTrue != null) {
            tLRPC$TL_boolTrue.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_boolTrue;
    }
}
