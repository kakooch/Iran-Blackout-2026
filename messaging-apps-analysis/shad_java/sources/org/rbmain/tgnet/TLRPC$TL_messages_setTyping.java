package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_setTyping extends TLObject {
    public static int constructor = 1486110434;
    public TLRPC$SendMessageAction action;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public TLRPC$InputPeer peer;
    public long top_msg_id;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        this.peer.serializeToStream(abstractSerializedData);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32((int) this.top_msg_id);
        }
        this.action.serializeToStream(abstractSerializedData);
    }
}
