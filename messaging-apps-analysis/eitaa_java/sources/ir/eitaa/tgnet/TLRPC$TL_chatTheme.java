package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatTheme extends TLObject {
    public static int constructor = -318022605;
    public TLRPC$Theme dark_theme;
    public String emoticon;
    public TLRPC$Theme theme;

    public static TLRPC$TL_chatTheme TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatTheme", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_chatTheme tLRPC$TL_chatTheme = new TLRPC$TL_chatTheme();
        tLRPC$TL_chatTheme.readParams(stream, exception);
        return tLRPC$TL_chatTheme;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.emoticon = stream.readString(exception);
        this.theme = TLRPC$Theme.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.dark_theme = TLRPC$Theme.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.emoticon);
        this.theme.serializeToStream(stream);
        this.dark_theme.serializeToStream(stream);
    }
}
