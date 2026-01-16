package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_encryptedChatRequested extends TLRPC$EncryptedChat {
    public static int constructor = 1223809356;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        this.id = stream.readInt32(exception);
        this.access_hash = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        this.admin_id = stream.readInt64(exception);
        this.participant_id = stream.readInt64(exception);
        this.g_a = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.folder_id);
        }
        stream.writeInt32(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeInt32(this.date);
        stream.writeInt64(this.admin_id);
        stream.writeInt64(this.participant_id);
        stream.writeByteArray(this.g_a);
    }
}
