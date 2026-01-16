package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_verifyEmail extends TLObject {
    public static int constructor = -323339813;
    public String code;
    public String email;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.email);
        abstractSerializedData.writeString(this.code);
    }
}
