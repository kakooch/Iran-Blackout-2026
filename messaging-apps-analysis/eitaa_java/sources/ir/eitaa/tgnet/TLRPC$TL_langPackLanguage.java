package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_langPackLanguage extends TLObject {
    public static int constructor = -288727837;
    public String base_lang_code;
    public int flags;
    public String lang_code;
    public String name;
    public String native_name;
    public boolean official;
    public String plural_code;
    public boolean rtl;
    public int strings_count;
    public int translated_count;
    public String translations_url;

    public static TLRPC$TL_langPackLanguage TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_langPackLanguage", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_langPackLanguage tLRPC$TL_langPackLanguage = new TLRPC$TL_langPackLanguage();
        tLRPC$TL_langPackLanguage.readParams(stream, exception);
        return tLRPC$TL_langPackLanguage;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.official = (int32 & 1) != 0;
        this.rtl = (int32 & 4) != 0;
        this.name = stream.readString(exception);
        this.native_name = stream.readString(exception);
        this.lang_code = stream.readString(exception);
        if ((this.flags & 2) != 0) {
            this.base_lang_code = stream.readString(exception);
        }
        this.plural_code = stream.readString(exception);
        this.strings_count = stream.readInt32(exception);
        this.translated_count = stream.readInt32(exception);
        this.translations_url = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.official ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.rtl ? i | 4 : i & (-5);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeString(this.name);
        stream.writeString(this.native_name);
        stream.writeString(this.lang_code);
        if ((this.flags & 2) != 0) {
            stream.writeString(this.base_lang_code);
        }
        stream.writeString(this.plural_code);
        stream.writeInt32(this.strings_count);
        stream.writeInt32(this.translated_count);
        stream.writeString(this.translations_url);
    }
}
