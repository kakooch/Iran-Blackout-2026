package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10817cF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$TranscriptionSegment extends GeneratedMessageLite implements InterfaceC10817cF3 {
    private static final LivekitModels$TranscriptionSegment DEFAULT_INSTANCE;
    public static final int END_TIME_FIELD_NUMBER = 4;
    public static final int FINAL_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LANGUAGE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 2;
    private long endTime_;
    private boolean final_;
    private long startTime_;
    private String id_ = "";
    private String text_ = "";
    private String language_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC10817cF3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$TranscriptionSegment.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment = new LivekitModels$TranscriptionSegment();
        DEFAULT_INSTANCE = livekitModels$TranscriptionSegment;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$TranscriptionSegment.class, livekitModels$TranscriptionSegment);
    }

    private LivekitModels$TranscriptionSegment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndTime() {
        this.endTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFinal() {
        this.final_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLanguage() {
        this.language_ = getDefaultInstance().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartTime() {
        this.startTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearText() {
        this.text_ = getDefaultInstance().getText();
    }

    public static LivekitModels$TranscriptionSegment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$TranscriptionSegment parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndTime(long j) {
        this.endTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinal(boolean z) {
        this.final_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguage(String str) {
        str.getClass();
        this.language_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.language_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTime(long j) {
        this.startTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText(String str) {
        str.getClass();
        this.text_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.text_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$TranscriptionSegment();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0003\u0004\u0003\u0005\u0007\u0006Ȉ", new Object[]{"id_", "text_", "startTime_", "endTime_", "final_", "language_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$TranscriptionSegment.class) {
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

    public long getEndTime() {
        return this.endTime_;
    }

    public boolean getFinal() {
        return this.final_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getLanguage() {
        return this.language_;
    }

    public AbstractC2383g getLanguageBytes() {
        return AbstractC2383g.N(this.language_);
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public String getText() {
        return this.text_;
    }

    public AbstractC2383g getTextBytes() {
        return AbstractC2383g.N(this.text_);
    }

    public static a newBuilder(LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$TranscriptionSegment);
    }

    public static LivekitModels$TranscriptionSegment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(byte[] bArr) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(InputStream inputStream) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$TranscriptionSegment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$TranscriptionSegment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
