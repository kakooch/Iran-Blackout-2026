package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_webAuthorization extends TLObject {
    public static int constructor = -1493633966;
    public long bot_id;
    public String browser;
    public int date_active;
    public int date_created;
    public String domain;
    public long hash;
    public String ip;
    public String platform;
    public String region;

    public static TLRPC$TL_webAuthorization TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_webAuthorization", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_webAuthorization tLRPC$TL_webAuthorization = new TLRPC$TL_webAuthorization();
        tLRPC$TL_webAuthorization.readParams(stream, exception);
        return tLRPC$TL_webAuthorization;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hash = stream.readInt64(exception);
        this.bot_id = stream.readInt64(exception);
        this.domain = stream.readString(exception);
        this.browser = stream.readString(exception);
        this.platform = stream.readString(exception);
        this.date_created = stream.readInt32(exception);
        this.date_active = stream.readInt32(exception);
        this.ip = stream.readString(exception);
        this.region = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
        stream.writeInt64(this.bot_id);
        stream.writeString(this.domain);
        stream.writeString(this.browser);
        stream.writeString(this.platform);
        stream.writeInt32(this.date_created);
        stream.writeInt32(this.date_active);
        stream.writeString(this.ip);
        stream.writeString(this.region);
    }
}
