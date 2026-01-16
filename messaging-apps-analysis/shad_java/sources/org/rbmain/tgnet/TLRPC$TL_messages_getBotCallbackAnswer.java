package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_getBotCallbackAnswer extends TLObject {
    public static int constructor = -1824339449;
    public String bot_button_text;
    public byte[] data;
    public int flags;
    public boolean game;
    public TLRPC$MessageMedia media;
    public long msg_id;
    public TLRPC$InputCheckPasswordSRP password;
    public TLRPC$InputPeer peer;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_botCallbackAnswer.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.game ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32((int) this.msg_id);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeByteArray(this.data);
        }
        if ((this.flags & 4) != 0) {
            this.password.serializeToStream(abstractSerializedData);
        }
    }
}
