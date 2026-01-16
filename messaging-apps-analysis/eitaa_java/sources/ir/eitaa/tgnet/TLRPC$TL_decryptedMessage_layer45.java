package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_decryptedMessage_layer45 extends TLRPC$TL_decryptedMessage {
    public static int constructor = 917541342;

    @Override // ir.eitaa.tgnet.TLRPC$TL_decryptedMessage, ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.random_id = stream.readInt64(exception);
        this.ttl = stream.readInt32(exception);
        this.message = stream.readString(exception);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.media = TLRPC$DecryptedMessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 128) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$MessageEntityTLdeserialize == null) {
                    return;
                }
                this.entities.add(tLRPC$MessageEntityTLdeserialize);
            }
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.via_bot_name = stream.readString(exception);
        }
        if ((this.flags & 8) != 0) {
            this.reply_to_random_id = stream.readInt64(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLRPC$TL_decryptedMessage, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.random_id);
        stream.writeInt32(this.ttl);
        stream.writeString(this.message);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.media.serializeToStream(stream);
        }
        if ((this.flags & 128) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.entities.get(i).serializeToStream(stream);
            }
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeString(this.via_bot_name);
        }
        if ((this.flags & 8) != 0) {
            stream.writeInt64(this.reply_to_random_id);
        }
    }
}
