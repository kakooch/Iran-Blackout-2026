package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9366Zp7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class TimcheOuterClass$ResponseGetHomePage extends GeneratedMessageLite implements U64 {
    private static final TimcheOuterClass$ResponseGetHomePage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SECTIONS_FIELD_NUMBER = 1;
    private B.j sections_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$ResponseGetHomePage.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$ResponseGetHomePage timcheOuterClass$ResponseGetHomePage = new TimcheOuterClass$ResponseGetHomePage();
        DEFAULT_INSTANCE = timcheOuterClass$ResponseGetHomePage;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$ResponseGetHomePage.class, timcheOuterClass$ResponseGetHomePage);
    }

    private TimcheOuterClass$ResponseGetHomePage() {
    }

    private void addAllSections(Iterable<? extends TimcheStruct$SectionWithBots> iterable) {
        ensureSectionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.sections_);
    }

    private void addSections(TimcheStruct$SectionWithBots timcheStruct$SectionWithBots) {
        timcheStruct$SectionWithBots.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(timcheStruct$SectionWithBots);
    }

    private void clearSections() {
        this.sections_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSectionsIsMutable() {
        B.j jVar = this.sections_;
        if (jVar.u()) {
            return;
        }
        this.sections_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static TimcheOuterClass$ResponseGetHomePage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$ResponseGetHomePage parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSections(int i) {
        ensureSectionsIsMutable();
        this.sections_.remove(i);
    }

    private void setSections(int i, TimcheStruct$SectionWithBots timcheStruct$SectionWithBots) {
        timcheStruct$SectionWithBots.getClass();
        ensureSectionsIsMutable();
        this.sections_.set(i, timcheStruct$SectionWithBots);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$ResponseGetHomePage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"sections_", TimcheStruct$SectionWithBots.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$ResponseGetHomePage.class) {
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

    public TimcheStruct$SectionWithBots getSections(int i) {
        return (TimcheStruct$SectionWithBots) this.sections_.get(i);
    }

    public int getSectionsCount() {
        return this.sections_.size();
    }

    public List<TimcheStruct$SectionWithBots> getSectionsList() {
        return this.sections_;
    }

    public InterfaceC9366Zp7 getSectionsOrBuilder(int i) {
        return (InterfaceC9366Zp7) this.sections_.get(i);
    }

    public List<? extends InterfaceC9366Zp7> getSectionsOrBuilderList() {
        return this.sections_;
    }

    public static a newBuilder(TimcheOuterClass$ResponseGetHomePage timcheOuterClass$ResponseGetHomePage) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$ResponseGetHomePage);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSections(int i, TimcheStruct$SectionWithBots timcheStruct$SectionWithBots) {
        timcheStruct$SectionWithBots.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(i, timcheStruct$SectionWithBots);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(byte[] bArr) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$ResponseGetHomePage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$ResponseGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
