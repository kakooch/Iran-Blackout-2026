package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21859uF6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$ResponseGetBotSubjects extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$ResponseGetBotSubjects DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SUBJECTS_FIELD_NUMBER = 1;
    private B.j subjects_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseGetBotSubjects.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseGetBotSubjects smartSupportOuterClass$ResponseGetBotSubjects = new SmartSupportOuterClass$ResponseGetBotSubjects();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseGetBotSubjects;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseGetBotSubjects.class, smartSupportOuterClass$ResponseGetBotSubjects);
    }

    private SmartSupportOuterClass$ResponseGetBotSubjects() {
    }

    private void addAllSubjects(Iterable<? extends SmartSupportStruct$Subject> iterable) {
        ensureSubjectsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.subjects_);
    }

    private void addSubjects(SmartSupportStruct$Subject smartSupportStruct$Subject) {
        smartSupportStruct$Subject.getClass();
        ensureSubjectsIsMutable();
        this.subjects_.add(smartSupportStruct$Subject);
    }

    private void clearSubjects() {
        this.subjects_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureSubjectsIsMutable() {
        B.j jVar = this.subjects_;
        if (jVar.u()) {
            return;
        }
        this.subjects_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSubjects(int i) {
        ensureSubjectsIsMutable();
        this.subjects_.remove(i);
    }

    private void setSubjects(int i, SmartSupportStruct$Subject smartSupportStruct$Subject) {
        smartSupportStruct$Subject.getClass();
        ensureSubjectsIsMutable();
        this.subjects_.set(i, smartSupportStruct$Subject);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseGetBotSubjects();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"subjects_", SmartSupportStruct$Subject.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseGetBotSubjects.class) {
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

    public SmartSupportStruct$Subject getSubjects(int i) {
        return (SmartSupportStruct$Subject) this.subjects_.get(i);
    }

    public int getSubjectsCount() {
        return this.subjects_.size();
    }

    public List<SmartSupportStruct$Subject> getSubjectsList() {
        return this.subjects_;
    }

    public InterfaceC21859uF6 getSubjectsOrBuilder(int i) {
        return (InterfaceC21859uF6) this.subjects_.get(i);
    }

    public List<? extends InterfaceC21859uF6> getSubjectsOrBuilderList() {
        return this.subjects_;
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseGetBotSubjects smartSupportOuterClass$ResponseGetBotSubjects) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseGetBotSubjects);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSubjects(int i, SmartSupportStruct$Subject smartSupportStruct$Subject) {
        smartSupportStruct$Subject.getClass();
        ensureSubjectsIsMutable();
        this.subjects_.add(i, smartSupportStruct$Subject);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseGetBotSubjects parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
