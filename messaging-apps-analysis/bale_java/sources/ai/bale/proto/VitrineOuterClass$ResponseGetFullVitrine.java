package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class VitrineOuterClass$ResponseGetFullVitrine extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$ResponseGetFullVitrine DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SECTIONS_FIELD_NUMBER = 1;
    private B.j sections_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$ResponseGetFullVitrine.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$ResponseGetFullVitrine vitrineOuterClass$ResponseGetFullVitrine = new VitrineOuterClass$ResponseGetFullVitrine();
        DEFAULT_INSTANCE = vitrineOuterClass$ResponseGetFullVitrine;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$ResponseGetFullVitrine.class, vitrineOuterClass$ResponseGetFullVitrine);
    }

    private VitrineOuterClass$ResponseGetFullVitrine() {
    }

    private void addAllSections(Iterable<? extends VitrineOuterClass$VitrineSection> iterable) {
        ensureSectionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.sections_);
    }

    private void addSections(VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection) {
        vitrineOuterClass$VitrineSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(vitrineOuterClass$VitrineSection);
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

    public static VitrineOuterClass$ResponseGetFullVitrine getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSections(int i) {
        ensureSectionsIsMutable();
        this.sections_.remove(i);
    }

    private void setSections(int i, VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection) {
        vitrineOuterClass$VitrineSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.set(i, vitrineOuterClass$VitrineSection);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$ResponseGetFullVitrine();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"sections_", VitrineOuterClass$VitrineSection.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$ResponseGetFullVitrine.class) {
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

    public VitrineOuterClass$VitrineSection getSections(int i) {
        return (VitrineOuterClass$VitrineSection) this.sections_.get(i);
    }

    public int getSectionsCount() {
        return this.sections_.size();
    }

    public List<VitrineOuterClass$VitrineSection> getSectionsList() {
        return this.sections_;
    }

    public s2 getSectionsOrBuilder(int i) {
        return (s2) this.sections_.get(i);
    }

    public List<? extends s2> getSectionsOrBuilderList() {
        return this.sections_;
    }

    public static a newBuilder(VitrineOuterClass$ResponseGetFullVitrine vitrineOuterClass$ResponseGetFullVitrine) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$ResponseGetFullVitrine);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSections(int i, VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection) {
        vitrineOuterClass$VitrineSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(i, vitrineOuterClass$VitrineSection);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(byte[] bArr) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$ResponseGetFullVitrine parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetFullVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
