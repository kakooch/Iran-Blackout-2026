package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_dcOption extends TLObject {
    public static int constructor = 414687501;
    public boolean cdn;
    public int flags;
    public int id;
    public String ip_address;
    public boolean ipv6;
    public boolean isStatic;
    public boolean media_only;
    public int port;
    public byte[] secret;
    public boolean tcpo_only;

    public static TLRPC$TL_dcOption TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_dcOption", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_dcOption tLRPC$TL_dcOption = new TLRPC$TL_dcOption();
        tLRPC$TL_dcOption.readParams(stream, exception);
        return tLRPC$TL_dcOption;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.ipv6 = (int32 & 1) != 0;
        this.media_only = (int32 & 2) != 0;
        this.tcpo_only = (int32 & 4) != 0;
        this.cdn = (int32 & 8) != 0;
        this.isStatic = (int32 & 16) != 0;
        this.id = stream.readInt32(exception);
        this.ip_address = stream.readString(exception);
        this.port = stream.readInt32(exception);
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.secret = stream.readByteArray(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.ipv6 ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.media_only ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.tcpo_only ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.cdn ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.isStatic ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        stream.writeInt32(i5);
        stream.writeInt32(this.id);
        stream.writeString(this.ip_address);
        stream.writeInt32(this.port);
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeByteArray(this.secret);
        }
    }
}
