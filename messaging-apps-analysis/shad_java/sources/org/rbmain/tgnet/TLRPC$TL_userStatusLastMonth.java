package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_userStatusLastMonth extends TLRPC$UserStatus {
    public static int constructor = 2011940674;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
