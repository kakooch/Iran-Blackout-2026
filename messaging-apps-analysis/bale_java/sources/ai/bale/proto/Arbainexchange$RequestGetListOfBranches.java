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
public final class Arbainexchange$RequestGetListOfBranches extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$RequestGetListOfBranches DEFAULT_INSTANCE;
    public static final int EXIT_DATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STATE_ID_FIELD_NUMBER = 1;
    private String stateId_ = "";
    private String exitDate_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestGetListOfBranches.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestGetListOfBranches arbainexchange$RequestGetListOfBranches = new Arbainexchange$RequestGetListOfBranches();
        DEFAULT_INSTANCE = arbainexchange$RequestGetListOfBranches;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestGetListOfBranches.class, arbainexchange$RequestGetListOfBranches);
    }

    private Arbainexchange$RequestGetListOfBranches() {
    }

    private void clearExitDate() {
        this.exitDate_ = getDefaultInstance().getExitDate();
    }

    private void clearStateId() {
        this.stateId_ = getDefaultInstance().getStateId();
    }

    public static Arbainexchange$RequestGetListOfBranches getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestGetListOfBranches parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExitDate(String str) {
        str.getClass();
        this.exitDate_ = str;
    }

    private void setExitDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.exitDate_ = abstractC2383g.f0();
    }

    private void setStateId(String str) {
        str.getClass();
        this.stateId_ = str;
    }

    private void setStateIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stateId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestGetListOfBranches();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"stateId_", "exitDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestGetListOfBranches.class) {
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

    public String getExitDate() {
        return this.exitDate_;
    }

    public AbstractC2383g getExitDateBytes() {
        return AbstractC2383g.N(this.exitDate_);
    }

    public String getStateId() {
        return this.stateId_;
    }

    public AbstractC2383g getStateIdBytes() {
        return AbstractC2383g.N(this.stateId_);
    }

    public static a newBuilder(Arbainexchange$RequestGetListOfBranches arbainexchange$RequestGetListOfBranches) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestGetListOfBranches);
    }

    public static Arbainexchange$RequestGetListOfBranches parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestGetListOfBranches parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestGetListOfBranches) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
