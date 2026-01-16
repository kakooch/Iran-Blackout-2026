package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_globalPrivacySettings extends TLObject {
    public static int constructor = -1096616924;
    public boolean archive_and_mute_new_noncontact_peers;
    public int flags;

    public static TLRPC$TL_globalPrivacySettings TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_globalPrivacySettings", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_globalPrivacySettings tLRPC$TL_globalPrivacySettings = new TLRPC$TL_globalPrivacySettings();
        tLRPC$TL_globalPrivacySettings.readParams(stream, exception);
        return tLRPC$TL_globalPrivacySettings;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.archive_and_mute_new_noncontact_peers = stream.readBool(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeBool(this.archive_and_mute_new_noncontact_peers);
        }
    }
}
