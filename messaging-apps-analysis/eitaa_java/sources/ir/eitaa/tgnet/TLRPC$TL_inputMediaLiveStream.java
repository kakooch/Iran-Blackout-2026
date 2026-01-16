package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaLiveStream extends TLRPC$InputMedia {
    public static int constructor = 547960182;
    public byte[] thumbBytes;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            stream.writeByteArray(this.thumbBytes);
        }
    }
}
