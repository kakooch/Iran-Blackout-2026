package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMessagesFilterMusic extends TLRPC$MessagesFilter {
    public static int constructor = 928101534;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
