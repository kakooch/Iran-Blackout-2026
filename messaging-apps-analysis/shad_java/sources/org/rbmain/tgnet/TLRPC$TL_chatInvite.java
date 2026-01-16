package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatInvite extends TLRPC$ChatInvite {
    public static int constructor = -540871282;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.channel = (int32 & 1) != 0;
        this.broadcast = (int32 & 2) != 0;
        this.isPublic = (int32 & 4) != 0;
        this.megagroup = (int32 & 8) != 0;
        this.title = abstractSerializedData.readString(z);
        this.photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.participants_count = abstractSerializedData.readInt32(z);
        if ((this.flags & 16) != 0) {
            int int322 = abstractSerializedData.readInt32(z);
            if (int322 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < int323; i++) {
                TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (tLRPC$UserTLdeserialize == null) {
                    return;
                }
                this.participants.add(tLRPC$UserTLdeserialize);
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.channel ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.broadcast ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.isPublic ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.megagroup ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        abstractSerializedData.writeInt32(i4);
        abstractSerializedData.writeString(this.title);
        this.photo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.participants_count);
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.participants.size();
            abstractSerializedData.writeInt32(size);
            for (int i5 = 0; i5 < size; i5++) {
                this.participants.get(i5).serializeToStream(abstractSerializedData);
            }
        }
    }
}
