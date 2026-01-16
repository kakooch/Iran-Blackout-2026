package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_userFull extends TLRPC$UserFull {
    public static int constructor = -694681851;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.blocked = (int32 & 1) != 0;
        this.phone_calls_available = (int32 & 16) != 0;
        this.phone_calls_private = (int32 & 32) != 0;
        this.can_pin_message = (int32 & 128) != 0;
        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.video_calls_available = (int32 & 8192) != 0;
        this.user = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 2) != 0) {
            this.about = stream.readString(exception);
        }
        this.settings = TLRPC$TL_peerSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.profile_photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 8) != 0) {
            this.bot_info = TLRPC$BotInfo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 64) != 0) {
            this.pinned_msg_id = stream.readInt32(exception);
        }
        this.common_chats_count = stream.readInt32(exception);
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        if ((this.flags & 16384) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
        if ((this.flags & 32768) != 0) {
            this.theme_emoticon = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.blocked ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.phone_calls_available ? i | 16 : i & (-17);
        this.flags = i2;
        int i3 = this.phone_calls_private ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        int i4 = this.can_pin_message ? i3 | 128 : i3 & (-129);
        this.flags = i4;
        int i5 = this.has_scheduled ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
        this.flags = i5;
        int i6 = this.video_calls_available ? i5 | 8192 : i5 & (-8193);
        this.flags = i6;
        stream.writeInt32(i6);
        this.user.serializeToStream(stream);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.about);
        }
        this.settings.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            this.profile_photo.serializeToStream(stream);
        }
        this.notify_settings.serializeToStream(stream);
        if ((this.flags & 8) != 0) {
            this.bot_info.serializeToStream(stream);
        }
        if ((this.flags & 64) != 0) {
            stream.writeInt32(this.pinned_msg_id);
        }
        stream.writeInt32(this.common_chats_count);
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeInt32(this.folder_id);
        }
        if ((this.flags & 16384) != 0) {
            stream.writeInt32(this.ttl_period);
        }
        if ((this.flags & 32768) != 0) {
            stream.writeString(this.theme_emoticon);
        }
    }
}
