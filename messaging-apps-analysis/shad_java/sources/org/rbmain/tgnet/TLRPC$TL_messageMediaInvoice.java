package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageMediaInvoice extends TLRPC$MessageMedia {
    public static int constructor = -2074799289;
    public TLRPC$WebDocument webPhoto;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.shipping_address_requested = (int32 & 2) != 0;
        this.test = (int32 & 8) != 0;
        this.title = abstractSerializedData.readString(z);
        this.description = abstractSerializedData.readString(z);
        if ((this.flags & 1) != 0) {
            this.webPhoto = TLRPC$WebDocument.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 4) != 0) {
            this.receipt_msg_id = abstractSerializedData.readInt32(z);
        }
        this.currency = abstractSerializedData.readString(z);
        this.total_amount = abstractSerializedData.readInt64(z);
        this.start_param = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.shipping_address_requested ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.test ? i | 8 : i & (-9);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeString(this.title);
        abstractSerializedData.writeString(this.description);
        if ((this.flags & 1) != 0) {
            this.webPhoto.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.receipt_msg_id);
        }
        abstractSerializedData.writeString(this.currency);
        abstractSerializedData.writeInt64(this.total_amount);
        abstractSerializedData.writeString(this.start_param);
    }
}
