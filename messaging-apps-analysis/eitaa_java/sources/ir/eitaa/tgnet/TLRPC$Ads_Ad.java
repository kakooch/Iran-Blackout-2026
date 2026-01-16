package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$Ads_Ad extends TLObject {
    public TLRPC$Ads_ClickAction action;
    public int flags;
    public boolean highlight;
    public int id;
    public ArrayList<TLRPC$PhotoSize> photos = new ArrayList<>();
    public String title;

    public static TLRPC$Ads_Ad TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Ads_Ad tLRPC$TL_ads_emptyAd;
        if (constructor == -1837458077) {
            tLRPC$TL_ads_emptyAd = new TLRPC$Ads_Ad() { // from class: ir.eitaa.tgnet.TLRPC$TL_ads_simpleAd
                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream2, int constructor2, boolean exception2) {
                    return TLRPC$Ads_Ad.TLdeserialize(stream2, constructor2, exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.flags = stream2.readInt32(exception2);
                    this.id = stream2.readInt32(exception2);
                    if ((this.flags & 1) != 0) {
                        this.title = stream2.readString(exception2);
                    }
                    if ((this.flags & 2) != 0) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhotoSizeTLdeserialize == null) {
                                return;
                            }
                            this.photos.add(tLRPC$PhotoSizeTLdeserialize);
                        }
                    }
                    if ((this.flags & 4) != 0) {
                        this.action = TLRPC$Ads_ClickAction.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }
                    this.highlight = (this.flags & 8) != 0;
                }
            };
        } else if (constructor != -1205172244) {
            tLRPC$TL_ads_emptyAd = constructor != 812057886 ? null : new TLRPC$TL_ads_dialogAd();
        } else {
            tLRPC$TL_ads_emptyAd = new TLRPC$TL_ads_emptyAd();
        }
        if (tLRPC$TL_ads_emptyAd == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Ads_Ad", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_ads_emptyAd != null) {
            tLRPC$TL_ads_emptyAd.readParams(stream, exception);
        }
        return tLRPC$TL_ads_emptyAd;
    }
}
