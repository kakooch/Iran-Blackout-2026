package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionExportedInviteDelete extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1515256996;
    public TLRPC$TL_chatInviteExported invite;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.invite.serializeToStream(stream);
    }
}
