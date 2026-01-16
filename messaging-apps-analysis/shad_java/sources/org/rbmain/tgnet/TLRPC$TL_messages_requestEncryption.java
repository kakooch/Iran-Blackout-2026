package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_requestEncryption extends TLObject {
    public static int constructor = -162681021;
    public byte[] g_a;
    public int random_id;
    public TLRPC$InputUser user_id;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$EncryptedChat.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.user_id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.random_id);
        abstractSerializedData.writeByteArray(this.g_a);
    }
}
