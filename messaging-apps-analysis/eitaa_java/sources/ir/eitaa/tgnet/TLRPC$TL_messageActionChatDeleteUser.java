package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageActionChatDeleteUser extends TLRPC$MessageAction {
    public static int constructor = -1539362612;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.user_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.user_id);
    }
}
