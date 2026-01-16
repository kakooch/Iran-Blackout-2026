package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_sendMessageCancelAction extends TLRPC$SendMessageAction {
    public static int constructor = -44119819;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
