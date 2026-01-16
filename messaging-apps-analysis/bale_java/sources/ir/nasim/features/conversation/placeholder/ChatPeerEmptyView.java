package ir.nasim.features.conversation.placeholder;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C11458d25;
import ir.nasim.C14419ht;
import ir.nasim.C15929kQ0;
import ir.nasim.C17981nt;
import ir.nasim.C19938rB7;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C9248Zc6;
import ir.nasim.EnumC11723dV1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC5620Kc6;
import ir.nasim.InterfaceC7298Rc6;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.KB5;
import ir.nasim.QI2;
import ir.nasim.SZ;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.features.conversation.placeholder.ChatPeerEmptyView;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010&¨\u0006("}, d2 = {"Lir/nasim/features/conversation/placeholder/ChatPeerEmptyView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "username", "Lir/nasim/ht;", "animatedSticker", "Lir/nasim/d25;", "peer", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lir/nasim/ht;Lir/nasim/d25;)V", "Lir/nasim/rB7;", "b", "()V", "d", "e", "sticker", "setupAnimatedSticker", "(Lir/nasim/ht;)V", "onDetachedFromWindow", "a", "Ljava/lang/String;", "getUsername", "()Ljava/lang/String;", "Lir/nasim/ht;", "getAnimatedSticker", "()Lir/nasim/ht;", "c", "Lir/nasim/d25;", "getPeer", "()Lir/nasim/d25;", "Lir/nasim/kQ0;", "Lir/nasim/kQ0;", "getBinding", "()Lir/nasim/kQ0;", "binding", "Lir/nasim/Tm2;", "Lir/nasim/Tm2;", "bindedFile", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ChatPeerEmptyView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final String username;

    /* renamed from: b, reason: from kotlin metadata */
    private final C14419ht animatedSticker;

    /* renamed from: c, reason: from kotlin metadata */
    private final C11458d25 peer;

    /* renamed from: d, reason: from kotlin metadata */
    private final C15929kQ0 binding;

    /* renamed from: e, reason: from kotlin metadata */
    private InterfaceC7857Tm2 bindedFile;

    public final class a implements InterfaceC8091Um2 {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC3346Am2 interfaceC3346Am2, ChatPeerEmptyView chatPeerEmptyView) {
            AbstractC13042fc3.i(interfaceC3346Am2, "$reference");
            AbstractC13042fc3.i(chatPeerEmptyView, "this$0");
            chatPeerEmptyView.getBinding().c.setAnimation(new FileInputStream(new File(interfaceC3346Am2.getDescriptor())), chatPeerEmptyView.getAnimatedSticker().b());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ChatPeerEmptyView chatPeerEmptyView, C19938rB7 c19938rB7) {
            AbstractC13042fc3.i(chatPeerEmptyView, "this$0");
            chatPeerEmptyView.getBinding().c.x();
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            Object obj = C17981nt.b().get(Integer.valueOf(ChatPeerEmptyView.this.getAnimatedSticker().d()));
            AbstractC13042fc3.f(obj);
            int iIntValue = ((Number) obj).intValue();
            LottieAnimationView lottieAnimationView = ChatPeerEmptyView.this.getBinding().c;
            AbstractC13042fc3.h(lottieAnimationView, "chatPeerEmptyLottie");
            QI2.j(iIntValue, lottieAnimationView);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(final InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            final ChatPeerEmptyView chatPeerEmptyView = ChatPeerEmptyView.this;
            C9248Zc6 c9248Zc6F = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.iQ0
                @Override // ir.nasim.InterfaceC7298Rc6
                public final Object run() {
                    return ChatPeerEmptyView.a.f(interfaceC3346Am2, chatPeerEmptyView);
                }
            }).h(EnumC11723dV1.IO).f(true);
            final ChatPeerEmptyView chatPeerEmptyView2 = ChatPeerEmptyView.this;
            C9248Zc6 c9248Zc6G = c9248Zc6F.g(new InterfaceC5620Kc6() { // from class: ir.nasim.jQ0
                @Override // ir.nasim.InterfaceC5620Kc6
                public final void onSuccess(Object obj) {
                    ChatPeerEmptyView.a.h(chatPeerEmptyView2, (C19938rB7) obj);
                }
            });
            AbstractC13042fc3.h(c9248Zc6G, "onSuccess(...)");
            SZ.e(c9248Zc6G);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            Object obj = C17981nt.b().get(Integer.valueOf(ChatPeerEmptyView.this.getAnimatedSticker().d()));
            AbstractC13042fc3.f(obj);
            int iIntValue = ((Number) obj).intValue();
            LottieAnimationView lottieAnimationView = ChatPeerEmptyView.this.getBinding().c;
            AbstractC13042fc3.h(lottieAnimationView, "chatPeerEmptyLottie");
            QI2.j(iIntValue, lottieAnimationView);
            AbstractC5969Lp4.d().F1(ChatPeerEmptyView.this.getAnimatedSticker().c());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatPeerEmptyView(Context context, String str, C14419ht c14419ht, C11458d25 c11458d25) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "username");
        AbstractC13042fc3.i(c14419ht, "animatedSticker");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.username = str;
        this.animatedSticker = c14419ht;
        this.peer = c11458d25;
        C15929kQ0 c15929kQ0C = C15929kQ0.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(c15929kQ0C, "inflate(...)");
        this.binding = c15929kQ0C;
        b();
    }

    private final void b() {
        String string = getContext().getString(AbstractC12217eE5.say_hello_to_user, this.username);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(string).append((CharSequence) Separators.SP);
        StyleSpan styleSpan = new StyleSpan(1);
        AbstractC13042fc3.f(spannableStringBuilderAppend);
        spannableStringBuilderAppend.setSpan(styleSpan, AbstractC20762sZ6.l0(spannableStringBuilderAppend, this.username, 0, false, 6, null), AbstractC20762sZ6.l0(spannableStringBuilderAppend, this.username, 0, false, 6, null) + this.username.length(), 33);
        spannableStringBuilderAppend.setSpan(new ImageSpan(getContext(), KB5.ic_waving_hand, 1), string.length(), string.length() + 1, 33);
        this.binding.d.setText(spannableStringBuilderAppend, TextView.BufferType.EDITABLE);
        e();
        d();
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hQ0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatPeerEmptyView.c(this.a, view);
            }
        });
        setupAnimatedSticker(this.animatedSticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ChatPeerEmptyView chatPeerEmptyView, View view) {
        AbstractC13042fc3.i(chatPeerEmptyView, "this$0");
        AbstractC5969Lp4.d().x1(chatPeerEmptyView.peer, chatPeerEmptyView.animatedSticker);
    }

    private final void d() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12)}, null, null));
        Paint paint = shapeDrawable.getPaint();
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        paint.setColor(c5495Jo7.P0());
        shapeDrawable.getPaint().setAlpha(SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER);
        shapeDrawable.getPaint().setAntiAlias(true);
        this.binding.b.setBackgroundDrawable(shapeDrawable);
        this.binding.d.setTextColor(c5495Jo7.f1());
    }

    private final void e() {
        this.binding.d.setTypeface(C6011Lu2.k());
    }

    private final void setupAnimatedSticker(C14419ht sticker) {
        FileReference fileReferenceC;
        if (sticker == null || (fileReferenceC = sticker.c()) == null) {
            return;
        }
        this.bindedFile = AbstractC5969Lp4.d().q(fileReferenceC, true, new a());
    }

    public final C14419ht getAnimatedSticker() {
        return this.animatedSticker;
    }

    public final C15929kQ0 getBinding() {
        return this.binding;
    }

    public final C11458d25 getPeer() {
        return this.peer;
    }

    public final String getUsername() {
        return this.username;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FileReference fileReferenceC = this.animatedSticker.c();
        if (fileReferenceC != null) {
            AbstractC5969Lp4.d().s(fileReferenceC.getFileId());
        }
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.bindedFile;
        if (interfaceC7857Tm2 != null) {
            if (interfaceC7857Tm2 != null) {
                interfaceC7857Tm2.a(true);
            }
            this.bindedFile = null;
        }
    }
}
