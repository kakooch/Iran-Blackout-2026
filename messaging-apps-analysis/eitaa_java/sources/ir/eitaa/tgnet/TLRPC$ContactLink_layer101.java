package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$ContactLink_layer101 extends TLObject {
    public static TLRPC$ContactLink_layer101 TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$ContactLink_layer101 tLRPC$ContactLink_layer101;
        if (constructor == -721239344) {
            tLRPC$ContactLink_layer101 = new TLRPC$ContactLink_layer101() { // from class: ir.eitaa.tgnet.TLRPC$TL_contactLinkContact
                public static int constructor = -721239344;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else if (constructor == -17968211) {
            tLRPC$ContactLink_layer101 = new TLRPC$ContactLink_layer101() { // from class: ir.eitaa.tgnet.TLRPC$TL_contactLinkNone
                public static int constructor = -17968211;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$ContactLink_layer101 = constructor != 1599050311 ? null : new TLRPC$ContactLink_layer101() { // from class: ir.eitaa.tgnet.TLRPC$TL_contactLinkUnknown
                public static int constructor = 1599050311;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$ContactLink_layer101 == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in ContactLink", Integer.valueOf(constructor)));
        }
        if (tLRPC$ContactLink_layer101 != null) {
            tLRPC$ContactLink_layer101.readParams(stream, exception);
        }
        return tLRPC$ContactLink_layer101;
    }
}
