package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_payments_bankCardData extends TLObject {
    public static int constructor = 1042605427;
    public ArrayList<TLRPC$TL_bankCardOpenUrl> open_urls = new ArrayList<>();
    public String title;

    public static TLRPC$TL_payments_bankCardData TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_payments_bankCardData", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_payments_bankCardData tLRPC$TL_payments_bankCardData = new TLRPC$TL_payments_bankCardData();
        tLRPC$TL_payments_bankCardData.readParams(abstractSerializedData, z);
        return tLRPC$TL_payments_bankCardData;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.title = abstractSerializedData.readString(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_bankCardOpenUrl tLRPC$TL_bankCardOpenUrlTLdeserialize = TLRPC$TL_bankCardOpenUrl.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_bankCardOpenUrlTLdeserialize == null) {
                return;
            }
            this.open_urls.add(tLRPC$TL_bankCardOpenUrlTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.title);
        abstractSerializedData.writeInt32(481674261);
        int size = this.open_urls.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.open_urls.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
