package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC11000cZ6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class ReportStruct$StoryReport extends GeneratedMessageLite implements U64 {
    private static final ReportStruct$StoryReport DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STORY_ID_FIELD_NUMBER = 1;
    private B.j storyId_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((ReportStruct$StoryReport) this.b).addStoryId(stringValue);
            return this;
        }

        private a() {
            super(ReportStruct$StoryReport.DEFAULT_INSTANCE);
        }
    }

    static {
        ReportStruct$StoryReport reportStruct$StoryReport = new ReportStruct$StoryReport();
        DEFAULT_INSTANCE = reportStruct$StoryReport;
        GeneratedMessageLite.registerDefaultInstance(ReportStruct$StoryReport.class, reportStruct$StoryReport);
    }

    private ReportStruct$StoryReport() {
    }

    private void addAllStoryId(Iterable<? extends StringValue> iterable) {
        ensureStoryIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.storyId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStoryId(StringValue stringValue) {
        stringValue.getClass();
        ensureStoryIdIsMutable();
        this.storyId_.add(stringValue);
    }

    private void clearStoryId() {
        this.storyId_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureStoryIdIsMutable() {
        B.j jVar = this.storyId_;
        if (jVar.u()) {
            return;
        }
        this.storyId_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ReportStruct$StoryReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReportStruct$StoryReport parseDelimitedFrom(InputStream inputStream) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$StoryReport parseFrom(ByteBuffer byteBuffer) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeStoryId(int i) {
        ensureStoryIdIsMutable();
        this.storyId_.remove(i);
    }

    private void setStoryId(int i, StringValue stringValue) {
        stringValue.getClass();
        ensureStoryIdIsMutable();
        this.storyId_.set(i, stringValue);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1913z1.a[gVar.ordinal()]) {
            case 1:
                return new ReportStruct$StoryReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"storyId_", StringValue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReportStruct$StoryReport.class) {
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

    public StringValue getStoryId(int i) {
        return (StringValue) this.storyId_.get(i);
    }

    public int getStoryIdCount() {
        return this.storyId_.size();
    }

    public List<StringValue> getStoryIdList() {
        return this.storyId_;
    }

    public InterfaceC11000cZ6 getStoryIdOrBuilder(int i) {
        return (InterfaceC11000cZ6) this.storyId_.get(i);
    }

    public List<? extends InterfaceC11000cZ6> getStoryIdOrBuilderList() {
        return this.storyId_;
    }

    public static a newBuilder(ReportStruct$StoryReport reportStruct$StoryReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(reportStruct$StoryReport);
    }

    public static ReportStruct$StoryReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$StoryReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReportStruct$StoryReport parseFrom(AbstractC2383g abstractC2383g) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addStoryId(int i, StringValue stringValue) {
        stringValue.getClass();
        ensureStoryIdIsMutable();
        this.storyId_.add(i, stringValue);
    }

    public static ReportStruct$StoryReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReportStruct$StoryReport parseFrom(byte[] bArr) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReportStruct$StoryReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReportStruct$StoryReport parseFrom(InputStream inputStream) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$StoryReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$StoryReport parseFrom(AbstractC2384h abstractC2384h) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReportStruct$StoryReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReportStruct$StoryReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
