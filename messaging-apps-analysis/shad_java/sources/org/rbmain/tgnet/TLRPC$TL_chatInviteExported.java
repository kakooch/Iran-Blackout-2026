package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_chatInviteExported extends TLRPC$ExportedChatInvite {
    public static int constructor = 1847917725;
    public int admin_id;
    public int date;
    public int expire_date;
    public boolean expired;
    public int flags;
    public String link;
    public boolean permanent;
    public boolean revoked;
    public int start_date;
    public int usage;
    public int usage_limit;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.revoked = (int32 & 1) != 0;
        this.permanent = (int32 & 32) != 0;
        this.link = abstractSerializedData.readString(z);
        this.admin_id = abstractSerializedData.readInt32(z);
        this.date = abstractSerializedData.readInt32(z);
        if ((this.flags & 16) != 0) {
            this.start_date = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 2) != 0) {
            this.expire_date = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 4) != 0) {
            this.usage_limit = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            this.usage = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.revoked ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.permanent ? i | 32 : i & (-33);
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeString(this.link);
        abstractSerializedData.writeInt32(this.admin_id);
        abstractSerializedData.writeInt32(this.date);
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeInt32(this.start_date);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.expire_date);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.usage_limit);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt32(this.usage);
        }
    }
}
