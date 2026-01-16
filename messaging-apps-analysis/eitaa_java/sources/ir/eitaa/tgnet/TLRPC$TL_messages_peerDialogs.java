package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_peerDialogs extends TLObject {
    public static int constructor = 863093588;
    public TLRPC$TL_updates_state state;
    public ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();
    public ArrayList<TLRPC$Message> messages = new ArrayList<>();
    public ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_messages_peerDialogs TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_peerDialogs", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_peerDialogs tLRPC$TL_messages_peerDialogs = new TLRPC$TL_messages_peerDialogs();
        tLRPC$TL_messages_peerDialogs.readParams(stream, exception);
        return tLRPC$TL_messages_peerDialogs;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$Dialog tLRPC$DialogTLdeserialize = TLRPC$Dialog.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DialogTLdeserialize == null) {
                return;
            }
            this.dialogs.add(tLRPC$DialogTLdeserialize);
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
            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$MessageTLdeserialize == null) {
                return;
            }
            this.messages.add(tLRPC$MessageTLdeserialize);
        }
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
        }
        int int327 = stream.readInt32(exception);
        if (int327 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = stream.readInt32(exception);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
        this.state = TLRPC$TL_updates_state.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.dialogs.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.dialogs.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.messages.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.messages.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.chats.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.chats.get(i3).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size4 = this.users.size();
        stream.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(stream);
        }
        this.state.serializeToStream(stream);
    }
}
