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

/* loaded from: classes.dex */
public final class SefteOuterClass$ResponseUserHasCred extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseUserHasCred DEFAULT_INSTANCE;
    public static final int HAS_CRED_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private boolean hasCred_;
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseUserHasCred.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseUserHasCred sefteOuterClass$ResponseUserHasCred = new SefteOuterClass$ResponseUserHasCred();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseUserHasCred;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseUserHasCred.class, sefteOuterClass$ResponseUserHasCred);
    }

    private SefteOuterClass$ResponseUserHasCred() {
    }

    private void clearHasCred() {
        this.hasCred_ = false;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static SefteOuterClass$ResponseUserHasCred getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseUserHasCred parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHasCred(boolean z) {
        this.hasCred_ = z;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseUserHasCred();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"hasCred_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseUserHasCred.class) {
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

    public boolean getHasCred() {
        return this.hasCred_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public static a newBuilder(SefteOuterClass$ResponseUserHasCred sefteOuterClass$ResponseUserHasCred) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseUserHasCred);
    }

    public static SefteOuterClass$ResponseUserHasCred parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseUserHasCred parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseUserHasCred) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
