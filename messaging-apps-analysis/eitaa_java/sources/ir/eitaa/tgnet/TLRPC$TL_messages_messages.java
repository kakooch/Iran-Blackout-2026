package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_messages extends TLRPC$messages_Messages {
    public static int constructor = -1938715001;

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
            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$MessageTLdeserialize == null) {
                return;
            }
            this.messages.add(tLRPC$MessageTLdeserialize);
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
            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$ChatTLdeserialize == null) {
                return;
            }
            this.chats.add(tLRPC$ChatTLdeserialize);
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
        stream.writeInt32(481674261);
        int size = this.messages.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.messages.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.chats.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.chats.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.users.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.users.get(i3).serializeToStream(stream);
        }
    }
}
