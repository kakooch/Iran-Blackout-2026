package ai.bale.proto;

import ai.bale.proto.TuringStruct$DownloadSource;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Turing$ResponseGetTranscript extends GeneratedMessageLite implements U64 {
    private static final Turing$ResponseGetTranscript DEFAULT_INSTANCE;
    public static final int DOWNLOAD_SOURCE_FIELD_NUMBER = 2;
    public static final int MUST_WAIT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Turing$ResponseGetTranscript.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        MUST_WAIT(1),
        DOWNLOAD_SOURCE(2),
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
                return MUST_WAIT;
            }
            if (i != 2) {
                return null;
            }
            return DOWNLOAD_SOURCE;
        }
    }

    static {
        Turing$ResponseGetTranscript turing$ResponseGetTranscript = new Turing$ResponseGetTranscript();
        DEFAULT_INSTANCE = turing$ResponseGetTranscript;
        GeneratedMessageLite.registerDefaultInstance(Turing$ResponseGetTranscript.class, turing$ResponseGetTranscript);
    }

    private Turing$ResponseGetTranscript() {
    }

    private void clearDownloadSource() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMustWait() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static Turing$ResponseGetTranscript getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDownloadSource(TuringStruct$DownloadSource turingStruct$DownloadSource) {
        turingStruct$DownloadSource.getClass();
        if (this.traitCase_ != 2 || this.trait_ == TuringStruct$DownloadSource.getDefaultInstance()) {
            this.trait_ = turingStruct$DownloadSource;
        } else {
            this.trait_ = ((TuringStruct$DownloadSource.a) TuringStruct$DownloadSource.newBuilder((TuringStruct$DownloadSource) this.trait_).v(turingStruct$DownloadSource)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Turing$ResponseGetTranscript parseDelimitedFrom(InputStream inputStream) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$ResponseGetTranscript parseFrom(ByteBuffer byteBuffer) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDownloadSource(TuringStruct$DownloadSource turingStruct$DownloadSource) {
        turingStruct$DownloadSource.getClass();
        this.trait_ = turingStruct$DownloadSource;
        this.traitCase_ = 2;
    }

    private void setMustWait(boolean z) {
        this.traitCase_ = 1;
        this.trait_ = Boolean.valueOf(z);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (m2.a[gVar.ordinal()]) {
            case 1:
                return new Turing$ResponseGetTranscript();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", TuringStruct$DownloadSource.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Turing$ResponseGetTranscript.class) {
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

    public TuringStruct$DownloadSource getDownloadSource() {
        return this.traitCase_ == 2 ? (TuringStruct$DownloadSource) this.trait_ : TuringStruct$DownloadSource.getDefaultInstance();
    }

    public boolean getMustWait() {
        if (this.traitCase_ == 1) {
            return ((Boolean) this.trait_).booleanValue();
        }
        return false;
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasDownloadSource() {
        return this.traitCase_ == 2;
    }

    public boolean hasMustWait() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(Turing$ResponseGetTranscript turing$ResponseGetTranscript) {
        return (a) DEFAULT_INSTANCE.createBuilder(turing$ResponseGetTranscript);
    }

    public static Turing$ResponseGetTranscript parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$ResponseGetTranscript parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Turing$ResponseGetTranscript parseFrom(AbstractC2383g abstractC2383g) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Turing$ResponseGetTranscript parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Turing$ResponseGetTranscript parseFrom(byte[] bArr) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Turing$ResponseGetTranscript parseFrom(byte[] bArr, C2394s c2394s) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Turing$ResponseGetTranscript parseFrom(InputStream inputStream) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Turing$ResponseGetTranscript parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Turing$ResponseGetTranscript parseFrom(AbstractC2384h abstractC2384h) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Turing$ResponseGetTranscript parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Turing$ResponseGetTranscript) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
