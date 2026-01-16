package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$LangPackString extends TLObject {
    public String few_value;
    public int flags;
    public String key;
    public String many_value;
    public String one_value;
    public String other_value;
    public String two_value;
    public String value;
    public String zero_value;

    public static TLRPC$LangPackString TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$LangPackString tLRPC$LangPackString;
        if (constructor == -892239370) {
            tLRPC$LangPackString = new TLRPC$LangPackString() { // from class: ir.eitaa.tgnet.TLRPC$TL_langPackString
                public static int constructor = -892239370;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.key = stream2.readString(exception2);
                    this.value = stream2.readString(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeString(this.key);
                    stream2.writeString(this.value);
                }
            };
        } else if (constructor != 695856818) {
            tLRPC$LangPackString = constructor != 1816636575 ? null : new TLRPC$LangPackString() { // from class: ir.eitaa.tgnet.TLRPC$TL_langPackStringPluralized
                public static int constructor = 1816636575;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.flags = stream2.readInt32(exception2);
                    this.key = stream2.readString(exception2);
                    if ((this.flags & 1) != 0) {
                        this.zero_value = stream2.readString(exception2);
                    }
                    if ((this.flags & 2) != 0) {
                        this.one_value = stream2.readString(exception2);
                    }
                    if ((this.flags & 4) != 0) {
                        this.two_value = stream2.readString(exception2);
                    }
                    if ((this.flags & 8) != 0) {
                        this.few_value = stream2.readString(exception2);
                    }
                    if ((this.flags & 16) != 0) {
                        this.many_value = stream2.readString(exception2);
                    }
                    this.other_value = stream2.readString(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.flags);
                    stream2.writeString(this.key);
                    if ((this.flags & 1) != 0) {
                        stream2.writeString(this.zero_value);
                    }
                    if ((this.flags & 2) != 0) {
                        stream2.writeString(this.one_value);
                    }
                    if ((this.flags & 4) != 0) {
                        stream2.writeString(this.two_value);
                    }
                    if ((this.flags & 8) != 0) {
                        stream2.writeString(this.few_value);
                    }
                    if ((this.flags & 16) != 0) {
                        stream2.writeString(this.many_value);
                    }
                    stream2.writeString(this.other_value);
                }
            };
        } else {
            tLRPC$LangPackString = new TLRPC$LangPackString() { // from class: ir.eitaa.tgnet.TLRPC$TL_langPackStringDeleted
                public static int constructor = 695856818;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.key = stream2.readString(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeString(this.key);
                }
            };
        }
        if (tLRPC$LangPackString == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in LangPackString", Integer.valueOf(constructor)));
        }
        if (tLRPC$LangPackString != null) {
            tLRPC$LangPackString.readParams(stream, exception);
        }
        return tLRPC$LangPackString;
    }
}
