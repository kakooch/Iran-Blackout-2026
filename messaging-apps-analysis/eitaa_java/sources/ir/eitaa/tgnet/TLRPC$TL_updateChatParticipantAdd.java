package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChatParticipantAdd extends TLRPC$Update {
    public static int constructor = 1037718609;
    public long chat_id;
    public int date;
    public long inviter_id;
    public long user_id;
    public int version;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
        this.user_id = stream.readInt64(exception);
        this.inviter_id = stream.readInt64(exception);
        this.date = stream.readInt32(exception);
        this.version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        stream.writeInt64(this.user_id);
        stream.writeInt64(this.inviter_id);
        stream.writeInt32(this.date);
        stream.writeInt32(this.version);
    }
}
