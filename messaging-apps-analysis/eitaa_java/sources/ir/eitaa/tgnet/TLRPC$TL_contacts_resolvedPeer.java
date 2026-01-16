package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_resolvedPeer extends TLObject {
    public static int constructor = 2131196633;
    public TLRPC$Peer peer;
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_contacts_resolvedPeer TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_contacts_resolvedPeer", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = new TLRPC$TL_contacts_resolvedPeer();
        tLRPC$TL_contacts_resolvedPeer.readParams(stream, exception);
        return tLRPC$TL_contacts_resolvedPeer;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
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
        this.peer.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.chats.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.chats.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.users.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.users.get(i2).serializeToStream(stream);
        }
    }
}
