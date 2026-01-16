package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMessagesFilterGif extends TLRPC$MessagesFilter {
    public static int constructor = -3644025;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
