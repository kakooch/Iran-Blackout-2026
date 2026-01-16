package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputThemeSlug extends TLRPC$InputTheme {
    public static int constructor = -175567375;
    public String slug;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.slug = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.slug);
    }
}
