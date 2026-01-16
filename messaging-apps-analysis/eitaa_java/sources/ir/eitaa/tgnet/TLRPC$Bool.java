package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$Bool extends TLObject {
    public static TLRPC$Bool TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Bool tLRPC$Bool;
        if (constructor == -1720552011) {
            tLRPC$Bool = new TLRPC$Bool() { // from class: ir.eitaa.tgnet.TLRPC$TL_boolTrue
                public static int constructor = -1720552011;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$Bool = constructor != -1132882121 ? null : new TLRPC$Bool() { // from class: ir.eitaa.tgnet.TLRPC$TL_boolFalse
                public static int constructor = -1132882121;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$Bool == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Bool", Integer.valueOf(constructor)));
        }
        if (tLRPC$Bool != null) {
            tLRPC$Bool.readParams(stream, exception);
        }
        return tLRPC$Bool;
    }
}
