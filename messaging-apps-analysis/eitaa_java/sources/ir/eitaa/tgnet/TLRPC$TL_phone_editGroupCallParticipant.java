package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_editGroupCallParticipant extends TLObject {
    public static int constructor = -1524155713;
    public TLRPC$TL_inputGroupCall call;
    public int flags;
    public boolean muted;
    public TLRPC$InputPeer participant;
    public boolean presentation_paused;
    public boolean raise_hand;
    public boolean video_paused;
    public boolean video_stopped;
    public int volume;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.call.serializeToStream(stream);
        this.participant.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeBool(this.muted);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.volume);
        }
        if ((this.flags & 4) != 0) {
            stream.writeBool(this.raise_hand);
        }
        if ((this.flags & 8) != 0) {
            stream.writeBool(this.video_stopped);
        }
        if ((this.flags & 16) != 0) {
            stream.writeBool(this.video_paused);
        }
        if ((this.flags & 32) != 0) {
            stream.writeBool(this.presentation_paused);
        }
    }
}
