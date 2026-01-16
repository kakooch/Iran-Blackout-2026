package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_votesList extends TLObject {
    public static int constructor = 136574537;
    public int count;
    public int flags;
    public boolean hasContinue;
    public String next_offset;
    public ArrayList<TLRPC$MessageUserVote> votes = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_votesList TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_votesList", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_messages_votesList tLRPC$TL_messages_votesList = new TLRPC$TL_messages_votesList();
        tLRPC$TL_messages_votesList.readParams(abstractSerializedData, z);
        return tLRPC$TL_messages_votesList;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
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
            TLRPC$MessageUserVote tLRPC$MessageUserVoteTLdeserialize = TLRPC$MessageUserVote.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$MessageUserVoteTLdeserialize == null) {
                return;
            }
            this.votes.add(tLRPC$MessageUserVoteTLdeserialize);
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
        if ((this.flags & 1) != 0) {
            this.next_offset = abstractSerializedData.readString(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt32(this.count);
        abstractSerializedData.writeInt32(481674261);
        int size = this.votes.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.votes.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.users.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.users.get(i2).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.next_offset);
        }
    }
}
