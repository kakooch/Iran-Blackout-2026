package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_authorization extends TLObject {
    public static int constructor = -1392388579;
    public int api_id;
    public String app_name;
    public String app_version;
    public String country;
    public boolean current;
    public int date_active;
    public int date_created;
    public String device_model;
    public int flags;
    public long hash;
    public String ip;
    public boolean official_app;
    public boolean password_pending;
    public String platform;
    public String region;
    public String system_version;

    public static TLRPC$TL_authorization TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_authorization", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_authorization tLRPC$TL_authorization = new TLRPC$TL_authorization();
        tLRPC$TL_authorization.readParams(stream, exception);
        return tLRPC$TL_authorization;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.current = (int32 & 1) != 0;
        this.official_app = (int32 & 2) != 0;
        this.password_pending = (int32 & 4) != 0;
        this.hash = stream.readInt64(exception);
        this.device_model = stream.readString(exception);
        this.platform = stream.readString(exception);
        this.system_version = stream.readString(exception);
        this.api_id = stream.readInt32(exception);
        this.app_name = stream.readString(exception);
        this.app_version = stream.readString(exception);
        this.date_created = stream.readInt32(exception);
        this.date_active = stream.readInt32(exception);
        this.ip = stream.readString(exception);
        this.country = stream.readString(exception);
        this.region = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.current ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.official_app ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.password_pending ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt64(this.hash);
        stream.writeString(this.device_model);
        stream.writeString(this.platform);
        stream.writeString(this.system_version);
        stream.writeInt32(this.api_id);
        stream.writeString(this.app_name);
        stream.writeString(this.app_version);
        stream.writeInt32(this.date_created);
        stream.writeInt32(this.date_active);
        stream.writeString(this.ip);
        stream.writeString(this.country);
        stream.writeString(this.region);
    }
}
