package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_updateShortMessage extends TLRPC$Updates {
    public static int constructor = 826001400;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.silent = (int32 & 8192) != 0;
        this.id = stream.readInt32(exception);
        this.user_id = stream.readInt64(exception);
        this.message = stream.readString(exception);
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
        this.date = stream.readInt32(exception);
        if ((this.flags & 4) != 0) {
            this.fwd_from = TLRPC$MessageFwdHeader.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.via_bot_id = stream.readInt64(exception);
        }
        if ((this.flags & 8) != 0) {
            this.reply_to = TLRPC$TL_messageReplyHeader.TLdeserialize(stream, stream.readInt32(exception), exception);
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
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.ttl_period = stream.readInt32(exception);
        }
    }
}
