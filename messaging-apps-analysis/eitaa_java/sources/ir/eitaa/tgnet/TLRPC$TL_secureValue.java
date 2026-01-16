package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_secureValue extends TLObject {
    public static int constructor = 411017418;
    public TLRPC$TL_secureData data;
    public int flags;
    public TLRPC$SecureFile front_side;
    public byte[] hash;
    public TLRPC$SecurePlainData plain_data;
    public TLRPC$SecureFile reverse_side;
    public TLRPC$SecureFile selfie;
    public TLRPC$SecureValueType type;
    public ArrayList<TLRPC$SecureFile> translation = new ArrayList<>();
    public ArrayList<TLRPC$SecureFile> files = new ArrayList<>();

    public static TLRPC$TL_secureValue TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_secureValue", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_secureValue tLRPC$TL_secureValue = new TLRPC$TL_secureValue();
        tLRPC$TL_secureValue.readParams(stream, exception);
        return tLRPC$TL_secureValue;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.type = TLRPC$SecureValueType.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.data = TLRPC$TL_secureData.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.front_side = TLRPC$SecureFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 4) != 0) {
            this.reverse_side = TLRPC$SecureFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 8) != 0) {
            this.selfie = TLRPC$SecureFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 64) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                TLRPC$SecureFile tLRPC$SecureFileTLdeserialize = TLRPC$SecureFile.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$SecureFileTLdeserialize == null) {
                    return;
                }
                this.translation.add(tLRPC$SecureFileTLdeserialize);
            }
        }
        if ((this.flags & 16) != 0) {
            int int323 = stream.readInt32(exception);
            if (int323 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
                return;
            }
            int int324 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int324; i2++) {
                TLRPC$SecureFile tLRPC$SecureFileTLdeserialize2 = TLRPC$SecureFile.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$SecureFileTLdeserialize2 == null) {
                    return;
                }
                this.files.add(tLRPC$SecureFileTLdeserialize2);
            }
        }
        if ((this.flags & 32) != 0) {
            this.plain_data = TLRPC$SecurePlainData.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.hash = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.type.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            this.data.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            this.front_side.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            this.reverse_side.serializeToStream(stream);
        }
        if ((this.flags & 8) != 0) {
            this.selfie.serializeToStream(stream);
        }
        if ((this.flags & 64) != 0) {
            stream.writeInt32(481674261);
            int size = this.translation.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.translation.get(i).serializeToStream(stream);
            }
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.files.size();
            stream.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.files.get(i2).serializeToStream(stream);
            }
        }
        if ((this.flags & 32) != 0) {
            this.plain_data.serializeToStream(stream);
        }
        stream.writeByteArray(this.hash);
    }
}
