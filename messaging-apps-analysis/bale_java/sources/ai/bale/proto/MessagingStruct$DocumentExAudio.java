package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$DocumentExAudio extends GeneratedMessageLite implements U64 {
    public static final int ALBUM_FIELD_NUMBER = 2;
    public static final int ARTIST_FIELD_NUMBER = 3;
    public static final int COVER_FIELD_NUMBER = 6;
    private static final MessagingStruct$DocumentExAudio DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 1;
    public static final int GENRE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_FIELD_NUMBER = 5;
    private int bitField0_;
    private BytesValue cover_;
    private int duration_;
    private String album_ = "";
    private String artist_ = "";
    private String genre_ = "";
    private String track_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$DocumentExAudio.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$DocumentExAudio messagingStruct$DocumentExAudio = new MessagingStruct$DocumentExAudio();
        DEFAULT_INSTANCE = messagingStruct$DocumentExAudio;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DocumentExAudio.class, messagingStruct$DocumentExAudio);
    }

    private MessagingStruct$DocumentExAudio() {
    }

    private void clearAlbum() {
        this.album_ = getDefaultInstance().getAlbum();
    }

    private void clearArtist() {
        this.artist_ = getDefaultInstance().getArtist();
    }

    private void clearCover() {
        this.cover_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDuration() {
        this.duration_ = 0;
    }

    private void clearGenre() {
        this.genre_ = getDefaultInstance().getGenre();
    }

    private void clearTrack() {
        this.track_ = getDefaultInstance().getTrack();
    }

    public static MessagingStruct$DocumentExAudio getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCover(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.cover_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.cover_ = bytesValue;
        } else {
            this.cover_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.cover_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DocumentExAudio parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAlbum(String str) {
        str.getClass();
        this.album_ = str;
    }

    private void setAlbumBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.album_ = abstractC2383g.f0();
    }

    private void setArtist(String str) {
        str.getClass();
        this.artist_ = str;
    }

    private void setArtistBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.artist_ = abstractC2383g.f0();
    }

    private void setCover(BytesValue bytesValue) {
        bytesValue.getClass();
        this.cover_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setDuration(int i) {
        this.duration_ = i;
    }

    private void setGenre(String str) {
        str.getClass();
        this.genre_ = str;
    }

    private void setGenreBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.genre_ = abstractC2383g.f0();
    }

    private void setTrack(String str) {
        str.getClass();
        this.track_ = str;
    }

    private void setTrackBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.track_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DocumentExAudio();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006ဉ\u0000", new Object[]{"bitField0_", "duration_", "album_", "artist_", "genre_", "track_", "cover_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DocumentExAudio.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String getAlbum() {
        return this.album_;
    }

    public AbstractC2383g getAlbumBytes() {
        return AbstractC2383g.N(this.album_);
    }

    public String getArtist() {
        return this.artist_;
    }

    public AbstractC2383g getArtistBytes() {
        return AbstractC2383g.N(this.artist_);
    }

    public BytesValue getCover() {
        BytesValue bytesValue = this.cover_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public int getDuration() {
        return this.duration_;
    }

    public String getGenre() {
        return this.genre_;
    }

    public AbstractC2383g getGenreBytes() {
        return AbstractC2383g.N(this.genre_);
    }

    public String getTrack() {
        return this.track_;
    }

    public AbstractC2383g getTrackBytes() {
        return AbstractC2383g.N(this.track_);
    }

    public boolean hasCover() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingStruct$DocumentExAudio messagingStruct$DocumentExAudio) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DocumentExAudio);
    }

    public static MessagingStruct$DocumentExAudio parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(byte[] bArr) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DocumentExAudio parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DocumentExAudio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
