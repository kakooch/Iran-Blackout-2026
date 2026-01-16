package ai.bale.proto;

import ai.bale.proto.SchedulerStruct$TaskDeleteMessage;
import ai.bale.proto.SchedulerStruct$TaskSendMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SchedulerStruct$TaskPayload extends GeneratedMessageLite implements U64 {
    private static final SchedulerStruct$TaskPayload DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TASK_DELETE_MESSAGE_FIELD_NUMBER = 2;
    public static final int TASK_SEND_MESSAGE_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SchedulerStruct$TaskPayload.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        TASK_SEND_MESSAGE(1),
        TASK_DELETE_MESSAGE(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return TASK_SEND_MESSAGE;
            }
            if (i != 2) {
                return null;
            }
            return TASK_DELETE_MESSAGE;
        }
    }

    static {
        SchedulerStruct$TaskPayload schedulerStruct$TaskPayload = new SchedulerStruct$TaskPayload();
        DEFAULT_INSTANCE = schedulerStruct$TaskPayload;
        GeneratedMessageLite.registerDefaultInstance(SchedulerStruct$TaskPayload.class, schedulerStruct$TaskPayload);
    }

    private SchedulerStruct$TaskPayload() {
    }

    private void clearTaskDeleteMessage() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTaskSendMessage() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static SchedulerStruct$TaskPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTaskDeleteMessage(SchedulerStruct$TaskDeleteMessage schedulerStruct$TaskDeleteMessage) {
        schedulerStruct$TaskDeleteMessage.getClass();
        if (this.traitCase_ != 2 || this.trait_ == SchedulerStruct$TaskDeleteMessage.getDefaultInstance()) {
            this.trait_ = schedulerStruct$TaskDeleteMessage;
        } else {
            this.trait_ = ((SchedulerStruct$TaskDeleteMessage.a) SchedulerStruct$TaskDeleteMessage.newBuilder((SchedulerStruct$TaskDeleteMessage) this.trait_).v(schedulerStruct$TaskDeleteMessage)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeTaskSendMessage(SchedulerStruct$TaskSendMessage schedulerStruct$TaskSendMessage) {
        schedulerStruct$TaskSendMessage.getClass();
        if (this.traitCase_ != 1 || this.trait_ == SchedulerStruct$TaskSendMessage.getDefaultInstance()) {
            this.trait_ = schedulerStruct$TaskSendMessage;
        } else {
            this.trait_ = ((SchedulerStruct$TaskSendMessage.a) SchedulerStruct$TaskSendMessage.newBuilder((SchedulerStruct$TaskSendMessage) this.trait_).v(schedulerStruct$TaskSendMessage)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SchedulerStruct$TaskPayload parseDelimitedFrom(InputStream inputStream) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$TaskPayload parseFrom(ByteBuffer byteBuffer) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTaskDeleteMessage(SchedulerStruct$TaskDeleteMessage schedulerStruct$TaskDeleteMessage) {
        schedulerStruct$TaskDeleteMessage.getClass();
        this.trait_ = schedulerStruct$TaskDeleteMessage;
        this.traitCase_ = 2;
    }

    private void setTaskSendMessage(SchedulerStruct$TaskSendMessage schedulerStruct$TaskSendMessage) {
        schedulerStruct$TaskSendMessage.getClass();
        this.trait_ = schedulerStruct$TaskSendMessage;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K1.a[gVar.ordinal()]) {
            case 1:
                return new SchedulerStruct$TaskPayload();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", SchedulerStruct$TaskSendMessage.class, SchedulerStruct$TaskDeleteMessage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SchedulerStruct$TaskPayload.class) {
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

    public SchedulerStruct$TaskDeleteMessage getTaskDeleteMessage() {
        return this.traitCase_ == 2 ? (SchedulerStruct$TaskDeleteMessage) this.trait_ : SchedulerStruct$TaskDeleteMessage.getDefaultInstance();
    }

    public SchedulerStruct$TaskSendMessage getTaskSendMessage() {
        return this.traitCase_ == 1 ? (SchedulerStruct$TaskSendMessage) this.trait_ : SchedulerStruct$TaskSendMessage.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasTaskDeleteMessage() {
        return this.traitCase_ == 2;
    }

    public boolean hasTaskSendMessage() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(SchedulerStruct$TaskPayload schedulerStruct$TaskPayload) {
        return (a) DEFAULT_INSTANCE.createBuilder(schedulerStruct$TaskPayload);
    }

    public static SchedulerStruct$TaskPayload parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$TaskPayload parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SchedulerStruct$TaskPayload parseFrom(AbstractC2383g abstractC2383g) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SchedulerStruct$TaskPayload parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SchedulerStruct$TaskPayload parseFrom(byte[] bArr) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SchedulerStruct$TaskPayload parseFrom(byte[] bArr, C2394s c2394s) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SchedulerStruct$TaskPayload parseFrom(InputStream inputStream) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SchedulerStruct$TaskPayload parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SchedulerStruct$TaskPayload parseFrom(AbstractC2384h abstractC2384h) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SchedulerStruct$TaskPayload parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SchedulerStruct$TaskPayload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
