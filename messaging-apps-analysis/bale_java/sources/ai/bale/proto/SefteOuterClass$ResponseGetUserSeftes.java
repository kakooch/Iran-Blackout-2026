package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21568tl6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SefteOuterClass$ResponseGetUserSeftes extends GeneratedMessageLite implements U64 {
    private static final SefteOuterClass$ResponseGetUserSeftes DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEFTES_FIELD_NUMBER = 1;
    private B.j seftes_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$ResponseGetUserSeftes.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$ResponseGetUserSeftes sefteOuterClass$ResponseGetUserSeftes = new SefteOuterClass$ResponseGetUserSeftes();
        DEFAULT_INSTANCE = sefteOuterClass$ResponseGetUserSeftes;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$ResponseGetUserSeftes.class, sefteOuterClass$ResponseGetUserSeftes);
    }

    private SefteOuterClass$ResponseGetUserSeftes() {
    }

    private void addAllSeftes(Iterable<? extends SefteStruct$SefteInfo> iterable) {
        ensureSeftesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.seftes_);
    }

    private void addSeftes(SefteStruct$SefteInfo sefteStruct$SefteInfo) {
        sefteStruct$SefteInfo.getClass();
        ensureSeftesIsMutable();
        this.seftes_.add(sefteStruct$SefteInfo);
    }

    private void clearSeftes() {
        this.seftes_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSeftesIsMutable() {
        B.j jVar = this.seftes_;
        if (jVar.u()) {
            return;
        }
        this.seftes_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SefteOuterClass$ResponseGetUserSeftes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSeftes(int i) {
        ensureSeftesIsMutable();
        this.seftes_.remove(i);
    }

    private void setSeftes(int i, SefteStruct$SefteInfo sefteStruct$SefteInfo) {
        sefteStruct$SefteInfo.getClass();
        ensureSeftesIsMutable();
        this.seftes_.set(i, sefteStruct$SefteInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$ResponseGetUserSeftes();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"seftes_", SefteStruct$SefteInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$ResponseGetUserSeftes.class) {
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

    public SefteStruct$SefteInfo getSeftes(int i) {
        return (SefteStruct$SefteInfo) this.seftes_.get(i);
    }

    public int getSeftesCount() {
        return this.seftes_.size();
    }

    public List<SefteStruct$SefteInfo> getSeftesList() {
        return this.seftes_;
    }

    public InterfaceC21568tl6 getSeftesOrBuilder(int i) {
        return (InterfaceC21568tl6) this.seftes_.get(i);
    }

    public List<? extends InterfaceC21568tl6> getSeftesOrBuilderList() {
        return this.seftes_;
    }

    public static a newBuilder(SefteOuterClass$ResponseGetUserSeftes sefteOuterClass$ResponseGetUserSeftes) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$ResponseGetUserSeftes);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSeftes(int i, SefteStruct$SefteInfo sefteStruct$SefteInfo) {
        sefteStruct$SefteInfo.getClass();
        ensureSeftesIsMutable();
        this.seftes_.add(i, sefteStruct$SefteInfo);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(byte[] bArr) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(InputStream inputStream) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$ResponseGetUserSeftes parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$ResponseGetUserSeftes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
