package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_sendMessageTypingAction extends TLRPC$SendMessageAction {
    public static int constructor = 381645902;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
