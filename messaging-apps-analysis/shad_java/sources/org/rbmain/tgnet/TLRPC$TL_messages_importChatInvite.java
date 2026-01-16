package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_importChatInvite extends TLObject {
    public static int constructor = 1817183516;
    public int chatId;
    public String hash;
    public boolean isChannel;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.hash);
    }
}
