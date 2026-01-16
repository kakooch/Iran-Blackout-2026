package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_DhConfig extends TLObject {
    public int g;
    public byte[] p;
    public byte[] random;
    public int version;

    public static TLRPC$messages_DhConfig TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_DhConfig tLRPC$TL_messages_dhConfig;
        if (i == -1058912715) {
            tLRPC$TL_messages_dhConfig = new TLRPC$messages_DhConfig() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_dhConfigNotModified
                public static int constructor = -1058912715;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.random = abstractSerializedData2.readByteArray(z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeByteArray(this.random);
                }
            };
        } else {
            tLRPC$TL_messages_dhConfig = i != 740433629 ? null : new TLRPC$TL_messages_dhConfig();
        }
        if (tLRPC$TL_messages_dhConfig == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_DhConfig", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_dhConfig != null) {
            tLRPC$TL_messages_dhConfig.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_dhConfig;
    }
}
