package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionExportedInviteEdit extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = -384910503;
    public TLRPC$TL_chatInviteExported new_invite;
    public TLRPC$TL_chatInviteExported prev_invite;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.prev_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.prev_invite.serializeToStream(stream);
        this.new_invite.serializeToStream(stream);
    }
}
