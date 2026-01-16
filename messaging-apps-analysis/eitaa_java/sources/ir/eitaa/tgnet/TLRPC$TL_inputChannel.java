package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputChannel extends TLRPC$InputChannel {
    public static int constructor = -212145112;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
        stream.writeInt64(this.access_hash);
    }
}
