package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$InputUser extends TLObject {
    public long access_hash;
    public int user_id;

    public static TLRPC$InputUser TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$InputUser tLRPC$TL_inputUserEmpty;
        switch (i) {
            case -1182234929:
                tLRPC$TL_inputUserEmpty = new TLRPC$TL_inputUserEmpty();
                break;
            case -668391402:
                tLRPC$TL_inputUserEmpty = new TLRPC$TL_inputUser();
                break;
            case -138301121:
                tLRPC$TL_inputUserEmpty = new TLRPC$TL_inputUserSelf();
                break;
            case 756118935:
                tLRPC$TL_inputUserEmpty = new TLRPC$InputUser() { // from class: org.rbmain.tgnet.TLRPC$TL_inputUserFromMessage
                    public static int constructor = 756118935;
                    public long msg_id;
                    public TLRPC$InputPeer peer;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.msg_id = abstractSerializedData2.readInt32(z2);
                        this.user_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.peer.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32((int) this.msg_id);
                        abstractSerializedData2.writeInt32(this.user_id);
                    }
                };
                break;
            default:
                tLRPC$TL_inputUserEmpty = null;
                break;
        }
        if (tLRPC$TL_inputUserEmpty == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputUser", Integer.valueOf(i)));
        }
        if (tLRPC$TL_inputUserEmpty != null) {
            tLRPC$TL_inputUserEmpty.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_inputUserEmpty;
    }
}
