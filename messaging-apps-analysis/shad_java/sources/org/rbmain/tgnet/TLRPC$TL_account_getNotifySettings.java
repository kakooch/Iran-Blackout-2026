package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_getNotifySettings extends TLObject {
    public static int constructor = 313765169;
    public TLRPC$InputNotifyPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
    }
}
