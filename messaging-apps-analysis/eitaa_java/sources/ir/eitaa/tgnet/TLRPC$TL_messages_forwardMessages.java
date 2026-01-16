package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_forwardMessages extends TLObject {
    public static int constructor = -637606386;
    public boolean background;
    public boolean drop_author;
    public boolean drop_media_captions;
    public int flags;
    public TLRPC$InputPeer from_peer;
    public ArrayList<Integer> id = new ArrayList<>();
    public ArrayList<Long> random_id = new ArrayList<>();
    public int schedule_date;
    public boolean silent;
    public TLRPC$InputPeer to_peer;
    public boolean with_my_score;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.silent ? this.flags | 32 : this.flags & (-33);
        this.flags = i;
        int i2 = this.background ? i | 64 : i & (-65);
        this.flags = i2;
        int i3 = this.with_my_score ? i2 | Factory.DEVICE_HAS_CRAPPY_OPENSLES : i2 & (-257);
        this.flags = i3;
        int i4 = this.drop_author ? i3 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i3 & (-2049);
        this.flags = i4;
        int i5 = this.drop_media_captions ? i4 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i4 & (-4097);
        this.flags = i5;
        stream.writeInt32(i5);
        this.from_peer.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.id.size();
        stream.writeInt32(size);
        for (int i6 = 0; i6 < size; i6++) {
            stream.writeInt32(this.id.get(i6).intValue());
        }
        stream.writeInt32(481674261);
        int size2 = this.random_id.size();
        stream.writeInt32(size2);
        for (int i7 = 0; i7 < size2; i7++) {
            stream.writeInt64(this.random_id.get(i7).longValue());
        }
        this.to_peer.serializeToStream(stream);
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeInt32(this.schedule_date);
        }
    }
}
