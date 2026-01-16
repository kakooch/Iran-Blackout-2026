package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_exportedChatInvites extends TLObject {
    public static int constructor = -1111085620;
    public int count;
    public ArrayList<TLRPC$ExportedChatInvite> invites = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_exportedChatInvites TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_exportedChatInvites", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_exportedChatInvites tLRPC$TL_messages_exportedChatInvites = new TLRPC$TL_messages_exportedChatInvites();
        tLRPC$TL_messages_exportedChatInvites.readParams(stream, exception);
        return tLRPC$TL_messages_exportedChatInvites;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
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
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInviteTLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$ExportedChatInviteTLdeserialize == null) {
                return;
            }
            this.invites.add(tLRPC$ExportedChatInviteTLdeserialize);
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
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.count);
        stream.writeInt32(481674261);
        int size = this.invites.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.invites.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.users.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.users.get(i2).serializeToStream(stream);
        }
    }
}
