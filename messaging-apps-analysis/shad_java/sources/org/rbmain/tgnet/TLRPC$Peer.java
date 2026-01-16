package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$Peer extends TLObject {
    public int channel_id;
    public int chat_id;
    public String guid;
    public int user_id;

    public static TLRPC$Peer TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Peer tLRPC$TL_peerUser;
        if (i == -1649296275) {
            tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        } else if (i != -1160714821) {
            tLRPC$TL_peerUser = i != -1109531342 ? null : new TLRPC$TL_peerChannel();
        } else {
            tLRPC$TL_peerUser = new TLRPC$TL_peerChat();
        }
        if (tLRPC$TL_peerUser == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Peer", Integer.valueOf(i)));
        }
        if (tLRPC$TL_peerUser != null) {
            tLRPC$TL_peerUser.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_peerUser;
    }
}
