package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_help_countryCode extends TLObject {
    public static int constructor = 1107543535;
    public String country_code;
    public int flags;
    public ArrayList<String> prefixes = new ArrayList<>();
    public ArrayList<String> patterns = new ArrayList<>();

    public static TLRPC$TL_help_countryCode TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_help_countryCode", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_help_countryCode tLRPC$TL_help_countryCode = new TLRPC$TL_help_countryCode();
        tLRPC$TL_help_countryCode.readParams(stream, exception);
        return tLRPC$TL_help_countryCode;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.country_code = stream.readString(exception);
        if ((this.flags & 1) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            } else {
                int int322 = stream.readInt32(exception);
                for (int i = 0; i < int322; i++) {
                    this.prefixes.add(stream.readString(exception));
                }
            }
        }
        if ((this.flags & 2) != 0) {
            int int323 = stream.readInt32(exception);
            if (int323 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
            } else {
                int int324 = stream.readInt32(exception);
                for (int i2 = 0; i2 < int324; i2++) {
                    this.patterns.add(stream.readString(exception));
                }
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.country_code);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.prefixes.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                stream.writeString(this.prefixes.get(i));
            }
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.patterns.size();
            stream.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                stream.writeString(this.patterns.get(i2));
            }
        }
    }
}
