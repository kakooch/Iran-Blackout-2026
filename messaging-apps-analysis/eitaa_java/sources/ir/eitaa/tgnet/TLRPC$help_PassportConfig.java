package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$help_PassportConfig extends TLObject {
    public static TLRPC$help_PassportConfig TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$help_PassportConfig tLRPC$TL_help_passportConfig;
        if (constructor != -1600596305) {
            tLRPC$TL_help_passportConfig = constructor != -1078332329 ? null : new TLRPC$help_PassportConfig() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_passportConfigNotModified
                public static int constructor = -1078332329;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$TL_help_passportConfig = new TLRPC$TL_help_passportConfig();
        }
        if (tLRPC$TL_help_passportConfig == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in help_PassportConfig", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_help_passportConfig != null) {
            tLRPC$TL_help_passportConfig.readParams(stream, exception);
        }
        return tLRPC$TL_help_passportConfig;
    }
}
