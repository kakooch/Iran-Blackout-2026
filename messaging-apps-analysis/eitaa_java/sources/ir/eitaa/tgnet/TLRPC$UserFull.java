package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public abstract class TLRPC$UserFull extends TLObject {
    public String about;
    public boolean blocked;
    public TLRPC$BotInfo bot_info;
    public boolean can_pin_message;
    public int common_chats_count;
    public int flags;
    public int folder_id;
    public boolean has_scheduled;
    public TLRPC$TL_contacts_link_layer101 link;
    public TLRPC$PeerNotifySettings notify_settings;
    public boolean phone_calls_available;
    public boolean phone_calls_private;
    public int pinned_msg_id;
    public TLRPC$Photo profile_photo;
    public TLRPC$TL_peerSettings settings;
    public String theme_emoticon;
    public int ttl_period;
    public TLRPC$User user;
    public boolean video_calls_available;

    public static TLRPC$UserFull TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_userFull tLRPC$TL_userFull;
        switch (constructor) {
            case -1901811583:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_userFull_layer98
                    public static int constructor = -1901811583;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.user = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 2) != 0) {
                            this.about = stream2.readString(exception2);
                        }
                        this.link = TLRPC$TL_contacts_link_layer101.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        this.common_chats_count = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.blocked ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.phone_calls_available ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.phone_calls_private ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.can_pin_message ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        this.user.serializeToStream(stream2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.about);
                        }
                        this.link.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        stream2.writeInt32(this.common_chats_count);
                    }
                };
                break;
            case -694681851:
                tLRPC$TL_userFull = new TLRPC$TL_userFull();
                break;
            case -302941166:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_userFull_layer123
                    public static int constructor = -302941166;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.video_calls_available = (int32 & 8192) != 0;
                        this.user = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 2) != 0) {
                            this.about = stream2.readString(exception2);
                        }
                        this.settings = TLRPC$TL_peerSettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        this.common_chats_count = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
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
                        stream2.writeInt32(i5);
                        this.user.serializeToStream(stream2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.about);
                        }
                        this.settings.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        stream2.writeInt32(this.common_chats_count);
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                    }
                };
                break;
            case 328899191:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_userFull_layer131
                    public static int constructor = 328899191;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.has_scheduled = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
                        this.video_calls_available = (int32 & 8192) != 0;
                        this.user = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 2) != 0) {
                            this.about = stream2.readString(exception2);
                        }
                        this.settings = TLRPC$TL_peerSettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        this.common_chats_count = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 16384) != 0) {
                            this.ttl_period = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
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
                        stream2.writeInt32(i6);
                        this.user.serializeToStream(stream2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.about);
                        }
                        this.settings.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        stream2.writeInt32(this.common_chats_count);
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                        if ((this.flags & 16384) != 0) {
                            stream2.writeInt32(this.ttl_period);
                        }
                    }
                };
                break;
            case 1951750604:
                tLRPC$TL_userFull = new TLRPC$TL_userFull() { // from class: ir.eitaa.tgnet.TLRPC$TL_userFull_layer101
                    public static int constructor = 1951750604;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.blocked = (int32 & 1) != 0;
                        this.phone_calls_available = (int32 & 16) != 0;
                        this.phone_calls_private = (int32 & 32) != 0;
                        this.can_pin_message = (int32 & 128) != 0;
                        this.user = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 2) != 0) {
                            this.about = stream2.readString(exception2);
                        }
                        this.link = TLRPC$TL_contacts_link_layer101.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info = TLRPC$BotInfo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.pinned_msg_id = stream2.readInt32(exception2);
                        }
                        this.common_chats_count = stream2.readInt32(exception2);
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            this.folder_id = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_userFull, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.blocked ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.phone_calls_available ? i | 16 : i & (-17);
                        this.flags = i2;
                        int i3 = this.phone_calls_private ? i2 | 32 : i2 & (-33);
                        this.flags = i3;
                        int i4 = this.can_pin_message ? i3 | 128 : i3 & (-129);
                        this.flags = i4;
                        stream2.writeInt32(i4);
                        this.user.serializeToStream(stream2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.about);
                        }
                        this.link.serializeToStream(stream2);
                        if ((this.flags & 4) != 0) {
                            this.profile_photo.serializeToStream(stream2);
                        }
                        this.notify_settings.serializeToStream(stream2);
                        if ((this.flags & 8) != 0) {
                            this.bot_info.serializeToStream(stream2);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.pinned_msg_id);
                        }
                        stream2.writeInt32(this.common_chats_count);
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(this.folder_id);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_userFull = null;
                break;
        }
        if (tLRPC$TL_userFull == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in UserFull", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_userFull != null) {
            tLRPC$TL_userFull.readParams(stream, exception);
        }
        return tLRPC$TL_userFull;
    }
}
