package ir.nasim.features.smiles.panel;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20423rz2;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.BC5;
import ir.nasim.BF6;
import ir.nasim.C10600bs7;
import ir.nasim.C11458d25;
import ir.nasim.C16731lm1;
import ir.nasim.C18111o62;
import ir.nasim.C19938rB7;
import ir.nasim.C6011Lu2;
import ir.nasim.C6246Mu3;
import ir.nasim.C7183Qq;
import ir.nasim.CF6;
import ir.nasim.D20;
import ir.nasim.DF6;
import ir.nasim.ED1;
import ir.nasim.EF6;
import ir.nasim.EnumC4196Ec1;
import ir.nasim.FF6;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.KH2;
import ir.nasim.OY0;
import ir.nasim.QF6;
import ir.nasim.SA2;
import ir.nasim.W25;
import ir.nasim.XV4;
import ir.nasim.features.smiles.panel.SmilesPanelView;
import ir.nasim.features.smiles.panel.sticker.StickerPagerFragment;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002%*BY\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013BG\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u0019*\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0019H\u0014¢\u0006\u0004\b,\u0010\"J\u000f\u0010-\u001a\u00020\u0019H\u0014¢\u0006\u0004\b-\u0010\"J\r\u0010.\u001a\u00020\n¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b*\u00103\u001a\u0004\b\u0010\u0010/R\u001a\u00108\u001a\u0002048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b6\u00107R&\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010@\u001a\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u00103R\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010@\u001a\u0004\bV\u0010WR$\u0010`\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010h\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u00103R\u0016\u0010p\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u00103R0\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00190q2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00190q8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v¨\u0006y"}, d2 = {"Lir/nasim/features/smiles/panel/SmilesPanelView;", "Landroid/widget/FrameLayout;", "Lir/nasim/EF6;", "Lir/nasim/oz3;", "Lir/nasim/d25;", "peer", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "showStickerPage", "showGifPage", "Lir/nasim/bL6;", "Lir/nasim/FF6;", "smilesPanelState", "isCommentChat", "forcedNightMode", "<init>", "(Lir/nasim/d25;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;ZZLir/nasim/bL6;ZZ)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;Lir/nasim/d25;ZZLir/nasim/bL6;Z)V", "", "time", "Lir/nasim/rB7;", "y", "(I)V", "Landroidx/viewpager2/widget/ViewPager2;", "A", "(Landroidx/viewpager2/widget/ViewPager2;)V", "setup", "(Landroidx/fragment/app/FragmentManager;)V", "B", "()V", "show", "animated", "c", "(ZZ)V", "a", "(Z)V", "lifecycleOwner", "b", "(Lir/nasim/oz3;)V", "onAttachedToWindow", "onDetachedFromWindow", "w", "()Z", "Lir/nasim/d25;", "getPeer", "()Lir/nasim/d25;", "Z", "Landroidx/lifecycle/p;", "Landroidx/lifecycle/p;", "getLifecycle", "()Landroidx/lifecycle/p;", "lifecycle", "", "Lir/nasim/XV4;", "d", "Ljava/util/List;", "smilesTabIcons", "Lir/nasim/o62;", "e", "Lir/nasim/Yu3;", "getEmojiFragment", "()Lir/nasim/o62;", "emojiFragment", "Lir/nasim/KH2;", "f", "getGifFragment", "()Lir/nasim/KH2;", "gifFragment", "Lir/nasim/features/smiles/panel/sticker/StickerPagerFragment;", "g", "getStickerFragment", "()Lir/nasim/features/smiles/panel/sticker/StickerPagerFragment;", "stickerFragment", "Landroid/animation/AnimatorSet;", "h", "Landroid/animation/AnimatorSet;", "bottomTabContainerAnimation", "i", "isBottomViewVisible", "Lir/nasim/Mu3;", "j", "getBinding", "()Lir/nasim/Mu3;", "binding", "Lir/nasim/CF6;", "k", "Lir/nasim/CF6;", "getSmilesKeyboardListener", "()Lir/nasim/CF6;", "setSmilesKeyboardListener", "(Lir/nasim/CF6;)V", "smilesKeyboardListener", "Lir/nasim/BF6;", "l", "Lir/nasim/BF6;", "getSmilesActionListener", "()Lir/nasim/BF6;", "setSmilesActionListener", "(Lir/nasim/BF6;)V", "smilesActionListener", "Lir/nasim/lm1;", "m", "Lir/nasim/lm1;", "contextThemeWrapper", "n", "backspacePressed", "o", "backspaceOnce", "Lkotlin/Function0;", "value", "p", "Lir/nasim/SA2;", "getOnClose", "()Lir/nasim/SA2;", "onClose", "q", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class SmilesPanelView extends FrameLayout implements EF6, InterfaceC18633oz3 {
    public static final int r = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final C11458d25 peer;

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean isCommentChat;

    /* renamed from: c, reason: from kotlin metadata */
    private final p lifecycle;

    /* renamed from: d, reason: from kotlin metadata */
    private final List smilesTabIcons;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 emojiFragment;

    /* renamed from: f, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 gifFragment;

    /* renamed from: g, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 stickerFragment;

    /* renamed from: h, reason: from kotlin metadata */
    private AnimatorSet bottomTabContainerAnimation;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isBottomViewVisible;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 binding;

    /* renamed from: k, reason: from kotlin metadata */
    private CF6 smilesKeyboardListener;

    /* renamed from: l, reason: from kotlin metadata */
    private BF6 smilesActionListener;

    /* renamed from: m, reason: from kotlin metadata */
    private C16731lm1 contextThemeWrapper;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean backspacePressed;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean backspaceOnce;

    /* renamed from: p, reason: from kotlin metadata */
    private SA2 onClose;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC10258bL6 d;

        /* renamed from: ir.nasim.features.smiles.panel.SmilesPanelView$a$a, reason: collision with other inner class name */
        static final class C1229a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ SmilesPanelView d;

            /* renamed from: ir.nasim.features.smiles.panel.SmilesPanelView$a$a$a, reason: collision with other inner class name */
            static final class C1230a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ SmilesPanelView d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1230a(SmilesPanelView smilesPanelView, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = smilesPanelView;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1230a c1230a = new C1230a(this.d, interfaceC20295rm1);
                    c1230a.c = obj;
                    return c1230a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    FF6 ff6 = (FF6) this.c;
                    this.d.getBinding().f.setCurrentItem(!ff6.d() ? ff6.c().ordinal() : QF6.b.ordinal(), false);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FF6 ff6, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1230a) create(ff6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1229a(InterfaceC10258bL6 interfaceC10258bL6, SmilesPanelView smilesPanelView, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = smilesPanelView;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1229a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                    if (interfaceC10258bL6 != null) {
                        C1230a c1230a = new C1230a(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6, c1230a, this) == objE) {
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
                return ((C1229a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SmilesPanelView.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                p lifecycle = SmilesPanelView.this.getLifecycle();
                j.b bVar = j.b.STARTED;
                C1229a c1229a = new C1229a(this.d, SmilesPanelView.this, null);
                this.b = 1;
                if (w.a(lifecycle, bVar, c1229a, this) == objE) {
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public final class c extends AbstractC20423rz2 {
        final /* synthetic */ SmilesPanelView l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SmilesPanelView smilesPanelView, FragmentManager fragmentManager) {
            super(fragmentManager, smilesPanelView.getLifecycle());
            AbstractC13042fc3.i(fragmentManager, "fragmentManager");
            this.l = smilesPanelView;
        }

        @Override // ir.nasim.AbstractC20423rz2
        public Fragment B(int i) {
            return i != 0 ? i != 1 ? i != 2 ? new Fragment(AbstractC12208eD5.fragment_chat_empty) : this.l.getGifFragment() : this.l.getStickerFragment() : this.l.getEmojiFragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return this.l.smilesTabIcons.size();
        }
    }

    public static final class d implements TabLayout.d {
        d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            View viewE;
            TextView textView;
            if (gVar != null && (viewE = gVar.e()) != null && (textView = (TextView) viewE.findViewById(BC5.txt_title)) != null) {
                textView.setTextColor(OY0.b(SmilesPanelView.this.contextThemeWrapper, AbstractC21139tA5.colorPrimary));
            }
            Integer numValueOf = gVar != null ? Integer.valueOf(gVar.h()) : null;
            int iOrdinal = QF6.b.ordinal();
            if (numValueOf != null && numValueOf.intValue() == iOrdinal) {
                AbstractC14828iY7.n(SmilesPanelView.this.getBinding().b, true, false);
                return;
            }
            int iOrdinal2 = QF6.c.ordinal();
            if (numValueOf != null && numValueOf.intValue() == iOrdinal2) {
                AbstractC14828iY7.h(SmilesPanelView.this.getBinding().b, true, false);
                return;
            }
            int iOrdinal3 = QF6.d.ordinal();
            if (numValueOf != null && numValueOf.intValue() == iOrdinal3) {
                AbstractC14828iY7.h(SmilesPanelView.this.getBinding().b, true, false);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            View viewE;
            TextView textView;
            if (gVar == null || (viewE = gVar.e()) == null || (textView = (TextView) viewE.findViewById(BC5.txt_title)) == null) {
                return;
            }
            textView.setTextColor(OY0.b(SmilesPanelView.this.contextThemeWrapper, AbstractC21139tA5.n400));
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public /* synthetic */ SmilesPanelView(C11458d25 c11458d25, Context context, FragmentManager fragmentManager, boolean z, boolean z2, InterfaceC10258bL6 interfaceC10258bL6, boolean z3, boolean z4, int i, ED1 ed1) {
        this(c11458d25, context, fragmentManager, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? null : interfaceC10258bL6, z3, (i & 128) != 0 ? false : z4);
    }

    private final void A(ViewPager2 viewPager2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = ViewPager2.class.getDeclaredField("j");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(viewPager2);
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) obj;
        Field declaredField2 = RecyclerView.class.getDeclaredField("O0");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(recyclerView);
        AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Int");
        declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(SmilesPanelView smilesPanelView, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        if (motionEvent.getAction() == 0) {
            smilesPanelView.backspacePressed = true;
            smilesPanelView.backspaceOnce = false;
            smilesPanelView.y(350);
            smilesPanelView.getBinding().b.setPressed(true);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            smilesPanelView.backspacePressed = false;
            if (!smilesPanelView.backspaceOnce) {
                view.performHapticFeedback(3);
                CF6 cf6 = smilesPanelView.smilesKeyboardListener;
                if (cf6 != null) {
                    cf6.a();
                }
            }
            smilesPanelView.getBinding().b.setPressed(false);
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final SmilesPanelView smilesPanelView, TabLayout.g gVar, final int i) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        AbstractC13042fc3.i(gVar, "tab");
        View viewInflate = LayoutInflater.from(smilesPanelView.getContext()).inflate(AbstractC12208eD5.smiles_tab_item_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(BC5.txt_title);
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(OY0.b(smilesPanelView.contextThemeWrapper, AbstractC21139tA5.n400));
        textView.setText(((Number) ((XV4) smilesPanelView.smilesTabIcons.get(i)).f()).intValue());
        if (i == QF6.c.ordinal() && AbstractC5969Lp4.d().w0(EnumC4196Ec1.z)) {
            Drawable drawable = textView.getContext().getDrawable(KB5.ic_watermelon_1x);
            if (drawable != null) {
                drawable.setBounds(0, 0, AbstractC8943Xx1.c(18), AbstractC8943Xx1.c(18));
                C19938rB7 c19938rB7 = C19938rB7.a;
            } else {
                drawable = null;
            }
            textView.setCompoundDrawables(null, null, drawable, null);
            textView.setCompoundDrawablePadding(AbstractC8943Xx1.c(4));
        }
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KF6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmilesPanelView.E(i, smilesPanelView, view);
            }
        });
        gVar.r(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(int i, SmilesPanelView smilesPanelView, View view) {
        CF6 cf6;
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        if (i == QF6.b.ordinal()) {
            CF6 cf62 = smilesPanelView.smilesKeyboardListener;
            if (cf62 != null) {
                cf62.c();
                return;
            }
            return;
        }
        if (i == QF6.c.ordinal()) {
            CF6 cf63 = smilesPanelView.smilesKeyboardListener;
            if (cf63 != null) {
                cf63.e();
            }
            C7183Qq.s().g("HAS_SEEN_YALDA_STICKERS", true);
            return;
        }
        if (i != QF6.d.ordinal() || (cf6 = smilesPanelView.smilesKeyboardListener) == null) {
            return;
        }
        cf6.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(SmilesPanelView smilesPanelView, View view) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        C18111o62 emojiFragment = smilesPanelView.getEmojiFragment();
        if (!(emojiFragment instanceof DF6)) {
            emojiFragment = null;
        }
        if (emojiFragment != null) {
            emojiFragment.o4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerPagerFragment G(SmilesPanelView smilesPanelView, boolean z) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        StickerPagerFragment.Companion companion = StickerPagerFragment.INSTANCE;
        W25 w25S = smilesPanelView.peer.s();
        AbstractC13042fc3.h(w25S, "getPeerType(...)");
        StickerPagerFragment stickerPagerFragmentA = companion.a(w25S, smilesPanelView.peer.getPeerId(), smilesPanelView.isCommentChat, z);
        stickerPagerFragmentA.i9(smilesPanelView.smilesKeyboardListener);
        stickerPagerFragmentA.j9(smilesPanelView);
        return stickerPagerFragmentA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6246Mu3 getBinding() {
        return (C6246Mu3) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C18111o62 getEmojiFragment() {
        return (C18111o62) this.emojiFragment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KH2 getGifFragment() {
        return (KH2) this.gifFragment.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StickerPagerFragment getStickerFragment() {
        return (StickerPagerFragment) this.stickerFragment.getValue();
    }

    private final void setup(FragmentManager fragmentManager) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        ViewPager2 viewPager2 = getBinding().f;
        viewPager2.setAdapter(new c(this, fragmentManager));
        viewPager2.setOffscreenPageLimit(2);
        ViewPager2 viewPager22 = getBinding().f;
        AbstractC13042fc3.h(viewPager22, "vpSmilesPanel");
        A(viewPager22);
        getBinding().b.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.GF6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SmilesPanelView.C(this.a, view, motionEvent);
            }
        });
        getBinding().b.setBackground(AbstractC4310Eo7.h(5.0f));
        getBinding().e.d(new d());
        new com.google.android.material.tabs.d(getBinding().e, getBinding().f, new d.b() { // from class: ir.nasim.HF6
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i) {
                SmilesPanelView.D(this.a, gVar, i);
            }
        }).a();
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IF6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmilesPanelView.F(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6246Mu3 t(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return C6246Mu3.c(LayoutInflater.from(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18111o62 u(boolean z, SmilesPanelView smilesPanelView) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        C18111o62 c18111o62A = C18111o62.INSTANCE.a(z);
        c18111o62A.b9(smilesPanelView.smilesKeyboardListener);
        c18111o62A.a9(smilesPanelView.smilesActionListener);
        c18111o62A.c9(smilesPanelView);
        return c18111o62A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KH2 v(SmilesPanelView smilesPanelView, boolean z) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        KH2.Companion companion = KH2.INSTANCE;
        CF6 cf6 = smilesPanelView.smilesKeyboardListener;
        W25 w25S = smilesPanelView.peer.s();
        AbstractC13042fc3.h(w25S, "getPeerType(...)");
        return companion.a(cf6, smilesPanelView, w25S, smilesPanelView.peer.getPeerId(), smilesPanelView.isCommentChat, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(SmilesPanelView smilesPanelView) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        C18111o62 emojiFragment = smilesPanelView.getEmojiFragment();
        if (!(emojiFragment instanceof DF6)) {
            emojiFragment = null;
        }
        if (emojiFragment != null) {
            emojiFragment.onClose();
        }
        return C19938rB7.a;
    }

    private final void y(final int time) {
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.JF6
            @Override // java.lang.Runnable
            public final void run() {
                SmilesPanelView.z(this.a, time);
            }
        }, time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SmilesPanelView smilesPanelView, int i) {
        AbstractC13042fc3.i(smilesPanelView, "this$0");
        if (smilesPanelView.backspacePressed) {
            smilesPanelView.getBinding().b.performHapticFeedback(3);
            CF6 cf6 = smilesPanelView.smilesKeyboardListener;
            if (cf6 != null) {
                cf6.a();
            }
            smilesPanelView.backspaceOnce = true;
            smilesPanelView.y(AbstractC23053wG5.e(50, i - 100));
        }
    }

    public final void B() {
        getEmojiFragment().Y8();
    }

    @Override // ir.nasim.EF6
    public void a(boolean show) {
        AppCompatImageView appCompatImageView = getBinding().c;
        if (show) {
            AbstractC14828iY7.m(appCompatImageView, true);
        } else {
            AbstractC14828iY7.g(appCompatImageView, true);
        }
    }

    @Override // ir.nasim.EF6
    public void b(InterfaceC18633oz3 lifecycleOwner) {
        AbstractC13042fc3.i(lifecycleOwner, "lifecycleOwner");
        D20.a aVarA = C10600bs7.a.a(lifecycleOwner);
        String string = getContext().getString(AbstractC12217eE5.view_new_gifs);
        AbstractC13042fc3.h(string, "getString(...)");
        D20 d20A = aVarA.X1(string).a1(0.5f).u1(RecyclerView.UNDEFINED_DURATION).b2(17).a();
        View childAt = getBinding().e.getChildAt(0);
        AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt2 = ((ViewGroup) childAt).getChildAt(2);
        AbstractC13042fc3.h(childAt2, "getChildAt(...)");
        d20A.J0(childAt2, JF5.g() ? AbstractC8943Xx1.c(4) : AbstractC8943Xx1.c(-4), AbstractC8943Xx1.c(-12));
    }

    @Override // ir.nasim.EF6
    public void c(boolean show, boolean animated) {
        if (show && this.isBottomViewVisible) {
            return;
        }
        if (show || this.isBottomViewVisible) {
            AnimatorSet animatorSet = this.bottomTabContainerAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.bottomTabContainerAnimation = null;
            this.isBottomViewVisible = show;
            if (!animated) {
                getBinding().d.setTranslationY(show ? 0 : AbstractC7426Rr.a.f(50.0f));
                return;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(getBinding().d, (Property<FrameLayout, Float>) FrameLayout.TRANSLATION_Y, show ? 0 : AbstractC7426Rr.a.f(50.0f)));
            animatorSet2.setDuration(200L);
            animatorSet2.setInterpolator(InterpolatorC12631ew1.h);
            animatorSet2.start();
            this.bottomTabContainerAnimation = animatorSet2;
        }
    }

    public final SA2 getOnClose() {
        return this.onClose;
    }

    public final C11458d25 getPeer() {
        return this.peer;
    }

    public final BF6 getSmilesActionListener() {
        return this.smilesActionListener;
    }

    public final CF6 getSmilesKeyboardListener() {
        return this.smilesKeyboardListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycle().i(j.a.ON_START);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        getLifecycle().i(j.a.ON_STOP);
        super.onDetachedFromWindow();
    }

    public final void setSmilesActionListener(BF6 bf6) {
        this.smilesActionListener = bf6;
    }

    public final void setSmilesKeyboardListener(CF6 cf6) {
        this.smilesKeyboardListener = cf6;
    }

    public final boolean w() {
        int currentItem = getBinding().f.getCurrentItem();
        if (currentItem != QF6.b.ordinal()) {
            if (currentItem != QF6.d.ordinal()) {
                return false;
            }
            KH2 gifFragment = getGifFragment();
            AbstractC13042fc3.g(gifFragment, "null cannot be cast to non-null type ir.nasim.features.smiles.panel.SmilesPanelInterface");
            return gifFragment.a();
        }
        C18111o62 emojiFragment = getEmojiFragment();
        if (!(emojiFragment instanceof DF6)) {
            emojiFragment = null;
        }
        if (emojiFragment != null) {
            return emojiFragment.a();
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmilesPanelView(C11458d25 c11458d25, final Context context, FragmentManager fragmentManager, boolean z, boolean z2, InterfaceC10258bL6 interfaceC10258bL6, boolean z3, final boolean z4) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(fragmentManager, "fragmentManager");
        this.peer = c11458d25;
        this.isCommentChat = z3;
        this.lifecycle = new p(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new XV4(Integer.valueOf(KB5.smiles_emoji_pack_1), Integer.valueOf(AbstractC12217eE5.emoji)));
        if (z) {
            arrayList.add(new XV4(Integer.valueOf(KB5.smiles_sticker), Integer.valueOf(AbstractC12217eE5.sticker)));
        }
        if (z2) {
            arrayList.add(new XV4(Integer.valueOf(KB5.smiles_gif_badge), Integer.valueOf(AbstractC12217eE5.gif)));
        }
        this.smilesTabIcons = arrayList;
        this.emojiFragment = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.LF6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SmilesPanelView.u(z4, this);
            }
        });
        this.gifFragment = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.MF6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SmilesPanelView.v(this.a, z4);
            }
        });
        this.stickerFragment = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NF6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SmilesPanelView.G(this.a, z4);
            }
        });
        this.isBottomViewVisible = true;
        this.binding = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.OF6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SmilesPanelView.t(context);
            }
        });
        addView(getBinding().getRoot());
        JF5.b(this);
        this.contextThemeWrapper = new C16731lm1(context, AbstractC23035wE5.Theme_Bale_Base);
        setup(fragmentManager);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new a(interfaceC10258bL6, null), 3, null);
        this.onClose = new SA2() { // from class: ir.nasim.PF6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SmilesPanelView.x(this.a);
            }
        };
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public p getLifecycle() {
        return this.lifecycle;
    }

    public /* synthetic */ SmilesPanelView(Fragment fragment, C11458d25 c11458d25, boolean z, boolean z2, InterfaceC10258bL6 interfaceC10258bL6, boolean z3, int i, ED1 ed1) {
        this(fragment, c11458d25, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : interfaceC10258bL6, z3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SmilesPanelView(Fragment fragment, C11458d25 c11458d25, boolean z, boolean z2, InterfaceC10258bL6 interfaceC10258bL6, boolean z3) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(c11458d25, "peer");
        Context contextS7 = fragment.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        FragmentManager fragmentManagerF5 = fragment.F5();
        AbstractC13042fc3.h(fragmentManagerF5, "getChildFragmentManager(...)");
        this(c11458d25, contextS7, fragmentManagerF5, z2, z, interfaceC10258bL6, z3, false, 128, null);
    }
}
