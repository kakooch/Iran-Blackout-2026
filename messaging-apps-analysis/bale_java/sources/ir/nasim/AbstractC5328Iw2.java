package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.compose.ui.e;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC5328Iw2;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.smiles.panel.SmilesPanelView;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.Iw2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5328Iw2 {

    /* renamed from: ir.nasim.Iw2$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ List b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ UA2 d;

        a(List list, List list2, UA2 ua2, UA2 ua22) {
            this.a = list;
            this.b = list2;
            this.c = ua2;
            this.d = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, C7947Tw2 c7947Tw2, UA2 ua22, boolean z) {
            AbstractC13042fc3.i(ua2, "$onSelectPeer");
            AbstractC13042fc3.i(c7947Tw2, "$forwardPeer");
            AbstractC13042fc3.i(ua22, "$onRemovePeer");
            if (z) {
                ua2.invoke(c7947Tw2);
            } else {
                ua22.invoke(c7947Tw2);
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final C7947Tw2 c7947Tw2 = (C7947Tw2) this.a.get(i);
            String strD = c7947Tw2.d();
            String strE = c7947Tw2.e();
            Avatar avatarA = c7947Tw2.a();
            boolean zContains = this.b.contains(c7947Tw2);
            interfaceC22053ub1.W(1190918464);
            boolean zV = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.D(c7947Tw2) | interfaceC22053ub1.V(this.d);
            final UA2 ua2 = this.c;
            final UA2 ua22 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Hw2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5328Iw2.a.c(ua2, c7947Tw2, ua22, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC5328Iw2.k0(strD, strE, avatarA, zContains, (UA2) objB, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Iw2$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ List b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ UA2 d;

        b(int i, List list, UA2 ua2, UA2 ua22) {
            this.a = i;
            this.b = list;
            this.c = ua2;
            this.d = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, C7947Tw2 c7947Tw2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(list, "$selectedPeers");
            AbstractC13042fc3.i(c7947Tw2, "$forwardPeer");
            AbstractC13042fc3.i(ua2, "$onRemovePeer");
            AbstractC13042fc3.i(ua22, "$onSelectPeer");
            if (list.contains(c7947Tw2)) {
                ua2.invoke(c7947Tw2);
            } else {
                ua22.invoke(c7947Tw2);
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC19187pv3 interfaceC19187pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC19187pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final C7947Tw2 c7947Tw2 = new C7947Tw2(UY6.c(DD5.saved_message_dialog_title, interfaceC22053ub1, 0), null, null, this.a, ExPeerType.PRIVATE);
            boolean zContains = this.b.contains(c7947Tw2);
            interfaceC22053ub1.W(1190974703);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(c7947Tw2) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.d);
            final List list = this.b;
            final UA2 ua2 = this.c;
            final UA2 ua22 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Jw2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5328Iw2.b.c(list, c7947Tw2, ua2, ua22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC5328Iw2.h0(true, zContains, (SA2) objB, c7947Tw2, interfaceC22053ub1, (C7947Tw2.f << 9) | 6, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC19187pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Iw2$c */
    static final class c implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ List b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ UA2 d;

        c(List list, List list2, UA2 ua2, UA2 ua22) {
            this.a = list;
            this.b = list2;
            this.c = ua2;
            this.d = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, C7947Tw2 c7947Tw2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(list, "$selectedPeers");
            AbstractC13042fc3.i(c7947Tw2, "$forwardPeer");
            AbstractC13042fc3.i(ua2, "$onRemovePeer");
            AbstractC13042fc3.i(ua22, "$onSelectPeer");
            if (list.contains(c7947Tw2)) {
                ua2.invoke(c7947Tw2);
            } else {
                ua22.invoke(c7947Tw2);
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC19187pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final C7947Tw2 c7947Tw2 = (C7947Tw2) this.a.get(i);
            boolean zContains = this.b.contains(c7947Tw2);
            interfaceC22053ub1.W(1191000207);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(c7947Tw2) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.d);
            final List list = this.b;
            final UA2 ua2 = this.c;
            final UA2 ua22 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Kw2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5328Iw2.c.c(list, c7947Tw2, ua2, ua22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC5328Iw2.h0(false, zContains, (SA2) objB, c7947Tw2, interfaceC22053ub1, C7947Tw2.f << 9, 1);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Iw2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c && AbstractC5328Iw2.D0(this.d)) {
                AbstractC5328Iw2.E0(this.d, false);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Iw2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C19391qG6 c19391qG6, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (KV0.b()) {
                    C19391qG6 c19391qG6 = this.c;
                    String str = this.d;
                    this.b = 1;
                    if (C19391qG6.f(c19391qG6, str, null, false, null, this, 14, null) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Iw2$g */
    static final class g implements InterfaceC16978mB2 {
        final /* synthetic */ List a;
        final /* synthetic */ int b;
        final /* synthetic */ UA2 c;

        g(List list, int i, UA2 ua2) {
            this.a = list;
            this.b = i;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, C7947Tw2 c7947Tw2) {
            AbstractC13042fc3.i(ua2, "$onRemovePeer");
            AbstractC13042fc3.i(c7947Tw2, "user");
            ua2.invoke(c7947Tw2);
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C7947Tw2 c7947Tw2 = (C7947Tw2) this.a.get(i);
            boolean z = ((C7947Tw2) this.a.get(i)).c() == this.b;
            interfaceC22053ub1.W(1270192659);
            boolean zV = interfaceC22053ub1.V(this.c);
            final UA2 ua2 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Mw2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5328Iw2.g.c(ua2, (C7947Tw2) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC5328Iw2.n0(z, null, c7947Tw2, (UA2) objB, interfaceC22053ub1, C7947Tw2.f << 6, 2);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Iw2$h */
    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        public final void a(InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15254jG6, "it");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC10984cY.c(this.a, null, AbstractC13463gG6.c.b, 0, null, interfaceC22053ub1, AbstractC13463gG6.c.d << 6, 26);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Iw2$i */
    public static final class i implements CF6 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ UA2 b;

        i(SA2 sa2, UA2 ua2) {
            this.a = sa2;
            this.b = ua2;
        }

        @Override // ir.nasim.CF6
        public boolean a() {
            return ((Boolean) this.a.invoke()).booleanValue();
        }

        @Override // ir.nasim.CF6
        public void f(String str) {
            AbstractC13042fc3.i(str, "emoji");
            this.b.invoke(str);
        }
    }

    /* renamed from: ir.nasim.Iw2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ A98 c;
        final /* synthetic */ WH1 d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* renamed from: ir.nasim.Iw2$j$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC9102Ym4 a;

            a(InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = interfaceC9102Ym4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).intValue(), interfaceC20295rm1);
            }

            public final Object b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                AbstractC5328Iw2.X0(this.a, i > 0);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(A98 a98, WH1 wh1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = a98;
            this.d = wh1;
            this.e = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int y(A98 a98, WH1 wh1) {
            return a98.c(wh1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final A98 a98 = this.c;
                final WH1 wh1 = this.d;
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(new SA2() { // from class: ir.nasim.Nw2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Integer.valueOf(AbstractC5328Iw2.j.y(a98, wh1));
                    }
                });
                a aVar = new a(this.e);
                this.b = 1;
                if (interfaceC4557Fq2R.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(List list, boolean z, boolean z2, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, UA2 ua2, int i2, UA2 ua22, Fragment fragment, C11458d25 c11458d25, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(list, "$selectedPeers");
        AbstractC13042fc3.i(sa2, "$onDismiss");
        AbstractC13042fc3.i(sa22, "$onCopyClicked");
        AbstractC13042fc3.i(sa23, "$sharePost");
        AbstractC13042fc3.i(sa24, "$addPostToStory");
        AbstractC13042fc3.i(ua2, "$onRemovePeer");
        AbstractC13042fc3.i(ua22, "$doForward");
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(c11458d25, "$peer");
        q0(list, z, z2, sa2, sa22, sa23, sa24, ua2, i2, ua22, fragment, c11458d25, interfaceC22053ub1, QJ5.a(i3 | 1), QJ5.a(i4));
        return C19938rB7.a;
    }

    private static final String B0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    private static final void C0(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F0(SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, C19391qG6 c19391qG6, String str) {
        AbstractC13042fc3.i(sa2, "$onCopyClicked");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(c19391qG6, "$snackBarHostState");
        AbstractC13042fc3.i(str, "$snackBarMessage");
        sa2.invoke();
        C19938rB7 c19938rB7 = C19938rB7.a;
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new f(c19391qG6, str, null), 3, null);
        return C19938rB7.a;
    }

    public static final void G0(final int i2, final int i3, final String str, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i4) {
        int i5;
        AbstractC13042fc3.i(str, "contentDescription");
        AbstractC13042fc3.i(sa2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-789788306);
        if ((i4 & 6) == 0) {
            i5 = (interfaceC22053ub1J.e(i2) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= interfaceC22053ub1J.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i4 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i5 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C24254yJ.f fVarB = C24254yJ.a.b();
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar.g();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(aVar2, C17784nZ1.q(96));
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarY);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            G10 g10 = G10.a;
            int i6 = G10.b;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(aVar2, g10.a(interfaceC22053ub1J, i6).A(), N46.c(AbstractC10554bo1.c(C17784nZ1.q(26))));
            interfaceC22053ub1J.W(-2098791245);
            boolean z = (i5 & 7168) == 2048;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.pw2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5328Iw2.H0(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarE2 = SP6.E(eVarC, (SA2) objB);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarE2);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE3, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            int i7 = i5 >> 3;
            AbstractC24077y03.a(XQ7.b(C12700f33.k, i2, interfaceC22053ub1J, ((i5 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 6), str, androidx.compose.foundation.layout.q.i(aVar2, C17784nZ1.q(15)), C24381yX0.b.i(), interfaceC22053ub1J, (i7 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 3456, 0);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(8)), interfaceC22053ub1J, 6);
            AbstractC9339Zm7.b(UY6.c(i3, interfaceC22053ub1J, i7 & 14), androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, AbstractC7038Pz7.d(), interfaceC22053ub1J, 48, 0, 65016);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.qw2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5328Iw2.I0(i2, i3, str, sa2, i4, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I0(int i2, int i3, String str, SA2 sa2, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$contentDescription");
        AbstractC13042fc3.i(sa2, "$onClick");
        G0(i2, i3, str, sa2, interfaceC22053ub1, QJ5.a(i4 | 1));
        return C19938rB7.a;
    }

    private static final void J0(final androidx.compose.ui.e eVar, final boolean z, final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(877371592);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa23) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            MY2.b(null, null, G10.a.a(interfaceC22053ub1J, G10.b).A(), interfaceC22053ub1J, 0, 3);
            C24254yJ.f fVarO = c24254yJ.o(C17784nZ1.q(6));
            float f2 = 12;
            androidx.compose.ui.e eVarL = androidx.compose.foundation.layout.q.l(androidx.compose.foundation.layout.t.h(eVar, 0.0f, 1, null), C17784nZ1.q(f2), C17784nZ1.q(f2), C17784nZ1.q(f2), C17784nZ1.q(16));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, aVar2.l(), interfaceC22053ub1J, 6);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarL);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            M66 m66 = M66.a;
            int i4 = AbstractC15208jB5.link;
            int i5 = DD5.invite_link_action_copy;
            G0(i4, i5, UY6.c(i5, interfaceC22053ub1J, 0), sa2, interfaceC22053ub1J, (i3 << 3) & 7168);
            int i6 = AbstractC15208jB5.share;
            int i7 = DD5.share;
            G0(i6, i7, UY6.c(i7, interfaceC22053ub1J, 0), sa23, interfaceC22053ub1J, (i3 >> 3) & 7168);
            interfaceC22053ub1J.W(835865540);
            if (z) {
                int i8 = AbstractC15208jB5.add_story;
                int i9 = DD5.story_add_post_to_story;
                G0(i8, i9, UY6.c(i9, interfaceC22053ub1J, 0), sa22, interfaceC22053ub1J, i3 & 7168);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fw2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5328Iw2.K0(eVar, z, sa2, sa22, sa23, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K0(androidx.compose.ui.e eVar, boolean z, SA2 sa2, SA2 sa22, SA2 sa23, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(sa2, "$onCopyClicked");
        AbstractC13042fc3.i(sa22, "$onAddPostToStoryClick");
        AbstractC13042fc3.i(sa23, "$sharePost");
        J0(eVar, z, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void L(final java.util.List r41, final java.util.List r42, final ir.nasim.UA2 r43, final ir.nasim.UA2 r44, final ir.nasim.UA2 r45, final int r46, ir.nasim.InterfaceC22053ub1 r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5328Iw2.L(java.util.List, java.util.List, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.UA2, int, ir.nasim.ub1, int):void");
    }

    private static final void L0(final androidx.compose.ui.e eVar, final Fragment fragment, final C11458d25 c11458d25, final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1640437833);
        if ((i2 & 48) == 0) {
            i3 = (interfaceC22053ub1J.D(fragment) ? 32 : 16) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(c11458d25) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 16384 : 8192;
        }
        if ((i3 & 9361) == 9360 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC12529em interfaceC12529emB = InterfaceC12529em.a.b();
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emB, false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1J.W(1481189644);
            boolean zD = ((i3 & 57344) == 16384) | interfaceC22053ub1J.D(fragment) | interfaceC22053ub1J.D(c11458d25) | ((i3 & 7168) == 2048);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.dw2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5328Iw2.M0(fragment, c11458d25, sa2, ua2, (Context) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC11355cs.a((UA2) objB, androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(320)), null, interfaceC22053ub1J, 48, 4);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ew2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5328Iw2.N0(eVar, fragment, c11458d25, sa2, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void M(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmilesPanelView M0(Fragment fragment, C11458d25 c11458d25, SA2 sa2, UA2 ua2, Context context) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(sa2, "$onBackspaceEmoji");
        AbstractC13042fc3.i(ua2, "$onEmojiSelected");
        AbstractC13042fc3.i(context, "it");
        SmilesPanelView smilesPanelView = new SmilesPanelView(fragment, c11458d25, false, false, (InterfaceC10258bL6) null, false, 16, (ED1) null);
        smilesPanelView.setSmilesKeyboardListener(new i(sa2, ua2));
        return smilesPanelView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(interfaceC11379cu3, "layoutCoordinates");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N0(androidx.compose.ui.e eVar, Fragment fragment, C11458d25 c11458d25, SA2 sa2, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(sa2, "$onBackspaceEmoji");
        AbstractC13042fc3.i(ua2, "$onEmojiSelected");
        L0(eVar, fragment, c11458d25, sa2, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, String str) {
        AbstractC13042fc3.i(ua2, "$onQueryChanged");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isInSearchMode$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$query$delegate");
        AbstractC13042fc3.i(str, "it");
        M(interfaceC9102Ym4, !AbstractC20762sZ6.n0(str));
        V(interfaceC9102Ym42, str);
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(final List list, List list2, UA2 ua2, UA2 ua22, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$filteredPeers");
        AbstractC13042fc3.i(list2, "$selectedPeers");
        AbstractC13042fc3.i(ua2, "$onSelectPeer");
        AbstractC13042fc3.i(ua22, "$onRemovePeer");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), new UA2() { // from class: ir.nasim.nw2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC5328Iw2.Q(list, ((Integer) obj).intValue());
            }
        }, null, AbstractC19242q11.c(1280894903, true, new a(list, list2, ua2, ua22)), 4, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Q(List list, int i2) {
        AbstractC13042fc3.i(list, "$filteredPeers");
        return Integer.valueOf(((C7947Tw2) list.get(i2)).c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(final List list, int i2, List list2, UA2 ua2, UA2 ua22, InterfaceC4369Ev3 interfaceC4369Ev3) {
        AbstractC13042fc3.i(list, "$peersArray");
        AbstractC13042fc3.i(list2, "$selectedPeers");
        AbstractC13042fc3.i(ua2, "$onRemovePeer");
        AbstractC13042fc3.i(ua22, "$onSelectPeer");
        AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
        InterfaceC4369Ev3.b(interfaceC4369Ev3, null, null, null, AbstractC19242q11.c(1959576708, true, new b(i2, list2, ua2, ua22)), 7, null);
        InterfaceC4369Ev3.h(interfaceC4369Ev3, list.size(), new UA2() { // from class: ir.nasim.cw2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC5328Iw2.S(list, ((Integer) obj).intValue());
            }
        }, null, null, AbstractC19242q11.c(1284513067, true, new c(list, list2, ua2, ua22)), 12, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object S(List list, int i2) {
        AbstractC13042fc3.i(list, "$peersArray");
        return Integer.valueOf(((C7947Tw2) list.get(i2)).c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T(List list, List list2, UA2 ua2, UA2 ua22, UA2 ua23, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(list, "$selectedPeers");
        AbstractC13042fc3.i(list2, "$peersArray");
        AbstractC13042fc3.i(ua2, "$onSelectPeer");
        AbstractC13042fc3.i(ua22, "$onRemovePeer");
        AbstractC13042fc3.i(ua23, "$onQueryChanged");
        L(list, list2, ua2, ua22, ua23, i2, interfaceC22053ub1, QJ5.a(i3 | 1));
        return C19938rB7.a;
    }

    private static final void T0(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.vw2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return AbstractC5328Iw2.U0(view, view2, motionEvent);
            }
        });
    }

    private static final String U(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean U0(android.view.View r2, android.view.View r3, android.view.MotionEvent r4) {
        /*
            java.lang.String r3 = "$this_ignoreBottomSheetScroll"
            ir.nasim.AbstractC13042fc3.i(r2, r3)
            int r3 = r4.getAction()
            r4 = 0
            if (r3 == 0) goto L2a
            r0 = 1
            if (r3 == r0) goto L20
            r1 = 2
            if (r3 == r1) goto L16
            r0 = 3
            if (r3 == r0) goto L20
            goto L33
        L16:
            android.view.ViewParent r2 = r2.getParent()
            if (r2 == 0) goto L33
            r2.requestDisallowInterceptTouchEvent(r0)
            goto L33
        L20:
            android.view.ViewParent r2 = r2.getParent()
            if (r2 == 0) goto L33
            r2.requestDisallowInterceptTouchEvent(r4)
            goto L33
        L2a:
            android.view.ViewParent r2 = r2.getParent()
            if (r2 == 0) goto L33
            r2.requestDisallowInterceptTouchEvent(r4)
        L33:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5328Iw2.U0(android.view.View, android.view.View, android.view.MotionEvent):boolean");
    }

    private static final void V(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    public static final boolean V0(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(1282195645);
        A98 a98B = AbstractC24416ya8.b(A98.a, interfaceC22053ub1, 6);
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        interfaceC22053ub1.W(1875034953);
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        interfaceC22053ub1.Q();
        interfaceC22053ub1.W(1875037186);
        boolean zV = interfaceC22053ub1.V(a98B) | interfaceC22053ub1.V(wh1);
        Object objB2 = interfaceC22053ub1.B();
        if (zV || objB2 == aVar.a()) {
            objB2 = new j(a98B, wh1, interfaceC9102Ym4, null);
            interfaceC22053ub1.s(objB2);
        }
        interfaceC22053ub1.Q();
        AbstractC10721c52.e(a98B, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
        boolean zW0 = W0(interfaceC9102Ym4);
        interfaceC22053ub1.Q();
        return zW0;
    }

    private static final boolean W(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final boolean W0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void X(androidx.compose.ui.e r45, final java.lang.String r46, final ir.nasim.UA2 r47, final ir.nasim.SA2 r48, ir.nasim.SA2 r49, final ir.nasim.SA2 r50, java.lang.String r51, final int r52, ir.nasim.InterfaceC22053ub1 r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5328Iw2.X(androidx.compose.ui.e, java.lang.String, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, java.lang.String, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void a0(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onSendClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditText c0(ContextThemeWrapper contextThemeWrapper, String str, String str2, final SA2 sa2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, Context context) {
        AbstractC13042fc3.i(contextThemeWrapper, "$context");
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(sa2, "$onDismissEmojiPanel");
        AbstractC13042fc3.i(ua2, "$onTextChange");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isUpdatingText$delegate");
        AbstractC13042fc3.i(context, "it");
        EditText editText = new EditText(contextThemeWrapper);
        editText.setText(str);
        editText.setHint(str2);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.rw2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                AbstractC5328Iw2.d0(sa2, view, z);
            }
        });
        editText.setTextSize(2, 16.0f);
        editText.setBackgroundColor(0);
        editText.setPadding(0, 0, 0, 0);
        editText.setSingleLine(false);
        editText.setMaxLines(6);
        editText.setMinLines(1);
        editText.setTextAppearance(AbstractC23035wE5.TextAppearance_Bale_BodySmall_13_Regular);
        editText.setHintTextColor(OY0.b(contextThemeWrapper, AbstractC12790fA5.n200));
        editText.setTextColor(OY0.b(contextThemeWrapper, AbstractC12790fA5.n500));
        editText.setTypeface(C6011Lu2.k());
        editText.setGravity(8388659);
        editText.setVerticalScrollBarEnabled(false);
        editText.setHorizontalScrollBarEnabled(false);
        editText.setInputType(180225);
        editText.setTextSize(13.0f);
        editText.setMovementMethod(ScrollingMovementMethod.getInstance());
        editText.setOverScrollMode(0);
        F62 f62 = new F62(editText);
        editText.setTag(f62);
        editText.addTextChangedListener(f62);
        T0(editText);
        editText.addTextChangedListener(new d(ua2, editText, interfaceC9102Ym4));
        return editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(SA2 sa2, View view, boolean z) {
        AbstractC13042fc3.i(sa2, "$onDismissEmojiPanel");
        if (z) {
            sa2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e0(String str, InterfaceC9102Ym4 interfaceC9102Ym4, EditText editText) {
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isUpdatingText$delegate");
        AbstractC13042fc3.i(editText, "editText");
        if (!AbstractC13042fc3.d(editText.getText().toString(), str) && !Z(interfaceC9102Ym4)) {
            a0(interfaceC9102Ym4, true);
            editText.setText(str);
            editText.setSelection(str.length());
            a0(interfaceC9102Ym4, false);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f0(InterfaceC20600sH6 interfaceC20600sH6, ContextThemeWrapper contextThemeWrapper, IBinder iBinder, SA2 sa2) {
        AbstractC13042fc3.i(contextThemeWrapper, "$context");
        if (interfaceC20600sH6 != null) {
            interfaceC20600sH6.b();
        }
        Object systemService = contextThemeWrapper.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 2);
        }
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g0(androidx.compose.ui.e eVar, String str, UA2 ua2, SA2 sa2, SA2 sa22, SA2 sa23, String str2, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(ua2, "$onTextChange");
        AbstractC13042fc3.i(sa2, "$onSendClick");
        AbstractC13042fc3.i(sa23, "$onDismissEmojiPanel");
        X(eVar, str, ua2, sa2, sa22, sa23, str2, i2, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(boolean z, final boolean z2, final SA2 sa2, final C7947Tw2 c7947Tw2, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        boolean z3;
        int i4;
        e.a aVar;
        final boolean z4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-344102031);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            z3 = z;
        } else if ((i2 & 6) == 0) {
            z3 = z;
            i4 = (interfaceC22053ub1J.a(z3) ? 4 : 2) | i2;
        } else {
            z3 = z;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.a(z2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= (i2 & 4096) == 0 ? interfaceC22053ub1J.V(c7947Tw2) : interfaceC22053ub1J.D(c7947Tw2) ? 2048 : 1024;
        }
        int i6 = i4;
        if ((i6 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            z4 = z3;
        } else {
            boolean z5 = i5 != 0 ? false : z3;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c7947Tw2.a(), null, false, 0, interfaceC22053ub1J, 0, 14);
            e.a aVar2 = androidx.compose.ui.e.a;
            float f2 = 4;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.y(aVar2, C17784nZ1.q(80)), 0.0f, C17784nZ1.q(f2), 0.0f, C17784nZ1.q(8), 5, null);
            interfaceC22053ub1J.W(-982598657);
            boolean z6 = (i6 & 896) == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z6 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.tw2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5328Iw2.i0(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarE = SP6.E(eVarM, (SA2) objB);
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), aVar3.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarE);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE2, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar2);
            SA2 sa2A2 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE3, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            if (z5) {
                interfaceC22053ub1J.W(-1660002004);
                aVar = aVar2;
                AbstractC24077y03.a(XQ7.b(C12700f33.k, AbstractC15208jB5.ic_saved_message, interfaceC22053ub1J, 6), "", androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(50)), C24381yX0.b.i(), interfaceC22053ub1J, 3504, 0);
                interfaceC22053ub1J.Q();
            } else {
                aVar = aVar2;
                interfaceC22053ub1J.W(-1659708713);
                TU.m(ev4H, new UU(false, null, null, null, c7947Tw2.d(), 0, false, WKSRecord.Service.SUNRPC, null), null, C17784nZ1.q(50), 0.0f, 0.0f, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 116);
                interfaceC22053ub1J.Q();
            }
            interfaceC22053ub1J.W(1886133117);
            if (z2) {
                AbstractC24077y03.a(XQ7.b(C12700f33.k, AbstractC15208jB5.select_check_box, interfaceC22053ub1J, 6), "Selected", hVar.h(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(24)), aVar3.d()), C24381yX0.b.i(), interfaceC22053ub1J, 3120, 0);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            String strD = c7947Tw2.d();
            float f3 = 6;
            androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(aVar, C17784nZ1.q(f3), C17784nZ1.q(f2), C17784nZ1.q(f3), 0.0f, 8, null);
            int iA3 = C6399Nk7.b.a();
            G10 g10 = G10.a;
            int i7 = G10.b;
            AbstractC9339Zm7.b(strD, eVarM2, g10.a(interfaceC22053ub1J, i7).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(iA3), 0L, AbstractC23365wn7.a.b(), false, 2, 0, null, g10.d(interfaceC22053ub1J, i7).d(), interfaceC22053ub1J, 0, 3120, 54776);
            interfaceC22053ub1J.u();
            z4 = z5;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.uw2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5328Iw2.j0(z4, z2, sa2, c7947Tw2, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j0(boolean z, boolean z2, SA2 sa2, C7947Tw2 c7947Tw2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(sa2, "$onClick");
        AbstractC13042fc3.i(c7947Tw2, "$forwardPeer");
        h0(z, z2, sa2, c7947Tw2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k0(final java.lang.String r36, final java.lang.String r37, final ir.nasim.core.modules.profile.entity.Avatar r38, boolean r39, final ir.nasim.UA2 r40, ir.nasim.InterfaceC22053ub1 r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5328Iw2.k0(java.lang.String, java.lang.String, ir.nasim.core.modules.profile.entity.Avatar, boolean, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(UA2 ua2, boolean z) {
        AbstractC13042fc3.i(ua2, "$onSelectChange");
        ua2.invoke(Boolean.valueOf(!z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(String str, String str2, Avatar avatar, boolean z, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(ua2, "$onSelectChange");
        k0(str, str2, avatar, z, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0310  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n0(final boolean r35, androidx.compose.ui.e r36, final ir.nasim.C7947Tw2 r37, final ir.nasim.UA2 r38, ir.nasim.InterfaceC22053ub1 r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 878
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5328Iw2.n0(boolean, androidx.compose.ui.e, ir.nasim.Tw2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0(UA2 ua2, C7947Tw2 c7947Tw2) {
        AbstractC13042fc3.i(ua2, "$onDelete");
        AbstractC13042fc3.i(c7947Tw2, "$peer");
        ua2.invoke(c7947Tw2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p0(boolean z, androidx.compose.ui.e eVar, C7947Tw2 c7947Tw2, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c7947Tw2, "$peer");
        AbstractC13042fc3.i(ua2, "$onDelete");
        n0(z, eVar, c7947Tw2, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void q0(final List list, final boolean z, final boolean z2, final SA2 sa2, final SA2 sa22, final SA2 sa23, final SA2 sa24, final UA2 ua2, final int i2, final UA2 ua22, final Fragment fragment, final C11458d25 c11458d25, InterfaceC22053ub1 interfaceC22053ub1, final int i3, final int i4) {
        int i5;
        int i6;
        InterfaceC22053ub1 interfaceC22053ub12;
        C19391qG6 c19391qG6;
        String str;
        final InterfaceC9102Ym4 interfaceC9102Ym4;
        final InterfaceC9102Ym4 interfaceC9102Ym42;
        AbstractC13042fc3.i(list, "selectedPeers");
        AbstractC13042fc3.i(sa2, "onDismiss");
        AbstractC13042fc3.i(sa22, "onCopyClicked");
        AbstractC13042fc3.i(sa23, "sharePost");
        AbstractC13042fc3.i(sa24, "addPostToStory");
        AbstractC13042fc3.i(ua2, "onRemovePeer");
        AbstractC13042fc3.i(ua22, "doForward");
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(c11458d25, "peer");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1639455532);
        if ((i3 & 6) == 0) {
            i5 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= interfaceC22053ub1J.a(z2) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i5 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= interfaceC22053ub1J.D(sa22) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i5 |= interfaceC22053ub1J.D(sa23) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i5 |= interfaceC22053ub1J.D(sa24) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= interfaceC22053ub1J.D(ua2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= interfaceC22053ub1J.e(i2) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= interfaceC22053ub1J.D(ua22) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (interfaceC22053ub1J.D(fragment) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= interfaceC22053ub1J.D(c11458d25) ? 32 : 16;
        }
        if ((i5 & 306783379) == 306783378 && (i6 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
            interfaceC22053ub1J.W(591132741);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new C19391qG6();
                interfaceC22053ub1J.s(objB2);
            }
            final C19391qG6 c19391qG62 = (C19391qG6) objB2;
            interfaceC22053ub1J.Q();
            final String strC = UY6.c(DD5.toast_post_link_success, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(591136836);
            Object objB3 = interfaceC22053ub1J.B();
            int i7 = i6;
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d("", null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(591138727);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB4);
            }
            InterfaceC9102Ym4 interfaceC9102Ym44 = (InterfaceC9102Ym4) objB4;
            interfaceC22053ub1J.Q();
            boolean zV0 = V0(interfaceC22053ub1J, 0);
            Boolean boolValueOf = Boolean.valueOf(zV0);
            interfaceC22053ub1J.W(591143020);
            boolean zA = interfaceC22053ub1J.a(zV0);
            Object objB5 = interfaceC22053ub1J.B();
            if (zA || objB5 == aVar.a()) {
                objB5 = new e(zV0, interfaceC9102Ym44, null);
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB5, interfaceC22053ub1J, 0);
            if (list.isEmpty() && z2) {
                interfaceC22053ub1J.W(1145744021);
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.ui.e.a, G10.a.a(interfaceC22053ub1J, G10.b).r(), null, 2, null);
                interfaceC22053ub1J.W(591151882);
                boolean zD = ((i5 & 57344) == 16384) | interfaceC22053ub1J.D(interfaceC20315ro1) | interfaceC22053ub1J.V(strC);
                Object objB6 = interfaceC22053ub1J.B();
                if (zD || objB6 == aVar.a()) {
                    objB6 = new SA2() { // from class: ir.nasim.Wv2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5328Iw2.F0(sa22, interfaceC20315ro1, c19391qG62, strC);
                        }
                    };
                    interfaceC22053ub1J.s(objB6);
                }
                interfaceC22053ub1J.Q();
                interfaceC22053ub12 = interfaceC22053ub1J;
                c19391qG6 = c19391qG62;
                J0(eVarD, z, (SA2) objB6, sa24, sa23, interfaceC22053ub12, (57344 & (i5 >> 3)) | (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i5 >> 9) & 7168));
                interfaceC22053ub12.Q();
                str = strC;
            } else {
                interfaceC22053ub12 = interfaceC22053ub1J;
                c19391qG6 = c19391qG62;
                if (!list.isEmpty()) {
                    interfaceC22053ub12.W(1146611060);
                    e.a aVar2 = androidx.compose.ui.e.a;
                    G10 g10 = G10.a;
                    int i8 = G10.b;
                    androidx.compose.ui.e eVarD2 = androidx.compose.foundation.b.d(aVar2, g10.a(interfaceC22053ub12, i8).r(), null, 2, null);
                    C24254yJ c24254yJ = C24254yJ.a;
                    InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), InterfaceC12529em.a.k(), interfaceC22053ub12, 0);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub12.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub12, eVarD2);
                    InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                    str = strC;
                    SA2 sa2A = aVar3.a();
                    if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub12.G();
                    if (interfaceC22053ub12.h()) {
                        interfaceC22053ub12.g(sa2A);
                    } else {
                        interfaceC22053ub12.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub12);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                    C9784aZ0 c9784aZ0 = C9784aZ0.a;
                    MY2.b(null, null, g10.a(interfaceC22053ub12, i8).A(), interfaceC22053ub12, 0, 3);
                    ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(4)), interfaceC22053ub12, 6);
                    float f2 = 8;
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, C17784nZ1.q(f2), C17784nZ1.q(f2), C17784nZ1.q(f2), 0.0f, 8, null);
                    C24254yJ.f fVarO = c24254yJ.o(C17784nZ1.q(f2));
                    interfaceC22053ub12.W(1417505866);
                    boolean zD2 = interfaceC22053ub12.D(list) | ((234881024 & i5) == 67108864) | ((29360128 & i5) == 8388608);
                    Object objB7 = interfaceC22053ub12.B();
                    if (zD2 || objB7 == aVar.a()) {
                        objB7 = new UA2() { // from class: ir.nasim.hw2
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC5328Iw2.u0(list, i2, ua2, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub12.s(objB7);
                    }
                    interfaceC22053ub12.Q();
                    AbstractC12623ev3.d(eVarM, null, null, false, fVarO, null, null, true, null, (UA2) objB7, interfaceC22053ub12, 12607488, 366);
                    ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(f2)), interfaceC22053ub12, 6);
                    MY2.b(null, null, g10.a(interfaceC22053ub12, i8).A(), interfaceC22053ub12, 0, 3);
                    ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(f2)), interfaceC22053ub12, 6);
                    String strB0 = B0(interfaceC9102Ym43);
                    int size = list.size();
                    interfaceC22053ub12.W(1417529816);
                    Object objB8 = interfaceC22053ub12.B();
                    if (objB8 == aVar.a()) {
                        interfaceC9102Ym4 = interfaceC9102Ym43;
                        objB8 = new UA2() { // from class: ir.nasim.sw2
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC5328Iw2.w0(interfaceC9102Ym4, (String) obj);
                            }
                        };
                        interfaceC22053ub12.s(objB8);
                    } else {
                        interfaceC9102Ym4 = interfaceC9102Ym43;
                    }
                    UA2 ua23 = (UA2) objB8;
                    interfaceC22053ub12.Q();
                    interfaceC22053ub12.W(1417532510);
                    boolean z3 = (1879048192 & i5) == 536870912;
                    Object objB9 = interfaceC22053ub12.B();
                    if (z3 || objB9 == aVar.a()) {
                        objB9 = new SA2() { // from class: ir.nasim.Aw2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC5328Iw2.x0(ua22, interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub12.s(objB9);
                    }
                    SA2 sa25 = (SA2) objB9;
                    interfaceC22053ub12.Q();
                    interfaceC22053ub12.W(1417535436);
                    Object objB10 = interfaceC22053ub12.B();
                    if (objB10 == aVar.a()) {
                        interfaceC9102Ym42 = interfaceC9102Ym44;
                        objB10 = new SA2() { // from class: ir.nasim.Bw2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC5328Iw2.y0(interfaceC9102Ym42);
                            }
                        };
                        interfaceC22053ub12.s(objB10);
                    } else {
                        interfaceC9102Ym42 = interfaceC9102Ym44;
                    }
                    SA2 sa26 = (SA2) objB10;
                    interfaceC22053ub12.Q();
                    interfaceC22053ub12.W(1417539078);
                    Object objB11 = interfaceC22053ub12.B();
                    if (objB11 == aVar.a()) {
                        objB11 = new SA2() { // from class: ir.nasim.Cw2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC5328Iw2.z0(interfaceC9102Ym42);
                            }
                        };
                        interfaceC22053ub12.s(objB11);
                    }
                    interfaceC22053ub12.Q();
                    X(aVar2, strB0, ua23, sa25, sa26, (SA2) objB11, null, size, interfaceC22053ub12, 221574, 64);
                    interfaceC22053ub12.W(1417546383);
                    boolean z4 = (i5 & 7168) == 2048;
                    Object objB12 = interfaceC22053ub12.B();
                    if (z4 || objB12 == aVar.a()) {
                        objB12 = new SA2() { // from class: ir.nasim.Dw2
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC5328Iw2.r0(sa2, interfaceC9102Ym42);
                            }
                        };
                        interfaceC22053ub12.s(objB12);
                    }
                    interfaceC22053ub12.Q();
                    UV.a(false, (SA2) objB12, interfaceC22053ub12, 0, 1);
                    interfaceC22053ub12.W(1417552824);
                    if (D0(interfaceC9102Ym42)) {
                        androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
                        interfaceC22053ub12.W(1417559479);
                        Object objB13 = interfaceC22053ub12.B();
                        if (objB13 == aVar.a()) {
                            objB13 = new SA2() { // from class: ir.nasim.Ew2
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return Boolean.valueOf(AbstractC5328Iw2.s0(interfaceC9102Ym4));
                                }
                            };
                            interfaceC22053ub12.s(objB13);
                        }
                        SA2 sa27 = (SA2) objB13;
                        interfaceC22053ub12.Q();
                        interfaceC22053ub12.W(1417572321);
                        Object objB14 = interfaceC22053ub12.B();
                        if (objB14 == aVar.a()) {
                            objB14 = new UA2() { // from class: ir.nasim.Fw2
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return AbstractC5328Iw2.t0(interfaceC9102Ym4, (String) obj);
                                }
                            };
                            interfaceC22053ub12.s(objB14);
                        }
                        interfaceC22053ub12.Q();
                        int i9 = i7 << 3;
                        L0(eVarH, fragment, c11458d25, sa27, (UA2) objB14, interfaceC22053ub12, (i9 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 27654 | (i9 & 896));
                    }
                    interfaceC22053ub12.Q();
                    interfaceC22053ub12.u();
                    interfaceC22053ub12.Q();
                } else {
                    str = strC;
                    interfaceC22053ub12.W(1149202877);
                    interfaceC22053ub12.Q();
                }
            }
            AbstractC18209oG6.b(c19391qG6, androidx.compose.ui.e.a, AbstractC19242q11.e(-954220417, true, new h(str), interfaceC22053ub12, 54), interfaceC22053ub12, 438, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Gw2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5328Iw2.A0(list, z, z2, sa2, sa22, sa23, sa24, ua2, i2, ua22, fragment, c11458d25, i3, i4, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r0(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(sa2, "$onDismiss");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showEmojiPanel$delegate");
        if (D0(interfaceC9102Ym4)) {
            E0(interfaceC9102Ym4, false);
        } else {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$message$delegate");
        if (B0(interfaceC9102Ym4).length() > 0) {
            C0(interfaceC9102Ym4, R62.a.H(AbstractC22039uZ6.u1(B0(interfaceC9102Ym4))) ? AbstractC22039uZ6.r1(B0(interfaceC9102Ym4), 2) : AbstractC22039uZ6.r1(B0(interfaceC9102Ym4), 1));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$message$delegate");
        AbstractC13042fc3.i(str, "it");
        C0(interfaceC9102Ym4, B0(interfaceC9102Ym4) + str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(final List list, int i2, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$selectedPeers");
        AbstractC13042fc3.i(ua2, "$onRemovePeer");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyRow");
        InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), new UA2() { // from class: ir.nasim.ow2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC5328Iw2.v0(list, ((Integer) obj).intValue());
            }
        }, null, AbstractC19242q11.c(607369118, true, new g(list, i2, ua2)), 4, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object v0(List list, int i2) {
        AbstractC13042fc3.i(list, "$selectedPeers");
        return Integer.valueOf(((C7947Tw2) list.get(i2)).c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$message$delegate");
        AbstractC13042fc3.i(str, "it");
        C0(interfaceC9102Ym4, str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x0(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(ua2, "$doForward");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$message$delegate");
        ua2.invoke(B0(interfaceC9102Ym4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showEmojiPanel$delegate");
        E0(interfaceC9102Ym4, !D0(interfaceC9102Ym4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showEmojiPanel$delegate");
        if (D0(interfaceC9102Ym4)) {
            E0(interfaceC9102Ym4, false);
        }
        return C19938rB7.a;
    }

    /* renamed from: ir.nasim.Iw2$d */
    public static final class d implements TextWatcher {
        final /* synthetic */ UA2 a;
        final /* synthetic */ EditText b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        d(UA2 ua2, EditText editText, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = ua2;
            this.b = editText;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(EditText editText) {
            int lineBottom;
            AbstractC13042fc3.i(editText, "$this_apply");
            Layout layout = editText.getLayout();
            if (layout == null || (lineBottom = (layout.getLineBottom(layout.getLineForOffset(editText.getSelectionEnd())) - editText.getHeight()) + editText.getPaddingTop() + editText.getPaddingBottom()) <= 0) {
                return;
            }
            editText.scrollTo(0, lineBottom);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string;
            if (!AbstractC5328Iw2.Z(this.c)) {
                UA2 ua2 = this.a;
                if (editable == null || (string = editable.toString()) == null) {
                    string = "";
                }
                ua2.invoke(string);
            }
            final EditText editText = this.b;
            editText.post(new Runnable() { // from class: ir.nasim.Lw2
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC5328Iw2.d.b(editText);
                }
            });
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
