package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_help_countriesList extends TLRPC$help_CountriesList {
    public static int constructor = -2016381538;
    public ArrayList<TLRPC$TL_help_country> countries = new ArrayList<>();
    public int hash;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_help_country tLRPC$TL_help_countryTLdeserialize = TLRPC$TL_help_country.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_help_countryTLdeserialize == null) {
                return;
            }
            this.countries.add(tLRPC$TL_help_countryTLdeserialize);
        }
        this.hash = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.countries.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.countries.get(i).serializeToStream(stream);
        }
        stream.writeInt32(this.hash);
    }
}
