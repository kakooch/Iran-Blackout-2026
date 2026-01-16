package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_channelFull extends TLRPC$ChatFull {
    public static int constructor = -374179305;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.can_view_participants = (int32 & 8) != 0;
        this.can_set_username = (int32 & 64) != 0;
        this.can_set_stickers = (int32 & 128) != 0;
        this.hidden_prehistory = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
        this.can_set_location = (65536 & int32) != 0;
        this.has_scheduled = (524288 & int32) != 0;
        this.can_view_stats = (1048576 & int32) != 0;
        this.blocked = (int32 & 4194304) != 0;
        this.id = stream.readInt64(exception);
        this.about = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            this.participants_count = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.admins_count = stream.readInt32(exception);
        }
        if ((this.flags & 4) != 0) {
            this.kicked_count = stream.readInt32(exception);
        }
        if ((this.flags & 4) != 0) {
            this.banned_count = stream.readInt32(exception);
        }
        if ((this.flags & 8192) != 0) {
            this.online_count = stream.readInt32(exception);
        }
        this.read_inbox_max_id = stream.readInt32(exception);
        this.read_outbox_max_id = stream.readInt32(exception);
        this.unread_count = stream.readInt32(exception);
        this.chat_photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 8388608) != 0) {
            this.exported_invite = TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$BotInfo tLRPC$BotInfoTLdeserialize = TLRPC$BotInfo.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$BotInfoTLdeserialize == null) {
                return;
            }
            this.bot_info.add(tLRPC$BotInfoTLdeserialize);
        }
        if ((this.flags & 16) != 0) {
            this.migrated_from_chat_id = stream.readInt64(exception);
        }
        if ((this.flags & 16) != 0) {
            this.migrated_from_max_id = stream.readInt32(exception);
        }
        if ((this.flags & 32) != 0) {
            this.pinned_msg_id = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.stickerset = TLRPC$StickerSet.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.available_min_id = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        if ((this.flags & 16384) != 0) {
            this.linked_chat_id = stream.readInt64(exception);
        }
        if ((this.flags & 32768) != 0) {
            this.location = TLRPC$ChannelLocation.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 131072) != 0) {
            this.slowmode_seconds = stream.readInt32(exception);
        }
        if ((this.flags & 262144) != 0) {
            this.slowmode_next_send_date = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            this.stats_dc = stream.readInt32(exception);
        }
        this.pts = stream.readInt32(exception);
        if ((this.flags & 2097152) != 0) {
            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            int int324 = stream.readInt32(exception);
            if (int324 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            } else {
                int int325 = stream.readInt32(exception);
                for (int i2 = 0; i2 < int325; i2++) {
                    this.pending_suggestions.add(stream.readString(exception));
                }
            }
        }
        if ((this.flags & ConnectionsManager.FileTypeFile) != 0) {
            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 134217728) != 0) {
            this.theme_emoticon = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.can_view_participants ? this.flags | 8 : this.flags & (-9);
        this.flags = i;
        int i2 = this.can_set_username ? i | 64 : i & (-65);
        this.flags = i2;
        int i3 = this.can_set_stickers ? i2 | 128 : i2 & (-129);
        this.flags = i3;
        int i4 = this.hidden_prehistory ? i3 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i3 & (-1025);
        this.flags = i4;
        int i5 = this.can_set_location ? i4 | 65536 : i4 & (-65537);
        this.flags = i5;
        int i6 = this.has_scheduled ? i5 | 524288 : i5 & (-524289);
        this.flags = i6;
        int i7 = this.can_view_stats ? i6 | 1048576 : i6 & (-1048577);
        this.flags = i7;
        int i8 = this.blocked ? i7 | 4194304 : i7 & (-4194305);
        this.flags = i8;
        stream.writeInt32(i8);
        stream.writeInt64(this.id);
        stream.writeString(this.about);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.participants_count);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.admins_count);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.kicked_count);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.banned_count);
        }
        if ((this.flags & 8192) != 0) {
            stream.writeInt32(this.online_count);
        }
        stream.writeInt32(this.read_inbox_max_id);
        stream.writeInt32(this.read_outbox_max_id);
        stream.writeInt32(this.unread_count);
        this.chat_photo.serializeToStream(stream);
        this.notify_settings.serializeToStream(stream);
        if ((this.flags & 8388608) != 0) {
            this.exported_invite.serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size = this.bot_info.size();
        stream.writeInt32(size);
        for (int i9 = 0; i9 < size; i9++) {
            this.bot_info.get(i9).serializeToStream(stream);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt64(this.migrated_from_chat_id);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.migrated_from_max_id);
        }
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.pinned_msg_id);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.stickerset.serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            stream.writeInt32(this.available_min_id);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeInt32(this.folder_id);
        }
        if ((this.flags & 16384) != 0) {
            stream.writeInt64(this.linked_chat_id);
        }
        if ((this.flags & 32768) != 0) {
            this.location.serializeToStream(stream);
        }
        if ((this.flags & 131072) != 0) {
            stream.writeInt32(this.slowmode_seconds);
        }
        if ((this.flags & 262144) != 0) {
            stream.writeInt32(this.slowmode_next_send_date);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            stream.writeInt32(this.stats_dc);
        }
        stream.writeInt32(this.pts);
        if ((this.flags & 2097152) != 0) {
            this.call.serializeToStream(stream);
        }
        if ((this.flags & ConnectionsManager.FileTypePhoto) != 0) {
            stream.writeInt32(this.ttl_period);
        }
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.pending_suggestions.size();
            stream.writeInt32(size2);
            for (int i10 = 0; i10 < size2; i10++) {
                stream.writeString(this.pending_suggestions.get(i10));
            }
        }
        if ((this.flags & ConnectionsManager.FileTypeFile) != 0) {
            this.groupcall_default_join_as.serializeToStream(stream);
        }
        if ((this.flags & 134217728) != 0) {
            stream.writeString(this.theme_emoticon);
        }
    }
}
