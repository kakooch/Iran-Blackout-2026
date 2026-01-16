package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stickers_checkShortName extends TLObject {
    public static int constructor = 676017721;
    public String short_name;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.short_name);
    }
}
