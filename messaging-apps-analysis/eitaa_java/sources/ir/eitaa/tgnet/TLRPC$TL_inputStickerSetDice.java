package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputStickerSetDice extends TLRPC$InputStickerSet {
    public static int constructor = -427863538;
    public String emoticon;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.emoticon = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.emoticon);
    }
}
