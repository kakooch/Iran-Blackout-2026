package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$PeerNotifySettings extends TLObject {
    public int events_mask;
    public int flags;
    public int mute_until;
    public boolean show_previews;
    public boolean silent;
    public String sound;

    public static TLRPC$PeerNotifySettings TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$PeerNotifySettings tLRPC$TL_peerNotifySettings;
        switch (i) {
            case -1923214866:
                tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings() { // from class: org.rbmain.tgnet.TLRPC$TL_peerNotifySettings_layer47
                    public static int constructor = -1923214866;

                    @Override // org.rbmain.tgnet.TLRPC$TL_peerNotifySettings, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        this.mute_until = abstractSerializedData2.readInt32(z2);
                        this.sound = abstractSerializedData2.readString(z2);
                        this.show_previews = abstractSerializedData2.readBool(z2);
                        this.events_mask = abstractSerializedData2.readInt32(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_peerNotifySettings, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        abstractSerializedData2.writeInt32(this.mute_until);
                        abstractSerializedData2.writeString(this.sound);
                        abstractSerializedData2.writeBool(this.show_previews);
                        abstractSerializedData2.writeInt32(this.events_mask);
                    }
                };
                break;
            case -1697798976:
                tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings() { // from class: org.rbmain.tgnet.TLRPC$TL_peerNotifySettings_layer77
                    public static int constructor = -1697798976;

                    @Override // org.rbmain.tgnet.TLRPC$TL_peerNotifySettings, org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                        int int32 = abstractSerializedData2.readInt32(z2);
                        this.flags = int32;
                        this.show_previews = (int32 & 1) != 0;
                        this.silent = (int32 & 2) != 0;
                        this.mute_until = abstractSerializedData2.readInt32(z2);
                        this.sound = abstractSerializedData2.readString(z2);
                    }

                    @Override // org.rbmain.tgnet.TLRPC$TL_peerNotifySettings, org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                        int i2 = this.show_previews ? this.flags | 1 : this.flags & (-2);
                        this.flags = i2;
                        int i3 = this.silent ? i2 | 2 : i2 & (-3);
                        this.flags = i3;
                        abstractSerializedData2.writeInt32(i3);
                        abstractSerializedData2.writeInt32(this.mute_until);
                        abstractSerializedData2.writeString(this.sound);
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
        if (tLRPC$TL_peerNotifySettings == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PeerNotifySettings", Integer.valueOf(i)));
        }
        if (tLRPC$TL_peerNotifySettings != null) {
            tLRPC$TL_peerNotifySettings.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_peerNotifySettings;
    }
}
