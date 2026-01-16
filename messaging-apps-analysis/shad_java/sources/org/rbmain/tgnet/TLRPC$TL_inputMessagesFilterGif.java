package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMessagesFilterGif extends TLRPC$MessagesFilter {
    public static int constructor = -3644025;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
