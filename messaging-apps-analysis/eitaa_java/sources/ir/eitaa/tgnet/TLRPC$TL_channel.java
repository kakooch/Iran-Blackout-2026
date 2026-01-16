package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_channel extends TLRPC$Chat {
    public static int constructor = -2107528095;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        this.eFlags = int32;
        int i = this.flags;
        this.creator = (i & 1) != 0;
        this.left = (i & 4) != 0;
        this.broadcast = (i & 32) != 0;
        this.verified = (i & 128) != 0;
        this.megagroup = (i & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        this.restricted = (i & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
        this.signatures = (i & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
        this.min = (i & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.isMediaContent = (i & 2097152) != 0;
        this.trusty = (int32 & 1) != 0;
        this.has_link = (1048576 & i) != 0;
        this.has_geo = (2097152 & i) != 0;
        this.slowmode_enabled = (4194304 & i) != 0;
        this.call_active = (8388608 & i) != 0;
        this.call_not_empty = (16777216 & i) != 0;
        this.fake = (int32 & 2) != 0;
        this.shop = (int32 & 4) != 0;
        this.gigagroup = (67108864 & i) != 0;
        this.id = stream.readInt64(exception);
        if ((this.flags & 8192) != 0) {
            this.access_hash = stream.readInt64(exception);
        }
        this.title = stream.readString(exception);
        if ((this.flags & 64) != 0) {
            this.username = stream.readString(exception);
        }
        this.photo = TLRPC$ChatPhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int323; i2++) {
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                    return;
                }
                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
            }
        }
        if ((this.flags & 16384) != 0) {
            this.admin_rights = TLRPC$TL_chatAdminRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 32768) != 0) {
            this.banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 262144) != 0) {
            this.default_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 131072) != 0) {
            this.participants_count = stream.readInt32(exception);
        }
        if ((this.flags & 536870912) != 0) {
            this.live_stream_msg_id = stream.readInt32(exception);
        }
        this.sponsoredMessage = (this.flags & 134217728) != 0;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.creator ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.left ? i | 4 : i & (-5);
        this.flags = i2;
        int i3 = this.broadcast ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        int i4 = this.verified ? i3 | 128 : i3 & (-129);
        this.flags = i4;
        int i5 = this.megagroup ? i4 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i4 & (-257);
        this.flags = i5;
        int i6 = this.restricted ? i5 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i5 & (-513);
        this.flags = i6;
        int i7 = this.signatures ? i6 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i6 & (-2049);
        this.flags = i7;
        int i8 = this.min ? i7 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i7 & (-4097);
        this.flags = i8;
        int i9 = this.live_stream_msg_id != 0 ? i8 | 536870912 : i8 & (-536870913);
        this.flags = i9;
        int i10 = this.trusty ? this.eFlags | 1 : this.eFlags & (-2);
        this.eFlags = i10;
        int i11 = this.has_link ? i9 | 1048576 : i9 & (-1048577);
        this.flags = i11;
        int i12 = this.has_geo ? i11 | 2097152 : i11 & (-2097153);
        this.flags = i12;
        int i13 = this.slowmode_enabled ? i12 | 4194304 : i12 & (-4194305);
        this.flags = i13;
        int i14 = this.call_active ? i13 | 8388608 : i13 & (-8388609);
        this.flags = i14;
        int i15 = this.call_not_empty ? i14 | ConnectionsManager.FileTypePhoto : i14 & (-16777217);
        this.flags = i15;
        int i16 = this.fake ? i10 | 2 : i10 & (-3);
        this.eFlags = i16;
        this.eFlags = this.shop ? i16 | 4 : i16 & (-5);
        int i17 = this.gigagroup ? i15 | ConnectionsManager.FileTypeFile : i15 & (-67108865);
        this.flags = i17;
        stream.writeInt32(i17);
        stream.writeInt32(this.eFlags);
        stream.writeInt64(this.id);
        if ((this.flags & 8192) != 0) {
            stream.writeInt64(this.access_hash);
        }
        stream.writeString(this.title);
        if ((this.flags & 64) != 0) {
            stream.writeString(this.username);
        }
        this.photo.serializeToStream(stream);
        stream.writeInt32(this.date);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            stream.writeInt32(481674261);
            int size = this.restriction_reason.size();
            stream.writeInt32(size);
            for (int i18 = 0; i18 < size; i18++) {
                this.restriction_reason.get(i18).serializeToStream(stream);
            }
        }
        if ((this.flags & 16384) != 0) {
            this.admin_rights.serializeToStream(stream);
        }
        if ((this.flags & 32768) != 0) {
            this.banned_rights.serializeToStream(stream);
        }
        if ((this.flags & 262144) != 0) {
            this.default_banned_rights.serializeToStream(stream);
        }
        if ((this.flags & 131072) != 0) {
            stream.writeInt32(this.participants_count);
        }
        if ((this.flags & 536870912) != 0) {
            stream.writeInt32(this.live_stream_msg_id);
        }
    }
}
