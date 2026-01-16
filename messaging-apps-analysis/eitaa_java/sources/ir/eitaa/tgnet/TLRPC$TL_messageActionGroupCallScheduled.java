package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageActionGroupCallScheduled extends TLRPC$MessageAction {
    public static int constructor = -1281329567;
    public int schedule_date;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.schedule_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.call.serializeToStream(stream);
        stream.writeInt32(this.schedule_date);
    }
}
