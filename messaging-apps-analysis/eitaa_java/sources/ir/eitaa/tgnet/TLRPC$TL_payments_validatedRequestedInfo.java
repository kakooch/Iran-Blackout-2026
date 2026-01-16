package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_validatedRequestedInfo extends TLObject {
    public static int constructor = -784000893;
    public int flags;
    public String id;
    public ArrayList<TLRPC$TL_shippingOption> shipping_options = new ArrayList<>();

    public static TLRPC$TL_payments_validatedRequestedInfo TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_payments_validatedRequestedInfo", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_payments_validatedRequestedInfo tLRPC$TL_payments_validatedRequestedInfo = new TLRPC$TL_payments_validatedRequestedInfo();
        tLRPC$TL_payments_validatedRequestedInfo.readParams(stream, exception);
        return tLRPC$TL_payments_validatedRequestedInfo;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.id = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$TL_shippingOption tLRPC$TL_shippingOptionTLdeserialize = TLRPC$TL_shippingOption.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_shippingOptionTLdeserialize == null) {
                    return;
                }
                this.shipping_options.add(tLRPC$TL_shippingOptionTLdeserialize);
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.id);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size = this.shipping_options.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.shipping_options.get(i).serializeToStream(stream);
            }
        }
    }
}
