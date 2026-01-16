package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitSip$SIPDispatchRuleCallee;
import livekit.LivekitSip$SIPDispatchRuleDirect;
import livekit.LivekitSip$SIPDispatchRuleIndividual;

/* loaded from: classes8.dex */
public final class LivekitSip$SIPDispatchRule extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$SIPDispatchRule DEFAULT_INSTANCE;
    public static final int DISPATCH_RULE_CALLEE_FIELD_NUMBER = 3;
    public static final int DISPATCH_RULE_DIRECT_FIELD_NUMBER = 1;
    public static final int DISPATCH_RULE_INDIVIDUAL_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int ruleCase_ = 0;
    private Object rule_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$SIPDispatchRule.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        DISPATCH_RULE_DIRECT(1),
        DISPATCH_RULE_INDIVIDUAL(2),
        DISPATCH_RULE_CALLEE(3),
        RULE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return RULE_NOT_SET;
            }
            if (i == 1) {
                return DISPATCH_RULE_DIRECT;
            }
            if (i == 2) {
                return DISPATCH_RULE_INDIVIDUAL;
            }
            if (i != 3) {
                return null;
            }
            return DISPATCH_RULE_CALLEE;
        }
    }

    static {
        LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule = new LivekitSip$SIPDispatchRule();
        DEFAULT_INSTANCE = livekitSip$SIPDispatchRule;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$SIPDispatchRule.class, livekitSip$SIPDispatchRule);
    }

    private LivekitSip$SIPDispatchRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchRuleCallee() {
        if (this.ruleCase_ == 3) {
            this.ruleCase_ = 0;
            this.rule_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchRuleDirect() {
        if (this.ruleCase_ == 1) {
            this.ruleCase_ = 0;
            this.rule_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDispatchRuleIndividual() {
        if (this.ruleCase_ == 2) {
            this.ruleCase_ = 0;
            this.rule_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRule() {
        this.ruleCase_ = 0;
        this.rule_ = null;
    }

    public static LivekitSip$SIPDispatchRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDispatchRuleCallee(LivekitSip$SIPDispatchRuleCallee livekitSip$SIPDispatchRuleCallee) {
        livekitSip$SIPDispatchRuleCallee.getClass();
        if (this.ruleCase_ != 3 || this.rule_ == LivekitSip$SIPDispatchRuleCallee.getDefaultInstance()) {
            this.rule_ = livekitSip$SIPDispatchRuleCallee;
        } else {
            this.rule_ = ((LivekitSip$SIPDispatchRuleCallee.a) LivekitSip$SIPDispatchRuleCallee.newBuilder((LivekitSip$SIPDispatchRuleCallee) this.rule_).v(livekitSip$SIPDispatchRuleCallee)).j();
        }
        this.ruleCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDispatchRuleDirect(LivekitSip$SIPDispatchRuleDirect livekitSip$SIPDispatchRuleDirect) {
        livekitSip$SIPDispatchRuleDirect.getClass();
        if (this.ruleCase_ != 1 || this.rule_ == LivekitSip$SIPDispatchRuleDirect.getDefaultInstance()) {
            this.rule_ = livekitSip$SIPDispatchRuleDirect;
        } else {
            this.rule_ = ((LivekitSip$SIPDispatchRuleDirect.a) LivekitSip$SIPDispatchRuleDirect.newBuilder((LivekitSip$SIPDispatchRuleDirect) this.rule_).v(livekitSip$SIPDispatchRuleDirect)).j();
        }
        this.ruleCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDispatchRuleIndividual(LivekitSip$SIPDispatchRuleIndividual livekitSip$SIPDispatchRuleIndividual) {
        livekitSip$SIPDispatchRuleIndividual.getClass();
        if (this.ruleCase_ != 2 || this.rule_ == LivekitSip$SIPDispatchRuleIndividual.getDefaultInstance()) {
            this.rule_ = livekitSip$SIPDispatchRuleIndividual;
        } else {
            this.rule_ = ((LivekitSip$SIPDispatchRuleIndividual.a) LivekitSip$SIPDispatchRuleIndividual.newBuilder((LivekitSip$SIPDispatchRuleIndividual) this.rule_).v(livekitSip$SIPDispatchRuleIndividual)).j();
        }
        this.ruleCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$SIPDispatchRule parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchRuleCallee(LivekitSip$SIPDispatchRuleCallee livekitSip$SIPDispatchRuleCallee) {
        livekitSip$SIPDispatchRuleCallee.getClass();
        this.rule_ = livekitSip$SIPDispatchRuleCallee;
        this.ruleCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchRuleDirect(LivekitSip$SIPDispatchRuleDirect livekitSip$SIPDispatchRuleDirect) {
        livekitSip$SIPDispatchRuleDirect.getClass();
        this.rule_ = livekitSip$SIPDispatchRuleDirect;
        this.ruleCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDispatchRuleIndividual(LivekitSip$SIPDispatchRuleIndividual livekitSip$SIPDispatchRuleIndividual) {
        livekitSip$SIPDispatchRuleIndividual.getClass();
        this.rule_ = livekitSip$SIPDispatchRuleIndividual;
        this.ruleCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$SIPDispatchRule();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"rule_", "ruleCase_", LivekitSip$SIPDispatchRuleDirect.class, LivekitSip$SIPDispatchRuleIndividual.class, LivekitSip$SIPDispatchRuleCallee.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$SIPDispatchRule.class) {
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

    public LivekitSip$SIPDispatchRuleCallee getDispatchRuleCallee() {
        return this.ruleCase_ == 3 ? (LivekitSip$SIPDispatchRuleCallee) this.rule_ : LivekitSip$SIPDispatchRuleCallee.getDefaultInstance();
    }

    public LivekitSip$SIPDispatchRuleDirect getDispatchRuleDirect() {
        return this.ruleCase_ == 1 ? (LivekitSip$SIPDispatchRuleDirect) this.rule_ : LivekitSip$SIPDispatchRuleDirect.getDefaultInstance();
    }

    public LivekitSip$SIPDispatchRuleIndividual getDispatchRuleIndividual() {
        return this.ruleCase_ == 2 ? (LivekitSip$SIPDispatchRuleIndividual) this.rule_ : LivekitSip$SIPDispatchRuleIndividual.getDefaultInstance();
    }

    public b getRuleCase() {
        return b.j(this.ruleCase_);
    }

    public boolean hasDispatchRuleCallee() {
        return this.ruleCase_ == 3;
    }

    public boolean hasDispatchRuleDirect() {
        return this.ruleCase_ == 1;
    }

    public boolean hasDispatchRuleIndividual() {
        return this.ruleCase_ == 2;
    }

    public static a newBuilder(LivekitSip$SIPDispatchRule livekitSip$SIPDispatchRule) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$SIPDispatchRule);
    }

    public static LivekitSip$SIPDispatchRule parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(byte[] bArr) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(InputStream inputStream) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$SIPDispatchRule parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$SIPDispatchRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
