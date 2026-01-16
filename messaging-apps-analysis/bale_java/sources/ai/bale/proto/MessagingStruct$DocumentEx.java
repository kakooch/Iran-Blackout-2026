package ai.bale.proto;

import ai.bale.proto.MessagingStruct$DocumentExAudio;
import ai.bale.proto.MessagingStruct$DocumentExGif;
import ai.bale.proto.MessagingStruct$DocumentExPhoto;
import ai.bale.proto.MessagingStruct$DocumentExVideo;
import ai.bale.proto.MessagingStruct$DocumentExVoice;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$DocumentEx extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$DocumentEx DEFAULT_INSTANCE;
    public static final int DOCUMENT_EX_AUDIO_FIELD_NUMBER = 5;
    public static final int DOCUMENT_EX_GIF_FIELD_NUMBER = 4;
    public static final int DOCUMENT_EX_PHOTO_FIELD_NUMBER = 1;
    public static final int DOCUMENT_EX_VIDEO_FIELD_NUMBER = 2;
    public static final int DOCUMENT_EX_VOICE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(MessagingStruct$DocumentExVoice messagingStruct$DocumentExVoice) {
            q();
            ((MessagingStruct$DocumentEx) this.b).setDocumentExVoice(messagingStruct$DocumentExVoice);
            return this;
        }

        private a() {
            super(MessagingStruct$DocumentEx.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        DOCUMENT_EX_PHOTO(1),
        DOCUMENT_EX_VIDEO(2),
        DOCUMENT_EX_VOICE(3),
        DOCUMENT_EX_AUDIO(5),
        DOCUMENT_EX_GIF(4),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return DOCUMENT_EX_PHOTO;
            }
            if (i == 2) {
                return DOCUMENT_EX_VIDEO;
            }
            if (i == 3) {
                return DOCUMENT_EX_VOICE;
            }
            if (i == 4) {
                return DOCUMENT_EX_GIF;
            }
            if (i != 5) {
                return null;
            }
            return DOCUMENT_EX_AUDIO;
        }
    }

    static {
        MessagingStruct$DocumentEx messagingStruct$DocumentEx = new MessagingStruct$DocumentEx();
        DEFAULT_INSTANCE = messagingStruct$DocumentEx;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$DocumentEx.class, messagingStruct$DocumentEx);
    }

    private MessagingStruct$DocumentEx() {
    }

    private void clearDocumentExAudio() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDocumentExGif() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDocumentExPhoto() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDocumentExVideo() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDocumentExVoice() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static MessagingStruct$DocumentEx getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDocumentExAudio(MessagingStruct$DocumentExAudio messagingStruct$DocumentExAudio) {
        messagingStruct$DocumentExAudio.getClass();
        if (this.traitCase_ != 5 || this.trait_ == MessagingStruct$DocumentExAudio.getDefaultInstance()) {
            this.trait_ = messagingStruct$DocumentExAudio;
        } else {
            this.trait_ = ((MessagingStruct$DocumentExAudio.a) MessagingStruct$DocumentExAudio.newBuilder((MessagingStruct$DocumentExAudio) this.trait_).v(messagingStruct$DocumentExAudio)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeDocumentExGif(MessagingStruct$DocumentExGif messagingStruct$DocumentExGif) {
        messagingStruct$DocumentExGif.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MessagingStruct$DocumentExGif.getDefaultInstance()) {
            this.trait_ = messagingStruct$DocumentExGif;
        } else {
            this.trait_ = ((MessagingStruct$DocumentExGif.a) MessagingStruct$DocumentExGif.newBuilder((MessagingStruct$DocumentExGif) this.trait_).v(messagingStruct$DocumentExGif)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeDocumentExPhoto(MessagingStruct$DocumentExPhoto messagingStruct$DocumentExPhoto) {
        messagingStruct$DocumentExPhoto.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingStruct$DocumentExPhoto.getDefaultInstance()) {
            this.trait_ = messagingStruct$DocumentExPhoto;
        } else {
            this.trait_ = ((MessagingStruct$DocumentExPhoto.a) MessagingStruct$DocumentExPhoto.newBuilder((MessagingStruct$DocumentExPhoto) this.trait_).v(messagingStruct$DocumentExPhoto)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeDocumentExVideo(MessagingStruct$DocumentExVideo messagingStruct$DocumentExVideo) {
        messagingStruct$DocumentExVideo.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MessagingStruct$DocumentExVideo.getDefaultInstance()) {
            this.trait_ = messagingStruct$DocumentExVideo;
        } else {
            this.trait_ = ((MessagingStruct$DocumentExVideo.a) MessagingStruct$DocumentExVideo.newBuilder((MessagingStruct$DocumentExVideo) this.trait_).v(messagingStruct$DocumentExVideo)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeDocumentExVoice(MessagingStruct$DocumentExVoice messagingStruct$DocumentExVoice) {
        messagingStruct$DocumentExVoice.getClass();
        if (this.traitCase_ != 3 || this.trait_ == MessagingStruct$DocumentExVoice.getDefaultInstance()) {
            this.trait_ = messagingStruct$DocumentExVoice;
        } else {
            this.trait_ = ((MessagingStruct$DocumentExVoice.a) MessagingStruct$DocumentExVoice.newBuilder((MessagingStruct$DocumentExVoice) this.trait_).v(messagingStruct$DocumentExVoice)).j();
        }
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$DocumentEx parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentEx parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDocumentExAudio(MessagingStruct$DocumentExAudio messagingStruct$DocumentExAudio) {
        messagingStruct$DocumentExAudio.getClass();
        this.trait_ = messagingStruct$DocumentExAudio;
        this.traitCase_ = 5;
    }

    private void setDocumentExGif(MessagingStruct$DocumentExGif messagingStruct$DocumentExGif) {
        messagingStruct$DocumentExGif.getClass();
        this.trait_ = messagingStruct$DocumentExGif;
        this.traitCase_ = 4;
    }

    private void setDocumentExPhoto(MessagingStruct$DocumentExPhoto messagingStruct$DocumentExPhoto) {
        messagingStruct$DocumentExPhoto.getClass();
        this.trait_ = messagingStruct$DocumentExPhoto;
        this.traitCase_ = 1;
    }

    private void setDocumentExVideo(MessagingStruct$DocumentExVideo messagingStruct$DocumentExVideo) {
        messagingStruct$DocumentExVideo.getClass();
        this.trait_ = messagingStruct$DocumentExVideo;
        this.traitCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentExVoice(MessagingStruct$DocumentExVoice messagingStruct$DocumentExVoice) {
        messagingStruct$DocumentExVoice.getClass();
        this.trait_ = messagingStruct$DocumentExVoice;
        this.traitCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$DocumentEx();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$DocumentExPhoto.class, MessagingStruct$DocumentExVideo.class, MessagingStruct$DocumentExVoice.class, MessagingStruct$DocumentExGif.class, MessagingStruct$DocumentExAudio.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$DocumentEx.class) {
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

    public MessagingStruct$DocumentExAudio getDocumentExAudio() {
        return this.traitCase_ == 5 ? (MessagingStruct$DocumentExAudio) this.trait_ : MessagingStruct$DocumentExAudio.getDefaultInstance();
    }

    public MessagingStruct$DocumentExGif getDocumentExGif() {
        return this.traitCase_ == 4 ? (MessagingStruct$DocumentExGif) this.trait_ : MessagingStruct$DocumentExGif.getDefaultInstance();
    }

    public MessagingStruct$DocumentExPhoto getDocumentExPhoto() {
        return this.traitCase_ == 1 ? (MessagingStruct$DocumentExPhoto) this.trait_ : MessagingStruct$DocumentExPhoto.getDefaultInstance();
    }

    public MessagingStruct$DocumentExVideo getDocumentExVideo() {
        return this.traitCase_ == 2 ? (MessagingStruct$DocumentExVideo) this.trait_ : MessagingStruct$DocumentExVideo.getDefaultInstance();
    }

    public MessagingStruct$DocumentExVoice getDocumentExVoice() {
        return this.traitCase_ == 3 ? (MessagingStruct$DocumentExVoice) this.trait_ : MessagingStruct$DocumentExVoice.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasDocumentExAudio() {
        return this.traitCase_ == 5;
    }

    public boolean hasDocumentExGif() {
        return this.traitCase_ == 4;
    }

    public boolean hasDocumentExPhoto() {
        return this.traitCase_ == 1;
    }

    public boolean hasDocumentExVideo() {
        return this.traitCase_ == 2;
    }

    public boolean hasDocumentExVoice() {
        return this.traitCase_ == 3;
    }

    public static a newBuilder(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$DocumentEx);
    }

    public static MessagingStruct$DocumentEx parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentEx parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$DocumentEx parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$DocumentEx parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$DocumentEx parseFrom(byte[] bArr) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$DocumentEx parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$DocumentEx parseFrom(InputStream inputStream) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$DocumentEx parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$DocumentEx parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$DocumentEx parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$DocumentEx) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
