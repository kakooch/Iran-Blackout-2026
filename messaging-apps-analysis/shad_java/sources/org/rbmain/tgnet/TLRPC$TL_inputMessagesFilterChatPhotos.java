package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputMessagesFilterChatPhotos extends TLRPC$MessagesFilter {
    public static int constructor = 975236280;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
