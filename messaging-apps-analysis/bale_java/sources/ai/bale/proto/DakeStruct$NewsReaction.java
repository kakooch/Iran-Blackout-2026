package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4643Fy1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeStruct$NewsReaction extends GeneratedMessageLite implements InterfaceC4643Fy1 {
    private static final DakeStruct$NewsReaction DEFAULT_INSTANCE;
    public static final int HAS_LIKED_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean hasLiked_;
    private String id_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4643Fy1 {
        private a() {
            super(DakeStruct$NewsReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeStruct$NewsReaction dakeStruct$NewsReaction = new DakeStruct$NewsReaction();
        DEFAULT_INSTANCE = dakeStruct$NewsReaction;
        GeneratedMessageLite.registerDefaultInstance(DakeStruct$NewsReaction.class, dakeStruct$NewsReaction);
    }

    private DakeStruct$NewsReaction() {
    }

    private void clearHasLiked() {
        this.hasLiked_ = false;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    public static DakeStruct$NewsReaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeStruct$NewsReaction parseDelimitedFrom(InputStream inputStream) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeStruct$NewsReaction parseFrom(ByteBuffer byteBuffer) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHasLiked(boolean z) {
        this.hasLiked_ = z;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N.a[gVar.ordinal()]) {
            case 1:
                return new DakeStruct$NewsReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"id_", "hasLiked_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeStruct$NewsReaction.class) {
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

    public boolean getHasLiked() {
        return this.hasLiked_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public static a newBuilder(DakeStruct$NewsReaction dakeStruct$NewsReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeStruct$NewsReaction);
    }

    public static DakeStruct$NewsReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeStruct$NewsReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeStruct$NewsReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeStruct$NewsReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeStruct$NewsReaction parseFrom(byte[] bArr) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeStruct$NewsReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeStruct$NewsReaction parseFrom(InputStream inputStream) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeStruct$NewsReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeStruct$NewsReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeStruct$NewsReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeStruct$NewsReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
