package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
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

    public static TLRPC$updates_Difference TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$updates_Difference tLRPC$updates_Difference;
        switch (constructor) {
            case -1459938943:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_differenceSlice
                    public static int constructor = -1459938943;

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
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$MessageTLdeserialize == null) {
                                return;
                            }
                            this.new_messages.add(tLRPC$MessageTLdeserialize);
                        }
                        int int323 = stream2.readInt32(exception2);
                        if (int323 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = stream2.readInt32(exception2);
                        for (int i2 = 0; i2 < int324; i2++) {
                            TLRPC$EncryptedMessage tLRPC$EncryptedMessageTLdeserialize = TLRPC$EncryptedMessage.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$EncryptedMessageTLdeserialize == null) {
                                return;
                            }
                            this.new_encrypted_messages.add(tLRPC$EncryptedMessageTLdeserialize);
                        }
                        int int325 = stream2.readInt32(exception2);
                        if (int325 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int326; i3++) {
                            TLRPC$Update tLRPC$UpdateTLdeserialize = TLRPC$Update.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$UpdateTLdeserialize == null) {
                                return;
                            }
                            this.other_updates.add(tLRPC$UpdateTLdeserialize);
                        }
                        int int327 = stream2.readInt32(exception2);
                        if (int327 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
                            }
                            return;
                        }
                        int int328 = stream2.readInt32(exception2);
                        for (int i4 = 0; i4 < int328; i4++) {
                            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$ChatTLdeserialize == null) {
                                return;
                            }
                            this.chats.add(tLRPC$ChatTLdeserialize);
                        }
                        int int329 = stream2.readInt32(exception2);
                        if (int329 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int329)));
                            }
                            return;
                        }
                        int int3210 = stream2.readInt32(exception2);
                        for (int i5 = 0; i5 < int3210; i5++) {
                            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$UserTLdeserialize == null) {
                                return;
                            }
                            this.users.add(tLRPC$UserTLdeserialize);
                        }
                        this.intermediate_state = TLRPC$TL_updates_state.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.new_messages.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.new_messages.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size2 = this.new_encrypted_messages.size();
                        stream2.writeInt32(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            this.new_encrypted_messages.get(i2).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size3 = this.other_updates.size();
                        stream2.writeInt32(size3);
                        for (int i3 = 0; i3 < size3; i3++) {
                            this.other_updates.get(i3).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size4 = this.chats.size();
                        stream2.writeInt32(size4);
                        for (int i4 = 0; i4 < size4; i4++) {
                            this.chats.get(i4).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size5 = this.users.size();
                        stream2.writeInt32(size5);
                        for (int i5 = 0; i5 < size5; i5++) {
                            this.users.get(i5).serializeToStream(stream2);
                        }
                        this.intermediate_state.serializeToStream(stream2);
                    }
                };
                break;
            case 16030880:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_difference
                    public static int constructor = 16030880;

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
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$MessageTLdeserialize == null) {
                                return;
                            }
                            this.new_messages.add(tLRPC$MessageTLdeserialize);
                        }
                        int int323 = stream2.readInt32(exception2);
                        if (int323 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                            }
                            return;
                        }
                        int int324 = stream2.readInt32(exception2);
                        for (int i2 = 0; i2 < int324; i2++) {
                            TLRPC$EncryptedMessage tLRPC$EncryptedMessageTLdeserialize = TLRPC$EncryptedMessage.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$EncryptedMessageTLdeserialize == null) {
                                return;
                            }
                            this.new_encrypted_messages.add(tLRPC$EncryptedMessageTLdeserialize);
                        }
                        int int325 = stream2.readInt32(exception2);
                        if (int325 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
                            }
                            return;
                        }
                        int int326 = stream2.readInt32(exception2);
                        for (int i3 = 0; i3 < int326; i3++) {
                            TLRPC$Update tLRPC$UpdateTLdeserialize = TLRPC$Update.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$UpdateTLdeserialize == null) {
                                return;
                            }
                            this.other_updates.add(tLRPC$UpdateTLdeserialize);
                        }
                        int int327 = stream2.readInt32(exception2);
                        if (int327 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
                            }
                            return;
                        }
                        int int328 = stream2.readInt32(exception2);
                        for (int i4 = 0; i4 < int328; i4++) {
                            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$ChatTLdeserialize == null) {
                                return;
                            }
                            this.chats.add(tLRPC$ChatTLdeserialize);
                        }
                        int int329 = stream2.readInt32(exception2);
                        if (int329 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int329)));
                            }
                            return;
                        }
                        int int3210 = stream2.readInt32(exception2);
                        for (int i5 = 0; i5 < int3210; i5++) {
                            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$UserTLdeserialize == null) {
                                return;
                            }
                            this.users.add(tLRPC$UserTLdeserialize);
                        }
                        this.state = TLRPC$TL_updates_state.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.new_messages.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.new_messages.get(i).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size2 = this.new_encrypted_messages.size();
                        stream2.writeInt32(size2);
                        for (int i2 = 0; i2 < size2; i2++) {
                            this.new_encrypted_messages.get(i2).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size3 = this.other_updates.size();
                        stream2.writeInt32(size3);
                        for (int i3 = 0; i3 < size3; i3++) {
                            this.other_updates.get(i3).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size4 = this.chats.size();
                        stream2.writeInt32(size4);
                        for (int i4 = 0; i4 < size4; i4++) {
                            this.chats.get(i4).serializeToStream(stream2);
                        }
                        stream2.writeInt32(481674261);
                        int size5 = this.users.size();
                        stream2.writeInt32(size5);
                        for (int i5 = 0; i5 < size5; i5++) {
                            this.users.get(i5).serializeToStream(stream2);
                        }
                        this.state.serializeToStream(stream2);
                    }
                };
                break;
            case 1258196845:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_differenceTooLong
                    public static int constructor = 1258196845;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.pts = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.pts);
                    }
                };
                break;
            case 1567990072:
                tLRPC$updates_Difference = new TLRPC$updates_Difference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_differenceEmpty
                    public static int constructor = 1567990072;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.date = stream2.readInt32(exception2);
                        this.seq = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(this.seq);
                    }
                };
                break;
            default:
                tLRPC$updates_Difference = null;
                break;
        }
        if (tLRPC$updates_Difference == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in updates_Difference", Integer.valueOf(constructor)));
        }
        if (tLRPC$updates_Difference != null) {
            tLRPC$updates_Difference.readParams(stream, exception);
        }
        return tLRPC$updates_Difference;
    }
}
