package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$InputPeer extends TLObject {
    public long access_hash;
    public int channel_id;
    public int chat_id;
    public int user_id;

    public static TLRPC$InputPeer TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$InputPeer tLRPC$TL_inputPeerChat;
        switch (i) {
            case -1667893317:
                tLRPC$TL_inputPeerChat = new TLRPC$InputPeer() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPeerChannelFromMessage
                    public static int constructor = -1667893317;
                    public int msg_id;
                    public TLRPC$InputPeer peer;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        this.msg_id = abstractSerializedData2.readInt32(z2);
                        this.channel_id = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        this.peer.serializeToStream(abstractSerializedData2);
                        abstractSerializedData2.writeInt32(this.msg_id);
                        abstractSerializedData2.writeInt32(this.channel_id);
                    }
                };
                break;
            case 396093539:
                tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
                break;
            case 398123750:
                tLRPC$TL_inputPeerChat = new TLRPC$InputPeer() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPeerUserFromMessage
                    public static int constructor = 398123750;
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
            case 548253432:
                tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChannel();
                break;
            case 2072935910:
                tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerUser();
                break;
            case 2107670217:
                tLRPC$TL_inputPeerChat = new TLRPC$InputPeer() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPeerSelf
                    public static int constructor = 2107670217;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case 2134579434:
                tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerEmpty();
                break;
            default:
                tLRPC$TL_inputPeerChat = null;
                break;
        }
        if (tLRPC$TL_inputPeerChat == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputPeer", Integer.valueOf(i)));
        }
        if (tLRPC$TL_inputPeerChat != null) {
            tLRPC$TL_inputPeerChat.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_inputPeerChat;
    }
}
