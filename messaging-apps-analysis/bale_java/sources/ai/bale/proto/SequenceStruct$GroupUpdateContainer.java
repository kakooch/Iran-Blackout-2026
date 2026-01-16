package ai.bale.proto;

import ai.bale.proto.SequenceStruct$SeqState;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11027cc4;
import ir.nasim.InterfaceC7415Rp6;
import ir.nasim.InterfaceC7888Tp6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SequenceStruct$GroupUpdateContainer extends GeneratedMessageLite implements InterfaceC7888Tp6 {
    private static final SequenceStruct$GroupUpdateContainer DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 6;
    public static final int NEED_MORE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    public static final int TOO_LONG_FIELD_NUMBER = 7;
    public static final int UPDATES_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean needMore_;
    private SequenceStruct$SeqState state_;
    private BoolValue tooLong_;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();
    private B.j messages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7888Tp6 {
        private a() {
            super(SequenceStruct$GroupUpdateContainer.DEFAULT_INSTANCE);
        }
    }

    static {
        SequenceStruct$GroupUpdateContainer sequenceStruct$GroupUpdateContainer = new SequenceStruct$GroupUpdateContainer();
        DEFAULT_INSTANCE = sequenceStruct$GroupUpdateContainer;
        GeneratedMessageLite.registerDefaultInstance(SequenceStruct$GroupUpdateContainer.class, sequenceStruct$GroupUpdateContainer);
    }

    private SequenceStruct$GroupUpdateContainer() {
    }

    private void addAllMessages(Iterable<? extends MessagingStruct$MessageContainer> iterable) {
        ensureMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messages_);
    }

    private void addAllUpdates(Iterable<? extends SequenceStruct$ContainerUpdates> iterable) {
        ensureUpdatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.updates_);
    }

    private void addMessages(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(messagingStruct$MessageContainer);
    }

    private void addUpdates(SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        sequenceStruct$ContainerUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(sequenceStruct$ContainerUpdates);
    }

    private void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearNeedMore() {
        this.needMore_ = false;
    }

    private void clearState() {
        this.state_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTooLong() {
        this.tooLong_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUpdates() {
        this.updates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMessagesIsMutable() {
        B.j jVar = this.messages_;
        if (jVar.u()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUpdatesIsMutable() {
        B.j jVar = this.updates_;
        if (jVar.u()) {
            return;
        }
        this.updates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SequenceStruct$GroupUpdateContainer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeState(SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        SequenceStruct$SeqState sequenceStruct$SeqState2 = this.state_;
        if (sequenceStruct$SeqState2 == null || sequenceStruct$SeqState2 == SequenceStruct$SeqState.getDefaultInstance()) {
            this.state_ = sequenceStruct$SeqState;
        } else {
            this.state_ = (SequenceStruct$SeqState) ((SequenceStruct$SeqState.a) SequenceStruct$SeqState.newBuilder(this.state_).v(sequenceStruct$SeqState)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTooLong(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.tooLong_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.tooLong_ = boolValue;
        } else {
            this.tooLong_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.tooLong_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SequenceStruct$GroupUpdateContainer parseDelimitedFrom(InputStream inputStream) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(ByteBuffer byteBuffer) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
    }

    private void setMessages(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i, messagingStruct$MessageContainer);
    }

    private void setNeedMore(boolean z) {
        this.needMore_ = z;
    }

    private void setState(SequenceStruct$SeqState sequenceStruct$SeqState) {
        sequenceStruct$SeqState.getClass();
        this.state_ = sequenceStruct$SeqState;
        this.bitField0_ |= 1;
    }

    private void setTooLong(BoolValue boolValue) {
        boolValue.getClass();
        this.tooLong_ = boolValue;
        this.bitField0_ |= 2;
    }

    private void setUpdates(int i, SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        sequenceStruct$ContainerUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, sequenceStruct$ContainerUpdates);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T1.a[gVar.ordinal()]) {
            case 1:
                return new SequenceStruct$GroupUpdateContainer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u0007\u0006\u001b\u0007ဉ\u0001", new Object[]{"bitField0_", "state_", "updates_", SequenceStruct$ContainerUpdates.class, "needMore_", "messages_", MessagingStruct$MessageContainer.class, "tooLong_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SequenceStruct$GroupUpdateContainer.class) {
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

    public MessagingStruct$MessageContainer getMessages(int i) {
        return (MessagingStruct$MessageContainer) this.messages_.get(i);
    }

    public int getMessagesCount() {
        return this.messages_.size();
    }

    public List<MessagingStruct$MessageContainer> getMessagesList() {
        return this.messages_;
    }

    public InterfaceC11027cc4 getMessagesOrBuilder(int i) {
        return (InterfaceC11027cc4) this.messages_.get(i);
    }

    public List<? extends InterfaceC11027cc4> getMessagesOrBuilderList() {
        return this.messages_;
    }

    public boolean getNeedMore() {
        return this.needMore_;
    }

    public SequenceStruct$SeqState getState() {
        SequenceStruct$SeqState sequenceStruct$SeqState = this.state_;
        return sequenceStruct$SeqState == null ? SequenceStruct$SeqState.getDefaultInstance() : sequenceStruct$SeqState;
    }

    public BoolValue getTooLong() {
        BoolValue boolValue = this.tooLong_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public SequenceStruct$ContainerUpdates getUpdates(int i) {
        return (SequenceStruct$ContainerUpdates) this.updates_.get(i);
    }

    public int getUpdatesCount() {
        return this.updates_.size();
    }

    public List<SequenceStruct$ContainerUpdates> getUpdatesList() {
        return this.updates_;
    }

    public InterfaceC7415Rp6 getUpdatesOrBuilder(int i) {
        return (InterfaceC7415Rp6) this.updates_.get(i);
    }

    public List<? extends InterfaceC7415Rp6> getUpdatesOrBuilderList() {
        return this.updates_;
    }

    public boolean hasState() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTooLong() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(SequenceStruct$GroupUpdateContainer sequenceStruct$GroupUpdateContainer) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequenceStruct$GroupUpdateContainer);
    }

    public static SequenceStruct$GroupUpdateContainer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(AbstractC2383g abstractC2383g) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMessages(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i, messagingStruct$MessageContainer);
    }

    private void addUpdates(int i, SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        sequenceStruct$ContainerUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, sequenceStruct$ContainerUpdates);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(byte[] bArr) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(byte[] bArr, C2394s c2394s) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(InputStream inputStream) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(AbstractC2384h abstractC2384h) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SequenceStruct$GroupUpdateContainer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SequenceStruct$GroupUpdateContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
