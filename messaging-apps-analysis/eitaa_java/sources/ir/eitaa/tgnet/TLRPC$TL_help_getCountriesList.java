package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_getCountriesList extends TLObject {
    public static int constructor = 1935116200;
    public int hash;
    public String lang_code;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$help_CountriesList.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_code);
        stream.writeInt32(this.hash);
    }
}
