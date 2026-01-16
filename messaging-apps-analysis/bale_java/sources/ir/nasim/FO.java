package ir.nasim;

import ir.nasim.InterfaceC17445my6;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lir/nasim/FO;", "Lir/nasim/Ha0;", "Lir/nasim/my6$a;", "Lir/nasim/CP;", "<init>", "()V", "", "W9", "()I", "X9", "Lir/nasim/Fq2;", "Lir/nasim/NT4;", "aa", "()Lir/nasim/Fq2;", "Lir/nasim/OT4;", "V9", "()Lir/nasim/OT4;", "o1", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class FO extends OV2<InterfaceC17445my6.a, CP> {

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.FO$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final FO a() {
            return new FO();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(FO fo, boolean z) {
        AbstractC13042fc3.i(fo, "this$0");
        fo.ba().x4(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(FO fo, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(fo, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        fo.ba().f4(interfaceC17445my6);
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public OT4 V9() {
        return new FP(ba().Z3(), null, new UA2() { // from class: ir.nasim.DO
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return FO.oa(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.EO
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return FO.pa(this.a, (InterfaceC17445my6) obj);
            }
        }, ba().v3(), 2, null);
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public int W9() {
        return AbstractC22412vB5.play;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public int X9() {
        return RD5.not_exist_audio;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public InterfaceC4557Fq2 aa() {
        return ba().N2();
    }
}
