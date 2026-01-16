package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$RecentMeUrl extends TLObject {
    public long chat_id;
    public TLRPC$ChatInvite chat_invite;
    public TLRPC$StickerSetCovered set;
    public String url;
    public long user_id;

    public static TLRPC$RecentMeUrl TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$RecentMeUrl tLRPC$RecentMeUrl;
        switch (constructor) {
            case -1294306862:
                tLRPC$RecentMeUrl = new TLRPC$RecentMeUrl() { // from class: ir.eitaa.tgnet.TLRPC$TL_recentMeUrlChat
                    public static int constructor = -1294306862;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.url = stream2.readString(exception2);
                        this.chat_id = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.url);
                        stream2.writeInt64(this.chat_id);
                    }
                };
                break;
            case -1188296222:
                tLRPC$RecentMeUrl = new TLRPC$RecentMeUrl() { // from class: ir.eitaa.tgnet.TLRPC$TL_recentMeUrlUser
                    public static int constructor = -1188296222;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.url = stream2.readString(exception2);
                        this.user_id = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.url);
                        stream2.writeInt64(this.user_id);
                    }
                };
                break;
            case -1140172836:
                tLRPC$RecentMeUrl = new TLRPC$RecentMeUrl() { // from class: ir.eitaa.tgnet.TLRPC$TL_recentMeUrlStickerSet
                    public static int constructor = -1140172836;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.url = stream2.readString(exception2);
                        this.set = TLRPC$StickerSetCovered.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.url);
                        this.set.serializeToStream(stream2);
                    }
                };
                break;
            case -347535331:
                tLRPC$RecentMeUrl = new TLRPC$RecentMeUrl() { // from class: ir.eitaa.tgnet.TLRPC$TL_recentMeUrlChatInvite
                    public static int constructor = -347535331;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.url = stream2.readString(exception2);
                        this.chat_invite = TLRPC$ChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.url);
                        this.chat_invite.serializeToStream(stream2);
                    }
                };
                break;
            case 1189204285:
                tLRPC$RecentMeUrl = new TLRPC$RecentMeUrl() { // from class: ir.eitaa.tgnet.TLRPC$TL_recentMeUrlUnknown
                    public static int constructor = 1189204285;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.url = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.url);
                    }
                };
                break;
            default:
                tLRPC$RecentMeUrl = null;
                break;
        }
        if (tLRPC$RecentMeUrl == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in RecentMeUrl", Integer.valueOf(constructor)));
        }
        if (tLRPC$RecentMeUrl != null) {
            tLRPC$RecentMeUrl.readParams(stream, exception);
        }
        return tLRPC$RecentMeUrl;
    }
}
