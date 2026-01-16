package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_draftMessage extends TLRPC$DraftMessage {
    public static int constructor = -40996577;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.no_webpage = (int32 & 2) != 0;
        if ((int32 & 1) != 0) {
            this.reply_to_msg_id = stream.readInt32(exception);
        }
        this.message = stream.readString(exception);
        if ((this.flags & 8) != 0) {
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
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.no_webpage ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.reply_to_msg_id);
        }
        stream.writeString(this.message);
        if ((this.flags & 8) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.entities.get(i2).serializeToStream(stream);
            }
        }
        stream.writeInt32(this.date);
    }
}
