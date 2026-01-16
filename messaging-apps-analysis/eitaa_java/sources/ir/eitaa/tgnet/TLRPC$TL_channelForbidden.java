package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_channelForbidden extends TLRPC$Chat {
    public static int constructor = 399807445;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.broadcast = (int32 & 32) != 0;
        this.megagroup = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.title = stream.readString(exception);
        if ((this.flags & 65536) != 0) {
            this.until_date = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.broadcast ? this.flags | 32 : this.flags & (-33);
        this.flags = i;
        int i2 = this.megagroup ? i | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i & (-257);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeString(this.title);
        if ((this.flags & 65536) != 0) {
            stream.writeInt32(this.until_date);
        }
    }
}
