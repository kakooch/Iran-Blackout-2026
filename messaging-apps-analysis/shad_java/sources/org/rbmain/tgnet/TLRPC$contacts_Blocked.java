package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$contacts_Blocked extends TLObject {
    public int count;
    public boolean hasContinue;
    public String nextStartId;
    public ArrayList<TLRPC$TL_peerBlocked> blocked = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$contacts_Blocked TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$contacts_Blocked tLRPC$TL_contacts_blocked;
        if (i != -513392236) {
            tLRPC$TL_contacts_blocked = i != 182326673 ? null : new TLRPC$TL_contacts_blocked();
        } else {
            tLRPC$TL_contacts_blocked = new TLRPC$contacts_Blocked() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_blockedSlice
                public static int constructor = -513392236;

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
                        TLRPC$TL_peerBlocked tLRPC$TL_peerBlockedTLdeserialize = TLRPC$TL_peerBlocked.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$TL_peerBlockedTLdeserialize == null) {
                            return;
                        }
                        this.blocked.add(tLRPC$TL_peerBlockedTLdeserialize);
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
                        TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$ChatTLdeserialize == null) {
                            return;
                        }
                        this.chats.add(tLRPC$ChatTLdeserialize);
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
                    int size = this.blocked.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.blocked.get(i2).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size2 = this.chats.size();
                    abstractSerializedData2.writeInt32(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        this.chats.get(i3).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(481674261);
                    int size3 = this.users.size();
                    abstractSerializedData2.writeInt32(size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        this.users.get(i4).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$TL_contacts_blocked == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_Blocked", Integer.valueOf(i)));
        }
        if (tLRPC$TL_contacts_blocked != null) {
            tLRPC$TL_contacts_blocked.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_contacts_blocked;
    }
}
