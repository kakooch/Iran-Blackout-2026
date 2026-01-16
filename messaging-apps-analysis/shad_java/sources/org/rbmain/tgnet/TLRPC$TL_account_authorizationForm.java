package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_authorizationForm extends TLObject {
    public static int constructor = -1389486888;
    public int flags;
    public String privacy_policy_url;
    public ArrayList<TLRPC$SecureRequiredType> required_types = new ArrayList<>();
    public ArrayList<TLRPC$TL_secureValue> values = new ArrayList<>();
    public ArrayList<TLRPC$SecureValueError> errors = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_account_authorizationForm TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_authorizationForm", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm = new TLRPC$TL_account_authorizationForm();
        tLRPC$TL_account_authorizationForm.readParams(abstractSerializedData, z);
        return tLRPC$TL_account_authorizationForm;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$SecureRequiredType tLRPC$SecureRequiredTypeTLdeserialize = TLRPC$SecureRequiredType.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$SecureRequiredTypeTLdeserialize == null) {
                return;
            }
            this.required_types.add(tLRPC$SecureRequiredTypeTLdeserialize);
        }
        int int323 = abstractSerializedData.readInt32(z);
        if (int323 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$TL_secureValue tLRPC$TL_secureValueTLdeserialize = TLRPC$TL_secureValue.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_secureValueTLdeserialize == null) {
                return;
            }
            this.values.add(tLRPC$TL_secureValueTLdeserialize);
        }
        int int325 = abstractSerializedData.readInt32(z);
        if (int325 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = abstractSerializedData.readInt32(z);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$SecureValueError tLRPC$SecureValueErrorTLdeserialize = TLRPC$SecureValueError.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$SecureValueErrorTLdeserialize == null) {
                return;
            }
            this.errors.add(tLRPC$SecureValueErrorTLdeserialize);
        }
        int int327 = abstractSerializedData.readInt32(z);
        if (int327 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = abstractSerializedData.readInt32(z);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
        if ((this.flags & 1) != 0) {
            this.privacy_policy_url = abstractSerializedData.readString(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt32(481674261);
        int size = this.required_types.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.required_types.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.values.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.values.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.errors.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.errors.get(i3).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size4 = this.users.size();
        abstractSerializedData.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.privacy_policy_url);
        }
    }
}
