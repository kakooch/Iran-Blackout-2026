package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_getTmpPassword extends TLObject {
    public static int constructor = 1151208273;
    public TLRPC$InputCheckPasswordSRP password;
    public int period;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_account_tmpPassword.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.password.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.period);
    }
}
