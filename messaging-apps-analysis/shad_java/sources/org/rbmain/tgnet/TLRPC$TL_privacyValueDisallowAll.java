package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_privacyValueDisallowAll extends TLRPC$PrivacyRule {
    public static int constructor = -1955338397;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
