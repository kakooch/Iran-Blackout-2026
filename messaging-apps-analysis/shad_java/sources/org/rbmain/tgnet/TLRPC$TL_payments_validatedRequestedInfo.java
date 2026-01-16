package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_payments_validatedRequestedInfo extends TLObject {
    public static int constructor = -784000893;
    public int flags;
    public String id;
    public ArrayList<TLRPC$TL_shippingOption> shipping_options = new ArrayList<>();

    public static TLRPC$TL_payments_validatedRequestedInfo TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_payments_validatedRequestedInfo", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_payments_validatedRequestedInfo tLRPC$TL_payments_validatedRequestedInfo = new TLRPC$TL_payments_validatedRequestedInfo();
        tLRPC$TL_payments_validatedRequestedInfo.readParams(abstractSerializedData, z);
        return tLRPC$TL_payments_validatedRequestedInfo;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.id = abstractSerializedData.readString(z);
        }
        if ((this.flags & 2) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$TL_shippingOption tLRPC$TL_shippingOptionTLdeserialize = TLRPC$TL_shippingOption.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$TL_shippingOptionTLdeserialize == null) {
                    return;
                }
                this.shipping_options.add(tLRPC$TL_shippingOptionTLdeserialize);
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.id);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.shipping_options.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.shipping_options.get(i).serializeToStream(abstractSerializedData);
            }
        }
    }
}
