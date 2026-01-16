package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$Peer extends TLObject {
    public long user_id = 0;
    public long chat_id = 0;
    public long channel_id = 0;

    public static TLRPC$Peer TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Peer tLRPC$TL_peerChannel;
        switch (constructor) {
            case -1649296275:
                tLRPC$TL_peerChannel = new TLRPC$TL_peerUser() { // from class: ir.eitaa.tgnet.TLRPC$TL_peerUser_layer131
                    public static int constructor = -1649296275;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerUser, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerUser, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case -1566230754:
                tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                break;
            case -1160714821:
                tLRPC$TL_peerChannel = new TLRPC$TL_peerChat() { // from class: ir.eitaa.tgnet.TLRPC$TL_peerChat_layer131
                    public static int constructor = -1160714821;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerChat, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.chat_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerChat, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.chat_id);
                    }
                };
                break;
            case -1109531342:
                tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel() { // from class: ir.eitaa.tgnet.TLRPC$TL_peerChannel_layer131
                    public static int constructor = -1109531342;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerChannel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.channel_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerChannel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.channel_id);
                    }
                };
                break;
            case 918946202:
                tLRPC$TL_peerChannel = new TLRPC$TL_peerChat();
                break;
            case 1498486562:
                tLRPC$TL_peerChannel = new TLRPC$TL_peerUser();
                break;
            default:
                tLRPC$TL_peerChannel = null;
                break;
        }
        if (tLRPC$TL_peerChannel == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Peer", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_peerChannel != null) {
            tLRPC$TL_peerChannel.readParams(stream, exception);
        }
        return tLRPC$TL_peerChannel;
    }
}
