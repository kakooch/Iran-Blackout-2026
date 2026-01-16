package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_dialogAd extends TLRPC$Ads_Ad {
    public String badge;
    public int expire;
    public String message;
    public boolean muted;
    public boolean pinnedBackground;
    public int type;
    public int unreadCount;
    public boolean verified;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.pinnedBackground = (int32 & 4) != 0;
        this.muted = (int32 & 8) != 0;
        this.verified = (int32 & 16) != 0;
        this.expire = stream.readInt32(exception);
        this.type = stream.readInt32(exception);
        this.id = stream.readInt32(exception);
        this.action = TLRPC$Ads_ClickAction.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.title = stream.readString(exception);
        this.badge = stream.readString(exception);
        this.message = stream.readString(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, 0L, stream, stream.readInt32(exception), exception);
            if (tLRPC$PhotoSizeTLdeserialize == null) {
                return;
            }
            this.photos.add(tLRPC$PhotoSizeTLdeserialize);
        }
        this.unreadCount = stream.readInt32(exception);
    }
}
