package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_cancelPasswordEmail extends TLObject {
    public static int constructor = -1043606090;
    public byte[] password;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
