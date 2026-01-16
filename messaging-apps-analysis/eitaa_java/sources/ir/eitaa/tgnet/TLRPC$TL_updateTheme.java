package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateTheme extends TLRPC$Update {
    public static int constructor = -2112423005;
    public TLRPC$Theme theme;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.theme = TLRPC$Theme.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.theme.serializeToStream(stream);
    }
}
