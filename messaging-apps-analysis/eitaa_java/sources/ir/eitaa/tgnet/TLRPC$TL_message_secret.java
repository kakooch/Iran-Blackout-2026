package ir.eitaa.tgnet;

import android.text.TextUtils;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_message_secret extends TLRPC$TL_message {
    public static int constructor = 1431655930;

    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.unread = (int32 & 1) != 0;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.id = stream.readInt32(exception);
        this.ttl = stream.readInt32(exception);
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = stream.readInt32(exception);
        this.peer_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
        this.message = stream.readString(exception);
        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.media = tLRPC$MessageMediaTLdeserialize;
        if (tLRPC$MessageMediaTLdeserialize != null && !TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
            this.message = this.media.captionLegacy;
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
            TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$MessageEntityTLdeserialize == null) {
                return;
            }
            this.entities.add(tLRPC$MessageEntityTLdeserialize);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.via_bot_name = stream.readString(exception);
        }
        if ((this.flags & 8) != 0) {
            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
            this.reply_to = tLRPC$TL_messageReplyHeader;
            tLRPC$TL_messageReplyHeader.reply_to_random_id = stream.readInt64(exception);
        }
        if ((this.flags & 131072) != 0) {
            this.grouped_id = stream.readInt64(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLRPC$TL_message, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.unread ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.out ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
        this.flags = i3;
        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        stream.writeInt32(i4);
        stream.writeInt32(this.id);
        stream.writeInt32(this.ttl);
        stream.writeInt32((int) this.from_id.user_id);
        this.peer_id.serializeToStream(stream);
        stream.writeInt32(this.date);
        stream.writeString(this.message);
        this.media.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.entities.size();
        stream.writeInt32(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.entities.get(i5).serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeString(this.via_bot_name);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt64(this.reply_to.reply_to_random_id);
        }
        if ((this.flags & 131072) != 0) {
            stream.writeInt64(this.grouped_id);
        }
        writeAttachPath(stream);
    }
}
