package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_editPhoto extends TLObject {
    public static int constructor = -248621111;
    public TLRPC$InputChannel channel;
    public TLRPC$InputChatPhoto photo;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.photo.serializeToStream(stream);
    }
}
