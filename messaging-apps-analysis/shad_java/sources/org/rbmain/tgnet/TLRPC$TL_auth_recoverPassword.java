package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_auth_recoverPassword extends TLObject {
    public static int constructor = 1319464594;
    public String code;
    public String hashCode;
    public String phoneNumber;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$auth_Authorization.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.code);
    }
}
