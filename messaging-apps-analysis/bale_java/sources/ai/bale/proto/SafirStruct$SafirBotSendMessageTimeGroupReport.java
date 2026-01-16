package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.N96;
import ir.nasim.U96;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SafirStruct$SafirBotSendMessageTimeGroupReport extends GeneratedMessageLite implements U96 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final SafirStruct$SafirBotSendMessageTimeGroupReport DEFAULT_INSTANCE;
    public static final int GROUPED_MESSAGES_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int botId_;
    private B.j groupedMessages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U96 {
        private a() {
            super(SafirStruct$SafirBotSendMessageTimeGroupReport.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$SafirBotSendMessageTimeGroupReport safirStruct$SafirBotSendMessageTimeGroupReport = new SafirStruct$SafirBotSendMessageTimeGroupReport();
        DEFAULT_INSTANCE = safirStruct$SafirBotSendMessageTimeGroupReport;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$SafirBotSendMessageTimeGroupReport.class, safirStruct$SafirBotSendMessageTimeGroupReport);
    }

    private SafirStruct$SafirBotSendMessageTimeGroupReport() {
    }

    private void addAllGroupedMessages(Iterable<? extends SafirStruct$GroupMessageCount> iterable) {
        ensureGroupedMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupedMessages_);
    }

    private void addGroupedMessages(SafirStruct$GroupMessageCount safirStruct$GroupMessageCount) {
        safirStruct$GroupMessageCount.getClass();
        ensureGroupedMessagesIsMutable();
        this.groupedMessages_.add(safirStruct$GroupMessageCount);
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearGroupedMessages() {
        this.groupedMessages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupedMessagesIsMutable() {
        B.j jVar = this.groupedMessages_;
        if (jVar.u()) {
            return;
        }
        this.groupedMessages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroupedMessages(int i) {
        ensureGroupedMessagesIsMutable();
        this.groupedMessages_.remove(i);
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setGroupedMessages(int i, SafirStruct$GroupMessageCount safirStruct$GroupMessageCount) {
        safirStruct$GroupMessageCount.getClass();
        ensureGroupedMessagesIsMutable();
        this.groupedMessages_.set(i, safirStruct$GroupMessageCount);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$SafirBotSendMessageTimeGroupReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"botId_", "groupedMessages_", SafirStruct$GroupMessageCount.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$SafirBotSendMessageTimeGroupReport.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public SafirStruct$GroupMessageCount getGroupedMessages(int i) {
        return (SafirStruct$GroupMessageCount) this.groupedMessages_.get(i);
    }

    public int getGroupedMessagesCount() {
        return this.groupedMessages_.size();
    }

    public List<SafirStruct$GroupMessageCount> getGroupedMessagesList() {
        return this.groupedMessages_;
    }

    public N96 getGroupedMessagesOrBuilder(int i) {
        return (N96) this.groupedMessages_.get(i);
    }

    public List<? extends N96> getGroupedMessagesOrBuilderList() {
        return this.groupedMessages_;
    }

    public static a newBuilder(SafirStruct$SafirBotSendMessageTimeGroupReport safirStruct$SafirBotSendMessageTimeGroupReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$SafirBotSendMessageTimeGroupReport);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroupedMessages(int i, SafirStruct$GroupMessageCount safirStruct$GroupMessageCount) {
        safirStruct$GroupMessageCount.getClass();
        ensureGroupedMessagesIsMutable();
        this.groupedMessages_.add(i, safirStruct$GroupMessageCount);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(byte[] bArr) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(InputStream inputStream) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$SafirBotSendMessageTimeGroupReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$SafirBotSendMessageTimeGroupReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
