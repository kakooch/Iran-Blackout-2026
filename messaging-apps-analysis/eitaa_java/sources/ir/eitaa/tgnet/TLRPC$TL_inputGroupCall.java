package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputGroupCall extends TLObject {
    public static int constructor = -659913713;
    public long access_hash;
    public long id;

    public static TLRPC$TL_inputGroupCall TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_inputGroupCall", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall = new TLRPC$TL_inputGroupCall();
        tLRPC$TL_inputGroupCall.readParams(stream, exception);
        return tLRPC$TL_inputGroupCall;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
    }
}
