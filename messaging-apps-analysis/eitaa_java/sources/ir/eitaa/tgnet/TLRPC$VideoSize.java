package ir.eitaa.tgnet;

import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class TLRPC$VideoSize extends TLObject {
    public int flags;
    public int h;
    public TLRPC$FileLocation location;
    public int size;
    public String type;
    public double video_start_ts;
    public int w;

    public static TLRPC$VideoSize TLdeserialize(long photo_id, long document_id, AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_videoSize tLRPC$TL_videoSize;
        if (constructor == -567037804) {
            tLRPC$TL_videoSize = new TLRPC$TL_videoSize();
        } else if (constructor != -399391402) {
            tLRPC$TL_videoSize = constructor != 1130084743 ? null : new TLRPC$TL_videoSize() { // from class: ir.eitaa.tgnet.TLRPC$TL_videoSize_layer115
                public static int constructor = 1130084743;

                @Override // ir.eitaa.tgnet.TLRPC$TL_videoSize, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.type = stream2.readString(exception2);
                    this.location = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    this.w = stream2.readInt32(exception2);
                    this.h = stream2.readInt32(exception2);
                    this.size = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_videoSize, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeString(this.type);
                    this.location.serializeToStream(stream2);
                    stream2.writeInt32(this.w);
                    stream2.writeInt32(this.h);
                    stream2.writeInt32(this.size);
                }
            };
        } else {
            tLRPC$TL_videoSize = new TLRPC$TL_videoSize() { // from class: ir.eitaa.tgnet.TLRPC$TL_videoSize_layer127
                public static int constructor = -399391402;

                @Override // ir.eitaa.tgnet.TLRPC$TL_videoSize, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.flags = stream2.readInt32(exception2);
                    this.type = stream2.readString(exception2);
                    this.location = TLRPC$FileLocation.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    this.w = stream2.readInt32(exception2);
                    this.h = stream2.readInt32(exception2);
                    this.size = stream2.readInt32(exception2);
                    if ((this.flags & 1) != 0) {
                        this.video_start_ts = stream2.readDouble(exception2);
                    }
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_videoSize, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(this.flags);
                    stream2.writeString(this.type);
                    this.location.serializeToStream(stream2);
                    stream2.writeInt32(this.w);
                    stream2.writeInt32(this.h);
                    stream2.writeInt32(this.size);
                    if ((this.flags & 1) != 0) {
                        stream2.writeDouble(this.video_start_ts);
                    }
                }
            };
        }
        if (tLRPC$TL_videoSize == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in VideoSize", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_videoSize != null) {
            tLRPC$TL_videoSize.readParams(stream, exception);
            if (tLRPC$TL_videoSize.location == null) {
                if (!TextUtils.isEmpty(tLRPC$TL_videoSize.type) && (photo_id != 0 || document_id != 0)) {
                    TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
                    tLRPC$TL_videoSize.location = tLRPC$TL_fileLocationToBeDeprecated;
                    if (photo_id != 0) {
                        tLRPC$TL_fileLocationToBeDeprecated.volume_id = -photo_id;
                        tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$TL_videoSize.type.charAt(0);
                    } else {
                        tLRPC$TL_fileLocationToBeDeprecated.volume_id = -document_id;
                        tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$TL_videoSize.type.charAt(0) + 1000;
                    }
                } else {
                    tLRPC$TL_videoSize.location = new TLRPC$TL_fileLocationUnavailable();
                }
            }
        }
        return tLRPC$TL_videoSize;
    }
}
