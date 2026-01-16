package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_checkUsername extends TLObject {
    public static int constructor = 283557164;
    public TLRPC$InputChannel channel;
    public String username;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        stream.writeString(this.username);
    }
}
