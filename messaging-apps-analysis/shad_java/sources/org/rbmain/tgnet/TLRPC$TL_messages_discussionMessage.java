package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_discussionMessage extends TLObject {
    public static int constructor = -170029155;
    public int flags;
    public long max_id;
    public int read_inbox_max_id;
    public int read_outbox_max_id;
    public int unread_count;
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_discussionMessage TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_discussionMessage", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_messages_discussionMessage tLRPC$TL_messages_discussionMessage = new TLRPC$TL_messages_discussionMessage();
        tLRPC$TL_messages_discussionMessage.readParams(abstractSerializedData, z);
        return tLRPC$TL_messages_discussionMessage;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$MessageTLdeserialize == null) {
                return;
            }
            this.messages.add(tLRPC$MessageTLdeserialize);
        }
        if ((this.flags & 1) != 0) {
            this.max_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 2) != 0) {
            this.read_inbox_max_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 4) != 0) {
            this.read_outbox_max_id = abstractSerializedData.readInt32(z);
        }
        int int323 = abstractSerializedData.readInt32(z);
        if (int323 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
        }
        int int325 = abstractSerializedData.readInt32(z);
        if (int325 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = abstractSerializedData.readInt32(z);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt32(481674261);
        int size = this.messages.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.messages.get(i).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32((int) this.max_id);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.read_inbox_max_id);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.read_outbox_max_id);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.chats.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.chats.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.users.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.users.get(i3).serializeToStream(abstractSerializedData);
        }
    }
}
