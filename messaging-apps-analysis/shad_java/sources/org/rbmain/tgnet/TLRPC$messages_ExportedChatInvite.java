package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$messages_ExportedChatInvite extends TLObject {
    public TLRPC$ExportedChatInvite invite;
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$messages_ExportedChatInvite TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_ExportedChatInvite tLRPC$TL_messages_exportedChatInviteReplaced;
        if (i != 410107472) {
            tLRPC$TL_messages_exportedChatInviteReplaced = i != 572915951 ? null : new TLRPC$TL_messages_exportedChatInviteReplaced();
        } else {
            tLRPC$TL_messages_exportedChatInviteReplaced = new TLRPC$messages_ExportedChatInvite() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInvite
                public static int constructor = 410107472;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.invite = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    this.invite.serializeToStream(abstractSerializedData2);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.users.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.users.get(i2).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$TL_messages_exportedChatInviteReplaced == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_ExportedChatInvite", Integer.valueOf(i)));
        }
        if (tLRPC$TL_messages_exportedChatInviteReplaced != null) {
            tLRPC$TL_messages_exportedChatInviteReplaced.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_messages_exportedChatInviteReplaced;
    }
}
