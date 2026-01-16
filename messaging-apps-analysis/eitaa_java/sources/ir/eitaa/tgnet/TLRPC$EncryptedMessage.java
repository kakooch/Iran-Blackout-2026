package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$EncryptedMessage extends TLObject {
    public byte[] bytes;
    public int chat_id;
    public int date;
    public TLRPC$EncryptedFile file;
    public long random_id;

    public static TLRPC$EncryptedMessage TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$EncryptedMessage tLRPC$EncryptedMessage;
        if (constructor != -317144808) {
            tLRPC$EncryptedMessage = constructor != 594758406 ? null : new TLRPC$EncryptedMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedMessageService
                public static int constructor = 594758406;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.random_id = stream2.readInt64(exception2);
                    this.chat_id = stream2.readInt32(exception2);
                    this.date = stream2.readInt32(exception2);
                    this.bytes = stream2.readByteArray(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.random_id);
                    stream2.writeInt32(this.chat_id);
                    stream2.writeInt32(this.date);
                    stream2.writeByteArray(this.bytes);
                }
            };
        } else {
            tLRPC$EncryptedMessage = new TLRPC$EncryptedMessage() { // from class: ir.eitaa.tgnet.TLRPC$TL_encryptedMessage
                public static int constructor = -317144808;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.random_id = stream2.readInt64(exception2);
                    this.chat_id = stream2.readInt32(exception2);
                    this.date = stream2.readInt32(exception2);
                    this.bytes = stream2.readByteArray(exception2);
                    this.file = TLRPC$EncryptedFile.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.random_id);
                    stream2.writeInt32(this.chat_id);
                    stream2.writeInt32(this.date);
                    stream2.writeByteArray(this.bytes);
                    this.file.serializeToStream(stream2);
                }
            };
        }
        if (tLRPC$EncryptedMessage == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in EncryptedMessage", Integer.valueOf(constructor)));
        }
        if (tLRPC$EncryptedMessage != null) {
            tLRPC$EncryptedMessage.readParams(stream, exception);
        }
        return tLRPC$EncryptedMessage;
    }
}
