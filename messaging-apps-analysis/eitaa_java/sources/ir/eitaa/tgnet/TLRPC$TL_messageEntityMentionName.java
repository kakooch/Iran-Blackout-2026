package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageEntityMentionName extends TLRPC$MessageEntity {
    public static int constructor = -595914432;
    public long user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.offset = stream.readInt32(exception);
        this.length = stream.readInt32(exception);
        this.user_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.length);
        stream.writeInt64(this.user_id);
    }
}
