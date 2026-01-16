package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputChannel extends TLObject {
    public long access_hash;
    public long channel_id;

    public static TLRPC$InputChannel TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputChannel tLRPC$TL_inputChannelEmpty;
        switch (constructor) {
            case -1343524562:
                tLRPC$TL_inputChannelEmpty = new TLRPC$TL_inputChannel() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputChannel_layer131
                    public static int constructor = -1343524562;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputChannel, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.channel_id = stream2.readInt32(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputChannel, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32((int) this.channel_id);
                        stream2.writeInt64(this.access_hash);
                    }
                };
                break;
            case -292807034:
                tLRPC$TL_inputChannelEmpty = new TLRPC$TL_inputChannelEmpty();
                break;
            case -212145112:
                tLRPC$TL_inputChannelEmpty = new TLRPC$TL_inputChannel();
                break;
            case 707290417:
                tLRPC$TL_inputChannelEmpty = new TLRPC$TL_inputChannelFromMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputChannelFromMessage_layer131
                    public static int constructor = 707290417;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputChannelFromMessage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.peer = TLRPC$InputPeer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.msg_id = stream2.readInt32(exception2);
                        this.channel_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_inputChannelFromMessage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.peer.serializeToStream(stream2);
                        stream2.writeInt32(this.msg_id);
                        stream2.writeInt32((int) this.channel_id);
                    }
                };
                break;
            case 1536380829:
                tLRPC$TL_inputChannelEmpty = new TLRPC$TL_inputChannelFromMessage();
                break;
            default:
                tLRPC$TL_inputChannelEmpty = null;
                break;
        }
        if (tLRPC$TL_inputChannelEmpty == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputChannel", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputChannelEmpty != null) {
            tLRPC$TL_inputChannelEmpty.readParams(stream, exception);
        }
        return tLRPC$TL_inputChannelEmpty;
    }
}
