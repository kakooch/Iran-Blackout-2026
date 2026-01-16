package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC22711vi;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestChangeBonusCodeState extends GeneratedMessageLite implements U64 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final Advertisementnew$RequestChangeBonusCodeState DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 2;
    private String code_ = "";
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestChangeBonusCodeState.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestChangeBonusCodeState advertisementnew$RequestChangeBonusCodeState = new Advertisementnew$RequestChangeBonusCodeState();
        DEFAULT_INSTANCE = advertisementnew$RequestChangeBonusCodeState;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestChangeBonusCodeState.class, advertisementnew$RequestChangeBonusCodeState);
    }

    private Advertisementnew$RequestChangeBonusCodeState() {
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static Advertisementnew$RequestChangeBonusCodeState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setState(EnumC22711vi enumC22711vi) {
        this.state_ = enumC22711vi.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestChangeBonusCodeState();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"code_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestChangeBonusCodeState.class) {
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

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public EnumC22711vi getState() {
        EnumC22711vi enumC22711viJ = EnumC22711vi.j(this.state_);
        return enumC22711viJ == null ? EnumC22711vi.UNRECOGNIZED : enumC22711viJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(Advertisementnew$RequestChangeBonusCodeState advertisementnew$RequestChangeBonusCodeState) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestChangeBonusCodeState);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestChangeBonusCodeState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestChangeBonusCodeState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
