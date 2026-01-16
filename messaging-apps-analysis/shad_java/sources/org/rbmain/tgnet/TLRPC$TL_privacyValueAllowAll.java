package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_privacyValueAllowAll extends TLRPC$PrivacyRule {
    public static int constructor = 1698855810;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
