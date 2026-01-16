package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageActionChatJoinedByLink extends TLRPC$MessageAction {
    public static int constructor = -123931160;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.inviter_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.inviter_id);
    }
}
