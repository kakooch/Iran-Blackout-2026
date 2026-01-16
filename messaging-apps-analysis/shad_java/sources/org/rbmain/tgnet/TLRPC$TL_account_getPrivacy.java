package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_getPrivacy extends TLObject {
    public static int constructor = -623130288;
    public TLRPC$InputPrivacyKey key;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_account_privacyRules.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.key.serializeToStream(abstractSerializedData);
    }
}
