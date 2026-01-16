package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateEncryptedChatTyping extends TLRPC$Update {
    public static int constructor = 386986326;
    public int chat_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.chat_id);
    }
}
