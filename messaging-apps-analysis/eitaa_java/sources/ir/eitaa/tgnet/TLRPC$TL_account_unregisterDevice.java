package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_unregisterDevice extends TLObject {
    public static int constructor = 1779249670;
    public ArrayList<Long> other_uids = new ArrayList<>();
    public String token;
    public int token_type;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.token_type);
        stream.writeString(this.token);
        stream.writeInt32(481674261);
        int size = this.other_uids.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeInt64(this.other_uids.get(i).longValue());
        }
    }
}
