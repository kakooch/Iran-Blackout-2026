package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_peerSettings extends TLObject {
    public static int constructor = 1933519201;
    public boolean add_contact;
    public boolean autoarchived;
    public boolean block_contact;
    public int flags;
    public int geo_distance;
    public boolean invite_members;
    public boolean need_contacts_exception;
    public boolean report_geo;
    public boolean report_spam;
    public boolean share_contact;

    public static TLRPC$TL_peerSettings TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_peerSettings", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_peerSettings tLRPC$TL_peerSettings = new TLRPC$TL_peerSettings();
        tLRPC$TL_peerSettings.readParams(abstractSerializedData, z);
        return tLRPC$TL_peerSettings;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.report_spam = (int32 & 1) != 0;
        this.add_contact = (int32 & 2) != 0;
        this.block_contact = (int32 & 4) != 0;
        this.share_contact = (int32 & 8) != 0;
        this.need_contacts_exception = (int32 & 16) != 0;
        this.report_geo = (int32 & 32) != 0;
        this.autoarchived = (int32 & 128) != 0;
        this.invite_members = (int32 & 256) != 0;
        if ((int32 & 64) != 0) {
            this.geo_distance = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.report_spam ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.add_contact ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.block_contact ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.share_contact ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.need_contacts_exception ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        int i6 = this.report_geo ? i5 | 32 : i5 & (-33);
        this.flags = i6;
        int i7 = this.autoarchived ? i6 | 128 : i6 & (-129);
        this.flags = i7;
        int i8 = this.invite_members ? i7 | 256 : i7 & (-257);
        this.flags = i8;
        abstractSerializedData.writeInt32(i8);
        if ((this.flags & 64) != 0) {
            abstractSerializedData.writeInt32(this.geo_distance);
        }
    }
}
