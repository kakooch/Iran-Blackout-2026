package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_help_termsOfService extends TLObject {
    public static int constructor = 2013922064;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public TLRPC$TL_dataJSON id;
    public int min_age_confirm;
    public boolean popup;
    public String text;

    public static TLRPC$TL_help_termsOfService TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_help_termsOfService", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService = new TLRPC$TL_help_termsOfService();
        tLRPC$TL_help_termsOfService.readParams(stream, exception);
        return tLRPC$TL_help_termsOfService;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.popup = (int32 & 1) != 0;
        this.id = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
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
            this.min_age_confirm = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.popup ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.id.serializeToStream(stream);
        stream.writeString(this.text);
        stream.writeInt32(481674261);
        int size = this.entities.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.entities.get(i2).serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.min_age_confirm);
        }
    }
}
