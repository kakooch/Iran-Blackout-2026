package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_Chats extends TLObject {
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public int count;

    public static TLRPC$messages_Chats TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_Chats tLRPC$TL_messages_chats;
        if (i != -1663561404) {
            tLRPC$TL_messages_chats = i != 1694474197 ? null : new TLRPC$TL_messages_chats();
        } else {
            tLRPC$TL_messages_chats = new TLRPC$messages_Chats() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_chatsSlice
                public static int constructor = -1663561404;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.count = abstractSerializedData2.readInt32(z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.count);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.chats.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.chats.get(i2).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$TL_messages_chats == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Chats", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_chats != null) {
            tLRPC$TL_messages_chats.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_chats;
    }
}
