package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputNotifyBroadcasts extends TLRPC$InputNotifyPeer {
    public static int constructor = -1311015810;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
