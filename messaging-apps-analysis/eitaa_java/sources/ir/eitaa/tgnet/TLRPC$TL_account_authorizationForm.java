package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_account_authorizationForm extends TLObject {
    public static int constructor = -1389486888;
    public int flags;
    public String privacy_policy_url;
    public ArrayList<TLRPC$SecureRequiredType> required_types = new ArrayList<>();
    public ArrayList<TLRPC$TL_secureValue> values = new ArrayList<>();
    public ArrayList<TLRPC$SecureValueError> errors = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_account_authorizationForm TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_authorizationForm", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm = new TLRPC$TL_account_authorizationForm();
        tLRPC$TL_account_authorizationForm.readParams(stream, exception);
        return tLRPC$TL_account_authorizationForm;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
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
            this.required_types.add(tLRPC$SecureRequiredTypeTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$TL_secureValue tLRPC$TL_secureValueTLdeserialize = TLRPC$TL_secureValue.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_secureValueTLdeserialize == null) {
                return;
            }
            this.values.add(tLRPC$TL_secureValueTLdeserialize);
        }
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$SecureValueError tLRPC$SecureValueErrorTLdeserialize = TLRPC$SecureValueError.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$SecureValueErrorTLdeserialize == null) {
                return;
            }
            this.errors.add(tLRPC$SecureValueErrorTLdeserialize);
        }
        int int327 = stream.readInt32(exception);
        if (int327 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = stream.readInt32(exception);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
        if ((this.flags & 1) != 0) {
            this.privacy_policy_url = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt32(481674261);
        int size = this.required_types.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.required_types.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.values.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.values.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.errors.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.errors.get(i3).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size4 = this.users.size();
        stream.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(stream);
        }
        if ((this.flags & 1) != 0) {
            stream.writeString(this.privacy_policy_url);
        }
    }
}
