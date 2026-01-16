package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17506n48;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class WarriorStruct$ScoreBoard extends GeneratedMessageLite implements U64 {
    public static final int BOTTOM_FIELD_NUMBER = 2;
    public static final int COMPETITORS_AFTER_ME_FIELD_NUMBER = 3;
    private static final WarriorStruct$ScoreBoard DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOP_FIELD_NUMBER = 1;
    private int competitorsAfterMe_;
    private B.j top_ = GeneratedMessageLite.emptyProtobufList();
    private B.j bottom_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorStruct$ScoreBoard.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorStruct$ScoreBoard warriorStruct$ScoreBoard = new WarriorStruct$ScoreBoard();
        DEFAULT_INSTANCE = warriorStruct$ScoreBoard;
        GeneratedMessageLite.registerDefaultInstance(WarriorStruct$ScoreBoard.class, warriorStruct$ScoreBoard);
    }

    private WarriorStruct$ScoreBoard() {
    }

    private void addAllBottom(Iterable<? extends WarriorStruct$Competitor> iterable) {
        ensureBottomIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.bottom_);
    }

    private void addAllTop(Iterable<? extends WarriorStruct$Competitor> iterable) {
        ensureTopIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.top_);
    }

    private void addBottom(WarriorStruct$Competitor warriorStruct$Competitor) {
        warriorStruct$Competitor.getClass();
        ensureBottomIsMutable();
        this.bottom_.add(warriorStruct$Competitor);
    }

    private void addTop(WarriorStruct$Competitor warriorStruct$Competitor) {
        warriorStruct$Competitor.getClass();
        ensureTopIsMutable();
        this.top_.add(warriorStruct$Competitor);
    }

    private void clearBottom() {
        this.bottom_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCompetitorsAfterMe() {
        this.competitorsAfterMe_ = 0;
    }

    private void clearTop() {
        this.top_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBottomIsMutable() {
        B.j jVar = this.bottom_;
        if (jVar.u()) {
            return;
        }
        this.bottom_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTopIsMutable() {
        B.j jVar = this.top_;
        if (jVar.u()) {
            return;
        }
        this.top_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static WarriorStruct$ScoreBoard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorStruct$ScoreBoard parseDelimitedFrom(InputStream inputStream) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorStruct$ScoreBoard parseFrom(ByteBuffer byteBuffer) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBottom(int i) {
        ensureBottomIsMutable();
        this.bottom_.remove(i);
    }

    private void removeTop(int i) {
        ensureTopIsMutable();
        this.top_.remove(i);
    }

    private void setBottom(int i, WarriorStruct$Competitor warriorStruct$Competitor) {
        warriorStruct$Competitor.getClass();
        ensureBottomIsMutable();
        this.bottom_.set(i, warriorStruct$Competitor);
    }

    private void setCompetitorsAfterMe(int i) {
        this.competitorsAfterMe_ = i;
    }

    private void setTop(int i, WarriorStruct$Competitor warriorStruct$Competitor) {
        warriorStruct$Competitor.getClass();
        ensureTopIsMutable();
        this.top_.set(i, warriorStruct$Competitor);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (x2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorStruct$ScoreBoard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003\u0004", new Object[]{"top_", WarriorStruct$Competitor.class, "bottom_", WarriorStruct$Competitor.class, "competitorsAfterMe_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorStruct$ScoreBoard.class) {
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

    public WarriorStruct$Competitor getBottom(int i) {
        return (WarriorStruct$Competitor) this.bottom_.get(i);
    }

    public int getBottomCount() {
        return this.bottom_.size();
    }

    public List<WarriorStruct$Competitor> getBottomList() {
        return this.bottom_;
    }

    public InterfaceC17506n48 getBottomOrBuilder(int i) {
        return (InterfaceC17506n48) this.bottom_.get(i);
    }

    public List<? extends InterfaceC17506n48> getBottomOrBuilderList() {
        return this.bottom_;
    }

    public int getCompetitorsAfterMe() {
        return this.competitorsAfterMe_;
    }

    public WarriorStruct$Competitor getTop(int i) {
        return (WarriorStruct$Competitor) this.top_.get(i);
    }

    public int getTopCount() {
        return this.top_.size();
    }

    public List<WarriorStruct$Competitor> getTopList() {
        return this.top_;
    }

    public InterfaceC17506n48 getTopOrBuilder(int i) {
        return (InterfaceC17506n48) this.top_.get(i);
    }

    public List<? extends InterfaceC17506n48> getTopOrBuilderList() {
        return this.top_;
    }

    public static a newBuilder(WarriorStruct$ScoreBoard warriorStruct$ScoreBoard) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorStruct$ScoreBoard);
    }

    public static WarriorStruct$ScoreBoard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorStruct$ScoreBoard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorStruct$ScoreBoard parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBottom(int i, WarriorStruct$Competitor warriorStruct$Competitor) {
        warriorStruct$Competitor.getClass();
        ensureBottomIsMutable();
        this.bottom_.add(i, warriorStruct$Competitor);
    }

    private void addTop(int i, WarriorStruct$Competitor warriorStruct$Competitor) {
        warriorStruct$Competitor.getClass();
        ensureTopIsMutable();
        this.top_.add(i, warriorStruct$Competitor);
    }

    public static WarriorStruct$ScoreBoard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorStruct$ScoreBoard parseFrom(byte[] bArr) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorStruct$ScoreBoard parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorStruct$ScoreBoard parseFrom(InputStream inputStream) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorStruct$ScoreBoard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorStruct$ScoreBoard parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorStruct$ScoreBoard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorStruct$ScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
