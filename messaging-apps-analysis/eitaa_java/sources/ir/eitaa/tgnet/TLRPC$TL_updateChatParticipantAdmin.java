package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChatParticipantAdmin extends TLRPC$Update {
    public static int constructor = -674602590;
    public long chat_id;
    public boolean is_admin;
    public long user_id;
    public int version;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
        this.user_id = stream.readInt64(exception);
        this.is_admin = stream.readBool(exception);
        this.version = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        stream.writeInt64(this.user_id);
        stream.writeBool(this.is_admin);
        stream.writeInt32(this.version);
    }
}
