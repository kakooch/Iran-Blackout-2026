package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channels_editAdmin extends TLObject {
    public static int constructor = -751007486;
    public TLRPC$TL_chatAdminRights admin_rights;
    public TLRPC$InputChannel channel;
    public String rank;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        this.user_id.serializeToStream(stream);
        this.admin_rights.serializeToStream(stream);
        stream.writeString(this.rank);
    }
}
