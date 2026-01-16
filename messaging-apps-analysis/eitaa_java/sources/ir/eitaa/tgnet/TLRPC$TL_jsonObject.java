package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_jsonObject extends TLRPC$JSONValue {
    public static int constructor = -1715350371;
    public ArrayList<TLRPC$TL_jsonObjectValue> value = new ArrayList<>();

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
            TLRPC$TL_jsonObjectValue tLRPC$TL_jsonObjectValueTLdeserialize = TLRPC$TL_jsonObjectValue.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_jsonObjectValueTLdeserialize == null) {
                return;
            }
            this.value.add(tLRPC$TL_jsonObjectValueTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.value.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.value.get(i).serializeToStream(stream);
        }
    }
}
