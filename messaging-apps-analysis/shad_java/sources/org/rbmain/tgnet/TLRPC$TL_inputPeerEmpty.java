package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputPeerEmpty extends TLRPC$InputPeer {
    public static int constructor = 2134579434;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
