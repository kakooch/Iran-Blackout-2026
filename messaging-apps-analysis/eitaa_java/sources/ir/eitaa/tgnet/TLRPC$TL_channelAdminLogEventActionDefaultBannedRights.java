package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionDefaultBannedRights extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 771095562;
    public TLRPC$TL_chatBannedRights new_banned_rights;
    public TLRPC$TL_chatBannedRights prev_banned_rights;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_banned_rights = TLRPC$TL_chatBannedRights.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.prev_banned_rights.serializeToStream(stream);
        this.new_banned_rights.serializeToStream(stream);
    }
}
