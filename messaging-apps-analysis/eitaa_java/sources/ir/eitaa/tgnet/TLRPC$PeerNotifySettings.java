package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PeerNotifySettings extends TLObject {
    public int events_mask;
    public int flags;
    public int mute_until;
    public boolean show_previews;
    public boolean silent;
    public String sound;

    public static TLRPC$PeerNotifySettings TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PeerNotifySettings tLRPC$TL_peerNotifySettings;
        switch (constructor) {
            case -1923214866:
                tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings() { // from class: ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings_layer47
                    public static int constructor = -1923214866;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.mute_until = stream2.readInt32(exception2);
                        this.sound = stream2.readString(exception2);
                        this.show_previews = stream2.readBool(exception2);
                        this.events_mask = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.mute_until);
                        stream2.writeString(this.sound);
                        stream2.writeBool(this.show_previews);
                        stream2.writeInt32(this.events_mask);
                    }
                };
                break;
            case -1697798976:
                tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings() { // from class: ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings_layer77
                    public static int constructor = -1697798976;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.show_previews = (int32 & 1) != 0;
                        this.silent = (int32 & 2) != 0;
                        this.mute_until = stream2.readInt32(exception2);
                        this.sound = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.show_previews ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.silent ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt32(this.mute_until);
                        stream2.writeString(this.sound);
                    }
                };
                break;
            case -1353671392:
                tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                break;
            case 1889961234:
                tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettingsEmpty_layer77();
                break;
            default:
                tLRPC$TL_peerNotifySettings = null;
                break;
        }
        if (tLRPC$TL_peerNotifySettings == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PeerNotifySettings", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_peerNotifySettings != null) {
            tLRPC$TL_peerNotifySettings.readParams(stream, exception);
        }
        return tLRPC$TL_peerNotifySettings;
    }
}
