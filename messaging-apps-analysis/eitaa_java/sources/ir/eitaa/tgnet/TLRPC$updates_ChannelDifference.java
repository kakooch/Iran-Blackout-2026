package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
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

    public static TLRPC$updates_ChannelDifference TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$updates_ChannelDifference tLRPC$updates_ChannelDifference;
        if (constructor == -1531132162) {
            tLRPC$updates_ChannelDifference = new TLRPC$updates_ChannelDifference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_channelDifferenceTooLong
                public static int constructor = -1531132162;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.isFinal = (int32 & 1) != 0;
                    if ((int32 & 2) != 0) {
                        this.timeout = stream2.readInt32(exception2);
                    }
                    this.dialog = TLRPC$Dialog.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    int int322 = stream2.readInt32(exception2);
                    if (int322 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = stream2.readInt32(exception2);
                    for (int i = 0; i < int323; i++) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$MessageTLdeserialize == null) {
                            return;
                        }
                        this.messages.add(tLRPC$MessageTLdeserialize);
                    }
                    int int324 = stream2.readInt32(exception2);
                    if (int324 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                        }
                        return;
                    }
                    int int325 = stream2.readInt32(exception2);
                    for (int i2 = 0; i2 < int325; i2++) {
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
                    }
                    int int326 = stream2.readInt32(exception2);
                    if (int326 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                        }
                        return;
                    }
                    int int327 = stream2.readInt32(exception2);
                    for (int i3 = 0; i3 < int327; i3++) {
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
                    int i = this.isFinal ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    stream2.writeInt32(i);
                    if ((this.flags & 2) != 0) {
                        stream2.writeInt32(this.timeout);
                    }
                    this.dialog.serializeToStream(stream2);
                    stream2.writeInt32(481674261);
                    int size = this.messages.size();
                    stream2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.messages.get(i2).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.chats.size();
                    stream2.writeInt32(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        this.chats.get(i3).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size3 = this.users.size();
                    stream2.writeInt32(size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        this.users.get(i4).serializeToStream(stream2);
                    }
                }
            };
        } else if (constructor != 543450958) {
            tLRPC$updates_ChannelDifference = constructor != 1041346555 ? null : new TLRPC$updates_ChannelDifference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_channelDifferenceEmpty
                public static int constructor = 1041346555;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.isFinal = (int32 & 1) != 0;
                    this.pts = stream2.readInt32(exception2);
                    if ((this.flags & 2) != 0) {
                        this.timeout = stream2.readInt32(exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.isFinal ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    stream2.writeInt32(i);
                    stream2.writeInt32(this.pts);
                    if ((this.flags & 2) != 0) {
                        stream2.writeInt32(this.timeout);
                    }
                }
            };
        } else {
            tLRPC$updates_ChannelDifference = new TLRPC$updates_ChannelDifference() { // from class: ir.eitaa.tgnet.TLRPC$TL_updates_channelDifference
                public static int constructor = 543450958;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.isFinal = (int32 & 1) != 0;
                    this.pts = stream2.readInt32(exception2);
                    if ((this.flags & 2) != 0) {
                        this.timeout = stream2.readInt32(exception2);
                    }
                    int int322 = stream2.readInt32(exception2);
                    if (int322 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                        }
                        return;
                    }
                    int int323 = stream2.readInt32(exception2);
                    for (int i = 0; i < int323; i++) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$MessageTLdeserialize == null) {
                            return;
                        }
                        this.new_messages.add(tLRPC$MessageTLdeserialize);
                    }
                    int int324 = stream2.readInt32(exception2);
                    if (int324 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                        }
                        return;
                    }
                    int int325 = stream2.readInt32(exception2);
                    for (int i2 = 0; i2 < int325; i2++) {
                        TLRPC$Update tLRPC$UpdateTLdeserialize = TLRPC$Update.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$UpdateTLdeserialize == null) {
                            return;
                        }
                        this.other_updates.add(tLRPC$UpdateTLdeserialize);
                    }
                    int int326 = stream2.readInt32(exception2);
                    if (int326 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
                        }
                        return;
                    }
                    int int327 = stream2.readInt32(exception2);
                    for (int i3 = 0; i3 < int327; i3++) {
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
                    }
                    int int328 = stream2.readInt32(exception2);
                    if (int328 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int328)));
                        }
                        return;
                    }
                    int int329 = stream2.readInt32(exception2);
                    for (int i4 = 0; i4 < int329; i4++) {
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
                    int i = this.isFinal ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    stream2.writeInt32(i);
                    stream2.writeInt32(this.pts);
                    if ((this.flags & 2) != 0) {
                        stream2.writeInt32(this.timeout);
                    }
                    stream2.writeInt32(481674261);
                    int size = this.new_messages.size();
                    stream2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.new_messages.get(i2).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.other_updates.size();
                    stream2.writeInt32(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        this.other_updates.get(i3).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size3 = this.chats.size();
                    stream2.writeInt32(size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        this.chats.get(i4).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size4 = this.users.size();
                    stream2.writeInt32(size4);
                    for (int i5 = 0; i5 < size4; i5++) {
                        this.users.get(i5).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$updates_ChannelDifference == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in updates_ChannelDifference", Integer.valueOf(constructor)));
        }
        if (tLRPC$updates_ChannelDifference != null) {
            tLRPC$updates_ChannelDifference.readParams(stream, exception);
        }
        return tLRPC$updates_ChannelDifference;
    }
}
