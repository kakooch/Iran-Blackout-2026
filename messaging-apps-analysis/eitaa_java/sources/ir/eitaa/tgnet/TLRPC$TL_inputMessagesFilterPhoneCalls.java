package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMessagesFilterPhoneCalls extends TLRPC$MessagesFilter {
    public static int constructor = -2134272152;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.missed = (int32 & 1) != 0;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.missed ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
    }
}
