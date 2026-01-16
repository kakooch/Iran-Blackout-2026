package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_langpack_getLanguage extends TLObject {
    public static int constructor = 1784243458;
    public String lang_code;
    public String lang_pack;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_langPackLanguage.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_pack);
        stream.writeString(this.lang_code);
    }
}
