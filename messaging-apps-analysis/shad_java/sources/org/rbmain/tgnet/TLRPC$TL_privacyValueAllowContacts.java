package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_privacyValueAllowContacts extends TLRPC$PrivacyRule {
    public static int constructor = -123988;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
