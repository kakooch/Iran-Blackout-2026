package androidx.compose.foundation.layout;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
import ir.nasim.ED1;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.PT1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)BA\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "Lir/nasim/zg4;", "Landroidx/compose/foundation/layout/w;", "Lir/nasim/PT1;", "direction", "", "unbounded", "Lkotlin/Function2;", "Lir/nasim/Fa3;", "Lir/nasim/eu3;", "Lir/nasim/ua3;", "alignmentCallback", "", "align", "", "inspectorName", "<init>", "(Lir/nasim/PT1;ZLir/nasim/iB2;Ljava/lang/Object;Ljava/lang/String;)V", "l", "()Landroidx/compose/foundation/layout/w;", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/foundation/layout/w;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "Lir/nasim/PT1;", "c", "Z", "d", "Lir/nasim/iB2;", "e", "Ljava/lang/Object;", "f", "Ljava/lang/String;", "g", "a", "foundation-layout_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
final class WrapContentElement extends AbstractC25066zg4 {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: from kotlin metadata */
    private final PT1 direction;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean unbounded;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC14603iB2 alignmentCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private final Object align;

    /* renamed from: f, reason: from kotlin metadata */
    private final String inspectorName;

    /* renamed from: androidx.compose.foundation.layout.WrapContentElement$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: androidx.compose.foundation.layout.WrapContentElement$a$a, reason: collision with other inner class name */
        static final class C0043a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC12529em.c e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0043a(InterfaceC12529em.c cVar) {
                super(2);
                this.e = cVar;
            }

            public final long a(long j, EnumC12613eu3 enumC12613eu3) {
                return C22045ua3.f((0 << 32) | (4294967295L & this.e.a(0, (int) (j & 4294967295L))));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C22045ua3.c(a(((C4414Fa3) obj).j(), (EnumC12613eu3) obj2));
            }
        }

        /* renamed from: androidx.compose.foundation.layout.WrapContentElement$a$b */
        static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC12529em e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC12529em interfaceC12529em) {
                super(2);
                this.e = interfaceC12529em;
            }

            public final long a(long j, EnumC12613eu3 enumC12613eu3) {
                return this.e.a(C4414Fa3.b.a(), j, enumC12613eu3);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C22045ua3.c(a(((C4414Fa3) obj).j(), (EnumC12613eu3) obj2));
            }
        }

        /* renamed from: androidx.compose.foundation.layout.WrapContentElement$a$c */
        static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC12529em.b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC12529em.b bVar) {
                super(2);
                this.e = bVar;
            }

            public final long a(long j, EnumC12613eu3 enumC12613eu3) {
                return C22045ua3.f((0 & 4294967295L) | (this.e.a(0, (int) (j >> 32), enumC12613eu3) << 32));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return C22045ua3.c(a(((C4414Fa3) obj).j(), (EnumC12613eu3) obj2));
            }
        }

        private Companion() {
        }

        public final WrapContentElement a(InterfaceC12529em.c cVar, boolean z) {
            return new WrapContentElement(PT1.a, z, new C0043a(cVar), cVar, "wrapContentHeight");
        }

        public final WrapContentElement b(InterfaceC12529em interfaceC12529em, boolean z) {
            return new WrapContentElement(PT1.c, z, new b(interfaceC12529em), interfaceC12529em, "wrapContentSize");
        }

        public final WrapContentElement c(InterfaceC12529em.b bVar, boolean z) {
            return new WrapContentElement(PT1.b, z, new c(bVar), bVar, "wrapContentWidth");
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public WrapContentElement(PT1 pt1, boolean z, InterfaceC14603iB2 interfaceC14603iB2, Object obj, String str) {
        this.direction = pt1;
        this.unbounded = z;
        this.alignmentCallback = interfaceC14603iB2;
        this.align = obj;
        this.inspectorName = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || WrapContentElement.class != other.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) other;
        return this.direction == wrapContentElement.direction && this.unbounded == wrapContentElement.unbounded && AbstractC13042fc3.d(this.align, wrapContentElement.align);
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + Boolean.hashCode(this.unbounded)) * 31) + this.align.hashCode();
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public w f() {
        return new w(this.direction, this.unbounded, this.alignmentCallback);
    }

    @Override // ir.nasim.AbstractC25066zg4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void k(w node) {
        node.x2(this.direction);
        node.y2(this.unbounded);
        node.w2(this.alignmentCallback);
    }
}
