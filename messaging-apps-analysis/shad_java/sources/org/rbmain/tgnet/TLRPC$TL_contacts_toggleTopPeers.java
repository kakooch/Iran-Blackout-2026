package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_contacts_toggleTopPeers extends TLObject {
    public static int constructor = -2062238246;
    public boolean enabled;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeBool(this.enabled);
    }
}
