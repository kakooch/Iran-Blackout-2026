package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_acceptAuthorization extends TLObject {
    public static int constructor = -202552205;
    public long bot_id;
    public TLRPC$TL_secureCredentialsEncrypted credentials;
    public String public_key;
    public String scope;
    public ArrayList<TLRPC$TL_secureValueHash> value_hashes = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.bot_id);
        stream.writeString(this.scope);
        stream.writeString(this.public_key);
        stream.writeInt32(481674261);
        int size = this.value_hashes.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.value_hashes.get(i).serializeToStream(stream);
        }
        this.credentials.serializeToStream(stream);
    }
}
