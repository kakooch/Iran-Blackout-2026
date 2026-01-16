package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stickers_suggestShortName extends TLObject {
    public static int constructor = 1303364867;
    public String title;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_stickers_suggestedShortName.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.title);
    }
}
