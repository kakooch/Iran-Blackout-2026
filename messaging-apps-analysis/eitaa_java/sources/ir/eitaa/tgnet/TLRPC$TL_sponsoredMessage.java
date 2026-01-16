package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_sponsoredMessage extends TLObject {
    public static int constructor = 708589599;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public TLRPC$Peer from_id;
    public String message;
    public byte[] random_id;
    public String start_param;

    public static TLRPC$TL_sponsoredMessage TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_sponsoredMessage", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_sponsoredMessage tLRPC$TL_sponsoredMessage = new TLRPC$TL_sponsoredMessage();
        tLRPC$TL_sponsoredMessage.readParams(stream, exception);
        return tLRPC$TL_sponsoredMessage;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.random_id = stream.readByteArray(exception);
        this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.start_param = stream.readString(exception);
        }
        this.message = stream.readString(exception);
        if ((this.flags & 2) != 0) {
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
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeByteArray(this.random_id);
        this.from_id.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.start_param);
        }
        stream.writeString(this.message);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.entities.get(i).serializeToStream(stream);
            }
        }
    }
}
