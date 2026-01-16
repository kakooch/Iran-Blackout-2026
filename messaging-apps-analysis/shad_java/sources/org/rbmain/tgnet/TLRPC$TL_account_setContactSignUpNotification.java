package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_setContactSignUpNotification extends TLObject {
    public static int constructor = -806076575;
    public boolean silent;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeBool(this.silent);
    }
}
