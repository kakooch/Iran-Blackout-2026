package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_documentAttributeAudio extends TLRPC$DocumentAttribute {
    public static int constructor = -1739392570;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.voice = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
        this.duration = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.title = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.performer = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.waveform = stream.readByteArray(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.voice ? this.flags | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : this.flags & (-1025);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.duration);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.title);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.performer);
        }
        if ((this.flags & 4) != 0) {
            stream.writeByteArray(this.waveform);
        }
    }
}
