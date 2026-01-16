package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_getPasswordSettings extends TLObject {
    public static int constructor = -1663767815;
    public String oldPassword;
    public TLRPC$InputCheckPasswordSRP password;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_account_passwordSettings.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.password.serializeToStream(abstractSerializedData);
    }
}
