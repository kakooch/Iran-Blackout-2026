package ir.nasim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC25195zt3;
import ir.nasim.C11669dP1;
import ir.nasim.C24904zP1;
import ir.nasim.NP1;
import ir.nasim.RP1;
import ir.nasim.UO1;
import ir.nasim.components.text.BoundedSizeTextView;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.dailogLists.DialogLastMessage;
import ir.nasim.database.dailogLists.MessageState;
import ir.nasim.dialoglist.data.model.DialogDTO;
import ir.nasim.features.story.avatarwithstory.AvatarWithStory;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import java.io.IOException;

/* renamed from: ir.nasim.dP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11669dP1 extends OT4 {
    public static final b p = new b(null);
    public static final int q = 8;
    private static final a r = new a();
    private final UA2 h;
    private final UA2 i;
    private final InterfaceC14603iB2 j;
    private final UA2 k;
    private final C24904zP1 l;
    private final int m;
    private final int n;
    private final QM1 o;

    /* renamed from: ir.nasim.dP1$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(DialogDTO dialogDTO, DialogDTO dialogDTO2) {
            AbstractC13042fc3.i(dialogDTO, "oldItem");
            AbstractC13042fc3.i(dialogDTO2, "newItem");
            return dialogDTO.isContentEqual(dialogDTO2);
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(DialogDTO dialogDTO, DialogDTO dialogDTO2) {
            AbstractC13042fc3.i(dialogDTO, "old");
            AbstractC13042fc3.i(dialogDTO2, "new");
            return dialogDTO.getPeerUniqueId() == dialogDTO2.getPeerUniqueId();
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object c(DialogDTO dialogDTO, DialogDTO dialogDTO2) {
            AbstractC13042fc3.i(dialogDTO, "oldItem");
            AbstractC13042fc3.i(dialogDTO2, "newItem");
            return dialogDTO.getChangedPayload(dialogDTO2);
        }
    }

    /* renamed from: ir.nasim.dP1$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.dP1$c */
    public final class c extends RecyclerView.C {
        private YI7 A;
        final /* synthetic */ C11669dP1 B;
        private final C12912fO1 u;
        private final Context v;
        private C24904zP1.a w;
        private ValueAnimator x;
        private DialogDTO y;
        private SP1 z;

        /* renamed from: ir.nasim.dP1$c$a */
        public static final class a extends DynamicDrawableSpan {
            final /* synthetic */ C4658Fz7 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C4658Fz7 c4658Fz7) {
                super(0);
                this.a = c4658Fz7;
            }

            @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
            public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
                AbstractC13042fc3.i(canvas, "canvas");
                AbstractC13042fc3.i(paint, "paint");
                C4658Fz7 c4658Fz7 = this.a;
                int iSave = canvas.save();
                try {
                    canvas.translate(f, i4 + paint.getFontMetrics().ascent + (((paint.getFontMetrics().descent - paint.getFontMetrics().ascent) - c4658Fz7.getIntrinsicHeight()) / 2));
                    c4658Fz7.draw(canvas);
                } finally {
                    canvas.restoreToCount(iSave);
                }
            }

            @Override // android.text.style.DynamicDrawableSpan
            public Drawable getDrawable() {
                return this.a;
            }
        }

        /* renamed from: ir.nasim.dP1$c$b */
        public static final class b implements View.OnLayoutChangeListener {
            final /* synthetic */ SA2 a;

            public b(SA2 sa2) {
                this.a = sa2;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view.removeOnLayoutChangeListener(this);
                this.a.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C11669dP1 c11669dP1, C12912fO1 c12912fO1, Context context) {
            super(c12912fO1.getRoot());
            AbstractC13042fc3.i(c12912fO1, "binding");
            AbstractC13042fc3.i(context, "context");
            this.B = c11669dP1;
            this.u = c12912fO1;
            this.v = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A1(TextView textView, int i, CharSequence charSequence) {
            AbstractC13042fc3.i(textView, "$this_setEllipsizedTextWithDrawableSupportSafe");
            AbstractC13042fc3.i(charSequence, "$textToEllipsize");
            float width = textView.getWidth();
            if (width > 0.0f) {
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(charSequence, textView.getPaint(), AbstractC23053wG5.d(((width - i) - textView.getCompoundDrawablePadding()) - textView.getPaint().measureText("…"), 0.0f), TextUtils.TruncateAt.END);
                if (!AbstractC13042fc3.d(textView.getText(), charSequenceEllipsize)) {
                    textView.setText(charSequenceEllipsize);
                }
            }
            return C19938rB7.a;
        }

        private final void B1(boolean z, boolean z2) {
            if (z) {
                this.u.getRoot().setBackgroundColor(OY0.b(this.v, AbstractC13408gA5.primaryOpacity15));
            } else {
                this.u.getRoot().setBackgroundColor(0);
                this.u.getRoot().setBackground(z2 ? AbstractC4043Dl1.f(this.v, AbstractC16390lB5.bg_dialog_list_item_pinned) : AbstractC4043Dl1.f(this.v, AbstractC16390lB5.bg_dialog_list_item));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(C11669dP1 c11669dP1, DialogDTO dialogDTO, View view) {
            AbstractC13042fc3.i(c11669dP1, "this$0");
            AbstractC13042fc3.i(dialogDTO, "$dialog");
            c11669dP1.h.invoke(dialogDTO);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean E1(C11669dP1 c11669dP1, DialogDTO dialogDTO, View view) {
            AbstractC13042fc3.i(c11669dP1, "this$0");
            AbstractC13042fc3.i(dialogDTO, "$dialog");
            UA2 ua2 = c11669dP1.i;
            if (ua2 == null) {
                return false;
            }
            ua2.invoke(dialogDTO);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F1(C11669dP1 c11669dP1, DialogDTO dialogDTO, View view) {
            AbstractC13042fc3.i(c11669dP1, "this$0");
            AbstractC13042fc3.i(dialogDTO, "$dialog");
            c11669dP1.k.invoke(Integer.valueOf((int) dialogDTO.getPeerUniqueId()));
        }

        private final String H1(String str) {
            return JF5.g() ? XY6.e(str) : str;
        }

        private final void I1() {
            C12912fO1 c12912fO1 = this.u;
            c12912fO1.getRoot().setOnClickListener(null);
            c12912fO1.getRoot().setOnLongClickListener(null);
            c12912fO1.b.setOnClickListener(null);
            c12912fO1.s.setOnClickListener(null);
        }

        public static /* synthetic */ void L1(c cVar, String str, int i, Object obj) throws IOException {
            if ((i & 1) != 0) {
                str = null;
            }
            cVar.J1(str);
        }

        private final SpannableStringBuilder M0(SpannableStringBuilder spannableStringBuilder, String str, int i, final SA2 sa2) {
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.append(Separators.SP);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(Separators.SP);
            C4658Fz7 c4658Fz7 = new C4658Fz7(i);
            c4658Fz7.setBounds(0, 0, c4658Fz7.getIntrinsicWidth(), c4658Fz7.getIntrinsicHeight());
            spannableStringBuilder.setSpan(new a(c4658Fz7), length, length + 1, 33);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(800L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setRepeatMode(1);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.iP1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C11669dP1.c.N0(sa2, valueAnimator);
                }
            });
            valueAnimatorOfFloat.start();
            this.x = valueAnimatorOfFloat;
            return spannableStringBuilder;
        }

        private final void M1(AbstractC25195zt3 abstractC25195zt3) {
            boolean zD;
            RP1.h hVarG;
            DialogLastMessage dialogLastMessageA;
            MessageState messageStateR1 = r1();
            DialogDTO dialogDTO = this.y;
            MessageState messageState = dialogDTO != null ? dialogDTO.getMessageState() : null;
            if ((abstractC25195zt3 instanceof AbstractC25195zt3.d) || (abstractC25195zt3 instanceof AbstractC25195zt3.c) || (abstractC25195zt3 instanceof AbstractC25195zt3.e)) {
                messageStateR1 = null;
            } else if (messageStateR1 == null) {
                messageStateR1 = messageState;
            }
            SP1 sp1 = this.z;
            if (sp1 == null || (hVarG = sp1.g()) == null || (dialogLastMessageA = hVarG.a()) == null) {
                DialogDTO dialogDTO2 = this.y;
                zD = dialogDTO2 != null ? AbstractC13042fc3.d(dialogDTO2.getLastMessageIsMine(), Boolean.TRUE) : false;
            } else {
                zD = dialogLastMessageA.isMine();
            }
            d1(messageStateR1, Boolean.valueOf(zD));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void N0(SA2 sa2, ValueAnimator valueAnimator) {
            AbstractC13042fc3.i(sa2, "$onInvalidate");
            AbstractC13042fc3.i(valueAnimator, "it");
            sa2.invoke();
        }

        private final SpannableStringBuilder O0(SpannableStringBuilder spannableStringBuilder, String str, int i) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (str + ": "));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), length, spannableStringBuilder.length(), 33);
            return spannableStringBuilder;
        }

        private final SpannableStringBuilder P0(SpannableStringBuilder spannableStringBuilder, NP1 np1, Paint.FontMetricsInt fontMetricsInt) {
            Spannable spannableC;
            NP1.a aVar = np1 instanceof NP1.a ? (NP1.a) np1 : null;
            if (aVar != null && (spannableC = aVar.c()) != null) {
                spannableStringBuilder.append(R62.W(spannableC, fontMetricsInt, C5161Id6.e(14.0f), false, null, null, 48, null));
            }
            return spannableStringBuilder;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0282  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x02a2  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x02a5  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x027b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void Y0(java.lang.String r23, ir.nasim.AbstractC25195zt3 r24, boolean r25, boolean r26) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 763
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11669dP1.c.Y0(java.lang.String, ir.nasim.zt3, boolean, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 Z0(C12912fO1 c12912fO1) {
            AbstractC13042fc3.i(c12912fO1, "$this_with");
            c12912fO1.l.invalidate();
            return C19938rB7.a;
        }

        private final void a1(boolean z) {
            C12912fO1 c12912fO1 = this.u;
            BoundedSizeTextView boundedSizeTextView = c12912fO1.s;
            AbstractC13042fc3.h(boundedSizeTextView, "openWebAppBtn");
            boundedSizeTextView.setVisibility(z ? 0 : 8);
            c12912fO1.s.setBackground(s1());
        }

        private final void l1(AbstractC19428qK7 abstractC19428qK7) {
            C12912fO1 c12912fO1 = this.u;
            EnumC23487x03 enumC23487x03B = abstractC19428qK7.b();
            if (enumC23487x03B == null) {
                ImageView imageView = c12912fO1.B;
                AbstractC13042fc3.h(imageView, "userTypeIcon");
                imageView.setVisibility(8);
            } else {
                ImageView imageView2 = c12912fO1.B;
                AbstractC13042fc3.h(imageView2, "userTypeIcon");
                imageView2.setVisibility(0);
                c12912fO1.B.setImageDrawable(AbstractC4043Dl1.f(this.v, enumC23487x03B.j()));
            }
        }

        private final MessageState r1() {
            SP1 sp1 = this.z;
            MessageState state = null;
            if (sp1 == null) {
                return null;
            }
            C11669dP1 c11669dP1 = this.B;
            RP1.h hVarG = sp1.g();
            if (hVarG != null && hVarG.d() == c11669dP1.n) {
                state = sp1.g().a().getState();
            }
            MessageState messageStateH = sp1.h();
            return messageStateH == null ? state : messageStateH;
        }

        private final Drawable s1() {
            Drawable drawableD = AbstractC4310Eo7.d(C22078ud6.a(8.0f), C5495Jo7.a.V0());
            AbstractC13042fc3.h(drawableD, "createRoundRectDrawable(...)");
            return drawableD;
        }

        private final void t1(ViewStub viewStub, int i) {
            if (viewStub.getInflatedId() != -1) {
                return;
            }
            viewStub.setLayoutResource(i);
            viewStub.setInflatedId(viewStub.getId());
            viewStub.inflate();
        }

        private final void u1(final EnumC18228oI7 enumC18228oI7) {
            C12912fO1 c12912fO1 = this.u;
            final C11669dP1 c11669dP1 = this.B;
            final DialogDTO dialogDTO = this.y;
            if (dialogDTO != null && enumC18228oI7 != null) {
                c12912fO1.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kP1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C11669dP1.c.x1(c11669dP1, dialogDTO, enumC18228oI7, view);
                    }
                });
                return;
            }
            c12912fO1.b.setOnClickListener(null);
            c12912fO1.b.setClickable(false);
            c12912fO1.b.setFocusable(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x1(C11669dP1 c11669dP1, DialogDTO dialogDTO, EnumC18228oI7 enumC18228oI7, View view) {
            AbstractC13042fc3.i(c11669dP1, "this$0");
            c11669dP1.j.invoke(dialogDTO, enumC18228oI7);
        }

        public final void C1(final DialogDTO dialogDTO) {
            AbstractC13042fc3.i(dialogDTO, "dialog");
            C12912fO1 c12912fO1 = this.u;
            final C11669dP1 c11669dP1 = this.B;
            c12912fO1.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fP1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C11669dP1.c.D1(c11669dP1, dialogDTO, view);
                }
            });
            c12912fO1.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.gP1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return C11669dP1.c.E1(c11669dP1, dialogDTO, view);
                }
            });
            u1(c12912fO1.c.getAvatarState());
            if (!dialogDTO.getHasMainWebApp() || c11669dP1.k == null) {
                c12912fO1.s.setOnClickListener(null);
            } else {
                c12912fO1.s.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hP1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C11669dP1.c.F1(c11669dP1, dialogDTO, view);
                    }
                });
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void J1(java.lang.String r26) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11669dP1.c.J1(java.lang.String):void");
        }

        public final void Q0(DialogDTO dialogDTO) throws IOException {
            AbstractC13042fc3.i(dialogDTO, "dialog");
            this.y = dialogDTO;
            Group group = this.u.n;
            AbstractC13042fc3.h(group, "mainContent");
            group.setVisibility(0);
            C1(dialogDTO);
            l1(dialogDTO.getUserType());
            g1(dialogDTO.isPersonalSpace(), dialogDTO.getUserName(), dialogDTO.getHasBlueTick(), dialogDTO.isMuted());
            T0(dialogDTO.isPersonalSpace(), null, dialogDTO.getUserName(), GM1.a(dialogDTO), dialogDTO.isDeletedAccount());
            X0(dialogDTO.isPinned());
            a1(dialogDTO.getHasMainWebApp());
            c1(dialogDTO.getHasMention(), dialogDTO.getLastReactionEmoji());
            i1(this.B.W(dialogDTO.isMuted()), dialogDTO.getMarkAsUnread(), dialogDTO.getUnreadMessageCount());
            W0(dialogDTO.getFormattedTime());
            Y0(dialogDTO.getContentDescription(), dialogDTO.getPreviewLastMessage(), dialogDTO.isForwarded(), false);
            VP1 vp1 = new VP1(dialogDTO.getPeerUniqueId(), dialogDTO.getExPeerType(), this);
            this.B.l.G(dialogDTO, vp1);
            this.w = vp1;
        }

        public final void S0(EnumC18228oI7 enumC18228oI7) {
            this.u.c.setAvatarState(enumC18228oI7);
            u1(enumC18228oI7);
        }

        public final void T0(boolean z, Avatar avatar, String str, int i, boolean z2) {
            AbstractC13042fc3.i(str, "userName");
            AvatarWithStory avatarWithStory = this.u.c;
            if (z) {
                avatarWithStory.setAvatarState(EnumC18928pV.c);
                avatarWithStory.o();
                avatarWithStory.setPlaceHolder(AbstractC4043Dl1.f(avatarWithStory.getContext(), KB5.ic_saved_message));
            } else {
                Context context = avatarWithStory.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                avatarWithStory.d(avatar, str, i, z2, new WU(str, i, 16.0f, context, z2, true));
            }
        }

        public final void U0(String str) {
            C8386Vt0 c8386Vt0 = C8386Vt0.a;
            if (!c8386Vt0.n9() || str == null || str.length() == 0) {
                RLottieImageView rLottieImageView = this.u.d;
                AbstractC13042fc3.h(rLottieImageView, "badgeIcon");
                rLottieImageView.setVisibility(8);
                return;
            }
            RLottieImageView rLottieImageView2 = this.u.d;
            AbstractC13042fc3.h(rLottieImageView2, "badgeIcon");
            rLottieImageView2.setVisibility(0);
            this.u.d.setAnimationWithName(str, AbstractC22039uZ6.A1(str, 10));
            if (c8386Vt0.j9()) {
                this.u.d.f();
            }
        }

        public final void V0(String str) throws IOException {
            AbstractC25195zt3 previewLastMessage;
            RP1.h hVarG;
            Boolean boolF;
            if (str != null && !AbstractC20762sZ6.n0(str)) {
                Y0("", new AbstractC25195zt3.c(str), false, true);
                return;
            }
            SP1 sp1 = this.z;
            Boolean boolValueOf = null;
            if (sp1 == null || (previewLastMessage = sp1.d()) == null) {
                DialogDTO dialogDTO = this.y;
                previewLastMessage = dialogDTO != null ? dialogDTO.getPreviewLastMessage() : null;
            }
            SP1 sp12 = this.z;
            if (sp12 == null || (hVarG = sp12.g()) == null || (boolF = hVarG.f()) == null) {
                DialogDTO dialogDTO2 = this.y;
                if (dialogDTO2 != null) {
                    boolValueOf = Boolean.valueOf(dialogDTO2.isForwarded());
                }
            } else {
                boolValueOf = boolF;
            }
            Y0("", previewLastMessage, AbstractC13042fc3.d(boolValueOf, Boolean.TRUE), true);
        }

        public final void W0(String str) {
            BoundedSizeTextView boundedSizeTextView = this.u.f;
            String strH1 = str != null ? H1(str) : null;
            if (strH1 == null) {
                strH1 = "";
            }
            boundedSizeTextView.setText(strH1);
            boundedSizeTextView.requestLayout();
        }

        public final void X0(boolean z) {
            C12912fO1 c12912fO1 = this.u;
            B1(c12912fO1.k.isSelected(), z);
            AppCompatImageView appCompatImageView = c12912fO1.t;
            AbstractC13042fc3.h(appCompatImageView, "pinIcon");
            appCompatImageView.setVisibility(z ? 0 : 8);
        }

        public final void a() {
            C24904zP1.a aVar = this.w;
            if (aVar != null) {
                this.B.l.K(aVar);
                this.w = null;
            }
            AvatarWithStory avatarWithStory = this.u.c;
            avatarWithStory.o();
            avatarWithStory.setPresenceState(false);
            ValueAnimator valueAnimator = this.x;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.x = null;
            I1();
            this.y = null;
            this.z = null;
            this.A = null;
        }

        public final void c1(boolean z, String str) {
            C12912fO1 c12912fO1 = this.u;
            AppCompatImageView appCompatImageView = c12912fO1.m;
            AbstractC13042fc3.h(appCompatImageView, "lastReactionEmoji");
            appCompatImageView.setVisibility((str == null || AbstractC20762sZ6.n0(str)) ^ true ? 0 : 8);
            BoundedSizeTextView boundedSizeTextView = c12912fO1.p;
            AbstractC13042fc3.h(boundedSizeTextView, "mentionIcon");
            boundedSizeTextView.setVisibility(z ? 0 : 8);
        }

        public final void d1(MessageState messageState, Boolean bool) {
            Integer numB;
            AppCompatImageView appCompatImageView = this.u.v;
            if (messageState == null || (numB = AbstractC24148y74.b(messageState)) == null) {
                o1();
                return;
            }
            int iIntValue = numB.intValue();
            if (!AbstractC13042fc3.d(bool, Boolean.TRUE)) {
                o1();
                return;
            }
            AbstractC13042fc3.f(appCompatImageView);
            appCompatImageView.setVisibility(0);
            appCompatImageView.setImageResource(iIntValue);
            Integer numA = AbstractC24148y74.a(messageState);
            appCompatImageView.setContentDescription(numA != null ? appCompatImageView.getContext().getString(numA.intValue()) : null);
            Integer numC = AbstractC24148y74.c(messageState);
            if (numC != null) {
                int iIntValue2 = numC.intValue();
                Context context = appCompatImageView.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                appCompatImageView.setColorFilter(OY0.b(context, iIntValue2), PorterDuff.Mode.SRC_IN);
            }
        }

        public final void e1(YI7 yi7) {
            this.A = yi7;
            this.u.c.setPresenceState(yi7 == YI7.a);
        }

        public final ImageView f1(boolean z, boolean z2) {
            ImageView imageView = this.u.k;
            AbstractC13042fc3.f(imageView);
            boolean z3 = false;
            imageView.setVisibility(z2 ? 0 : 8);
            imageView.setSelected(z);
            imageView.setImageDrawable(z ? AbstractC4043Dl1.f(imageView.getContext(), AbstractC16390lB5.tick_circular_check) : null);
            DialogDTO dialogDTO = this.y;
            if (dialogDTO != null && dialogDTO.isPinned()) {
                z3 = true;
            }
            B1(z, z3);
            AbstractC13042fc3.h(imageView, "apply(...)");
            return imageView;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g1(boolean r6, java.lang.String r7, boolean r8, boolean r9) {
            /*
                r5 = this;
                java.lang.String r0 = "userName"
                ir.nasim.AbstractC13042fc3.i(r7, r0)
                ir.nasim.fO1 r0 = r5.u
                ir.nasim.dP1 r1 = r5.B
                ir.nasim.components.text.BoundedSizeTextView r2 = r0.A
                r3 = 2
                r2.setTextDirection(r3)
                r3 = 5
                r2.setTextAlignment(r3)
                if (r6 == 0) goto L1f
                android.content.Context r6 = r2.getContext()
                int r7 = ir.nasim.AbstractC12217eE5.saved_message_dialog_title
                java.lang.String r7 = r6.getString(r7)
            L1f:
                ir.nasim.AbstractC13042fc3.f(r7)
                java.lang.Long r6 = r5.q1()
                if (r6 == 0) goto L3d
                long r3 = r6.longValue()
                java.lang.Long r6 = java.lang.Long.valueOf(r3)
                int r3 = r7.hashCode()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                ir.nasim.XV4 r6 = ir.nasim.AbstractC4616Fw7.a(r6, r3)
                goto L3e
            L3d:
                r6 = 0
            L3e:
                java.lang.Object r3 = r2.getTag()
                boolean r3 = ir.nasim.AbstractC13042fc3.d(r3, r6)
                if (r3 == 0) goto L57
                java.lang.CharSequence r3 = r2.getText()
                java.lang.String r4 = "getText(...)"
                ir.nasim.AbstractC13042fc3.h(r3, r4)
                int r3 = r3.length()
                if (r3 != 0) goto L60
            L57:
                r2.setText(r7)
                r2.requestLayout()
                r2.setTag(r6)
            L60:
                android.widget.ImageView r6 = r0.e
                java.lang.String r7 = "blueTick"
                ir.nasim.AbstractC13042fc3.h(r6, r7)
                r7 = 8
                r2 = 0
                if (r8 == 0) goto L6e
                r8 = r2
                goto L6f
            L6e:
                r8 = r7
            L6f:
                r6.setVisibility(r8)
                android.widget.ImageView r6 = r0.r
                java.lang.String r8 = "mutedIcon"
                ir.nasim.AbstractC13042fc3.h(r6, r8)
                int r6 = r6.getVisibility()
                if (r6 != 0) goto L81
                r6 = 1
                goto L82
            L81:
                r6 = r2
            L82:
                if (r6 == r9) goto L98
                android.widget.ImageView r6 = r0.r
                ir.nasim.AbstractC13042fc3.h(r6, r8)
                if (r9 == 0) goto L8c
                r7 = r2
            L8c:
                r6.setVisibility(r7)
                ir.nasim.components.text.BoundedSizeTextView r6 = r0.y
                android.graphics.drawable.Drawable r7 = ir.nasim.C11669dP1.V(r1, r9)
                r6.setBackground(r7)
            L98:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11669dP1.c.g1(boolean, java.lang.String, boolean, boolean):void");
        }

        public final void i() {
            C12912fO1 c12912fO1 = this.u;
            c12912fO1.A.invalidate();
            c12912fO1.l.invalidate();
            c12912fO1.u.invalidate();
        }

        public final View i1(Drawable drawable, boolean z, int i) {
            AbstractC13042fc3.i(drawable, "unreadBadgeBackground");
            C12912fO1 c12912fO1 = this.u;
            BoundedSizeTextView boundedSizeTextView = c12912fO1.y;
            if (i <= 0) {
                AbstractC13042fc3.f(boundedSizeTextView);
                boundedSizeTextView.setVisibility(8);
                boundedSizeTextView.setText("");
            } else {
                AbstractC13042fc3.f(boundedSizeTextView);
                boundedSizeTextView.setVisibility(0);
                boundedSizeTextView.setText(H1(String.valueOf(i)));
                boundedSizeTextView.setBackground(drawable);
                boundedSizeTextView.setTextColor(C5495Jo7.a.Y0());
            }
            View view = c12912fO1.o;
            AbstractC13042fc3.f(view);
            view.setVisibility(z && i <= 0 ? 0 : 8);
            if (z) {
                view.setBackground(drawable);
            }
            AbstractC13042fc3.h(view, "with(...)");
            return view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00e2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void j1(ir.nasim.SP1 r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 483
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11669dP1.c.j1(ir.nasim.SP1):void");
        }

        public final void n1() {
            C12912fO1 c12912fO1 = this.u;
            ViewStub viewStub = c12912fO1.w;
            AbstractC13042fc3.h(viewStub, "shimmer");
            viewStub.setVisibility(8);
            c12912fO1.A.setText("");
            c12912fO1.A.setTag(null);
            c12912fO1.l.setText("");
            c12912fO1.l.setTag(null);
            c12912fO1.l.setCompoundDrawables(null, null, null, null);
            o1();
            c12912fO1.f.setText("");
            BoundedSizeTextView boundedSizeTextView = c12912fO1.y;
            boundedSizeTextView.setText("");
            AbstractC13042fc3.f(boundedSizeTextView);
            boundedSizeTextView.setVisibility(8);
            ImageView imageView = c12912fO1.k;
            AbstractC13042fc3.h(imageView, "imgTick");
            imageView.setVisibility(8);
            ImageView imageView2 = c12912fO1.e;
            AbstractC13042fc3.h(imageView2, "blueTick");
            imageView2.setVisibility(8);
            View view = c12912fO1.o;
            AbstractC13042fc3.h(view, "markAsUnreadIcon");
            view.setVisibility(8);
            BoundedSizeTextView boundedSizeTextView2 = c12912fO1.p;
            AbstractC13042fc3.h(boundedSizeTextView2, "mentionIcon");
            boundedSizeTextView2.setVisibility(8);
            AppCompatImageView appCompatImageView = c12912fO1.m;
            AbstractC13042fc3.h(appCompatImageView, "lastReactionEmoji");
            appCompatImageView.setVisibility(8);
            AppCompatImageView appCompatImageView2 = c12912fO1.t;
            AbstractC13042fc3.h(appCompatImageView2, "pinIcon");
            appCompatImageView2.setVisibility(8);
            BoundedSizeTextView boundedSizeTextView3 = c12912fO1.s;
            AbstractC13042fc3.h(boundedSizeTextView3, "openWebAppBtn");
            boundedSizeTextView3.setVisibility(8);
            ImageView imageView3 = c12912fO1.B;
            AbstractC13042fc3.h(imageView3, "userTypeIcon");
            imageView3.setVisibility(8);
            ImageView imageView4 = c12912fO1.j;
            AbstractC13042fc3.h(imageView4, "forwardIcon");
            imageView4.setVisibility(8);
            c12912fO1.c.setPlaceHolder(null);
            if (C8386Vt0.a.j9()) {
                c12912fO1.d.g();
            }
            RLottieImageView rLottieImageView = c12912fO1.d;
            AbstractC13042fc3.h(rLottieImageView, "badgeIcon");
            rLottieImageView.setVisibility(8);
        }

        public final void o1() {
            AppCompatImageView appCompatImageView = this.u.v;
            AbstractC13042fc3.f(appCompatImageView);
            appCompatImageView.setVisibility(8);
            appCompatImageView.setImageDrawable(null);
            appCompatImageView.setContentDescription(null);
        }

        public final void p1() {
            C12912fO1 c12912fO1 = this.u;
            Group group = c12912fO1.n;
            AbstractC13042fc3.h(group, "mainContent");
            group.setVisibility(8);
            ViewStub viewStub = c12912fO1.w;
            AbstractC13042fc3.h(viewStub, "shimmer");
            t1(viewStub, AbstractC11565dD5.dialog_list_item_shimmer);
            ViewStub viewStub2 = c12912fO1.w;
            AbstractC13042fc3.h(viewStub2, "shimmer");
            viewStub2.setVisibility(0);
        }

        public final Long q1() {
            DialogDTO dialogDTO = this.y;
            if (dialogDTO != null) {
                return Long.valueOf(dialogDTO.getPeerUniqueId());
            }
            return null;
        }

        public final void y1(DialogDTO dialogDTO) {
            this.y = dialogDTO;
        }

        public final void z1(final TextView textView, final CharSequence charSequence, final int i) {
            AbstractC13042fc3.i(textView, "<this>");
            AbstractC13042fc3.i(charSequence, "textToEllipsize");
            SA2 sa2 = new SA2() { // from class: ir.nasim.jP1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C11669dP1.c.A1(textView, i, charSequence);
                }
            };
            if (!textView.isLaidOut() || textView.isLayoutRequested()) {
                textView.addOnLayoutChangeListener(new b(sa2));
            } else {
                sa2.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11669dP1(UA2 ua2, UA2 ua22, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua23, C24904zP1 c24904zP1, int i, int i2, QM1 qm1) {
        super(r, null, null, 6, null);
        AbstractC13042fc3.i(ua2, "onClick");
        AbstractC13042fc3.i(interfaceC14603iB2, "onAvatarClick");
        AbstractC13042fc3.i(c24904zP1, "dialogStateBinder");
        AbstractC13042fc3.i(qm1, "contentDescriptionMapper");
        this.h = ua2;
        this.i = ua22;
        this.j = interfaceC14603iB2;
        this.k = ua23;
        this.l = c24904zP1;
        this.m = i;
        this.n = i2;
        this.o = qm1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable W(boolean z) {
        Drawable drawableD = AbstractC4310Eo7.d(C22078ud6.a(16.0f), z ? C5495Jo7.a.Z0() : C5495Jo7.a.V0());
        AbstractC13042fc3.h(drawableD, "createRoundRectDrawable(...)");
        return drawableD;
    }

    private final DialogDTO X(int i) {
        if (i < 0 || i >= getItemCount()) {
            UO1.d.a.a(this.m, "Invalid bind at " + i + " / count=" + getItemCount(), UO1.d.a.c);
            return null;
        }
        DialogDTO dialogDTO = (DialogDTO) D(i);
        if (dialogDTO != null) {
            return dialogDTO;
        }
        UO1.d.a.a(this.m, "Invalid Item NULL value for " + i + " / count=" + getItemCount(), UO1.d.a.c);
        Y(i);
        return null;
    }

    private final void Y(int i) {
        UO1.d.a.a(this.m, "Invalid bind at " + i + " / count=" + getItemCount(), UO1.d.a.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) throws IOException {
        AbstractC13042fc3.i(cVar, "holder");
        cVar.a();
        cVar.n1();
        DialogDTO dialogDTOX = X(i);
        if (dialogDTOX == null) {
            cVar.p1();
        } else {
            cVar.Q0(dialogDTOX);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076 A[EDGE_INSN: B:33:0x0076->B:34:0x0077 BREAK  A[LOOP:3: B:17:0x0043->B:74:0x0043]] */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(ir.nasim.C11669dP1.c r8, int r9, java.util.List r10) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            java.lang.String r0 = "payloads"
            ir.nasim.AbstractC13042fc3.i(r10, r0)
            ir.nasim.dialoglist.data.model.DialogDTO r0 = r7.X(r9)
            r1 = 1
            if (r0 == 0) goto L76
            java.lang.Long r2 = r8.q1()
            long r3 = r0.getPeerUniqueId()
            if (r2 != 0) goto L1c
            goto L76
        L1c:
            long r5 = r2.longValue()
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 != 0) goto L76
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r1
            if (r2 == 0) goto L76
            r2 = r10
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L3f
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L3f
            goto L74
        L3f:
            java.util.Iterator r2 = r2.iterator()
        L43:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L74
            java.lang.Object r3 = r2.next()
            boolean r4 = r3 instanceof java.util.Set
            if (r4 == 0) goto L76
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L61
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L61
            goto L43
        L61:
            java.util.Iterator r3 = r3.iterator()
        L65:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L43
            java.lang.Object r4 = r3.next()
            boolean r4 = r4 instanceof ir.nasim.MM1
            if (r4 != 0) goto L65
            goto L76
        L74:
            r2 = r1
            goto L77
        L76:
            r2 = 0
        L77:
            if (r0 == 0) goto Lef
            if (r2 == 0) goto Lef
            r8.y1(r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r10 = r10.iterator()
        L89:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L9b
            java.lang.Object r2 = r10.next()
            boolean r3 = r2 instanceof java.util.Set
            if (r3 == 0) goto L89
            r9.add(r2)
            goto L89
        L9b:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r9 = r9.iterator()
        La4:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto Ld1
            java.lang.Object r2 = r9.next()
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        Lbb:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto Lcd
            java.lang.Object r4 = r2.next()
            boolean r5 = r4 instanceof ir.nasim.MM1
            if (r5 == 0) goto Lbb
            r3.add(r4)
            goto Lbb
        Lcd:
            ir.nasim.ZW0.D(r10, r3)
            goto La4
        Ld1:
            java.util.Set r9 = ir.nasim.ZW0.r1(r10)
            ir.nasim.MM1 r10 = ir.nasim.MM1.a
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto Leb
            boolean r9 = r0.isPinned()
            r8.X0(r9)
            r9 = 0
            ir.nasim.C11669dP1.c.L1(r8, r9, r1, r9)
            ir.nasim.C11669dP1.c.L1(r8, r9, r1, r9)
        Leb:
            r8.C1(r0)
            goto Lf2
        Lef:
            r7.onBindViewHolder(r8, r9)
        Lf2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11669dP1.onBindViewHolder(ir.nasim.dP1$c, int, java.util.List):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C12912fO1 c12912fO1C = C12912fO1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        c12912fO1C.A.setTypeface(C6011Lu2.k());
        c12912fO1C.f.setTypeface(C6011Lu2.k());
        c12912fO1C.y.setTypeface(C6011Lu2.k());
        c12912fO1C.l.setTypeface(C6011Lu2.k());
        c12912fO1C.u.setTypeface(C6011Lu2.k());
        c12912fO1C.c.setSize(50);
        c12912fO1C.A.setTextDirection(2);
        AbstractC13042fc3.h(c12912fO1C, "apply(...)");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new c(this, c12912fO1C, context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public boolean onFailedToRecycleView(c cVar) {
        AbstractC13042fc3.i(cVar, "holder");
        UO1.d dVar = UO1.d.a;
        int i = this.m;
        UO1.d.d(dVar, "onFailedToRecycleView(" + cVar.K() + Separators.RPAREN, null, UO1.d.a.c, i, 2, null);
        return super.onFailedToRecycleView(cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(c cVar) {
        AbstractC13042fc3.i(cVar, "holder");
        cVar.a();
        cVar.n1();
        super.onViewRecycled(cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.l.I();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.l.J();
    }
}
