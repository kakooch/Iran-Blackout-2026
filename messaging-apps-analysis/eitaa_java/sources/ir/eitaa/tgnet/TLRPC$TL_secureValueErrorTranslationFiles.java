package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_secureValueErrorTranslationFiles extends TLRPC$SecureValueError {
    public static int constructor = 878931416;
    public ArrayList<byte[]> file_hash = new ArrayList<>();
    public String text;
    public TLRPC$SecureValueType type;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = TLRPC$SecureValueType.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            this.file_hash.add(stream.readByteArray(exception));
        }
        this.text = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.type.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.file_hash.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeByteArray(this.file_hash.get(i));
        }
        stream.writeString(this.text);
    }
}
