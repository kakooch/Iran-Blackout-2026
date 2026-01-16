package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_secureRequiredTypeOneOf extends TLRPC$SecureRequiredType {
    public static int constructor = 41187252;
    public ArrayList<TLRPC$SecureRequiredType> types = new ArrayList<>();

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
            TLRPC$SecureRequiredType tLRPC$SecureRequiredTypeTLdeserialize = TLRPC$SecureRequiredType.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$SecureRequiredTypeTLdeserialize == null) {
                return;
            }
            this.types.add(tLRPC$SecureRequiredTypeTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.types.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.types.get(i).serializeToStream(stream);
        }
    }
}
