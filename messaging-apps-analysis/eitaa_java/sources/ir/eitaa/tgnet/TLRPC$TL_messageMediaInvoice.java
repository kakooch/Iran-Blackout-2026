package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaInvoice extends TLRPC$MessageMedia {
    public static int constructor = -2074799289;
    public TLRPC$WebDocument photo;

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
        if ((this.flags & 4) != 0) {
            this.receipt_msg_id = stream.readInt32(exception);
        }
        this.currency = stream.readString(exception);
        this.total_amount = stream.readInt64(exception);
        this.start_param = stream.readString(exception);
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
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.receipt_msg_id);
        }
        stream.writeString(this.currency);
        stream.writeInt64(this.total_amount);
        stream.writeString(this.start_param);
    }
}
