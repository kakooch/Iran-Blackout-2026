package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_setEncryptedTyping extends TLObject {
    public static int constructor = 2031374829;
    public TLRPC$TL_inputEncryptedChat peer;
    public boolean typing;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeBool(this.typing);
    }
}
