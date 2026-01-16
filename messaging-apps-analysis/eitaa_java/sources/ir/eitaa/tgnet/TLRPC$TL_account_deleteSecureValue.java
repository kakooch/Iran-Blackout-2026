package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_deleteSecureValue extends TLObject {
    public static int constructor = -1199522741;
    public ArrayList<TLRPC$SecureValueType> types = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
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
