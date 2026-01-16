package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$help_AppUpdate extends TLObject {
    public static TLRPC$help_AppUpdate TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$help_AppUpdate tLRPC$TL_help_appUpdate;
        if (constructor != -1000708810) {
            tLRPC$TL_help_appUpdate = constructor != -860107216 ? null : new TLRPC$TL_help_appUpdate();
        } else {
            tLRPC$TL_help_appUpdate = new TLRPC$help_AppUpdate() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_noAppUpdate
                public static int constructor = -1000708810;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        }
        if (tLRPC$TL_help_appUpdate == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in help_AppUpdate", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_help_appUpdate != null) {
            tLRPC$TL_help_appUpdate.readParams(stream, exception);
        }
        return tLRPC$TL_help_appUpdate;
    }
}
