package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_registerDevice extends TLObject {
    public static int constructor = -326762118;
    public boolean app_sandbox;
    public int flags;
    public boolean no_muted;
    public ArrayList<Long> other_uids = new ArrayList<>();
    public byte[] secret;
    public String token;
    public int token_type;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.no_muted ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt32(this.token_type);
        stream.writeString(this.token);
        stream.writeBool(this.app_sandbox);
        stream.writeByteArray(this.secret);
        stream.writeInt32(481674261);
        int size = this.other_uids.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            stream.writeInt64(this.other_uids.get(i2).longValue());
        }
    }
}
