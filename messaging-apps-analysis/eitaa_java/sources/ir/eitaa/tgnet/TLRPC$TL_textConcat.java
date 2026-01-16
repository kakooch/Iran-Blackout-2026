package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_textConcat extends TLRPC$RichText {
    public static int constructor = 2120376535;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$RichText tLRPC$RichTextTLdeserialize = TLRPC$RichText.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$RichTextTLdeserialize == null) {
                return;
            }
            this.texts.add(tLRPC$RichTextTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.texts.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.texts.get(i).serializeToStream(stream);
        }
    }
}
