package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_setGlobalPrivacySettings extends TLObject {
    public static int constructor = 517647042;
    public TLRPC$TL_globalPrivacySettings settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_globalPrivacySettings.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.settings.serializeToStream(stream);
    }
}
