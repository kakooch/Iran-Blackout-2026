package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_Chats extends TLObject {
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public int count;

    public static TLRPC$messages_Chats TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_Chats tLRPC$messages_Chats;
        if (constructor != -1663561404) {
            tLRPC$messages_Chats = constructor != 1694474197 ? null : new TLRPC$messages_Chats() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_chats
                public static int constructor = 1694474197;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(481674261);
                    int size = this.chats.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.chats.get(i).serializeToStream(stream2);
                    }
                }
            };
        } else {
            tLRPC$messages_Chats = new TLRPC$messages_Chats() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_chatsSlice
                public static int constructor = -1663561404;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.count = stream2.readInt32(exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.count);
                    stream2.writeInt32(481674261);
                    int size = this.chats.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.chats.get(i).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$messages_Chats == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Chats", Integer.valueOf(constructor)));
        }
        if (tLRPC$messages_Chats != null) {
            tLRPC$messages_Chats.readParams(stream, exception);
        }
        return tLRPC$messages_Chats;
    }
}
