package ir.eitaa.tgnet;

import android.text.TextUtils;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_message extends TLRPC$Message {
    public static int constructor = -2049520670;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.silent = (int32 & 8192) != 0;
        this.post = (int32 & 16384) != 0;
        this.from_scheduled = (262144 & int32) != 0;
        this.legacy = (524288 & int32) != 0;
        this.edit_hide = (2097152 & int32) != 0;
        this.pinned = (int32 & ConnectionsManager.FileTypePhoto) != 0;
        this.id = stream.readInt32(exception);
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.via_bot_id = stream.readInt64(exception);
        }
        if ((this.flags & 8) != 0) {
            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.date = stream.readInt32(exception);
        this.message = stream.readString(exception);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
            this.media = tLRPC$MessageMediaTLdeserialize;
            if (tLRPC$MessageMediaTLdeserialize != null) {
                this.ttl = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
            }
            if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
                this.message = this.media.captionLegacy;
            }
        }
        if ((this.flags & 64) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 128) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.views = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.forwards = stream.readInt32(exception);
        }
        if ((this.flags & 8388608) != 0) {
            this.replies = TLRPC$MessageReplies.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 32768) != 0) {
            this.edit_date = stream.readInt32(exception);
        }
        if ((this.flags & 65536) != 0) {
            this.post_author = stream.readString(exception);
        }
        if ((this.flags & 131072) != 0) {
            this.grouped_id = stream.readInt64(exception);
        }
        if ((this.flags & 4194304) != 0) {
            int int324 = stream.readInt32(exception);
            if (int324 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            }
            int int325 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int325; i2++) {
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReasonTLdeserialize = TLRPC$TL_restrictionReason.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_restrictionReasonTLdeserialize == null) {
                    return;
                }
                this.restriction_reason.add(tLRPC$TL_restrictionReasonTLdeserialize);
            }
        }
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.out ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.mentioned ? i | 16 : i & (-17);
        this.flags = i2;
        int i3 = this.media_unread ? i2 | 32 : i2 & (-33);
        this.flags = i3;
        int i4 = this.silent ? i3 | 8192 : i3 & (-8193);
        this.flags = i4;
        int i5 = this.post ? i4 | 16384 : i4 & (-16385);
        this.flags = i5;
        int i6 = this.from_scheduled ? i5 | 262144 : i5 & (-262145);
        this.flags = i6;
        int i7 = this.legacy ? i6 | 524288 : i6 & (-524289);
        this.flags = i7;
        int i8 = this.edit_hide ? i7 | 2097152 : i7 & (-2097153);
        this.flags = i8;
        int i9 = this.pinned ? i8 | ConnectionsManager.FileTypePhoto : i8 & (-16777217);
        this.flags = i9;
        stream.writeInt32(i9);
        stream.writeInt32(this.id);
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.from_id.serializeToStream(stream);
        }
        this.peer_id.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            this.fwd_from.serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeInt64(this.via_bot_id);
        }
        if ((this.flags & 8) != 0) {
            this.reply_to.serializeToStream(stream);
        }
        stream.writeInt32(this.date);
        stream.writeString(this.message);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.media.serializeToStream(stream);
        }
        if ((this.flags & 64) != 0) {
            this.reply_markup.serializeToStream(stream);
        }
        if ((this.flags & 128) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i10 = 0; i10 < size; i10++) {
                this.entities.get(i10).serializeToStream(stream);
            }
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.views);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.forwards);
        }
        if ((this.flags & 8388608) != 0) {
            this.replies.serializeToStream(stream);
        }
        if ((this.flags & 32768) != 0) {
            stream.writeInt32(this.edit_date);
        }
        if ((this.flags & 65536) != 0) {
            stream.writeString(this.post_author);
        }
        if ((this.flags & 131072) != 0) {
            stream.writeInt64(this.grouped_id);
        }
        if ((this.flags & 4194304) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.restriction_reason.size();
            stream.writeInt32(size2);
            for (int i11 = 0; i11 < size2; i11++) {
                this.restriction_reason.get(i11).serializeToStream(stream);
            }
        }
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            stream.writeInt32(this.ttl_period);
        }
        writeAttachPath(stream);
    }
}
