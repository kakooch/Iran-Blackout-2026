package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_receivedQueue extends TLObject {
    public static int constructor = 1436924774;
    public int max_qts;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            tLRPC$Vector.objects.add(Long.valueOf(stream.readInt64(exception)));
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.max_qts);
    }
}
