package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_viewSponsoredMessage extends TLObject {
    public static int constructor = -1095836780;
    public TLRPC$InputChannel channel;
    public byte[] random_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        stream.writeByteArray(this.random_id);
    }
}
