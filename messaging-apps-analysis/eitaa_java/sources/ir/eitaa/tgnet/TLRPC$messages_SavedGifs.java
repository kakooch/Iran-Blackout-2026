package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_SavedGifs extends TLObject {
    public ArrayList<TLRPC$Document> gifs = new ArrayList<>();
    public long hash;

    public static TLRPC$messages_SavedGifs TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_SavedGifs tLRPC$messages_SavedGifs;
        if (constructor != -2069878259) {
            tLRPC$messages_SavedGifs = constructor != -402498398 ? null : new TLRPC$messages_SavedGifs() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_savedGifsNotModified
                public static int constructor = -402498398;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$messages_SavedGifs = new TLRPC$messages_SavedGifs() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_savedGifs
                public static int constructor = -2069878259;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.hash = stream2.readInt64(exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$DocumentTLdeserialize == null) {
                            return;
                        }
                        this.gifs.add(tLRPC$DocumentTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.hash);
                    stream2.writeInt32(481674261);
                    int size = this.gifs.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.gifs.get(i).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$messages_SavedGifs == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_SavedGifs", Integer.valueOf(constructor)));
        }
        if (tLRPC$messages_SavedGifs != null) {
            tLRPC$messages_SavedGifs.readParams(stream, exception);
        }
        return tLRPC$messages_SavedGifs;
    }
}
