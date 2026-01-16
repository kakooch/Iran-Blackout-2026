package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_paymentReceipt extends TLObject {
    public static int constructor = 1891958275;
    public long bot_id;
    public String credentials_title;
    public String currency;
    public int date;
    public String description;
    public int flags;
    public TLRPC$TL_paymentRequestedInfo info;
    public TLRPC$TL_invoice invoice;
    public TLRPC$WebDocument photo;
    public long provider_id;
    public TLRPC$TL_shippingOption shipping;
    public long tip_amount;
    public String title;
    public long total_amount;
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_payments_paymentReceipt TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_payments_paymentReceipt", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_payments_paymentReceipt tLRPC$TL_payments_paymentReceipt = new TLRPC$TL_payments_paymentReceipt();
        tLRPC$TL_payments_paymentReceipt.readParams(stream, exception);
        return tLRPC$TL_payments_paymentReceipt;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.date = stream.readInt32(exception);
        this.bot_id = stream.readInt64(exception);
        this.provider_id = stream.readInt64(exception);
        this.title = stream.readString(exception);
        this.description = stream.readString(exception);
        if ((this.flags & 4) != 0) {
            this.photo = TLRPC$WebDocument.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.invoice = TLRPC$TL_invoice.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.info = TLRPC$TL_paymentRequestedInfo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.shipping = TLRPC$TL_shippingOption.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 8) != 0) {
            this.tip_amount = stream.readInt64(exception);
        }
        this.currency = stream.readString(exception);
        this.total_amount = stream.readInt64(exception);
        this.credentials_title = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.date);
        stream.writeInt64(this.bot_id);
        stream.writeInt64(this.provider_id);
        stream.writeString(this.title);
        stream.writeString(this.description);
        if ((this.flags & 4) != 0) {
            this.photo.serializeToStream(stream);
        }
        this.invoice.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            this.info.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            this.shipping.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt64(this.tip_amount);
        }
        stream.writeString(this.currency);
        stream.writeInt64(this.total_amount);
        stream.writeString(this.credentials_title);
        stream.writeInt32(481674261);
        int size = this.users.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.users.get(i).serializeToStream(stream);
        }
    }
}
