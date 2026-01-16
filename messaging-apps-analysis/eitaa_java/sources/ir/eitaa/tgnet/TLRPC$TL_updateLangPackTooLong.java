package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateLangPackTooLong extends TLRPC$Update {
    public static int constructor = 1180041828;
    public String lang_code;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.lang_code = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_code);
    }
}
