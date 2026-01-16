package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4307Eo4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MyBankStruct$NewMyBankPage extends GeneratedMessageLite implements U64 {
    private static final MyBankStruct$NewMyBankPage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SECTIONS_FIELD_NUMBER = 1;
    private B.j sections_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MyBankStruct$NewMyBankPage.DEFAULT_INSTANCE);
        }
    }

    static {
        MyBankStruct$NewMyBankPage myBankStruct$NewMyBankPage = new MyBankStruct$NewMyBankPage();
        DEFAULT_INSTANCE = myBankStruct$NewMyBankPage;
        GeneratedMessageLite.registerDefaultInstance(MyBankStruct$NewMyBankPage.class, myBankStruct$NewMyBankPage);
    }

    private MyBankStruct$NewMyBankPage() {
    }

    private void addAllSections(Iterable<? extends MyBankStruct$NewMyBankSection> iterable) {
        ensureSectionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.sections_);
    }

    private void addSections(MyBankStruct$NewMyBankSection myBankStruct$NewMyBankSection) {
        myBankStruct$NewMyBankSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(myBankStruct$NewMyBankSection);
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

    public static MyBankStruct$NewMyBankPage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MyBankStruct$NewMyBankPage parseDelimitedFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(ByteBuffer byteBuffer) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSections(int i) {
        ensureSectionsIsMutable();
        this.sections_.remove(i);
    }

    private void setSections(int i, MyBankStruct$NewMyBankSection myBankStruct$NewMyBankSection) {
        myBankStruct$NewMyBankSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.set(i, myBankStruct$NewMyBankSection);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (R0.a[gVar.ordinal()]) {
            case 1:
                return new MyBankStruct$NewMyBankPage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"sections_", MyBankStruct$NewMyBankSection.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MyBankStruct$NewMyBankPage.class) {
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

    public MyBankStruct$NewMyBankSection getSections(int i) {
        return (MyBankStruct$NewMyBankSection) this.sections_.get(i);
    }

    public int getSectionsCount() {
        return this.sections_.size();
    }

    public List<MyBankStruct$NewMyBankSection> getSectionsList() {
        return this.sections_;
    }

    public InterfaceC4307Eo4 getSectionsOrBuilder(int i) {
        return (InterfaceC4307Eo4) this.sections_.get(i);
    }

    public List<? extends InterfaceC4307Eo4> getSectionsOrBuilderList() {
        return this.sections_;
    }

    public static a newBuilder(MyBankStruct$NewMyBankPage myBankStruct$NewMyBankPage) {
        return (a) DEFAULT_INSTANCE.createBuilder(myBankStruct$NewMyBankPage);
    }

    public static MyBankStruct$NewMyBankPage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(AbstractC2383g abstractC2383g) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSections(int i, MyBankStruct$NewMyBankSection myBankStruct$NewMyBankSection) {
        myBankStruct$NewMyBankSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(i, myBankStruct$NewMyBankSection);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(byte[] bArr) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(AbstractC2384h abstractC2384h) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MyBankStruct$NewMyBankPage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MyBankStruct$NewMyBankPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
