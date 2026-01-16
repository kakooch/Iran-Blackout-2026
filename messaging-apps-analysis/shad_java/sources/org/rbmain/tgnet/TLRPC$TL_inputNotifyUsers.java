package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputNotifyUsers extends TLRPC$InputNotifyPeer {
    public static int constructor = 423314455;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
