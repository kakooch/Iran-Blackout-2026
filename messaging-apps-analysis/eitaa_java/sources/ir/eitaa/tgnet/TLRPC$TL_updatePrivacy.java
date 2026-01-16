package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updatePrivacy extends TLRPC$Update {
    public static int constructor = -298113238;
    public TLRPC$PrivacyKey key;
    public ArrayList<TLRPC$PrivacyRule> rules = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.key = TLRPC$PrivacyKey.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$PrivacyRule tLRPC$PrivacyRuleTLdeserialize = TLRPC$PrivacyRule.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$PrivacyRuleTLdeserialize == null) {
                return;
            }
            this.rules.add(tLRPC$PrivacyRuleTLdeserialize);
        }
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
