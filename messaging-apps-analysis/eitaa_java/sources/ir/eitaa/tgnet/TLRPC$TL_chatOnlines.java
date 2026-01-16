package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatOnlines extends TLObject {
    public static int constructor = -264117680;
    public int onlines;

    public static TLRPC$TL_chatOnlines TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatOnlines", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_chatOnlines tLRPC$TL_chatOnlines = new TLRPC$TL_chatOnlines();
        tLRPC$TL_chatOnlines.readParams(stream, exception);
        return tLRPC$TL_chatOnlines;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.onlines = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.onlines);
    }
}
