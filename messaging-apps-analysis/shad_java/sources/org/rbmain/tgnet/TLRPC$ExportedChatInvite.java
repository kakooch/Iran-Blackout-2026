package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$ExportedChatInvite extends TLObject {
    public static TLRPC$ExportedChatInvite TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ExportedChatInvite tLRPC$TL_chatInviteEmpty_layer122;
        if (i == -64092740) {
            tLRPC$TL_chatInviteEmpty_layer122 = new TLRPC$TL_chatInviteExported() { // from class: org.rbmain.tgnet.TLRPC$TL_chatInviteExported_layer122
                public static int constructor = -64092740;

                @Override // org.rbmain.tgnet.TLRPC$TL_chatInviteExported, org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.link = abstractSerializedData2.readString(z2);
                }

                @Override // org.rbmain.tgnet.TLRPC$TL_chatInviteExported, org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeString(this.link);
                }
            };
        } else if (i == 1776236393) {
            tLRPC$TL_chatInviteEmpty_layer122 = new TLRPC$TL_chatInviteEmpty_layer122();
        } else {
            tLRPC$TL_chatInviteEmpty_layer122 = i != 1847917725 ? null : new TLRPC$TL_chatInviteExported();
        }
        if (tLRPC$TL_chatInviteEmpty_layer122 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ExportedChatInvite", Integer.valueOf(i)));
        }
        if (tLRPC$TL_chatInviteEmpty_layer122 != null) {
            tLRPC$TL_chatInviteEmpty_layer122.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_chatInviteEmpty_layer122;
    }
}
