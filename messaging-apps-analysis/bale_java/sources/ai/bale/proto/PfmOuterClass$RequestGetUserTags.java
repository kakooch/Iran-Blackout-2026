package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.F75;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PfmOuterClass$RequestGetUserTags extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestGetUserTags DEFAULT_INSTANCE;
    public static final int GET_USER_TAG_TYPE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int getUserTagType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(F75 f75) {
            q();
            ((PfmOuterClass$RequestGetUserTags) this.b).setGetUserTagType(f75);
            return this;
        }

        private a() {
            super(PfmOuterClass$RequestGetUserTags.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestGetUserTags pfmOuterClass$RequestGetUserTags = new PfmOuterClass$RequestGetUserTags();
        DEFAULT_INSTANCE = pfmOuterClass$RequestGetUserTags;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestGetUserTags.class, pfmOuterClass$RequestGetUserTags);
    }

    private PfmOuterClass$RequestGetUserTags() {
    }

    private void clearGetUserTagType() {
        this.getUserTagType_ = 0;
    }

    public static PfmOuterClass$RequestGetUserTags getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestGetUserTags parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGetUserTagType(F75 f75) {
        this.getUserTagType_ = f75.getNumber();
    }

    private void setGetUserTagTypeValue(int i) {
        this.getUserTagType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestGetUserTags();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"getUserTagType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestGetUserTags.class) {
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

    public F75 getGetUserTagType() {
        F75 f75J = F75.j(this.getUserTagType_);
        return f75J == null ? F75.UNRECOGNIZED : f75J;
    }

    public int getGetUserTagTypeValue() {
        return this.getUserTagType_;
    }

    public static a newBuilder(PfmOuterClass$RequestGetUserTags pfmOuterClass$RequestGetUserTags) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestGetUserTags);
    }

    public static PfmOuterClass$RequestGetUserTags parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestGetUserTags parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserTags) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
