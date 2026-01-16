package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_fileLocation_layer82 extends TLRPC$TL_fileLocation_layer97 {
    public static int constructor = 1406570614;

    @Override // ir.eitaa.tgnet.TLRPC$TL_fileLocation_layer97, ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.dc_id = stream.readInt32(exception);
        this.volume_id = stream.readInt64(exception);
        this.local_id = stream.readInt32(exception);
        this.secret = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLRPC$TL_fileLocation_layer97, ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.dc_id);
        stream.writeInt64(this.volume_id);
        stream.writeInt32(this.local_id);
        stream.writeInt64(this.secret);
    }
}
