package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageMediaDice extends TLRPC$MessageMedia {
    public static int constructor = 1065280907;
    public String emoticon;
    public int value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.value = stream.readInt32(exception);
        this.emoticon = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.value);
        stream.writeString(this.emoticon);
    }
}
