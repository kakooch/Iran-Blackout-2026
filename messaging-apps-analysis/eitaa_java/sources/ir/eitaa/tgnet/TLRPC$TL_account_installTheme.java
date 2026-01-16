package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_installTheme extends TLObject {
    public static int constructor = 2061776695;
    public boolean dark;
    public int flags;
    public String format;
    public TLRPC$InputTheme theme;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.dark ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.format);
        }
        if ((this.flags & 2) != 0) {
            this.theme.serializeToStream(stream);
        }
    }
}
