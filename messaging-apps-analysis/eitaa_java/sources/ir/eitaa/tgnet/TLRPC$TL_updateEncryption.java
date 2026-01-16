package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateEncryption extends TLRPC$Update {
    public static int constructor = -1264392051;
    public TLRPC$EncryptedChat chat;
    public int date;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat = TLRPC$EncryptedChat.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.chat.serializeToStream(stream);
        stream.writeInt32(this.date);
    }
}
