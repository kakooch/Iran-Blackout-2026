package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_AdPack extends TLObject {
    public static int constructor = -545239366;
    public ArrayList<TLRPC$Ads_Ad> ads = new ArrayList<>();
    public String title;

    public static TLRPC$TL_ads_AdPack TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_ads_AdPack", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_ads_AdPack tLRPC$TL_ads_AdPack = new TLRPC$TL_ads_AdPack();
        tLRPC$TL_ads_AdPack.readParams(stream, exception);
        return tLRPC$TL_ads_AdPack;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
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
            TLRPC$Ads_Ad tLRPC$Ads_AdTLdeserialize = TLRPC$Ads_Ad.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$Ads_AdTLdeserialize == null) {
                return;
            }
            this.ads.add(tLRPC$Ads_AdTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.title);
        stream.writeInt32(481674261);
        int size = this.ads.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.ads.get(i).serializeToStream(stream);
        }
    }
}
