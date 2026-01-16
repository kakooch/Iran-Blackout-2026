package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_shippingOption extends TLObject {
    public static int constructor = -1239335713;
    public String id;
    public ArrayList<TLRPC$TL_labeledPrice> prices = new ArrayList<>();
    public String title;

    public static TLRPC$TL_shippingOption TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_shippingOption", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_shippingOption tLRPC$TL_shippingOption = new TLRPC$TL_shippingOption();
        tLRPC$TL_shippingOption.readParams(stream, exception);
        return tLRPC$TL_shippingOption;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readString(exception);
        this.title = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_labeledPrice tLRPC$TL_labeledPriceTLdeserialize = TLRPC$TL_labeledPrice.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_labeledPriceTLdeserialize == null) {
                return;
            }
            this.prices.add(tLRPC$TL_labeledPriceTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.id);
        stream.writeString(this.title);
        stream.writeInt32(481674261);
        int size = this.prices.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.prices.get(i).serializeToStream(stream);
        }
    }
}
