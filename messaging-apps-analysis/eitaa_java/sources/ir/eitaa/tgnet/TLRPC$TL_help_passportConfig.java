package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_passportConfig extends TLRPC$help_PassportConfig {
    public static int constructor = -1600596305;
    public TLRPC$TL_dataJSON countries_langs;
    public int hash;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hash = stream.readInt32(exception);
        this.countries_langs = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.hash);
        this.countries_langs.serializeToStream(stream);
    }
}
