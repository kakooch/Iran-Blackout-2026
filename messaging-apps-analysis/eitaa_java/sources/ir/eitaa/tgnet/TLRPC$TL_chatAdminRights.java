package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_chatAdminRights extends TLObject {
    public static int constructor = 1605510357;
    public boolean add_admins;
    public boolean anonymous;
    public boolean ban_users;
    public boolean change_info;
    public boolean delete_messages;
    public boolean edit_messages;
    public int flags;
    public boolean invite_users;
    public boolean manage_call;
    public boolean other;
    public boolean pin_messages;
    public boolean post_live;
    public boolean post_messages;

    public static TLRPC$TL_chatAdminRights TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatAdminRights", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
        tLRPC$TL_chatAdminRights.readParams(stream, exception);
        return tLRPC$TL_chatAdminRights;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.change_info = (int32 & 1) != 0;
        this.post_messages = (int32 & 2) != 0;
        this.edit_messages = (int32 & 4) != 0;
        this.delete_messages = (int32 & 8) != 0;
        this.ban_users = (int32 & 16) != 0;
        this.invite_users = (int32 & 32) != 0;
        this.pin_messages = (int32 & 128) != 0;
        this.add_admins = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
        this.anonymous = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
        this.manage_call = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
        this.other = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.post_live = (int32 & 1048576) != 0;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.change_info ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.post_messages ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.edit_messages ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.delete_messages ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.ban_users ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        int i6 = this.invite_users ? i5 | 32 : i5 & (-33);
        this.flags = i6;
        int i7 = this.pin_messages ? i6 | 128 : i6 & (-129);
        this.flags = i7;
        int i8 = this.add_admins ? i7 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i7 & (-513);
        this.flags = i8;
        int i9 = this.anonymous ? i8 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i8 & (-1025);
        this.flags = i9;
        int i10 = this.manage_call ? i9 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i9 & (-2049);
        this.flags = i10;
        int i11 = this.other ? i10 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i10 & (-4097);
        this.flags = i11;
        int i12 = this.post_live ? i11 | 1048576 : i11 & (-1048577);
        this.flags = i12;
        stream.writeInt32(i12);
    }
}
