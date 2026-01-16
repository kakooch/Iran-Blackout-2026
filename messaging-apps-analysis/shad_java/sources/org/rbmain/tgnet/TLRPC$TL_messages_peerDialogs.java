package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_peerDialogs extends TLObject {
    public static int constructor = 863093588;
    public TLRPC$TL_updates_state state;
    public ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_peerDialogs TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_peerDialogs", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = new TLRPC$TL_messages_peerDialogs();
        tLRPC$TL_messages_peerDialogs.readParams(abstractSerializedData, z);
        return tLRPC$TL_messages_peerDialogs;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$Dialog tLRPC$DialogTLdeserialize = TLRPC$Dialog.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$DialogTLdeserialize == null) {
                return;
            }
            this.dialogs.add(tLRPC$DialogTLdeserialize);
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
            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$MessageTLdeserialize == null) {
                return;
            }
            this.messages.add(tLRPC$MessageTLdeserialize);
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
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
        }
        int int327 = abstractSerializedData.readInt32(z);
        if (int327 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = abstractSerializedData.readInt32(z);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
        this.state = TLRPC$TL_updates_state.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.dialogs.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.dialogs.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.messages.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.messages.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.chats.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.chats.get(i3).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size4 = this.users.size();
        abstractSerializedData.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(abstractSerializedData);
        }
        this.state.serializeToStream(abstractSerializedData);
    }
}
