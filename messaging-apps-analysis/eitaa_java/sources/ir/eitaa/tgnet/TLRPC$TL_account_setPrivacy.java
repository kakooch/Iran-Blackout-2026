package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_setPrivacy extends TLObject {
    public static int constructor = -906486552;
    public TLRPC$InputPrivacyKey key;
    public ArrayList<TLRPC$InputPrivacyRule> rules = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_privacyRules.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.key.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.rules.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.rules.get(i).serializeToStream(stream);
        }
    }
}
