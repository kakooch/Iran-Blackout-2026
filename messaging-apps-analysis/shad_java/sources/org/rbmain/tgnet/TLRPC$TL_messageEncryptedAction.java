package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageEncryptedAction extends TLRPC$MessageAction {
    public static int constructor = 1431655927;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.encryptedAction = TLRPC$DecryptedMessageAction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.encryptedAction.serializeToStream(abstractSerializedData);
    }
}
