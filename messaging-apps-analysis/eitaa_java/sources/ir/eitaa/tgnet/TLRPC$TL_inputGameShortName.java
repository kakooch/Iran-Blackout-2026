package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputGameShortName extends TLRPC$InputGame {
    public static int constructor = -1020139510;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.bot_id = TLRPC$InputUser.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.short_name = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.bot_id.serializeToStream(stream);
        stream.writeString(this.short_name);
    }
}
