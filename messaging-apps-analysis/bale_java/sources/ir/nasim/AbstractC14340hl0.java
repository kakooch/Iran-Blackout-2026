package ir.nasim;

import android.graphics.Shader;

/* renamed from: ir.nasim.hl0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14340hl0 {

    /* renamed from: ir.nasim.hl0$a */
    public static final class a extends AbstractC4147Dw6 {
        final /* synthetic */ Shader e;

        a(Shader shader) {
            this.e = shader;
        }

        @Override // ir.nasim.AbstractC4147Dw6
        public Shader b(long j) {
            return this.e;
        }
    }

    public static final AbstractC4147Dw6 a(Shader shader) {
        return new a(shader);
    }
}
