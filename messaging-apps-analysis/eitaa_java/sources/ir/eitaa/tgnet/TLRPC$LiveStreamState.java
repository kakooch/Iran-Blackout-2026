package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$LiveStreamState extends TLObject {
    public int duration;
    public int expire_date;
    public int flags;
    public boolean isArchived;
    public boolean isPaused;
    public TLRPC$TL_LiveStream liveStream;
    public String archive_link = "";
    public int archive_size = 0;
    public boolean isBroadCasting = false;

    public static TLRPC$LiveStreamState TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$LiveStreamState tLRPC$TL_LiveStreamStateInit;
        switch (constructor) {
            case -1263446626:
                tLRPC$TL_LiveStreamStateInit = new TLRPC$TL_LiveStreamStateInit();
                break;
            case -1202907733:
                tLRPC$TL_LiveStreamStateInit = new TLRPC$TL_LiveStreamStateEnded() { // from class: ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateEnded_layer84
                    public static int constructor = -1202907733;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateEnded, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.isArchived = (int32 & 1) != 0;
                        this.duration = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.expire_date = stream2.readInt32(exception2);
                            this.archive_link = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateEnded, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt32(this.duration);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.expire_date);
                            stream2.writeString(this.archive_link);
                        }
                    }
                };
                break;
            case -1151640075:
                tLRPC$TL_LiveStreamStateInit = new TLRPC$LiveStreamState() { // from class: ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateBroadcasting
                    public static int constructor = -1151640075;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.isBroadCasting = true;
                        this.isPaused = (int32 & 1) != 0;
                        this.liveStream = TLRPC$TL_LiveStream.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        this.liveStream.serializeToStream(stream2);
                    }
                };
                break;
            case -53427794:
                tLRPC$TL_LiveStreamStateInit = new TLRPC$TL_LiveStreamStateEnded();
                break;
            default:
                tLRPC$TL_LiveStreamStateInit = null;
                break;
        }
        if (tLRPC$TL_LiveStreamStateInit == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in LiveStreamState", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_LiveStreamStateInit != null) {
            tLRPC$TL_LiveStreamStateInit.readParams(stream, exception);
        }
        return tLRPC$TL_LiveStreamStateInit;
    }
}
