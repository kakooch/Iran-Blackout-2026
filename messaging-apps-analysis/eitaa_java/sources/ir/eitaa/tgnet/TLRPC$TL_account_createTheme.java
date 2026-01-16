package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_createTheme extends TLObject {
    public static int constructor = -2077048289;
    public TLRPC$InputDocument document;
    public int flags;
    public TLRPC$TL_inputThemeSettings settings;
    public String slug;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Theme.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.slug);
        stream.writeString(this.title);
        if ((this.flags & 4) != 0) {
            this.document.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            this.settings.serializeToStream(stream);
        }
    }
}
