package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_sendMessageUploadRoundAction extends TLRPC$SendMessageAction {
    public static int constructor = 608050278;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.progress = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.progress);
    }
}
