package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateUserTyping extends TLRPC$Update {
    public static int constructor = -1071741569;
    public TLRPC$SendMessageAction action;
    public long user_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
        this.action = TLRPC$SendMessageAction.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
        this.action.serializeToStream(stream);
    }
}
