package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputChannelEmpty extends TLRPC$InputChannel {
    public static int constructor = -292807034;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
