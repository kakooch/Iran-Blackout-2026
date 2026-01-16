package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_Dialogs extends TLObject {
    public int count;
    public ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_Dialogs TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_Dialogs tLRPC$TL_messages_dialogs;
        if (constructor == -253500010) {
            tLRPC$TL_messages_dialogs = new TLRPC$messages_Dialogs() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_dialogsNotModified
                public static int constructor = -253500010;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.count = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.count);
                }
            };
        } else if (constructor == 364538944) {
            tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
        } else {
            tLRPC$TL_messages_dialogs = constructor != 1910543603 ? null : new TLRPC$messages_Dialogs() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_dialogsSlice
                public static int constructor = 1910543603;

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
                        TLRPC$Dialog tLRPC$DialogTLdeserialize = TLRPC$Dialog.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$DialogTLdeserialize == null) {
                            return;
                        }
                        this.dialogs.add(tLRPC$DialogTLdeserialize);
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
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$MessageTLdeserialize == null) {
                            return;
                        }
                        this.messages.add(tLRPC$MessageTLdeserialize);
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
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
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
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.count);
                    stream2.writeInt32(481674261);
                    int size = this.dialogs.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.dialogs.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.messages.size();
                    stream2.writeInt32(size2);
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.messages.get(i2).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size3 = this.chats.size();
                    stream2.writeInt32(size3);
                    for (int i3 = 0; i3 < size3; i3++) {
                        this.chats.get(i3).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size4 = this.users.size();
                    stream2.writeInt32(size4);
                    for (int i4 = 0; i4 < size4; i4++) {
                        this.users.get(i4).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$TL_messages_dialogs == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Dialogs", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_dialogs != null) {
            tLRPC$TL_messages_dialogs.readParams(stream, exception);
        }
        return tLRPC$TL_messages_dialogs;
    }
}
