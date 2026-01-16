package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_exportedChatInvites extends TLObject {
    public static int constructor = -1111085620;
    public int count;
    public ArrayList<TLRPC$ExportedChatInvite> invites = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_exportedChatInvites TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_exportedChatInvites", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_messages_exportedChatInvites tLRPC$TL_messages_exportedChatInvites = new TLRPC$TL_messages_exportedChatInvites();
        tLRPC$TL_messages_exportedChatInvites.readParams(abstractSerializedData, z);
        return tLRPC$TL_messages_exportedChatInvites;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.count = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$ExportedChatInviteTLdeserialize == null) {
                return;
            }
            this.invites.add(tLRPC$ExportedChatInviteTLdeserialize);
        }
        int int323 = abstractSerializedData.readInt32(z);
        if (int323 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.count);
        abstractSerializedData.writeInt32(481674261);
        int size = this.invites.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.invites.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.users.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.users.get(i2).serializeToStream(abstractSerializedData);
        }
    }
}
