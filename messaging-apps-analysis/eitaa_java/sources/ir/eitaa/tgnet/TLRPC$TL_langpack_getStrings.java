package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_langpack_getStrings extends TLObject {
    public static int constructor = 773776152;
    public ArrayList<String> keys = new ArrayList<>();
    public String lang_code;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            TLRPC$LangPackString tLRPC$LangPackStringTLdeserialize = TLRPC$LangPackString.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$LangPackStringTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$LangPackStringTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang_code);
        stream.writeInt32(481674261);
        int size = this.keys.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            stream.writeString(this.keys.get(i));
        }
    }
}
