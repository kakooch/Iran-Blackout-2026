package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_Messages extends TLObject {
    public int count;
    public int flags;
    public boolean hasContinue;
    public boolean inexact;
    public String nextStartId;
    public int next_rate;
    public int offset_id_offset;
    public int pts;
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_Messages TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_Messages tLRPC$TL_messages_messages;
        switch (i) {
            case -1938715001:
                tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                break;
            case 978610270:
                tLRPC$TL_messages_messages = new TLRPC$messages_Messages() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_messagesSlice
                    public static int constructor = 978610270;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.inexact = (int32 & 2) != 0;
                        this.count = abstractSerializedData2.readInt32(z2);
                        if ((this.flags & 1) != 0) {
                            this.next_rate = abstractSerializedData2.readInt32(z2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.offset_id_offset = abstractSerializedData2.readInt32(z2);
                        }
                        int int322 = abstractSerializedData2.readInt32(z2);
                        if (int322 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = abstractSerializedData2.readInt32(z2);
                        for (int i2 = 0; i2 < int323; i2++) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$MessageTLdeserialize == null) {
                                return;
                            }
                            this.messages.add(tLRPC$MessageTLdeserialize);
                        }
                        int int324 = abstractSerializedData2.readInt32(z2);
                        if (int324 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                            }
                            return;
                        }
                        int int325 = abstractSerializedData2.readInt32(z2);
                        for (int i3 = 0; i3 < int325; i3++) {
                            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                            if (tLRPC$ChatTLdeserialize == null) {
                                return;
                            }
                            this.chats.add(tLRPC$ChatTLdeserialize);
                        }
                        int int326 = abstractSerializedData2.readInt32(z2);
                        if (int326 != 481674261) {
                            if (z2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                            }
                            return;
                        }
                        int int327 = abstractSerializedData2.readInt32(z2);
                        for (int i4 = 0; i4 < int327; i4++) {
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
                        int i2 = this.inexact ? this.flags | 2 : this.flags & (-3);
                        this.flags = i2;
                        abstractSerializedData2.writeInt32(i2);
                        abstractSerializedData2.writeInt32(this.count);
                        if ((this.flags & 1) != 0) {
                            abstractSerializedData2.writeInt32(this.next_rate);
                        }
                        if ((this.flags & 4) != 0) {
                            abstractSerializedData2.writeInt32(this.offset_id_offset);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size = this.messages.size();
                        abstractSerializedData2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.messages.get(i3).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size2 = this.chats.size();
                        abstractSerializedData2.writeInt32(size2);
                        for (int i4 = 0; i4 < size2; i4++) {
                            this.chats.get(i4).serializeToStream(abstractSerializedData2);
                        }
                        abstractSerializedData2.writeInt32(481674261);
                        int size3 = this.users.size();
                        abstractSerializedData2.writeInt32(size3);
                        for (int i5 = 0; i5 < size3; i5++) {
                            this.users.get(i5).serializeToStream(abstractSerializedData2);
                        }
                    }
                };
                break;
            case 1682413576:
                tLRPC$TL_messages_messages = new TLRPC$TL_messages_channelMessages();
                break;
            case 1951620897:
                tLRPC$TL_messages_messages = new TLRPC$messages_Messages() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_messagesNotModified
                    public static int constructor = 1951620897;

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
                break;
            default:
                tLRPC$TL_messages_messages = null;
                break;
        }
        if (tLRPC$TL_messages_messages == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Messages", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_messages != null) {
            tLRPC$TL_messages_messages.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_messages;
    }
}
