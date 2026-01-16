package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_deleteUserHistory extends TLObject {
    public static int constructor = -787622117;
    public TLRPC$InputChannel channel;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_affectedHistory.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.user_id.serializeToStream(stream);
    }
}
