package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputPrivacyKeyAddedByPhone extends TLRPC$InputPrivacyKey {
    public static int constructor = -786326563;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
