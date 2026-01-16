package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_passwordSettings extends TLObject {
    public static int constructor = -1705233435;
    public String email;
    public int flags;
    public TLRPC$TL_secureSecretSettings secure_settings;

    public static TLRPC$TL_account_passwordSettings TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_passwordSettings", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_passwordSettings tLRPC$TL_account_passwordSettings = new TLRPC$TL_account_passwordSettings();
        tLRPC$TL_account_passwordSettings.readParams(stream, exception);
        return tLRPC$TL_account_passwordSettings;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.email = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.secure_settings = TLRPC$TL_secureSecretSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.email);
        }
        if ((this.flags & 2) != 0) {
            this.secure_settings.serializeToStream(stream);
        }
    }
}
