package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_botInlineMessageMediaInvoice extends TLRPC$BotInlineMessage {
    public static int constructor = 894081801;
    public String currency;
    public String description;
    public TLRPC$WebDocument photo;
    public boolean shipping_address_requested;
    public boolean test;
    public long total_amount;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.shipping_address_requested = (int32 & 2) != 0;
        this.test = (int32 & 8) != 0;
        this.title = stream.readString(exception);
        this.description = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            this.photo = TLRPC$WebDocument.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.currency = stream.readString(exception);
        this.total_amount = stream.readInt64(exception);
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.shipping_address_requested ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.test ? i | 8 : i & (-9);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeString(this.title);
        stream.writeString(this.description);
        if ((this.flags & 1) != 0) {
            this.photo.serializeToStream(stream);
        }
        stream.writeString(this.currency);
        stream.writeInt64(this.total_amount);
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(stream);
        }
    }
}
