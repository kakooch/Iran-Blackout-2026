package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateServiceNotification extends TLRPC$Update {
    public static int constructor = -337352679;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public int inbox_date;
    public TLRPC$MessageMedia media;
    public String message;
    public boolean popup;
    public String type;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.popup = (int32 & 1) != 0;
        if ((int32 & 2) != 0) {
            this.inbox_date = stream.readInt32(exception);
        }
        this.type = stream.readString(exception);
        this.message = stream.readString(exception);
        this.media = TLRPC$MessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
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

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.popup ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.inbox_date);
        }
        stream.writeString(this.type);
        stream.writeString(this.message);
        this.media.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.entities.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.entities.get(i2).serializeToStream(stream);
        }
    }
}
