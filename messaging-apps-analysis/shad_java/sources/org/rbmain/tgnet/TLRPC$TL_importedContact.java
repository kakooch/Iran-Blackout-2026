package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_importedContact extends TLObject {
    public static int constructor = -805141448;
    public long client_id;
    public int user_id;

    public static TLRPC$TL_importedContact TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_importedContact", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_importedContact tLRPC$TL_importedContact = new TLRPC$TL_importedContact();
        tLRPC$TL_importedContact.readParams(abstractSerializedData, z);
        return tLRPC$TL_importedContact;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.client_id = abstractSerializedData.readInt64(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        abstractSerializedData.writeInt64(this.client_id);
    }
}
