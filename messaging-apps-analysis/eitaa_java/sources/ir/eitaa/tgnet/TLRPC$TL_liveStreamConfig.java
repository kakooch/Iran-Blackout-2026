package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_liveStreamConfig extends TLObject {
    public static int constructor = 26504181;
    public int flags;
    public int maxVideoWidth = 720;
    public boolean send_in_groups;
    public boolean send_in_privateChannel;
    public boolean send_in_privateChat;
    public boolean send_in_publicChannel;
    public boolean send_in_supergroups;

    public TLRPC$TL_liveStreamConfig() {
    }

    public TLRPC$TL_liveStreamConfig(byte[] bytes) {
        SerializedData serializedData = new SerializedData(bytes);
        if (constructor == serializedData.readInt32(false)) {
            readParams(serializedData, false);
        }
    }

    public static TLRPC$TL_liveStreamConfig TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_liveBannedRights", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_liveStreamConfig tLRPC$TL_liveStreamConfig = new TLRPC$TL_liveStreamConfig();
        tLRPC$TL_liveStreamConfig.readParams(stream, exception);
        return tLRPC$TL_liveStreamConfig;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.send_in_privateChat = (int32 & 1) != 0;
        this.send_in_publicChannel = (int32 & 2) != 0;
        this.send_in_privateChannel = (int32 & 4) != 0;
        this.send_in_supergroups = (int32 & 8) != 0;
        this.send_in_groups = (int32 & 16) != 0;
        this.maxVideoWidth = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.send_in_privateChat ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.send_in_publicChannel ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.send_in_privateChannel ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.send_in_supergroups ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.send_in_groups ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        stream.writeInt32(i5);
        stream.writeInt32(this.maxVideoWidth);
    }
}
