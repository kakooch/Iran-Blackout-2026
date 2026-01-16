package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeOuterClass$RequestSetNewsReaction extends GeneratedMessageLite implements U64 {
    private static final DakeOuterClass$RequestSetNewsReaction DEFAULT_INSTANCE;
    public static final int FEED_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String feedId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$RequestSetNewsReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$RequestSetNewsReaction dakeOuterClass$RequestSetNewsReaction = new DakeOuterClass$RequestSetNewsReaction();
        DEFAULT_INSTANCE = dakeOuterClass$RequestSetNewsReaction;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$RequestSetNewsReaction.class, dakeOuterClass$RequestSetNewsReaction);
    }

    private DakeOuterClass$RequestSetNewsReaction() {
    }

    private void clearFeedId() {
        this.feedId_ = getDefaultInstance().getFeedId();
    }

    public static DakeOuterClass$RequestSetNewsReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeOuterClass$RequestSetNewsReaction parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFeedId(String str) {
        str.getClass();
        this.feedId_ = str;
    }

    private void setFeedIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.feedId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M.a[gVar.ordinal()]) {
            case 1:
                return new DakeOuterClass$RequestSetNewsReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"feedId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$RequestSetNewsReaction.class) {
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

    public String getFeedId() {
        return this.feedId_;
    }

    public AbstractC2383g getFeedIdBytes() {
        return AbstractC2383g.N(this.feedId_);
    }

    public static a newBuilder(DakeOuterClass$RequestSetNewsReaction dakeOuterClass$RequestSetNewsReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$RequestSetNewsReaction);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(byte[] bArr) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$RequestSetNewsReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$RequestSetNewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
