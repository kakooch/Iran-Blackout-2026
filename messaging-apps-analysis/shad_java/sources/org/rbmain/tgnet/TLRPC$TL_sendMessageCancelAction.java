package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_sendMessageCancelAction extends TLRPC$SendMessageAction {
    public static int constructor = -44119819;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
