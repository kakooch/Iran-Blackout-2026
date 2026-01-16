package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputWebFileLocation extends TLRPC$InputWebFileLocation {
    public static int constructor = -1036396922;
    public long access_hash;
    public String url;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
        this.access_hash = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
        stream.writeInt64(this.access_hash);
    }
}
