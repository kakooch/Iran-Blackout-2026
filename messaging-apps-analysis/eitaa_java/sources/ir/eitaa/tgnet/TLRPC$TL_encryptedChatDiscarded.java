package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_encryptedChatDiscarded extends TLRPC$EncryptedChat {
    public static int constructor = 505183301;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.history_deleted = (int32 & 1) != 0;
        this.id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.history_deleted ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.id);
    }
}
