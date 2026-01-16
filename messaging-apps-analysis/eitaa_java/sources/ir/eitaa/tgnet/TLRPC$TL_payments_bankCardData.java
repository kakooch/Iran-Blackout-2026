package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_bankCardData extends TLObject {
    public static int constructor = 1042605427;
    public ArrayList<TLRPC$TL_bankCardOpenUrl> open_urls = new ArrayList<>();
    public String title;

    public static TLRPC$TL_payments_bankCardData TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_payments_bankCardData", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_payments_bankCardData tLRPC$TL_payments_bankCardData = new TLRPC$TL_payments_bankCardData();
        tLRPC$TL_payments_bankCardData.readParams(stream, exception);
        return tLRPC$TL_payments_bankCardData;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.title = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_bankCardOpenUrl tLRPC$TL_bankCardOpenUrlTLdeserialize = TLRPC$TL_bankCardOpenUrl.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_bankCardOpenUrlTLdeserialize == null) {
                return;
            }
            this.open_urls.add(tLRPC$TL_bankCardOpenUrlTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.title);
        stream.writeInt32(481674261);
        int size = this.open_urls.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.open_urls.get(i).serializeToStream(stream);
        }
    }
}
