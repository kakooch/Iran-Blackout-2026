package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_SentEncryptedMessage extends TLObject {
    public int date;
    public TLRPC$EncryptedFile file;

    public static TLRPC$messages_SentEncryptedMessage TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_SentEncryptedMessage tLRPC$messages_SentEncryptedMessage;
        if (constructor != -1802240206) {
            tLRPC$messages_SentEncryptedMessage = constructor != 1443858741 ? null : new TLRPC$messages_SentEncryptedMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_sentEncryptedMessage
                public static int constructor = 1443858741;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.date = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.date);
                }
            };
        } else {
            tLRPC$messages_SentEncryptedMessage = new TLRPC$messages_SentEncryptedMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_sentEncryptedFile
                public static int constructor = -1802240206;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.date = stream2.readInt32(exception2);
                    this.file = TLRPC$EncryptedFile.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.date);
                    this.file.serializeToStream(stream2);
                }
            };
        }
        if (tLRPC$messages_SentEncryptedMessage == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_SentEncryptedMessage", Integer.valueOf(constructor)));
        }
        if (tLRPC$messages_SentEncryptedMessage != null) {
            tLRPC$messages_SentEncryptedMessage.readParams(stream, exception);
        }
        return tLRPC$messages_SentEncryptedMessage;
    }
}
