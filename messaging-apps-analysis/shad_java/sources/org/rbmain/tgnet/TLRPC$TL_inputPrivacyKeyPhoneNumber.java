package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputPrivacyKeyPhoneNumber extends TLRPC$InputPrivacyKey {
    public static int constructor = 55761658;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
