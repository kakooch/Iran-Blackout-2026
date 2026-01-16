package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_speakingInGroupCallAction extends TLRPC$SendMessageAction {
    public static int constructor = -651419003;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
