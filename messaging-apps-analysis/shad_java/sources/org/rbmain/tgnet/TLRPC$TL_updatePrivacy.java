package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_updatePrivacy extends TLRPC$Update {
    public static int constructor = -298113238;
    public TLRPC$PrivacyKey key;
    public ArrayList<TLRPC$PrivacyRule> rules = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.key = TLRPC$PrivacyKey.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$PrivacyRule tLRPC$PrivacyRuleTLdeserialize = TLRPC$PrivacyRule.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$PrivacyRuleTLdeserialize == null) {
                return;
            }
            this.rules.add(tLRPC$PrivacyRuleTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.key.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.rules.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.rules.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
