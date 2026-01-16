package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_auth_requestPasswordRecovery extends TLObject {
    public static int constructor = -661144474;
    public String phoneNumber;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_auth_passwordRecovery.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
