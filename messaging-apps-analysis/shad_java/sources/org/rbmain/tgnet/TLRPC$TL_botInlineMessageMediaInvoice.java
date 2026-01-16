package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_botInlineMessageMediaInvoice extends TLRPC$BotInlineMessage {
    public static int constructor = 894081801;
    public String currency;
    public String description;
    public TLRPC$WebDocument photo;
    public boolean shipping_address_requested;
    public boolean test;
    public long total_amount;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.shipping_address_requested = (int32 & 2) != 0;
        this.test = (int32 & 8) != 0;
        this.title = abstractSerializedData.readString(z);
        this.description = abstractSerializedData.readString(z);
        if ((this.flags & 1) != 0) {
            this.photo = TLRPC$WebDocument.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.currency = abstractSerializedData.readString(z);
        this.total_amount = abstractSerializedData.readInt64(z);
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
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
            this.photo.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeString(this.currency);
        abstractSerializedData.writeInt64(this.total_amount);
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(abstractSerializedData);
        }
    }
}
