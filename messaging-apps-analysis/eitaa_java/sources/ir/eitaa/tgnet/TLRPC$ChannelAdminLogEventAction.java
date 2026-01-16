package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$ChannelAdminLogEventAction extends TLObject {
    public static TLRPC$ChannelAdminLogEventAction TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ChannelAdminLogEventAction tLRPC$TL_channelAdminLogEventActionStopPoll;
        switch (constructor) {
            case -1895328189:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionStopPoll();
                break;
            case -1312568665:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeStickerSet();
                break;
            case -714643696:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionParticipantToggleAdmin();
                break;
            case -610299584:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$ChannelAdminLogEventAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionDiscardGroupCall
                    public static int constructor = -610299584;
                    public TLRPC$TL_inputGroupCall call;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.call.serializeToStream(stream2);
                    }
                };
                break;
            case -484690728:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionParticipantInvite();
                break;
            case -431740480:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionParticipantUnmute();
                break;
            case -422036098:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionParticipantToggleBan();
                break;
            case -421545947:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeTitle();
                break;
            case -384910503:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionExportedInviteEdit();
                break;
            case -370660328:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionUpdatePinned();
                break;
            case -124291086:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$ChannelAdminLogEventAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionParticipantLeave
                    public static int constructor = -124291086;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -115071790:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionParticipantMute();
                break;
            case -26672755:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeTheme();
                break;
            case 84703944:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeLinkedChat();
                break;
            case 241923758:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeLocation();
                break;
            case 405815507:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$ChannelAdminLogEventAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionParticipantJoin
                    public static int constructor = 405815507;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 460916654:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionToggleInvites();
                break;
            case 589338437:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$ChannelAdminLogEventAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionStartGroupCall
                    public static int constructor = 589338437;
                    public TLRPC$TL_inputGroupCall call;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.call.serializeToStream(stream2);
                    }
                };
                break;
            case 648939889:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionToggleSignatures();
                break;
            case 771095562:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionDefaultBannedRights();
                break;
            case 1048537159:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionParticipantVolume();
                break;
            case 1091179342:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionExportedInviteRevoke();
                break;
            case 1121994683:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionDeleteMessage();
                break;
            case 1129042607:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangePhoto();
                break;
            case 1401984889:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionToggleSlowMode();
                break;
            case 1427671598:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeAbout();
                break;
            case 1456906823:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionToggleGroupCallSetting();
                break;
            case 1515256996:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionExportedInviteDelete();
                break;
            case 1557846647:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$ChannelAdminLogEventAction() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionParticipantJoinByInvite
                    public static int constructor = 1557846647;
                    public TLRPC$TL_chatInviteExported invite;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.invite.serializeToStream(stream2);
                    }
                };
                break;
            case 1599903217:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionTogglePreHistoryHidden();
                break;
            case 1783299128:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeUsername();
                break;
            case 1855199800:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionChangeHistoryTTL();
                break;
            case 1889215493:
                tLRPC$TL_channelAdminLogEventActionStopPoll = new TLRPC$TL_channelAdminLogEventActionEditMessage();
                break;
            default:
                tLRPC$TL_channelAdminLogEventActionStopPoll = null;
                break;
        }
        if (tLRPC$TL_channelAdminLogEventActionStopPoll == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ChannelAdminLogEventAction", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_channelAdminLogEventActionStopPoll != null) {
            tLRPC$TL_channelAdminLogEventActionStopPoll.readParams(stream, exception);
        }
        return tLRPC$TL_channelAdminLogEventActionStopPoll;
    }
}
