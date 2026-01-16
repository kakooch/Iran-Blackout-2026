package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chat extends TLRPC$Chat {
    public static int constructor = 1103884886;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.creator = (int32 & 1) != 0;
        this.kicked = (int32 & 2) != 0;
        this.left = (int32 & 4) != 0;
        this.admins_enabled = (int32 & 8) != 0;
        this.admin = (int32 & 16) != 0;
        this.deactivated = (int32 & 32) != 0;
        this.call_active = (8388608 & int32) != 0;
        this.call_not_empty = (int32 & ConnectionsManager.FileTypePhoto) != 0;
        this.id = stream.readInt64(exception);
        this.title = stream.readString(exception);
        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.participants_count = stream.readInt32(exception);
        this.date = stream.readInt32(exception);
        this.version = stream.readInt32(exception);
        if ((this.flags & 64) != 0) {
            this.migrated_to = TLRPC$InputChannel.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16384) != 0) {
            this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 262144) != 0) {
            this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.creator ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.kicked ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.left ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.deactivated ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        int i5 = this.call_active ? i4 | 8388608 : i4 & (-8388609);
        this.flags = i5;
        int i6 = this.call_not_empty ? i5 | ConnectionsManager.FileTypePhoto : i5 & (-16777217);
        this.flags = i6;
        stream.writeInt32(i6);
        stream.writeInt64(this.id);
        stream.writeString(this.title);
        this.photo.serializeToStream(stream);
        stream.writeInt32(this.participants_count);
        stream.writeInt32(this.date);
        stream.writeInt32(this.version);
        if ((this.flags & 64) != 0) {
            this.migrated_to.serializeToStream(stream);
        }
        if ((this.flags & 16384) != 0) {
            this.admin_rights.serializeToStream(stream);
        }
        if ((this.flags & 262144) != 0) {
            this.default_banned_rights.serializeToStream(stream);
        }
    }
}
