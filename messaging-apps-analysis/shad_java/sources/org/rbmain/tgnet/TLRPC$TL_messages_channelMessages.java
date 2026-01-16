package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_channelMessages extends TLRPC$messages_Messages {
    public static int constructor = 1682413576;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.inexact = (int32 & 2) != 0;
        this.pts = abstractSerializedData.readInt32(z);
        this.count = abstractSerializedData.readInt32(z);
        if ((this.flags & 4) != 0) {
            this.offset_id_offset = abstractSerializedData.readInt32(z);
        }
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$MessageTLdeserialize == null) {
                return;
            }
            this.messages.add(tLRPC$MessageTLdeserialize);
        }
        int int324 = abstractSerializedData.readInt32(z);
        if (int324 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
        }
        int int326 = abstractSerializedData.readInt32(z);
        if (int326 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
            }
            return;
        }
        int int327 = abstractSerializedData.readInt32(z);
        for (int i3 = 0; i3 < int327; i3++) {
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
        int i = this.inexact ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(this.pts);
        abstractSerializedData.writeInt32(this.count);
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.offset_id_offset);
        }
        abstractSerializedData.writeInt32(481674261);
        int size = this.messages.size();
        abstractSerializedData.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.messages.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.chats.size();
        abstractSerializedData.writeInt32(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            this.chats.get(i3).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.users.size();
        abstractSerializedData.writeInt32(size3);
        for (int i4 = 0; i4 < size3; i4++) {
            this.users.get(i4).serializeToStream(abstractSerializedData);
        }
    }
}
