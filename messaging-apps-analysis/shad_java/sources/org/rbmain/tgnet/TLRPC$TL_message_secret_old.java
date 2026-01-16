package org.rbmain.tgnet;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class TLRPC$TL_message_secret_old extends TLRPC$TL_message_secret {
    public static int constructor = 1431655928;

    @Override // org.rbmain.tgnet.TLRPC$TL_message_secret, org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z) | 256 | 512;
        this.flags = int32;
        this.unread = (int32 & 1) != 0;
        this.out = (int32 & 2) != 0;
        this.mentioned = (int32 & 16) != 0;
        this.media_unread = (int32 & 32) != 0;
        this.id = abstractSerializedData.readInt32(z);
        this.ttl = abstractSerializedData.readInt32(z);
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = abstractSerializedData.readInt32(z);
        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.date = abstractSerializedData.readInt32(z);
        this.message = abstractSerializedData.readString(z);
        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.media = tLRPC$MessageMediaTLdeserialize;
        if (tLRPC$MessageMediaTLdeserialize == null || TextUtils.isEmpty(tLRPC$MessageMediaTLdeserialize.captionLegacy)) {
            return;
        }
        this.message = this.media.captionLegacy;
    }

    @Override // org.rbmain.tgnet.TLRPC$TL_message_secret, org.rbmain.tgnet.TLRPC$TL_message, org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.unread ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.out ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.mentioned ? i2 | 16 : i2 & (-17);
        this.flags = i3;
        int i4 = this.media_unread ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        abstractSerializedData.writeInt32(i4);
        abstractSerializedData.writeInt32((int) this.id);
        abstractSerializedData.writeInt32(this.ttl);
        abstractSerializedData.writeInt32(this.from_id.user_id);
        this.peer_id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeString(this.message);
        this.media.serializeToStream(abstractSerializedData);
        writeAttachPath(abstractSerializedData);
    }
}
