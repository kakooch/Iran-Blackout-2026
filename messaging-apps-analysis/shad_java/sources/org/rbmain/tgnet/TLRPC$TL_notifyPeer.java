package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_notifyPeer extends TLRPC$NotifyPeer {
    public static int constructor = -1613493288;
    public TLRPC$Peer peer;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
    }
}
