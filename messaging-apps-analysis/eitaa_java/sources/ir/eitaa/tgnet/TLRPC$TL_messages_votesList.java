package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_votesList extends TLObject {
    public static int constructor = 136574537;
    public int count;
    public int flags;
    public String next_offset;
    public ArrayList<TLRPC$MessageUserVote> votes = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_votesList TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_votesList", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_votesList tLRPC$TL_messages_votesList = new TLRPC$TL_messages_votesList();
        tLRPC$TL_messages_votesList.readParams(stream, exception);
        return tLRPC$TL_messages_votesList;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.count = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$MessageUserVote tLRPC$MessageUserVoteTLdeserialize = TLRPC$MessageUserVote.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$MessageUserVoteTLdeserialize == null) {
                return;
            }
            this.votes.add(tLRPC$MessageUserVoteTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
        if ((this.flags & 1) != 0) {
            this.next_offset = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(this.count);
        stream.writeInt32(481674261);
        int size = this.votes.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.votes.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.users.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.users.get(i2).serializeToStream(stream);
        }
        if ((this.flags & 1) != 0) {
            stream.writeString(this.next_offset);
        }
    }
}
