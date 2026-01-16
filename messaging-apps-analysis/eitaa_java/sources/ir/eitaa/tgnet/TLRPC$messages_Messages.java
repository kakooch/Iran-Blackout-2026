package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_Messages extends TLObject {
    public int count;
    public int flags;
    public boolean inexact;
    public int next_rate;
    public int offset_id_offset;
    public int pts;
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_Messages TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_Messages tLRPC$TL_messages_messages;
        switch (constructor) {
            case -1938715001:
                tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                break;
            case 978610270:
                tLRPC$TL_messages_messages = new TLRPC$messages_Messages() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_messagesSlice
                    public static int constructor = 978610270;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.inexact = (int32 & 2) != 0;
                        this.count = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.next_rate = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.offset_id_offset = stream2.readInt32(exception2);
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
                        int i = this.inexact ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32(this.count);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.next_rate);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.offset_id_offset);
                        }
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
                break;
            case 1682413576:
                tLRPC$TL_messages_messages = new TLRPC$messages_Messages() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_channelMessages
                    public static int constructor = 1682413576;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.inexact = (int32 & 2) != 0;
                        this.pts = stream2.readInt32(exception2);
                        this.count = stream2.readInt32(exception2);
                        if ((this.flags & 4) != 0) {
                            this.offset_id_offset = stream2.readInt32(exception2);
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
                        int i = this.inexact ? this.flags | 2 : this.flags & (-3);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt32(this.pts);
                        stream2.writeInt32(this.count);
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.offset_id_offset);
                        }
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
                break;
            case 1951620897:
                tLRPC$TL_messages_messages = new TLRPC$messages_Messages() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_messagesNotModified
                    public static int constructor = 1951620897;

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
                break;
            default:
                tLRPC$TL_messages_messages = null;
                break;
        }
        if (tLRPC$TL_messages_messages == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_Messages", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_messages != null) {
            tLRPC$TL_messages_messages.readParams(stream, exception);
        }
        return tLRPC$TL_messages_messages;
    }
}
