package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_langpack_getDifference extends TLObject {
    public static int constructor = -845657435;
    public int from_version;
    public String lang_code;
    public String lang_pack;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_langPackDifference.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_pack);
        stream.writeString(this.lang_code);
        stream.writeInt32(this.from_version);
    }
}
