package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_help_promoData extends TLRPC$help_PromoData {
    public static int constructor = -1942390465;
    public int expires;
    public int flags;
    public TLRPC$Peer peer;
    public boolean proxy;
    public String psa_message;
    public String psa_type;
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.proxy = (int32 & 1) != 0;
        this.expires = stream.readInt32(exception);
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
        }
        int int324 = stream.readInt32(exception);
        if (int324 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
        if ((this.flags & 2) != 0) {
            this.psa_type = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.psa_message = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.proxy ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.expires);
        this.peer.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.chats.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.chats.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.users.size();
        stream.writeInt32(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            this.users.get(i3).serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.psa_type);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.psa_message);
        }
    }
}
