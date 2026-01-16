package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_exportInvite extends TLObject {
    public static int constructor = -950663035;
    public TLRPC$InputChannel channel;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$ExportedChatInvite.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
    }
}
