package ir.nasim;

import android.view.View;
import android.view.inputmethod.EditorInfo;

/* renamed from: ir.nasim.Ky3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5815Ky3 {
    private static UA2 a = a.a;

    /* renamed from: ir.nasim.Ky3$a */
    /* synthetic */ class a extends EB2 implements UA2 {
        public static final a a = new a();

        a() {
            super(1, C21127t93.class, "<init>", "<init>(Landroid/view/View;)V", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final C21127t93 invoke(View view) {
            return new C21127t93(view);
        }
    }

    public static final AbstractC5581Jy3 b() {
        return new C3370Ap();
    }

    public static final UA2 c() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EditorInfo editorInfo) {
        if (androidx.emoji2.text.e.k()) {
            androidx.emoji2.text.e.c().x(editorInfo);
        }
    }
}
