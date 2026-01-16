package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
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

    public static TLRPC$TL_peerSettings TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_peerSettings", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_peerSettings tLRPC$TL_peerSettings = new TLRPC$TL_peerSettings();
        tLRPC$TL_peerSettings.readParams(stream, exception);
        return tLRPC$TL_peerSettings;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.report_spam = (int32 & 1) != 0;
        this.add_contact = (int32 & 2) != 0;
        this.block_contact = (int32 & 4) != 0;
        this.share_contact = (int32 & 8) != 0;
        this.need_contacts_exception = (int32 & 16) != 0;
        this.report_geo = (int32 & 32) != 0;
        this.autoarchived = (int32 & 128) != 0;
        this.invite_members = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        if ((int32 & 64) != 0) {
            this.geo_distance = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
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
        int i8 = this.invite_members ? i7 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i7 & (-257);
        this.flags = i8;
        stream.writeInt32(i8);
        if ((this.flags & 64) != 0) {
            stream.writeInt32(this.geo_distance);
        }
    }
}
