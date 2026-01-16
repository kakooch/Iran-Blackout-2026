package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_ExportedChatInvite extends TLObject {
    public TLRPC$ExportedChatInvite invite;
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_ExportedChatInvite TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_ExportedChatInvite tLRPC$TL_messages_exportedChatInviteReplaced;
        if (constructor != 410107472) {
            tLRPC$TL_messages_exportedChatInviteReplaced = constructor != 572915951 ? null : new TLRPC$TL_messages_exportedChatInviteReplaced();
        } else {
            tLRPC$TL_messages_exportedChatInviteReplaced = new TLRPC$messages_ExportedChatInvite() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInvite
                public static int constructor = 410107472;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.invite = TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    this.invite.serializeToStream(stream2);
                    stream2.writeInt32(481674261);
                    int size = this.users.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.users.get(i).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$TL_messages_exportedChatInviteReplaced == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_ExportedChatInvite", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messages_exportedChatInviteReplaced != null) {
            tLRPC$TL_messages_exportedChatInviteReplaced.readParams(stream, exception);
        }
        return tLRPC$TL_messages_exportedChatInviteReplaced;
    }
}
