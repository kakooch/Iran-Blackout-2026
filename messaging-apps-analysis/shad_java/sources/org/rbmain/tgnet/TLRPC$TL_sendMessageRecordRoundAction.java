package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_sendMessageRecordRoundAction extends TLRPC$SendMessageAction {
    public static int constructor = -1997373508;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
