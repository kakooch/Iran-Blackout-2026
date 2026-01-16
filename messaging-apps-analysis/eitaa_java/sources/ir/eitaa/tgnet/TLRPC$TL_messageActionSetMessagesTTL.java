package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageActionSetMessagesTTL extends TLRPC$MessageAction {
    public static int constructor = -1441072131;
    public int period;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.period = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.period);
    }
}
