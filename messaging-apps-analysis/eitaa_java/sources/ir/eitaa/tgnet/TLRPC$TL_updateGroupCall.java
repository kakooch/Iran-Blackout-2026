package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateGroupCall extends TLRPC$Update {
    public static int constructor = 347227392;
    public TLRPC$GroupCall call;
    public long chat_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
        this.call = TLRPC$GroupCall.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        this.call.serializeToStream(stream);
    }
}
