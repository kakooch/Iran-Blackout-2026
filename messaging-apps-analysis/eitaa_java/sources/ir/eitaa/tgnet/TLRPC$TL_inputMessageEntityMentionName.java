package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMessageEntityMentionName extends TLRPC$MessageEntity {
    public static int constructor = 546203849;
    public TLRPC$InputUser user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.offset = stream.readInt32(exception);
        this.length = stream.readInt32(exception);
        this.user_id = TLRPC$InputUser.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.length);
        this.user_id.serializeToStream(stream);
    }
}
