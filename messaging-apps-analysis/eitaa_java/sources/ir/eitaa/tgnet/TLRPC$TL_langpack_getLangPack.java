package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_langpack_getLangPack extends TLObject {
    public static int constructor = -1699363442;
    public String lang_code;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_langPackDifference.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_code);
    }
}
