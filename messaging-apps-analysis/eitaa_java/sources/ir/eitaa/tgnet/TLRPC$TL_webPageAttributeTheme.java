package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_webPageAttributeTheme extends TLObject {
    public static int constructor = 1421174295;
    public ArrayList<TLRPC$Document> documents = new ArrayList<>();
    public int flags;
    public TLRPC$ThemeSettings settings;

    public static TLRPC$TL_webPageAttributeTheme TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_webPageAttributeTheme", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeTheme = new TLRPC$TL_webPageAttributeTheme();
        tLRPC$TL_webPageAttributeTheme.readParams(stream, exception);
        return tLRPC$TL_webPageAttributeTheme;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$DocumentTLdeserialize == null) {
                    return;
                }
                this.documents.add(tLRPC$DocumentTLdeserialize);
            }
        }
        if ((this.flags & 2) != 0) {
            this.settings = TLRPC$ThemeSettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.documents.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.documents.get(i).serializeToStream(stream);
            }
        }
        if ((this.flags & 2) != 0) {
            this.settings.serializeToStream(stream);
        }
    }
}
