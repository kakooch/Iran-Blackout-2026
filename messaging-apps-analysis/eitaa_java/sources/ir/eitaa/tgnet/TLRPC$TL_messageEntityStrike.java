package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageEntityStrike extends TLRPC$MessageEntity {
    public static int constructor = -1090087980;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.offset = stream.readInt32(exception);
        this.length = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.offset);
        stream.writeInt32(this.length);
    }
}
