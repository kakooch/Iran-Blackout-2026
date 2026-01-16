package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pollAnswer extends TLObject {
    public static int constructor = 1823064809;
    public byte[] option;
    public String text;

    public static TLRPC$TL_pollAnswer TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pollAnswer", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = new TLRPC$TL_pollAnswer();
        tLRPC$TL_pollAnswer.readParams(stream, exception);
        return tLRPC$TL_pollAnswer;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = stream.readString(exception);
        this.option = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.text);
        stream.writeByteArray(this.option);
    }
}
