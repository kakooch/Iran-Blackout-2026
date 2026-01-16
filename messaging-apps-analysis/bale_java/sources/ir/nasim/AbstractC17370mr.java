package ir.nasim;

import android.graphics.Shader;
import android.os.Build;
import ir.nasim.AbstractC4553Fp7;

/* renamed from: ir.nasim.mr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17370mr {
    public static final Shader.TileMode a(int i) {
        AbstractC4553Fp7.a aVar = AbstractC4553Fp7.a;
        return AbstractC4553Fp7.f(i, aVar.a()) ? Shader.TileMode.CLAMP : AbstractC4553Fp7.f(i, aVar.d()) ? Shader.TileMode.REPEAT : AbstractC4553Fp7.f(i, aVar.c()) ? Shader.TileMode.MIRROR : AbstractC4553Fp7.f(i, aVar.b()) ? Build.VERSION.SDK_INT >= 31 ? C5036Hp7.a.a() : Shader.TileMode.CLAMP : Shader.TileMode.CLAMP;
    }
}
