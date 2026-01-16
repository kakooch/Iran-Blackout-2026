package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_invoice extends TLObject {
    public static int constructor = 215516896;
    public String currency;
    public boolean email_requested;
    public boolean email_to_provider;
    public int flags;
    public boolean flexible;
    public long max_tip_amount;
    public boolean name_requested;
    public boolean phone_requested;
    public boolean phone_to_provider;
    public boolean shipping_address_requested;
    public boolean test;
    public ArrayList<TLRPC$TL_labeledPrice> prices = new ArrayList<>();
    public ArrayList<Long> suggested_tip_amounts = new ArrayList<>();

    public static TLRPC$TL_invoice TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_invoice", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_invoice tLRPC$TL_invoice = new TLRPC$TL_invoice();
        tLRPC$TL_invoice.readParams(stream, exception);
        return tLRPC$TL_invoice;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.test = (int32 & 1) != 0;
        this.name_requested = (int32 & 2) != 0;
        this.phone_requested = (int32 & 4) != 0;
        this.email_requested = (int32 & 8) != 0;
        this.shipping_address_requested = (int32 & 16) != 0;
        this.flexible = (int32 & 32) != 0;
        this.phone_to_provider = (int32 & 64) != 0;
        this.email_to_provider = (int32 & 128) != 0;
        this.currency = stream.readString(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_labeledPrice tLRPC$TL_labeledPriceTLdeserialize = TLRPC$TL_labeledPrice.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_labeledPriceTLdeserialize == null) {
                return;
            }
            this.prices.add(tLRPC$TL_labeledPriceTLdeserialize);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.max_tip_amount = stream.readInt64(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            int int324 = stream.readInt32(exception);
            if (int324 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
            } else {
                int int325 = stream.readInt32(exception);
                for (int i2 = 0; i2 < int325; i2++) {
                    this.suggested_tip_amounts.add(Long.valueOf(stream.readInt64(exception)));
                }
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.test ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.name_requested ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.phone_requested ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.email_requested ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.shipping_address_requested ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        int i6 = this.flexible ? i5 | 32 : i5 & (-33);
        this.flags = i6;
        int i7 = this.phone_to_provider ? i6 | 64 : i6 & (-65);
        this.flags = i7;
        int i8 = this.email_to_provider ? i7 | 128 : i7 & (-129);
        this.flags = i8;
        stream.writeInt32(i8);
        stream.writeString(this.currency);
        stream.writeInt32(481674261);
        int size = this.prices.size();
        stream.writeInt32(size);
        for (int i9 = 0; i9 < size; i9++) {
            this.prices.get(i9).serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            stream.writeInt64(this.max_tip_amount);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.suggested_tip_amounts.size();
            stream.writeInt32(size2);
            for (int i10 = 0; i10 < size2; i10++) {
                stream.writeInt64(this.suggested_tip_amounts.get(i10).longValue());
            }
        }
    }
}
