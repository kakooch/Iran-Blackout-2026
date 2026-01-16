package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_UrlWhiteList extends TLObject {
    public static int constructor = 2096483029;
    public ArrayList<String> urls = new ArrayList<>();

    public static TLRPC$TL_UrlWhiteList TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_ads_AdPack", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_UrlWhiteList tLRPC$TL_UrlWhiteList = new TLRPC$TL_UrlWhiteList();
        tLRPC$TL_UrlWhiteList.readParams(stream, exception);
        return tLRPC$TL_UrlWhiteList;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.urls.add(stream.readString(exception));
            }
        }
    }
}
