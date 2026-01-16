package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_auth_acceptLoginToken extends TLObject {
    public static int constructor = -392909491;
    public byte[] token;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_authorization.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeByteArray(this.token);
    }
}
