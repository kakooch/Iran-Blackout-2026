package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$updates_ChannelDifference extends TLObject {
    public TLRPC$Dialog dialog;
    public int flags;
    public boolean isFinal;
    public int pts;
    public int timeout;
    public ArrayList<TLRPC$Message> new_messages = new ArrayList<>();
    public ArrayList<TLRPC$Update> other_updates = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();

    public static TLRPC$updates_ChannelDifference TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference;
        if (i == -1531132162) {
            tLRPC$updates_ChannelDifference = new TLRPC$updates_ChannelDifference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_channelDifferenceTooLong
                public static int constructor = -1531132162;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.isFinal = (int32 & 1) != 0;
                    if ((int32 & 2) != 0) {
                        this.timeout = abstractSerializedData2.readInt32(z2);
                    }
                    this.dialog = TLRPC$Dialog.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
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
                    int i2 = this.isFinal ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeInt32(this.timeout);
                    }
                    this.dialog.serializeToStream(abstractSerializedData2);
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
        } else if (i != 543450958) {
            tLRPC$updates_ChannelDifference = i != 1041346555 ? null : new TLRPC$updates_ChannelDifference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_channelDifferenceEmpty
                public static int constructor = 1041346555;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.isFinal = (int32 & 1) != 0;
                    this.pts = abstractSerializedData2.readInt32(z2);
                    if ((this.flags & 2) != 0) {
                        this.timeout = abstractSerializedData2.readInt32(z2);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    int i2 = this.isFinal ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    abstractSerializedData2.writeInt32(this.pts);
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeInt32(this.timeout);
                    }
                }
            };
        } else {
            tLRPC$updates_ChannelDifference = new TLRPC$updates_ChannelDifference() { // from class: org.rbmain.tgnet.TLRPC$TL_updates_channelDifference
                public static int constructor = 543450958;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    this.flags = int32;
                    this.isFinal = (int32 & 1) != 0;
                    this.pts = abstractSerializedData2.readInt32(z2);
                    if ((this.flags & 2) != 0) {
                        this.timeout = abstractSerializedData2.readInt32(z2);
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
                        this.new_messages.add(tLRPC$MessageTLdeserialize);
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
                        TLRPC$Update tLRPC$UpdateTLdeserialize = TLRPC$Update.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$UpdateTLdeserialize == null) {
                            return;
                        }
                        this.other_updates.add(tLRPC$UpdateTLdeserialize);
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
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
                    }
                    int int328 = abstractSerializedData2.readInt32(z2);
                    if (int328 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int328)));
                        }
                        return;
                    }
                    int int329 = abstractSerializedData2.readInt32(z2);
                    for (int i5 = 0; i5 < int329; i5++) {
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
                    int i2 = this.isFinal ? this.flags | 1 : this.flags & (-2);
                    this.flags = i2;
                    abstractSerializedData2.writeInt32(i2);
                    abstractSerializedData2.writeInt32(this.pts);
                    if ((this.flags & 2) != 0) {
                        abstractSerializedData2.writeInt32(this.timeout);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.new_messages.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i3 = 0; i3 < size; i3++) {
                        this.new_messages.get(i3).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size2 = this.other_updates.size();
                    abstractSerializedData2.writeInt32(size2);
                    for (int i4 = 0; i4 < size2; i4++) {
                        this.other_updates.get(i4).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size3 = this.chats.size();
                    abstractSerializedData2.writeInt32(size3);
                    for (int i5 = 0; i5 < size3; i5++) {
                        this.chats.get(i5).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size4 = this.users.size();
                    abstractSerializedData2.writeInt32(size4);
                    for (int i6 = 0; i6 < size4; i6++) {
                        this.users.get(i6).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$updates_ChannelDifference == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in updates_ChannelDifference", Integer.valueOf(i)));
        }
        if (tLRPC$updates_ChannelDifference != null) {
            tLRPC$updates_ChannelDifference.readParams(abstractSerializedData, z);
        }
        return tLRPC$updates_ChannelDifference;
    }
}
