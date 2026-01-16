package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_stickerPack extends TLObject {
    public static int constructor = 313694676;
    public ArrayList<Long> documents = new ArrayList<>();
    public String emoticon;

    public static TLRPC$TL_stickerPack TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_stickerPack", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_stickerPack tLRPC$TL_stickerPack = new TLRPC$TL_stickerPack();
        tLRPC$TL_stickerPack.readParams(stream, exception);
        return tLRPC$TL_stickerPack;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.emoticon = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.documents.add(Long.valueOf(stream.readInt64(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.emoticon);
        stream.writeInt32(481674261);
        int size = this.documents.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt64(this.documents.get(i).longValue());
        }
    }
}
