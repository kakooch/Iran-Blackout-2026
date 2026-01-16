package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_inputSingleMedia extends TLObject {
    public static int constructor = 482797855;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public TLRPC$InputMedia media;
    public String message;
    public long random_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.media = TLRPC$InputMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.random_id = stream.readInt64(exception);
        this.message = stream.readString(exception);
        if ((this.flags & 1) != 0) {
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
        this.media.serializeToStream(stream);
        stream.writeInt64(this.random_id);
        stream.writeString(this.message);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.entities.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.entities.get(i).serializeToStream(stream);
            }
        }
    }
}
