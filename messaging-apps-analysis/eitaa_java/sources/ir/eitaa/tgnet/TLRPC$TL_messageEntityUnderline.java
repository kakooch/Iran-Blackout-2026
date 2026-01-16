package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageEntityUnderline extends TLRPC$MessageEntity {
    public static int constructor = -1672577397;

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
