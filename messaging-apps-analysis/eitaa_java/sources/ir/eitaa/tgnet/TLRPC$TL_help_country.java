package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_help_country extends TLObject {
    public static int constructor = -1014526429;
    public ArrayList<TLRPC$TL_help_countryCode> country_codes = new ArrayList<>();
    public String default_name;
    public int flags;
    public boolean hidden;
    public String iso2;
    public String name;

    public static TLRPC$TL_help_country TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_help_country", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_help_country tLRPC$TL_help_country = new TLRPC$TL_help_country();
        tLRPC$TL_help_country.readParams(stream, exception);
        return tLRPC$TL_help_country;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.hidden = (int32 & 1) != 0;
        this.iso2 = stream.readString(exception);
        this.default_name = stream.readString(exception);
        if ((this.flags & 2) != 0) {
            this.name = stream.readString(exception);
        }
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_help_countryCode tLRPC$TL_help_countryCodeTLdeserialize = TLRPC$TL_help_countryCode.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_help_countryCodeTLdeserialize == null) {
                return;
            }
            this.country_codes.add(tLRPC$TL_help_countryCodeTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.hidden ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeString(this.iso2);
        stream.writeString(this.default_name);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.name);
        }
        stream.writeInt32(481674261);
        int size = this.country_codes.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.country_codes.get(i2).serializeToStream(stream);
        }
    }
}
