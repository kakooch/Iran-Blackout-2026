package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_user extends TLRPC$User {
    public static int constructor = 1073147056;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.self = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
        this.contact = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
        this.mutual_contact = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.deleted = (int32 & 8192) != 0;
        this.bot = (int32 & 16384) != 0;
        this.bot_chat_history = (32768 & int32) != 0;
        this.bot_nochats = (65536 & int32) != 0;
        this.verified = (131072 & int32) != 0;
        this.restricted = (int32 & 262144) != 0;
        this.min = (1048576 & int32) != 0;
        this.bot_inline_geo = (2097152 & int32) != 0;
        this.support = (8388608 & int32) != 0;
        this.trusty = (16777216 & int32) != 0;
        this.apply_min_photo = (33554432 & int32) != 0;
        this.fake = (67108864 & int32) != 0;
        this.MXB_VIRTUAL_USER = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
        this.MXB_REGISTERED_USER = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        this.id = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.access_hash = stream.readInt64(exception);
        }
        if ((this.flags & 2) != 0) {
            this.first_name = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.last_name = stream.readString(exception);
        }
        if ((this.flags & 8) != 0) {
            this.username = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.phone = stream.readString(exception);
        }
        if ((this.flags & 32) != 0) {
            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 64) != 0) {
            this.status = TLRPC$UserStatus.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16384) != 0) {
            this.bot_info_version = stream.readInt32(exception);
        }
        if ((this.flags & 262144) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                    return;
                }
                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
            }
        }
        if ((this.flags & 524288) != 0) {
            this.bot_inline_placeholder = stream.readString(exception);
        }
        if ((this.flags & 4194304) != 0) {
            this.lang_code = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.self ? this.flags | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : this.flags & (-1025);
        this.flags = i;
        int i2 = this.contact ? i | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i & (-2049);
        this.flags = i2;
        int i3 = this.mutual_contact ? i2 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i2 & (-4097);
        this.flags = i3;
        int i4 = this.deleted ? i3 | 8192 : i3 & (-8193);
        this.flags = i4;
        int i5 = this.bot ? i4 | 16384 : i4 & (-16385);
        this.flags = i5;
        int i6 = this.bot_chat_history ? i5 | 32768 : i5 & (-32769);
        this.flags = i6;
        int i7 = this.bot_nochats ? i6 | 65536 : i6 & (-65537);
        this.flags = i7;
        int i8 = this.verified ? i7 | 131072 : i7 & (-131073);
        this.flags = i8;
        int i9 = this.restricted ? i8 | 262144 : i8 & (-262145);
        this.flags = i9;
        int i10 = this.min ? i9 | 1048576 : i9 & (-1048577);
        this.flags = i10;
        int i11 = this.bot_inline_geo ? i10 | 2097152 : i10 & (-2097153);
        this.flags = i11;
        int i12 = this.support ? i11 | 8388608 : i11 & (-8388609);
        this.flags = i12;
        int i13 = this.trusty ? i12 | ConnectionsManager.FileTypePhoto : i12 & (-16777217);
        this.flags = i13;
        int i14 = this.apply_min_photo ? i13 | ConnectionsManager.FileTypeVideo : i13 & (-33554433);
        this.flags = i14;
        int i15 = this.fake ? i14 | ConnectionsManager.FileTypeFile : i14 & (-67108865);
        this.flags = i15;
        stream.writeInt32(i15);
        stream.writeInt64(this.id);
        if ((this.flags & 1) != 0) {
            stream.writeInt64(this.access_hash);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.first_name);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.last_name);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.username);
        }
        if ((this.flags & 16) != 0) {
            stream.writeString(this.phone);
        }
        if ((this.flags & 32) != 0) {
            this.photo.serializeToStream(stream);
        }
        if ((this.flags & 64) != 0) {
            this.status.serializeToStream(stream);
        }
        if ((this.flags & 16384) != 0) {
            stream.writeInt32(this.bot_info_version);
        }
        if ((this.flags & 262144) != 0) {
            stream.writeInt32(481674261);
            int size = this.restriction_reason.size();
            stream.writeInt32(size);
            for (int i16 = 0; i16 < size; i16++) {
                this.restriction_reason.get(i16).serializeToStream(stream);
            }
        }
        if ((this.flags & 524288) != 0) {
            stream.writeString(this.bot_inline_placeholder);
        }
        if ((this.flags & 4194304) != 0) {
            stream.writeString(this.lang_code);
        }
    }
}
