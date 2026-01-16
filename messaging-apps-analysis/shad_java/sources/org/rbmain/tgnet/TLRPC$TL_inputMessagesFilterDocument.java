package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMessagesFilterDocument extends TLRPC$MessagesFilter {
    public static int constructor = -1629621880;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
