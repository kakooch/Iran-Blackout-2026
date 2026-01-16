package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8857Xp7;
import ir.nasim.InterfaceC9366Zp7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class TimcheStruct$SectionWithBots extends GeneratedMessageLite implements InterfaceC9366Zp7 {
    public static final int BOTS_FIELD_NUMBER = 3;
    private static final TimcheStruct$SectionWithBots DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SECTION_ID_FIELD_NUMBER = 1;
    public static final int SECTION_NAME_FIELD_NUMBER = 2;
    private int sectionId_;
    private String sectionName_ = "";
    private B.j bots_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9366Zp7 {
        private a() {
            super(TimcheStruct$SectionWithBots.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheStruct$SectionWithBots timcheStruct$SectionWithBots = new TimcheStruct$SectionWithBots();
        DEFAULT_INSTANCE = timcheStruct$SectionWithBots;
        GeneratedMessageLite.registerDefaultInstance(TimcheStruct$SectionWithBots.class, timcheStruct$SectionWithBots);
    }

    private TimcheStruct$SectionWithBots() {
    }

    private void addAllBots(Iterable<? extends TimcheStruct$BotPreview> iterable) {
        ensureBotsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bots_);
    }

    private void addBots(TimcheStruct$BotPreview timcheStruct$BotPreview) {
        timcheStruct$BotPreview.getClass();
        ensureBotsIsMutable();
        this.bots_.add(timcheStruct$BotPreview);
    }

    private void clearBots() {
        this.bots_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSectionId() {
        this.sectionId_ = 0;
    }

    private void clearSectionName() {
        this.sectionName_ = getDefaultInstance().getSectionName();
    }

    private void ensureBotsIsMutable() {
        B.j jVar = this.bots_;
        if (jVar.u()) {
            return;
        }
        this.bots_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static TimcheStruct$SectionWithBots getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheStruct$SectionWithBots parseDelimitedFrom(InputStream inputStream) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheStruct$SectionWithBots parseFrom(ByteBuffer byteBuffer) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBots(int i) {
        ensureBotsIsMutable();
        this.bots_.remove(i);
    }

    private void setBots(int i, TimcheStruct$BotPreview timcheStruct$BotPreview) {
        timcheStruct$BotPreview.getClass();
        ensureBotsIsMutable();
        this.bots_.set(i, timcheStruct$BotPreview);
    }

    private void setSectionId(int i) {
        this.sectionId_ = i;
    }

    private void setSectionName(String str) {
        str.getClass();
        this.sectionName_ = str;
    }

    private void setSectionNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sectionName_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (j2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheStruct$SectionWithBots();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u001b", new Object[]{"sectionId_", "sectionName_", "bots_", TimcheStruct$BotPreview.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheStruct$SectionWithBots.class) {
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

    public TimcheStruct$BotPreview getBots(int i) {
        return (TimcheStruct$BotPreview) this.bots_.get(i);
    }

    public int getBotsCount() {
        return this.bots_.size();
    }

    public List<TimcheStruct$BotPreview> getBotsList() {
        return this.bots_;
    }

    public InterfaceC8857Xp7 getBotsOrBuilder(int i) {
        return (InterfaceC8857Xp7) this.bots_.get(i);
    }

    public List<? extends InterfaceC8857Xp7> getBotsOrBuilderList() {
        return this.bots_;
    }

    public int getSectionId() {
        return this.sectionId_;
    }

    public String getSectionName() {
        return this.sectionName_;
    }

    public AbstractC2383g getSectionNameBytes() {
        return AbstractC2383g.N(this.sectionName_);
    }

    public static a newBuilder(TimcheStruct$SectionWithBots timcheStruct$SectionWithBots) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheStruct$SectionWithBots);
    }

    public static TimcheStruct$SectionWithBots parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheStruct$SectionWithBots parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheStruct$SectionWithBots parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBots(int i, TimcheStruct$BotPreview timcheStruct$BotPreview) {
        timcheStruct$BotPreview.getClass();
        ensureBotsIsMutable();
        this.bots_.add(i, timcheStruct$BotPreview);
    }

    public static TimcheStruct$SectionWithBots parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheStruct$SectionWithBots parseFrom(byte[] bArr) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheStruct$SectionWithBots parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheStruct$SectionWithBots parseFrom(InputStream inputStream) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheStruct$SectionWithBots parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheStruct$SectionWithBots parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheStruct$SectionWithBots parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheStruct$SectionWithBots) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
