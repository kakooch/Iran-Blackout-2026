package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$ChatInvite extends TLObject {
    public boolean broadcast;
    public boolean channel;
    public TLRPC$Chat chat;
    public int expires;
    public int flags;
    public boolean isPublic;
    public boolean megagroup;
    public ArrayList<TLRPC$User> participants = new ArrayList<>();
    public int participants_count;
    public TLRPC$Photo photo;
    public String title;

    public static TLRPC$ChatInvite TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChatInvite tLRPC$TL_chatInvite;
        if (i == -540871282) {
            tLRPC$TL_chatInvite = new TLRPC$TL_chatInvite();
        } else if (i != 1516793212) {
            tLRPC$TL_chatInvite = i != 1634294960 ? null : new TLRPC$ChatInvite() { // from class: org.rbmain.tgnet.TLRPC$TL_chatInvitePeek
                public static int constructor = 1634294960;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.chat = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    this.expires = abstractSerializedData2.readInt32(z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    this.chat.serializeToStream(abstractSerializedData2);
                    abstractSerializedData2.writeInt32(this.expires);
                }
            };
        } else {
            tLRPC$TL_chatInvite = new TLRPC$ChatInvite() { // from class: org.rbmain.tgnet.TLRPC$TL_chatInviteAlready
                public static int constructor = 1516793212;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.chat = TLRPC$Chat.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    this.chat.serializeToStream(abstractSerializedData2);
                }
            };
        }
        if (tLRPC$TL_chatInvite == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ChatInvite", Integer.valueOf(i)));
        }
        if (tLRPC$TL_chatInvite != null) {
            tLRPC$TL_chatInvite.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_chatInvite;
    }
}
