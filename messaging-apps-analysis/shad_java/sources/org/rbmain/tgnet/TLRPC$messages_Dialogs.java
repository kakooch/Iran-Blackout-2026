package org.rbmain.tgnet;

import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_Dialogs extends TLObject {
    public int count;
    public ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();
    public HashSet<Long> dialogKeys = new HashSet<>();

    public static TLRPC$messages_Dialogs TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_Dialogs tLRPC$TL_messages_dialogs;
        if (i == -253500010) {
            tLRPC$TL_messages_dialogs = new TLRPC$messages_Dialogs() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_dialogsNotModified
                public static int constructor = -253500010;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.count = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.count);
                }
            };
        } else if (i == 364538944) {
            tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
        } else {
            tLRPC$TL_messages_dialogs = i != 1910543603 ? null : new TLRPC$messages_Dialogs() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_dialogsSlice
                public static int constructor = 1910543603;

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
                        TLRPC$Dialog tLRPC$DialogTLdeserialize = TLRPC$Dialog.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$DialogTLdeserialize == null) {
                            return;
                        }
                        this.dialogs.add(tLRPC$DialogTLdeserialize);
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
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$MessageTLdeserialize == null) {
                            return;
                        }
                        this.messages.add(tLRPC$MessageTLdeserialize);
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
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
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
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(this.count);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.dialogs.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.dialogs.get(i2).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size2 = this.messages.size();
                    abstractSerializedData2.writeInt32(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        this.messages.get(i3).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size3 = this.chats.size();
                    abstractSerializedData2.writeInt32(size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        this.chats.get(i4).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size4 = this.users.size();
                    abstractSerializedData2.writeInt32(size4);
                    for (int i5 = 0; i5 < size4; i5++) {
                        this.users.get(i5).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$TL_messages_dialogs == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Dialogs", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_dialogs != null) {
            tLRPC$TL_messages_dialogs.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_dialogs;
    }
}
