package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$contacts_Blocked extends TLObject {
    public int count;
    public ArrayList<TLRPC$TL_peerBlocked> blocked = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$contacts_Blocked TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$contacts_Blocked tLRPC$contacts_Blocked;
        if (constructor != -513392236) {
            tLRPC$contacts_Blocked = constructor != 182326673 ? null : new TLRPC$contacts_Blocked() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_blocked
                public static int constructor = 182326673;

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
                        TLRPC$TL_peerBlocked tLRPC$TL_peerBlockedTLdeserialize = TLRPC$TL_peerBlocked.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_peerBlockedTLdeserialize == null) {
                            return;
                        }
                        this.blocked.add(tLRPC$TL_peerBlockedTLdeserialize);
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
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
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
                    stream2.writeInt32(481674261);
                    int size = this.blocked.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.blocked.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.chats.size();
                    stream2.writeInt32(size2);
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.chats.get(i2).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size3 = this.users.size();
                    stream2.writeInt32(size3);
                    for (int i3 = 0; i3 < size3; i3++) {
                        this.users.get(i3).serializeToStream(stream2);
                    }
                }
            };
        } else {
            tLRPC$contacts_Blocked = new TLRPC$contacts_Blocked() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_blockedSlice
                public static int constructor = -513392236;

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
                        TLRPC$TL_peerBlocked tLRPC$TL_peerBlockedTLdeserialize = TLRPC$TL_peerBlocked.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_peerBlockedTLdeserialize == null) {
                            return;
                        }
                        this.blocked.add(tLRPC$TL_peerBlockedTLdeserialize);
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
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
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
                    int size = this.blocked.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.blocked.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.chats.size();
                    stream2.writeInt32(size2);
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.chats.get(i2).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size3 = this.users.size();
                    stream2.writeInt32(size3);
                    for (int i3 = 0; i3 < size3; i3++) {
                        this.users.get(i3).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$contacts_Blocked == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_Blocked", Integer.valueOf(constructor)));
        }
        if (tLRPC$contacts_Blocked != null) {
            tLRPC$contacts_Blocked.readParams(stream, exception);
        }
        return tLRPC$contacts_Blocked;
    }
}
