package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_exportChatInvite_layer84 extends TLObject {
    public static int constructor = 2106086025;
    public int chat_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$ExportedChatInvite.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.chat_id);
    }
}
