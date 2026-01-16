package ai.bale.proto;

import ai.bale.proto.ReportStruct$MessageReport;
import ai.bale.proto.ReportStruct$PeerReport;
import ai.bale.proto.ReportStruct$StoryReport;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.MP5;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ReportStruct$InappropriateContentReport extends GeneratedMessageLite implements U64 {
    private static final ReportStruct$InappropriateContentReport DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int MESSAGE_REPORT_FIELD_NUMBER = 102;
    private static volatile KW4 PARSER = null;
    public static final int PEER_REPORT_FIELD_NUMBER = 101;
    public static final int STORY_REPORT_FIELD_NUMBER = 103;
    private int kind_;
    private Object trait_;
    private int traitCase_ = 0;
    private String description_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((ReportStruct$InappropriateContentReport) this.b).setDescription(str);
            return this;
        }

        public a B(MP5 mp5) {
            q();
            ((ReportStruct$InappropriateContentReport) this.b).setKind(mp5);
            return this;
        }

        public a C(ReportStruct$MessageReport reportStruct$MessageReport) {
            q();
            ((ReportStruct$InappropriateContentReport) this.b).setMessageReport(reportStruct$MessageReport);
            return this;
        }

        public a D(ReportStruct$PeerReport reportStruct$PeerReport) {
            q();
            ((ReportStruct$InappropriateContentReport) this.b).setPeerReport(reportStruct$PeerReport);
            return this;
        }

        public a E(ReportStruct$StoryReport reportStruct$StoryReport) {
            q();
            ((ReportStruct$InappropriateContentReport) this.b).setStoryReport(reportStruct$StoryReport);
            return this;
        }

        private a() {
            super(ReportStruct$InappropriateContentReport.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PEER_REPORT(101),
        MESSAGE_REPORT(102),
        STORY_REPORT(103),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            switch (i) {
                case 101:
                    return PEER_REPORT;
                case 102:
                    return MESSAGE_REPORT;
                case 103:
                    return STORY_REPORT;
                default:
                    return null;
            }
        }
    }

    static {
        ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport = new ReportStruct$InappropriateContentReport();
        DEFAULT_INSTANCE = reportStruct$InappropriateContentReport;
        GeneratedMessageLite.registerDefaultInstance(ReportStruct$InappropriateContentReport.class, reportStruct$InappropriateContentReport);
    }

    private ReportStruct$InappropriateContentReport() {
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearKind() {
        this.kind_ = 0;
    }

    private void clearMessageReport() {
        if (this.traitCase_ == 102) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeerReport() {
        if (this.traitCase_ == 101) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStoryReport() {
        if (this.traitCase_ == 103) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static ReportStruct$InappropriateContentReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessageReport(ReportStruct$MessageReport reportStruct$MessageReport) {
        reportStruct$MessageReport.getClass();
        if (this.traitCase_ != 102 || this.trait_ == ReportStruct$MessageReport.getDefaultInstance()) {
            this.trait_ = reportStruct$MessageReport;
        } else {
            this.trait_ = ((ReportStruct$MessageReport.a) ReportStruct$MessageReport.newBuilder((ReportStruct$MessageReport) this.trait_).v(reportStruct$MessageReport)).j();
        }
        this.traitCase_ = 102;
    }

    private void mergePeerReport(ReportStruct$PeerReport reportStruct$PeerReport) {
        reportStruct$PeerReport.getClass();
        if (this.traitCase_ != 101 || this.trait_ == ReportStruct$PeerReport.getDefaultInstance()) {
            this.trait_ = reportStruct$PeerReport;
        } else {
            this.trait_ = ((ReportStruct$PeerReport.a) ReportStruct$PeerReport.newBuilder((ReportStruct$PeerReport) this.trait_).v(reportStruct$PeerReport)).j();
        }
        this.traitCase_ = 101;
    }

    private void mergeStoryReport(ReportStruct$StoryReport reportStruct$StoryReport) {
        reportStruct$StoryReport.getClass();
        if (this.traitCase_ != 103 || this.trait_ == ReportStruct$StoryReport.getDefaultInstance()) {
            this.trait_ = reportStruct$StoryReport;
        } else {
            this.trait_ = ((ReportStruct$StoryReport.a) ReportStruct$StoryReport.newBuilder((ReportStruct$StoryReport) this.trait_).v(reportStruct$StoryReport)).j();
        }
        this.traitCase_ = 103;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReportStruct$InappropriateContentReport parseDelimitedFrom(InputStream inputStream) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(ByteBuffer byteBuffer) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(MP5 mp5) {
        this.kind_ = mp5.getNumber();
    }

    private void setKindValue(int i) {
        this.kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageReport(ReportStruct$MessageReport reportStruct$MessageReport) {
        reportStruct$MessageReport.getClass();
        this.trait_ = reportStruct$MessageReport;
        this.traitCase_ = 102;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeerReport(ReportStruct$PeerReport reportStruct$PeerReport) {
        reportStruct$PeerReport.getClass();
        this.trait_ = reportStruct$PeerReport;
        this.traitCase_ = 101;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoryReport(ReportStruct$StoryReport reportStruct$StoryReport) {
        reportStruct$StoryReport.getClass();
        this.trait_ = reportStruct$StoryReport;
        this.traitCase_ = 103;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1913z1.a[gVar.ordinal()]) {
            case 1:
                return new ReportStruct$InappropriateContentReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001g\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉe<\u0000f<\u0000g<\u0000", new Object[]{"trait_", "traitCase_", "kind_", "description_", ReportStruct$PeerReport.class, ReportStruct$MessageReport.class, ReportStruct$StoryReport.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReportStruct$InappropriateContentReport.class) {
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

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public MP5 getKind() {
        MP5 mp5J = MP5.j(this.kind_);
        return mp5J == null ? MP5.UNRECOGNIZED : mp5J;
    }

    public int getKindValue() {
        return this.kind_;
    }

    public ReportStruct$MessageReport getMessageReport() {
        return this.traitCase_ == 102 ? (ReportStruct$MessageReport) this.trait_ : ReportStruct$MessageReport.getDefaultInstance();
    }

    public ReportStruct$PeerReport getPeerReport() {
        return this.traitCase_ == 101 ? (ReportStruct$PeerReport) this.trait_ : ReportStruct$PeerReport.getDefaultInstance();
    }

    public ReportStruct$StoryReport getStoryReport() {
        return this.traitCase_ == 103 ? (ReportStruct$StoryReport) this.trait_ : ReportStruct$StoryReport.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasMessageReport() {
        return this.traitCase_ == 102;
    }

    public boolean hasPeerReport() {
        return this.traitCase_ == 101;
    }

    public boolean hasStoryReport() {
        return this.traitCase_ == 103;
    }

    public static a newBuilder(ReportStruct$InappropriateContentReport reportStruct$InappropriateContentReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(reportStruct$InappropriateContentReport);
    }

    public static ReportStruct$InappropriateContentReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(AbstractC2383g abstractC2383g) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(byte[] bArr) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(InputStream inputStream) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(AbstractC2384h abstractC2384h) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReportStruct$InappropriateContentReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReportStruct$InappropriateContentReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
