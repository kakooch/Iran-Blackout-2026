package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_editChatTitle extends TLObject {
    public static int constructor = -599447467;
    public int chat_id;
    public String title;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.chat_id);
        abstractSerializedData.writeString(this.title);
    }
}
