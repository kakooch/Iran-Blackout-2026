package org.rbmain.tgnet;

import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public class TLRPC$TL_channelForbidden extends TLRPC$Chat {
    public static int constructor = 681420594;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.broadcast = (int32 & 32) != 0;
        this.megagroup = (int32 & 256) != 0;
        this.id = abstractSerializedData.readInt32(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.title = abstractSerializedData.readString(z);
        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
            this.until_date = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.broadcast ? this.flags | 32 : this.flags & (-33);
        this.flags = i;
        int i2 = this.megagroup ? i | 256 : i & (-257);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeInt32(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeString(this.title);
        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
            abstractSerializedData.writeInt32(this.until_date);
        }
    }
}
