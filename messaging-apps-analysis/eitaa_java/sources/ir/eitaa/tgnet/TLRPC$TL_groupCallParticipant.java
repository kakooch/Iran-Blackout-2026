package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_groupCallParticipant extends TLObject {
    public static int constructor = -341428482;
    public String about;
    public int active_date;
    public float amplitude;
    public boolean can_self_unmute;
    public int date;
    public int flags;
    public int hasCameraFrame;
    public int hasPresentationFrame;
    public boolean hasVoice;
    public boolean hasVoiceDelayed;
    public boolean just_joined;
    public long lastActiveDate;
    public long lastRaiseHandDate;
    public long lastSpeakTime;
    public int lastTypingDate;
    public long lastVisibleDate;
    public long lastVoiceUpdateTime;
    public boolean left;
    public boolean min;
    public boolean muted;
    public boolean muted_by_you;
    public TLRPC$Peer peer;
    public TLRPC$TL_groupCallParticipantVideo presentation;
    public String presentationEndpoint;
    public long raise_hand_rating;
    public boolean self;
    public int source;
    public boolean versioned;
    public TLRPC$TL_groupCallParticipantVideo video;
    public String videoEndpoint;
    public int videoIndex;
    public boolean video_joined;
    public int volume;
    public boolean volume_by_admin;

    public static TLRPC$TL_groupCallParticipant TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_groupCallParticipant", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
        tLRPC$TL_groupCallParticipant.readParams(stream, exception);
        return tLRPC$TL_groupCallParticipant;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.muted = (int32 & 1) != 0;
        this.left = (int32 & 2) != 0;
        this.can_self_unmute = (int32 & 4) != 0;
        this.just_joined = (int32 & 16) != 0;
        this.versioned = (int32 & 32) != 0;
        this.min = (int32 & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0;
        this.muted_by_you = (int32 & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
        this.volume_by_admin = (int32 & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0;
        this.self = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.video_joined = (int32 & 32768) != 0;
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
        if ((this.flags & 8) != 0) {
            this.active_date = stream.readInt32(exception);
        }
        this.source = stream.readInt32(exception);
        if ((this.flags & 128) != 0) {
            this.volume = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.about = stream.readString(exception);
        }
        if ((this.flags & 8192) != 0) {
            this.raise_hand_rating = stream.readInt64(exception);
        }
        if ((this.flags & 64) != 0) {
            this.video = TLRPC$TL_groupCallParticipantVideo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16384) != 0) {
            this.presentation = TLRPC$TL_groupCallParticipantVideo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.muted ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.left ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.can_self_unmute ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.just_joined ? i3 | 16 : i3 & (-17);
        this.flags = i4;
        int i5 = this.versioned ? i4 | 32 : i4 & (-33);
        this.flags = i5;
        int i6 = this.min ? i5 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i5 & (-257);
        this.flags = i6;
        int i7 = this.muted_by_you ? i6 | Factory.DEVICE_USE_ANDROID_CAMCORDER : i6 & (-513);
        this.flags = i7;
        int i8 = this.volume_by_admin ? i7 | Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV : i7 & (-1025);
        this.flags = i8;
        int i9 = this.self ? i8 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i8 & (-4097);
        this.flags = i9;
        int i10 = this.video_joined ? i9 | 32768 : i9 & (-32769);
        this.flags = i10;
        stream.writeInt32(i10);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.date);
        if ((this.flags & 8) != 0) {
            stream.writeInt32(this.active_date);
        }
        stream.writeInt32(this.source);
        if ((this.flags & 128) != 0) {
            stream.writeInt32(this.volume);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeString(this.about);
        }
        if ((this.flags & 8192) != 0) {
            stream.writeInt64(this.raise_hand_rating);
        }
        if ((this.flags & 64) != 0) {
            this.video.serializeToStream(stream);
        }
        if ((this.flags & 16384) != 0) {
            this.presentation.serializeToStream(stream);
        }
    }
}
