package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_sentCode extends TLObject {
    public static int constructor = 1577067778;
    public int flags;
    public String message;
    public TLRPC$auth_CodeType next_type;
    public String phone_code_hash;
    public int timeout;
    public TLRPC$auth_SentCodeType type;

    public static TLRPC$TL_auth_sentCode TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_auth_sentCode", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = new TLRPC$TL_auth_sentCode();
        tLRPC$TL_auth_sentCode.readParams(stream, exception);
        return tLRPC$TL_auth_sentCode;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.type = TLRPC$auth_SentCodeType.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.phone_code_hash = stream.readString(exception);
        if ((this.flags & 2) != 0) {
            this.next_type = TLRPC$auth_CodeType.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 4) != 0) {
            this.timeout = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.message = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.type.serializeToStream(stream);
        stream.writeString(this.phone_code_hash);
        if ((this.flags & 2) != 0) {
            this.next_type.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.timeout);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            stream.writeString(this.message);
        }
    }
}
