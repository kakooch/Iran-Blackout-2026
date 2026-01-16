package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TimcheOuterClass$ResponseSubmitReview extends GeneratedMessageLite implements U64 {
    private static final TimcheOuterClass$ResponseSubmitReview DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SHOULD_ASK_BALE_REVIEW_FIELD_NUMBER = 1;
    private boolean shouldAskBaleReview_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$ResponseSubmitReview.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$ResponseSubmitReview timcheOuterClass$ResponseSubmitReview = new TimcheOuterClass$ResponseSubmitReview();
        DEFAULT_INSTANCE = timcheOuterClass$ResponseSubmitReview;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$ResponseSubmitReview.class, timcheOuterClass$ResponseSubmitReview);
    }

    private TimcheOuterClass$ResponseSubmitReview() {
    }

    private void clearShouldAskBaleReview() {
        this.shouldAskBaleReview_ = false;
    }

    public static TimcheOuterClass$ResponseSubmitReview getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$ResponseSubmitReview parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setShouldAskBaleReview(boolean z) {
        this.shouldAskBaleReview_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$ResponseSubmitReview();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"shouldAskBaleReview_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$ResponseSubmitReview.class) {
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

    public boolean getShouldAskBaleReview() {
        return this.shouldAskBaleReview_;
    }

    public static a newBuilder(TimcheOuterClass$ResponseSubmitReview timcheOuterClass$ResponseSubmitReview) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$ResponseSubmitReview);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(byte[] bArr) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$ResponseSubmitReview parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$ResponseSubmitReview) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
