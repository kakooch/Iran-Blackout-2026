package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$InputUser extends TLObject {
    public long access_hash;
    public long user_id;

    public static TLRPC$InputUser TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputUser tLRPC$TL_inputUserEmpty;
        switch (constructor) {
            case -1182234929:
                tLRPC$TL_inputUserEmpty = new TLRPC$TL_inputUserEmpty();
                break;
            case -233744186:
                tLRPC$TL_inputUserEmpty = new TLRPC$TL_inputUser();
                break;
            case -138301121:
                tLRPC$TL_inputUserEmpty = new TLRPC$TL_inputUserSelf();
                break;
            case 497305826:
                tLRPC$TL_inputUserEmpty = new TLRPC$InputUser() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputUserFromMessage
                    public static int constructor = 497305826;
                    public int msg_id;
                    public TLRPC$InputPeer peer;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.peer = TLRPC$InputPeer.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.msg_id = stream2.readInt32(exception2);
                        this.user_id = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.peer.serializeToStream(stream2);
                        stream2.writeInt32(this.msg_id);
                        stream2.writeInt64(this.user_id);
                    }
                };
                break;
            default:
                tLRPC$TL_inputUserEmpty = null;
                break;
        }
        if (tLRPC$TL_inputUserEmpty == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputUser", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputUserEmpty != null) {
            tLRPC$TL_inputUserEmpty.readParams(stream, exception);
        }
        return tLRPC$TL_inputUserEmpty;
    }
}
