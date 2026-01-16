package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stickers_suggestedShortName extends TLObject {
    public static int constructor = -2046910401;
    public String short_name;

    public static TLRPC$TL_stickers_suggestedShortName TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_stickers_suggestedShortName", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_stickers_suggestedShortName tLRPC$TL_stickers_suggestedShortName = new TLRPC$TL_stickers_suggestedShortName();
        tLRPC$TL_stickers_suggestedShortName.readParams(stream, exception);
        return tLRPC$TL_stickers_suggestedShortName;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.short_name = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.short_name);
    }
}
