package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMessagesFilterChatPhotos extends TLRPC$MessagesFilter {
    public static int constructor = 975236280;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
