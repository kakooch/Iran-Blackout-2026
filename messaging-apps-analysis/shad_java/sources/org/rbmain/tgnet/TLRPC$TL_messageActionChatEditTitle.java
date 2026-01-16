package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messageActionChatEditTitle extends TLRPC$MessageAction {
    public static int constructor = -1247687078;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.title = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.title);
    }
}
