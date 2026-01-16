package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputPeer extends TLObject {
    public long access_hash;
    public long channel_id;
    public long chat_id;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public long user_id;

    public static TLRPC$InputPeer TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputPeer tLRPC$TL_inputPeerUserFromMessage;
        switch (constructor) {
            case -1667893317:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerChannelFromMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPeerChannelFromMessage_layer131
                    public static int constructor = -1667893317;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerChannelFromMessage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.peer = TLRPC$InputPeer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.msg_id = stream2.readInt32(exception2);
                        this.channel_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerChannelFromMessage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.peer.serializeToStream(stream2);
                        stream2.writeInt32(this.msg_id);
                        stream2.writeInt32((int) this.channel_id);
                    }
                };
                break;
            case -1468331492:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerUserFromMessage();
                break;
            case -1121318848:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerChannelFromMessage();
                break;
            case -571955892:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerUser();
                break;
            case 396093539:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerChat() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPeerChat_layer131
                    public static int constructor = 396093539;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerChat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerChat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.chat_id);
                    }
                };
                break;
            case 398123750:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerUserFromMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPeerUserFromMessage_layer131
                    public static int constructor = 398123750;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerUserFromMessage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.peer = TLRPC$InputPeer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.msg_id = stream2.readInt32(exception2);
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerUserFromMessage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.peer.serializeToStream(stream2);
                        stream2.writeInt32(this.msg_id);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case 548253432:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerChannel() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel_layer131
                    public static int constructor = 548253432;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.channel_id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.channel_id);
                        stream2.writeInt64(this.access_hash);
                    }
                };
                break;
            case 666680316:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerChannel();
                break;
            case 900291769:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerChat();
                break;
            case 2072935910:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerUser() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPeerUser_layer131
                    public static int constructor = 2072935910;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerUser, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputPeerUser, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                        stream2.writeInt64(this.access_hash);
                    }
                };
                break;
            case 2107670217:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerSelf();
                break;
            case 2134579434:
                tLRPC$TL_inputPeerUserFromMessage = new TLRPC$TL_inputPeerEmpty();
                break;
            default:
                tLRPC$TL_inputPeerUserFromMessage = null;
                break;
        }
        if (tLRPC$TL_inputPeerUserFromMessage == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputPeer", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputPeerUserFromMessage != null) {
            tLRPC$TL_inputPeerUserFromMessage.readParams(stream, exception);
        }
        return tLRPC$TL_inputPeerUserFromMessage;
    }
}
