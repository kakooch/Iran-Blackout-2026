package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_updatePasswordSettings extends TLObject {
    public static int constructor = -1516564433;
    public boolean abort;
    public boolean clear;
    public String newPass;
    public TLRPC$TL_account_passwordInputSettings new_settings;
    public byte[] oldPass;
    public TLRPC$InputCheckPasswordSRP password;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.password.serializeToStream(abstractSerializedData);
        this.new_settings.serializeToStream(abstractSerializedData);
    }
}
