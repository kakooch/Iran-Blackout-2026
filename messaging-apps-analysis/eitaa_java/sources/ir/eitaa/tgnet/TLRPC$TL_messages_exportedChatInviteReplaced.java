package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_exportedChatInviteReplaced extends TLRPC$messages_ExportedChatInvite {
    public static int constructor = 572915951;
    public TLRPC$ExportedChatInvite new_invite;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.invite = TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_invite = TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
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
        this.invite.serializeToStream(stream);
        this.new_invite.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.users.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.users.get(i).serializeToStream(stream);
        }
    }
}
