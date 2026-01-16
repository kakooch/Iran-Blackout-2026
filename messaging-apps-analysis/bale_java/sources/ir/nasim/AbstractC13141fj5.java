package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import ir.nasim.IQ0;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.model.story.WidgetCoordinate;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.fj5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC13141fj5 {
    public static final b g = new b(null);
    public static final int h = 8;
    private final Context a;
    private WidgetCoordinate b;
    private final float c;
    private final Drawable d;
    private final String e;
    private final ir.nasim.tgwidgets.editor.ui.stories.recorder.l f;

    /* renamed from: ir.nasim.fj5$a */
    private static final class a {
        private final Integer a;
        private final String b;
        private final E25 c;
        private final Avatar d;

        public a(Integer num, String str, E25 e25, Avatar avatar) {
            this.a = num;
            this.b = str;
            this.c = e25;
            this.d = avatar;
        }

        public final Avatar a() {
            return this.d;
        }

        public final Integer b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }

        public final E25 d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            E25 e25 = this.c;
            int iHashCode3 = (iHashCode2 + (e25 == null ? 0 : e25.hashCode())) * 31;
            Avatar avatar = this.d;
            return iHashCode3 + (avatar != null ? avatar.hashCode() : 0);
        }

        public String toString() {
            return "ChatProperties(id=" + this.a + ", name=" + this.b + ", peerIdentity=" + this.c + ", avatar=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.fj5$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fj5$c */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ TextView a;
        final /* synthetic */ int b;
        final /* synthetic */ Spannable c;
        final /* synthetic */ AbstractC13141fj5 d;
        final /* synthetic */ UA2 e;

        c(TextView textView, int i, Spannable spannable, AbstractC13141fj5 abstractC13141fj5, UA2 ua2) {
            this.a = textView;
            this.b = i;
            this.c = spannable;
            this.d = abstractC13141fj5;
            this.e = ua2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SpannableStringBuilder spannableStringBuilder;
            Layout layout = this.a.getLayout();
            if (layout == null) {
                this.e.invoke(new SpannableStringBuilder(""));
                return;
            }
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int lineCount = this.a.getLineCount();
            int i = this.b;
            if (lineCount > i) {
                int lineEnd = layout.getLineEnd(i - 1);
                spannableStringBuilder = new SpannableStringBuilder(this.c.subSequence(0, lineEnd));
                String str = "..." + this.d.a.getString(SD5.more);
                int length = spannableStringBuilder.length() - str.length();
                if (length >= 0) {
                    spannableStringBuilder.delete(length, spannableStringBuilder.length());
                    spannableStringBuilder.append((CharSequence) str);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(OY0.b(this.d.a, AbstractC14597iA5.colorPrimary)), length, spannableStringBuilder.length(), 33);
                } else {
                    spannableStringBuilder.clear();
                    spannableStringBuilder.append(this.c.subSequence(0, lineEnd - 1));
                    spannableStringBuilder.append((CharSequence) str);
                }
            } else {
                spannableStringBuilder = new SpannableStringBuilder(this.c);
            }
            this.e.invoke(spannableStringBuilder);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AbstractC13141fj5(android.content.Context r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            ir.nasim.AbstractC13042fc3.i(r4, r0)
            r3.<init>()
            r3.a = r4
            ir.nasim.database.model.story.WidgetCoordinate r0 = new ir.nasim.database.model.story.WidgetCoordinate
            r1 = 0
            r0.<init>(r1, r1)
            r3.b = r0
            androidx.lifecycle.r r0 = ir.nasim.AbstractC5963Lo7.b()
            java.lang.Object r0 = r0.f()
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            if (r0 == 0) goto L28
            int r1 = r0.getIntrinsicWidth()
            if (r1 == 0) goto L25
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 != 0) goto L3e
        L28:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r1 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r1, r0)
            java.lang.String r1 = "createBitmap(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r2 = r4.getResources()
            r1.<init>(r2, r0)
            r0 = r1
        L3e:
            r3.d = r0
            ir.nasim.ZP6 r1 = ir.nasim.ZP6.a
            java.lang.String r4 = r1.d(r4, r0)
            r3.e = r4
            ir.nasim.bK5 r0 = ir.nasim.C10248bK5.a
            ir.nasim.tgwidgets.editor.messenger.MediaController$m r4 = r0.a(r4)
            float r0 = r3.c
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l r4 = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.r(r4, r0)
            r3.f = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13141fj5.<init>(android.content.Context):void");
    }

    private final SpannableStringBuilder d(SpannableStringBuilder spannableStringBuilder, Context context, int i) {
        Drawable drawableF = AbstractC4043Dl1.f(context, i);
        if (drawableF != null) {
            ImageSpan imageSpan = new ImageSpan(w(B02.b(drawableF, 0, 0, null, 7, null), AbstractC20723sV3.c(Math.ceil(drawableF.getIntrinsicWidth() * 2.5d))), 2);
            spannableStringBuilder.append(Separators.SP);
            spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    private final Spannable e(C20610sI7 c20610sI7) {
        SpannableString spannableString = new SpannableString(Separators.SP);
        spannableString.setSpan(new C12973fV(c20610sI7, AbstractC8943Xx1.c(32)), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C12973fV c12973fV, C15481jf3 c15481jf3, Drawable drawable) {
        AbstractC13042fc3.i(c12973fV, "$span");
        AbstractC13042fc3.i(c15481jf3, "$binding");
        AbstractC13042fc3.i(drawable, "drawable");
        c12973fV.a(drawable);
        c15481jf3.m.invalidate();
        return C19938rB7.a;
    }

    private final C20610sI7 o(a aVar) {
        AvatarImage secondImage;
        AvatarImage imageDefaultSize;
        FileReference fileReference = null;
        if (aVar.b() == null) {
            return null;
        }
        Avatar avatarA = aVar.a();
        FileReference fileReference2 = (avatarA == null || (imageDefaultSize = avatarA.getImageDefaultSize()) == null) ? null : imageDefaultSize.getFileReference();
        Avatar avatarA2 = aVar.a();
        if (avatarA2 != null && (secondImage = avatarA2.getSecondImage()) != null) {
            fileReference = secondImage.getFileReference();
        }
        return new C20610sI7(fileReference2, fileReference, new WU(aVar.c(), aVar.b().intValue(), 12.0f, this.a, false, true));
    }

    private final a r(IQ0 iq0) {
        a aVar;
        C19482qQ7 c19482qQ7H;
        C19482qQ7 c19482qQ7T;
        C10410bZ6 c10410bZ6R;
        C19482qQ7 c19482qQ7J;
        C19482qQ7 c19482qQ7Y;
        C10410bZ6 c10410bZ6V;
        Avatar avatar = null;
        if (iq0 instanceof IQ0.a) {
            IQ0.a aVar2 = (IQ0.a) iq0;
            C14733iO2 c14733iO2A = aVar2.a();
            Integer numValueOf = c14733iO2A != null ? Integer.valueOf(c14733iO2A.r()) : null;
            C14733iO2 c14733iO2A2 = aVar2.a();
            String str = (c14733iO2A2 == null || (c10410bZ6V = c14733iO2A2.v()) == null) ? null : (String) c10410bZ6V.b();
            C14733iO2 c14733iO2A3 = aVar2.a();
            E25 e25 = (c14733iO2A3 == null || (c19482qQ7Y = c14733iO2A3.y()) == null) ? null : (E25) c19482qQ7Y.b();
            C14733iO2 c14733iO2A4 = aVar2.a();
            if (c14733iO2A4 != null && (c19482qQ7J = c14733iO2A4.j()) != null) {
                avatar = (Avatar) c19482qQ7J.b();
            }
            aVar = new a(numValueOf, str, e25, avatar);
        } else {
            if (!(iq0 instanceof IQ0.b)) {
                throw new NoWhenBranchMatchedException();
            }
            IQ0.b bVar = (IQ0.b) iq0;
            C21231tK7 c21231tK7A = bVar.a();
            Integer numValueOf2 = c21231tK7A != null ? Integer.valueOf(c21231tK7A.o()) : null;
            C21231tK7 c21231tK7A2 = bVar.a();
            String str2 = (c21231tK7A2 == null || (c10410bZ6R = c21231tK7A2.r()) == null) ? null : (String) c10410bZ6R.b();
            C21231tK7 c21231tK7A3 = bVar.a();
            E25 e252 = (c21231tK7A3 == null || (c19482qQ7T = c21231tK7A3.t()) == null) ? null : (E25) c19482qQ7T.b();
            C21231tK7 c21231tK7A4 = bVar.a();
            if (c21231tK7A4 != null && (c19482qQ7H = c21231tK7A4.h()) != null) {
                avatar = (Avatar) c19482qQ7H.b();
            }
            aVar = new a(numValueOf2, str2, e252, avatar);
        }
        return aVar;
    }

    private final l.c u(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar) {
        ArrayList arrayList = lVar.C;
        AbstractC13042fc3.h(arrayList, "parts");
        return (l.c) AbstractC15401jX0.q0(arrayList);
    }

    private final Bitmap w(Bitmap bitmap, int i) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, AbstractC20723sV3.d(bitmap.getHeight() * (i / bitmap.getWidth())), false);
        AbstractC13042fc3.h(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    private final ir.nasim.tgwidgets.editor.ui.stories.recorder.l z(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, XV4 xv4) {
        ArrayList arrayList = lVar.C;
        AbstractC13042fc3.h(arrayList, "parts");
        l.c cVar = (l.c) AbstractC15401jX0.q0(arrayList);
        cVar.b = (int) ((Number) xv4.e()).floatValue();
        cVar.c = (int) ((Number) xv4.f()).floatValue();
        cVar.e = false;
        ArrayList arrayList2 = lVar.C;
        AbstractC13042fc3.h(arrayList2, "parts");
        Matrix matrix = ((l.c) AbstractC15401jX0.q0(arrayList2)).d;
        matrix.postTranslate(this.b.getX(), this.b.getY());
        ArrayList arrayList3 = lVar.C;
        AbstractC13042fc3.h(arrayList3, "parts");
        ((l.c) AbstractC15401jX0.q0(arrayList3)).d.set(matrix);
        return lVar;
    }

    protected final ir.nasim.tgwidgets.editor.ui.stories.recorder.l c(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, Bitmap bitmap, l.c cVar) {
        AbstractC13042fc3.i(lVar, "storyEntry");
        AbstractC13042fc3.i(bitmap, "bitmap");
        AbstractC13042fc3.i(cVar, "storyPart");
        lVar.C.add(cVar);
        XV4 xv4I = i(bitmap, lVar);
        this.b = this.b.a(lVar.z * 0.12f, (lVar.A - ((Number) xv4I.f()).floatValue()) / 2.0f);
        return z(lVar, xv4I);
    }

    protected final void f(final C15481jf3 c15481jf3, C8967Xz7 c8967Xz7) {
        C12973fV[] c12973fVArr;
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        Context context = c15481jf3.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        FU fu = new FU(context);
        Spannable spannableO = c8967Xz7.o();
        if (spannableO == null || (c12973fVArr = (C12973fV[]) spannableO.getSpans(0, spannableO.length(), C12973fV.class)) == null) {
            return;
        }
        for (final C12973fV c12973fV : c12973fVArr) {
            FU.g(fu, c12973fV.c(), c12973fV.b(), null, new UA2() { // from class: ir.nasim.ej5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC13141fj5.g(c12973fV, c15481jf3, (Drawable) obj);
                }
            }, 4, null);
        }
    }

    public String h(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar) {
        AbstractC13042fc3.i(lVar, "entry");
        File fileI = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.I(0, false);
        lVar.j(fileI);
        String absolutePath = fileI.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    protected XV4 i(Bitmap bitmap, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        AbstractC13042fc3.i(lVar, "storyEntry");
        float f = lVar.z * 0.76f;
        return new XV4(Float.valueOf(f), Float.valueOf((bitmap.getHeight() * f) / bitmap.getWidth()));
    }

    public List j(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar) {
        AbstractC13042fc3.i(lVar, "storyEntry");
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[9];
        u(lVar).d.getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[2];
        float f4 = fArr[5];
        XV4 xv4 = new XV4(Float.valueOf(u(lVar).b * f), Float.valueOf(u(lVar).c * f2));
        AbstractC13610gX0.E(arrayList, new WidgetCoordinate[]{new WidgetCoordinate(f3 / lVar.z, f4 / lVar.A), new WidgetCoordinate((((Number) xv4.e()).floatValue() + f3) / lVar.z, f4 / lVar.A), new WidgetCoordinate(f3 / lVar.z, (((Number) xv4.f()).floatValue() + f4) / lVar.A), new WidgetCoordinate((f3 + ((Number) xv4.e()).floatValue()) / lVar.z, (f4 + ((Number) xv4.f()).floatValue()) / lVar.A)});
        return arrayList;
    }

    protected final void k(C15481jf3 c15481jf3, float f) {
        AbstractC13042fc3.i(c15481jf3, "postToStoryBinding");
        ((ImageViewCrossFade) c15481jf3.getRoot().findViewById(AbstractC18172oC5.imageView)).setCorners(f);
    }

    protected final C15481jf3 l(C16731lm1 c16731lm1) {
        AbstractC13042fc3.i(c16731lm1, "contextThemeWrapper");
        C15481jf3 c15481jf3C = C15481jf3.c(LayoutInflater.from(new ContextThemeWrapper(c16731lm1, AbstractC15826kE5.Theme_Bale_BubbleTheme_Incomming)));
        AbstractC13042fc3.h(c15481jf3C, "inflate(...)");
        return c15481jf3C;
    }

    public final SpannableStringBuilder m() {
        return new SpannableStringBuilder(Separators.SP);
    }

    protected final Spannable n(Context context, IQ0 iq0) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(iq0, "chatType");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        C18423oe0 c18423oe0D = C18423oe0.d(JF5.g());
        a aVarR = r(iq0);
        C20610sI7 c20610sI7O = o(aVarR);
        if (c20610sI7O != null) {
            spannableStringBuilder.append((CharSequence) e(c20610sI7O));
        }
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(4));
        spannableStringBuilder.append(Separators.SP);
        String strC = aVarR.c();
        if (strC != null) {
            spannableStringBuilder.append((CharSequence) c18423oe0D.k(strC));
        }
        if (aVarR.d() == E25.VERIFIED) {
            spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(4));
            d(spannableStringBuilder, context, AbstractC23008wB5.blue_tick);
        }
        return spannableStringBuilder;
    }

    public abstract void p(C16731lm1 c16731lm1, C8967Xz7 c8967Xz7, ViewGroup viewGroup, IQ0 iq0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22);

    protected l.c q(String str) {
        AbstractC13042fc3.i(str, "path");
        File file = new File(str);
        l.c cVar = new l.c();
        cVar.f = file;
        return cVar;
    }

    protected final ir.nasim.tgwidgets.editor.ui.stories.recorder.l s() {
        return this.f;
    }

    protected final void t(TextView textView, Spannable spannable, int i, UA2 ua2) {
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(spannable, "originalText");
        AbstractC13042fc3.i(ua2, "onResult");
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new c(textView, i, spannable, this, ua2));
    }

    protected final int v(ViewGroup viewGroup) {
        AbstractC13042fc3.i(viewGroup, "rootView");
        return (int) (viewGroup.getResources().getDisplayMetrics().heightPixels * 0.55d);
    }

    protected final void x(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "postToStoryBinding");
        ((ImageViewCrossFade) c15481jf3.getRoot().findViewById(AbstractC18172oC5.imageView)).setIsPostToStoryCapture(true);
    }

    protected final void y(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "postToStoryBinding");
        c15481jf3.getRoot().layout(c15481jf3.getRoot().getLeft(), c15481jf3.getRoot().getTop(), c15481jf3.getRoot().getRight(), c15481jf3.getRoot().getBottom());
    }
}
