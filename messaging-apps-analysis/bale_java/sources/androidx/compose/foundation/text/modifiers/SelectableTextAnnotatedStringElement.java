package androidx.compose.foundation.text.modifiers;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC24544yn6;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC9998au2;
import ir.nasim.C13245fu;
import ir.nasim.C9348Zn7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC8312Vk7;
import ir.nasim.UA2;
import ir.nasim.VX0;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B»\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014\u0012\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'H\u0096\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00109R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00109R\"\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R*\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00107R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010AR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010B\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/text/modifiers/a;", "Lir/nasim/fu;", ParameterNames.TEXT, "Lir/nasim/Zn7;", "style", "Lir/nasim/au2$b;", "fontFamilyResolver", "Lkotlin/Function1;", "Lir/nasim/gn7;", "Lir/nasim/rB7;", "onTextLayout", "Lir/nasim/wn7;", "overflow", "", "softWrap", "", "maxLines", "minLines", "", "Lir/nasim/fu$d;", "Lir/nasim/xe5;", "placeholders", "Lir/nasim/CK5;", "onPlaceholderLayout", "Lir/nasim/yn6;", "selectionController", "Lir/nasim/VX0;", "color", "Lir/nasim/Vk7;", "autoSize", "<init>", "(Lir/nasim/fu;Lir/nasim/Zn7;Lir/nasim/au2$b;Lir/nasim/UA2;IZIILjava/util/List;Lir/nasim/UA2;Lir/nasim/yn6;Lir/nasim/VX0;Lir/nasim/Vk7;Lir/nasim/ED1;)V", "l", "()Landroidx/compose/foundation/text/modifiers/a;", "node", "m", "(Landroidx/compose/foundation/text/modifiers/a;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", "Lir/nasim/fu;", "c", "Lir/nasim/Zn7;", "d", "Lir/nasim/au2$b;", "e", "Lir/nasim/UA2;", "f", TokenNames.I, "g", "Z", "h", "i", "j", "Ljava/util/List;", "k", "Lir/nasim/yn6;", "Lir/nasim/VX0;", "foundation_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final /* data */ class SelectableTextAnnotatedStringElement extends AbstractC25066zg4 {

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final C13245fu text;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final C9348Zn7 style;
    private final VX0 color;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final AbstractC9998au2.b fontFamilyResolver;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final UA2 onTextLayout;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final int overflow;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final boolean softWrap;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private final int maxLines;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private final int minLines;

    /* renamed from: j, reason: from kotlin metadata and from toString */
    private final List placeholders;

    /* renamed from: k, reason: from kotlin metadata and from toString */
    private final UA2 onPlaceholderLayout;

    /* renamed from: l, reason: from kotlin metadata and from toString */
    private final AbstractC24544yn6 selectionController;

    public /* synthetic */ SelectableTextAnnotatedStringElement(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, UA2 ua2, int i, boolean z, int i2, int i3, List list, UA2 ua22, AbstractC24544yn6 abstractC24544yn6, VX0 vx0, InterfaceC8312Vk7 interfaceC8312Vk7, ED1 ed1) {
        this(c13245fu, c9348Zn7, bVar, ua2, i, z, i2, i3, list, ua22, abstractC24544yn6, vx0, interfaceC8312Vk7);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) other;
        if (!AbstractC13042fc3.d(this.color, selectableTextAnnotatedStringElement.color) || !AbstractC13042fc3.d(this.text, selectableTextAnnotatedStringElement.text) || !AbstractC13042fc3.d(this.style, selectableTextAnnotatedStringElement.style) || !AbstractC13042fc3.d(this.placeholders, selectableTextAnnotatedStringElement.placeholders) || !AbstractC13042fc3.d(this.fontFamilyResolver, selectableTextAnnotatedStringElement.fontFamilyResolver)) {
            return false;
        }
        selectableTextAnnotatedStringElement.getClass();
        return AbstractC13042fc3.d(null, null) && this.onTextLayout == selectableTextAnnotatedStringElement.onTextLayout && AbstractC23365wn7.g(this.overflow, selectableTextAnnotatedStringElement.overflow) && this.softWrap == selectableTextAnnotatedStringElement.softWrap && this.maxLines == selectableTextAnnotatedStringElement.maxLines && this.minLines == selectableTextAnnotatedStringElement.minLines && this.onPlaceholderLayout == selectableTextAnnotatedStringElement.onPlaceholderLayout && AbstractC13042fc3.d(this.selectionController, selectableTextAnnotatedStringElement.selectionController);
    }

    public int hashCode() {
        int iHashCode = ((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31;
        UA2 ua2 = this.onTextLayout;
        int iHashCode2 = (((((((((iHashCode + (ua2 != null ? ua2.hashCode() : 0)) * 31) + AbstractC23365wn7.h(this.overflow)) * 31) + Boolean.hashCode(this.softWrap)) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        List list = this.placeholders;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        UA2 ua22 = this.onPlaceholderLayout;
        int iHashCode4 = (((iHashCode3 + (ua22 != null ? ua22.hashCode() : 0)) * 31) + 0) * 961;
        VX0 vx0 = this.color;
        return iHashCode4 + (vx0 != null ? vx0.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public a f() {
        return new a(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, null, null, 8192, null);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(a node) {
        node.B2(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color, null);
    }

    public String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.text) + ", style=" + this.style + ", fontFamilyResolver=" + this.fontFamilyResolver + ", onTextLayout=" + this.onTextLayout + ", overflow=" + ((Object) AbstractC23365wn7.i(this.overflow)) + ", softWrap=" + this.softWrap + ", maxLines=" + this.maxLines + ", minLines=" + this.minLines + ", placeholders=" + this.placeholders + ", onPlaceholderLayout=" + this.onPlaceholderLayout + ", selectionController=" + this.selectionController + ", color=" + this.color + ", autoSize=" + ((Object) null) + ')';
    }

    private SelectableTextAnnotatedStringElement(C13245fu c13245fu, C9348Zn7 c9348Zn7, AbstractC9998au2.b bVar, UA2 ua2, int i, boolean z, int i2, int i3, List list, UA2 ua22, AbstractC24544yn6 abstractC24544yn6, VX0 vx0, InterfaceC8312Vk7 interfaceC8312Vk7) {
        this.text = c13245fu;
        this.style = c9348Zn7;
        this.fontFamilyResolver = bVar;
        this.onTextLayout = ua2;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.onPlaceholderLayout = ua22;
        this.color = vx0;
    }
}
