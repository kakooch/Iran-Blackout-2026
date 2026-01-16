package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$updates_Difference extends TLObject {
    public int date;
    public TLRPC$TL_updates_state intermediate_state;
    public int pts;
    public int seq;
    public TLRPC$TL_updates_state state;
    public ArrayList<TLRPC$Message> new_messages = new ArrayList<>();
    public ArrayList<TLRPC$EncryptedMessage> new_encrypted_messages = new ArrayList<>();
    public ArrayList<TLRPC$Update> other_updates = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$updates_Difference TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$updates_Difference tLRPC$updates_Difference;
        switch (i) {
            case -1459938943:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_differenceSlice
                    public static int constructor = -1459938943;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$MessageTLdeserialize == null) {
                                return;
                            }
                            this.new_messages.add(tLRPC$MessageTLdeserialize);
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        if (int323 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$EncryptedMessage tLRPC$EncryptedMessageTLdeserialize = TLRPC$EncryptedMessage.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$EncryptedMessageTLdeserialize == null) {
                                return;
                            }
                            this.new_encrypted_messages.add(tLRPC$EncryptedMessageTLdeserialize);
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        if (int325 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int326; i4++) {
                            TLRPC$Update tLRPC$UpdateTLdeserialize = TLRPC$Update.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$UpdateTLdeserialize == null) {
                                return;
                            }
                            this.other_updates.add(tLRPC$UpdateTLdeserialize);
                        }
                        int int327 = abstractSerializedData2.readInt32(z2);
                        if (int327 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
                            }
                            return;
                        }
                        int int328 = abstractSerializedData2.readInt32(z2);
                        for (int i5 = 0; i5 < int328; i5++) {
                            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$ChatTLdeserialize == null) {
                                return;
                            }
                            this.chats.add(tLRPC$ChatTLdeserialize);
                        }
                        int int329 = abstractSerializedData2.readInt32(z2);
                        if (int329 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int329)));
                            }
                            return;
                        }
                        int int3210 = abstractSerializedData2.readInt32(z2);
                        for (int i6 = 0; i6 < int3210; i6++) {
                            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$UserTLdeserialize == null) {
                                return;
                            }
                            this.users.add(tLRPC$UserTLdeserialize);
                        }
                        this.intermediate_state = TLRPC$TL_updates_state.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.new_messages.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.new_messages.get(i2).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.new_encrypted_messages.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i3 = 0; i3 < size2; i3++) {
                            this.new_encrypted_messages.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.other_updates.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i4 = 0; i4 < size3; i4++) {
                            this.other_updates.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size4 = this.chats.size();
                        abstractSerializedData2.writeInt32(size4);
                        for (int i5 = 0; i5 < size4; i5++) {
                            this.chats.get(i5).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size5 = this.users.size();
                        abstractSerializedData2.writeInt32(size5);
                        for (int i6 = 0; i6 < size5; i6++) {
                            this.users.get(i6).serializeToStream(abstractSerializedData2);
                        }
                        this.intermediate_state.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 16030880:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_difference
                    public static int constructor = 16030880;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        if (int32 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int322; i2++) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$MessageTLdeserialize == null) {
                                return;
                            }
                            this.new_messages.add(tLRPC$MessageTLdeserialize);
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        if (int323 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int324; i3++) {
                            TLRPC$EncryptedMessage tLRPC$EncryptedMessageTLdeserialize = TLRPC$EncryptedMessage.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$EncryptedMessageTLdeserialize == null) {
                                return;
                            }
                            this.new_encrypted_messages.add(tLRPC$EncryptedMessageTLdeserialize);
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        if (int325 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int326; i4++) {
                            TLRPC$Update tLRPC$UpdateTLdeserialize = TLRPC$Update.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$UpdateTLdeserialize == null) {
                                return;
                            }
                            this.other_updates.add(tLRPC$UpdateTLdeserialize);
                        }
                        int int327 = abstractSerializedData2.readInt32(z2);
                        if (int327 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
                            }
                            return;
                        }
                        int int328 = abstractSerializedData2.readInt32(z2);
                        for (int i5 = 0; i5 < int328; i5++) {
                            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$ChatTLdeserialize == null) {
                                return;
                            }
                            this.chats.add(tLRPC$ChatTLdeserialize);
                        }
                        int int329 = abstractSerializedData2.readInt32(z2);
                        if (int329 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int329)));
                            }
                            return;
                        }
                        int int3210 = abstractSerializedData2.readInt32(z2);
                        for (int i6 = 0; i6 < int3210; i6++) {
                            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$UserTLdeserialize == null) {
                                return;
                            }
                            this.users.add(tLRPC$UserTLdeserialize);
                        }
                        this.state = TLRPC$TL_updates_state.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.new_messages.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i2 = 0; i2 < size; i2++) {
                            this.new_messages.get(i2).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.new_encrypted_messages.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i3 = 0; i3 < size2; i3++) {
                            this.new_encrypted_messages.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.other_updates.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i4 = 0; i4 < size3; i4++) {
                            this.other_updates.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size4 = this.chats.size();
                        abstractSerializedData2.writeInt32(size4);
                        for (int i5 = 0; i5 < size4; i5++) {
                            this.chats.get(i5).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size5 = this.users.size();
                        abstractSerializedData2.writeInt32(size5);
                        for (int i6 = 0; i6 < size5; i6++) {
                            this.users.get(i6).serializeToStream(abstractSerializedData2);
                        }
                        this.state.serializeToStream(abstractSerializedData2);
                    }
                };
                break;
            case 1258196845:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_differenceTooLong
                    public static int constructor = 1258196845;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.pts = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.pts);
                    }
                };
                break;
            case 1567990072:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_differenceEmpty
                    public static int constructor = 1567990072;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.date = abstractSerializedData2.readInt32(z2);
                        this.seq = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.date);
                        abstractSerializedData2.writeInt32(this.seq);
                    }
                };
                break;
            default:
                tLRPC$updates_Difference = null;
                break;
        }
        if (tLRPC$updates_Difference == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in updates_Difference", Integer.valueOf(i)));
        }
        if (tLRPC$updates_Difference != null) {
            tLRPC$updates_Difference.readParams(abstractSerializedData, z);
        }
        return tLRPC$updates_Difference;
    }
}
