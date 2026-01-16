package androidx.compose.animation;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.C21669tv7;
import ir.nasim.InterfaceC21900uK2;
import ir.nasim.SA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b+\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u009b\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R:\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R:\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R:\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010-\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\b\u0013\u0010F\"\u0004\bG\u0010HR\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006O"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "Lir/nasim/zg4;", "Landroidx/compose/animation/g;", "Lir/nasim/tv7;", "Lir/nasim/n92;", "transition", "Lir/nasim/tv7$a;", "Lir/nasim/Fa3;", "Lir/nasim/Rt;", "sizeAnimation", "Lir/nasim/ua3;", "offsetAnimation", "slideAnimation", "Landroidx/compose/animation/h;", "enter", "Landroidx/compose/animation/j;", "exit", "Lkotlin/Function0;", "", "isEnabled", "Lir/nasim/uK2;", "graphicsLayerBlock", "<init>", "(Lir/nasim/tv7;Lir/nasim/tv7$a;Lir/nasim/tv7$a;Lir/nasim/tv7$a;Landroidx/compose/animation/h;Landroidx/compose/animation/j;Lir/nasim/SA2;Lir/nasim/uK2;)V", "l", "()Landroidx/compose/animation/g;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/animation/g;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "b", "Lir/nasim/tv7;", "getTransition", "()Lir/nasim/tv7;", "c", "Lir/nasim/tv7$a;", "getSizeAnimation", "()Lir/nasim/tv7$a;", "setSizeAnimation", "(Lir/nasim/tv7$a;)V", "d", "getOffsetAnimation", "setOffsetAnimation", "e", "getSlideAnimation", "setSlideAnimation", "f", "Landroidx/compose/animation/h;", "getEnter", "()Landroidx/compose/animation/h;", "setEnter", "(Landroidx/compose/animation/h;)V", "g", "Landroidx/compose/animation/j;", "getExit", "()Landroidx/compose/animation/j;", "setExit", "(Landroidx/compose/animation/j;)V", "h", "Lir/nasim/SA2;", "()Lir/nasim/SA2;", "setEnabled", "(Lir/nasim/SA2;)V", "i", "Lir/nasim/uK2;", "getGraphicsLayerBlock", "()Lir/nasim/uK2;", "setGraphicsLayerBlock", "(Lir/nasim/uK2;)V", "animation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final /* data */ class EnterExitTransitionElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final C21669tv7 transition;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private C21669tv7.a sizeAnimation;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private C21669tv7.a offsetAnimation;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private C21669tv7.a slideAnimation;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private h enter;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private j exit;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private SA2 isEnabled;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private InterfaceC21900uK2 graphicsLayerBlock;

    public EnterExitTransitionElement(C21669tv7 c21669tv7, C21669tv7.a aVar, C21669tv7.a aVar2, C21669tv7.a aVar3, h hVar, j jVar, SA2 sa2, InterfaceC21900uK2 interfaceC21900uK2) {
        this.transition = c21669tv7;
        this.sizeAnimation = aVar;
        this.offsetAnimation = aVar2;
        this.slideAnimation = aVar3;
        this.enter = hVar;
        this.exit = jVar;
        this.isEnabled = sa2;
        this.graphicsLayerBlock = interfaceC21900uK2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) other;
        return AbstractC13042fc3.d(this.transition, enterExitTransitionElement.transition) && AbstractC13042fc3.d(this.sizeAnimation, enterExitTransitionElement.sizeAnimation) && AbstractC13042fc3.d(this.offsetAnimation, enterExitTransitionElement.offsetAnimation) && AbstractC13042fc3.d(this.slideAnimation, enterExitTransitionElement.slideAnimation) && AbstractC13042fc3.d(this.enter, enterExitTransitionElement.enter) && AbstractC13042fc3.d(this.exit, enterExitTransitionElement.exit) && AbstractC13042fc3.d(this.isEnabled, enterExitTransitionElement.isEnabled) && AbstractC13042fc3.d(this.graphicsLayerBlock, enterExitTransitionElement.graphicsLayerBlock);
    }

    public int hashCode() {
        int iHashCode = this.transition.hashCode() * 31;
        C21669tv7.a aVar = this.sizeAnimation;
        int iHashCode2 = (iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        C21669tv7.a aVar2 = this.offsetAnimation;
        int iHashCode3 = (iHashCode2 + (aVar2 == null ? 0 : aVar2.hashCode())) * 31;
        C21669tv7.a aVar3 = this.slideAnimation;
        return ((((((((iHashCode3 + (aVar3 != null ? aVar3.hashCode() : 0)) * 31) + this.enter.hashCode()) * 31) + this.exit.hashCode()) * 31) + this.isEnabled.hashCode()) * 31) + this.graphicsLayerBlock.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public g f() {
        return new g(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.isEnabled, this.graphicsLayerBlock);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(g node) {
        node.G2(this.transition);
        node.E2(this.sizeAnimation);
        node.D2(this.offsetAnimation);
        node.F2(this.slideAnimation);
        node.z2(this.enter);
        node.A2(this.exit);
        node.y2(this.isEnabled);
        node.B2(this.graphicsLayerBlock);
    }

    public String toString() {
        return "EnterExitTransitionElement(transition=" + this.transition + ", sizeAnimation=" + this.sizeAnimation + ", offsetAnimation=" + this.offsetAnimation + ", slideAnimation=" + this.slideAnimation + ", enter=" + this.enter + ", exit=" + this.exit + ", isEnabled=" + this.isEnabled + ", graphicsLayerBlock=" + this.graphicsLayerBlock + ')';
    }
}
