package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageEncryptedAction extends TLRPC$MessageAction {
    public static int constructor = 1431655927;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.encryptedAction = TLRPC$DecryptedMessageAction.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.encryptedAction.serializeToStream(stream);
    }
}
