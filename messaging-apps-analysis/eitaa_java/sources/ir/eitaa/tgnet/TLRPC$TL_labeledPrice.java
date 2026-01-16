package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_labeledPrice extends TLObject {
    public static int constructor = -886477832;
    public long amount;
    public String label;

    public static TLRPC$TL_labeledPrice TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_labeledPrice", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_labeledPrice tLRPC$TL_labeledPrice = new TLRPC$TL_labeledPrice();
        tLRPC$TL_labeledPrice.readParams(stream, exception);
        return tLRPC$TL_labeledPrice;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.label = stream.readString(exception);
        this.amount = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.label);
        stream.writeInt64(this.amount);
    }
}
