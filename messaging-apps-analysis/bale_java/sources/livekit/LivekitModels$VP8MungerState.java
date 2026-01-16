package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$VP8MungerState extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$VP8MungerState DEFAULT_INSTANCE;
    public static final int EXT_LAST_PICTURE_ID_FIELD_NUMBER = 1;
    public static final int KEY_IDX_USED_FIELD_NUMBER = 7;
    public static final int LAST_KEY_IDX_FIELD_NUMBER = 6;
    public static final int LAST_TL0_PIC_IDX_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PICTURE_ID_USED_FIELD_NUMBER = 2;
    public static final int TID_USED_FIELD_NUMBER = 5;
    public static final int TL0_PIC_IDX_USED_FIELD_NUMBER = 4;
    private int extLastPictureId_;
    private boolean keyIdxUsed_;
    private int lastKeyIdx_;
    private int lastTl0PicIdx_;
    private boolean pictureIdUsed_;
    private boolean tidUsed_;
    private boolean tl0PicIdxUsed_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$VP8MungerState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$VP8MungerState livekitModels$VP8MungerState = new LivekitModels$VP8MungerState();
        DEFAULT_INSTANCE = livekitModels$VP8MungerState;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$VP8MungerState.class, livekitModels$VP8MungerState);
    }

    private LivekitModels$VP8MungerState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtLastPictureId() {
        this.extLastPictureId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyIdxUsed() {
        this.keyIdxUsed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastKeyIdx() {
        this.lastKeyIdx_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastTl0PicIdx() {
        this.lastTl0PicIdx_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPictureIdUsed() {
        this.pictureIdUsed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTidUsed() {
        this.tidUsed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTl0PicIdxUsed() {
        this.tl0PicIdxUsed_ = false;
    }

    public static LivekitModels$VP8MungerState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$VP8MungerState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$VP8MungerState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtLastPictureId(int i) {
        this.extLastPictureId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyIdxUsed(boolean z) {
        this.keyIdxUsed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastKeyIdx(int i) {
        this.lastKeyIdx_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastTl0PicIdx(int i) {
        this.lastTl0PicIdx_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPictureIdUsed(boolean z) {
        this.pictureIdUsed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTidUsed(boolean z) {
        this.tidUsed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTl0PicIdxUsed(boolean z) {
        this.tl0PicIdxUsed_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$VP8MungerState();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\u0007\u0003\u000b\u0004\u0007\u0005\u0007\u0006\u000b\u0007\u0007", new Object[]{"extLastPictureId_", "pictureIdUsed_", "lastTl0PicIdx_", "tl0PicIdxUsed_", "tidUsed_", "lastKeyIdx_", "keyIdxUsed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$VP8MungerState.class) {
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

    public int getExtLastPictureId() {
        return this.extLastPictureId_;
    }

    public boolean getKeyIdxUsed() {
        return this.keyIdxUsed_;
    }

    public int getLastKeyIdx() {
        return this.lastKeyIdx_;
    }

    public int getLastTl0PicIdx() {
        return this.lastTl0PicIdx_;
    }

    public boolean getPictureIdUsed() {
        return this.pictureIdUsed_;
    }

    public boolean getTidUsed() {
        return this.tidUsed_;
    }

    public boolean getTl0PicIdxUsed() {
        return this.tl0PicIdxUsed_;
    }

    public static a newBuilder(LivekitModels$VP8MungerState livekitModels$VP8MungerState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$VP8MungerState);
    }

    public static LivekitModels$VP8MungerState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$VP8MungerState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$VP8MungerState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$VP8MungerState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$VP8MungerState parseFrom(byte[] bArr) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$VP8MungerState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$VP8MungerState parseFrom(InputStream inputStream) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$VP8MungerState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$VP8MungerState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$VP8MungerState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$VP8MungerState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
