package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMessagesFilterUrl extends TLRPC$MessagesFilter {
    public static int constructor = 2129714567;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
