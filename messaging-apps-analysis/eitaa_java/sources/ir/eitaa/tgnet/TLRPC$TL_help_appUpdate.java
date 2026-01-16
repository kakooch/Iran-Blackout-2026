package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_help_appUpdate extends TLRPC$help_AppUpdate {
    public static int constructor = -860107216;
    public boolean can_not_skip;
    public TLRPC$Document document;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public int id;
    public TLRPC$Document sticker;
    public String text;
    public String url;
    public String version;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.can_not_skip = (int32 & 1) != 0;
        this.id = stream.readInt32(exception);
        this.version = stream.readString(exception);
        this.text = stream.readString(exception);
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
        if ((this.flags & 2) != 0) {
            this.document = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 4) != 0) {
            this.url = stream.readString(exception);
        }
        if ((this.flags & 8) != 0) {
            this.sticker = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.can_not_skip ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.id);
        stream.writeString(this.version);
        stream.writeString(this.text);
        stream.writeInt32(481674261);
        int size = this.entities.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.entities.get(i2).serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            this.document.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.url);
        }
        if ((this.flags & 8) != 0) {
            this.sticker.serializeToStream(stream);
        }
    }
}
