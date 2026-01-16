package ir.nasim;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import ir.nasim.AbstractC7094Qg0;

/* renamed from: ir.nasim.Qn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7156Qn {
    public static final BlendMode a(int i) {
        AbstractC7094Qg0.a aVar = AbstractC7094Qg0.a;
        return AbstractC7094Qg0.E(i, aVar.a()) ? BlendMode.CLEAR : AbstractC7094Qg0.E(i, aVar.x()) ? BlendMode.SRC : AbstractC7094Qg0.E(i, aVar.g()) ? BlendMode.DST : AbstractC7094Qg0.E(i, aVar.B()) ? BlendMode.SRC_OVER : AbstractC7094Qg0.E(i, aVar.k()) ? BlendMode.DST_OVER : AbstractC7094Qg0.E(i, aVar.z()) ? BlendMode.SRC_IN : AbstractC7094Qg0.E(i, aVar.i()) ? BlendMode.DST_IN : AbstractC7094Qg0.E(i, aVar.A()) ? BlendMode.SRC_OUT : AbstractC7094Qg0.E(i, aVar.j()) ? BlendMode.DST_OUT : AbstractC7094Qg0.E(i, aVar.y()) ? BlendMode.SRC_ATOP : AbstractC7094Qg0.E(i, aVar.h()) ? BlendMode.DST_ATOP : AbstractC7094Qg0.E(i, aVar.C()) ? BlendMode.XOR : AbstractC7094Qg0.E(i, aVar.t()) ? BlendMode.PLUS : AbstractC7094Qg0.E(i, aVar.q()) ? BlendMode.MODULATE : AbstractC7094Qg0.E(i, aVar.v()) ? BlendMode.SCREEN : AbstractC7094Qg0.E(i, aVar.s()) ? BlendMode.OVERLAY : AbstractC7094Qg0.E(i, aVar.e()) ? BlendMode.DARKEN : AbstractC7094Qg0.E(i, aVar.o()) ? BlendMode.LIGHTEN : AbstractC7094Qg0.E(i, aVar.d()) ? BlendMode.COLOR_DODGE : AbstractC7094Qg0.E(i, aVar.c()) ? BlendMode.COLOR_BURN : AbstractC7094Qg0.E(i, aVar.m()) ? BlendMode.HARD_LIGHT : AbstractC7094Qg0.E(i, aVar.w()) ? BlendMode.SOFT_LIGHT : AbstractC7094Qg0.E(i, aVar.f()) ? BlendMode.DIFFERENCE : AbstractC7094Qg0.E(i, aVar.l()) ? BlendMode.EXCLUSION : AbstractC7094Qg0.E(i, aVar.r()) ? BlendMode.MULTIPLY : AbstractC7094Qg0.E(i, aVar.n()) ? BlendMode.HUE : AbstractC7094Qg0.E(i, aVar.u()) ? BlendMode.SATURATION : AbstractC7094Qg0.E(i, aVar.b()) ? BlendMode.COLOR : AbstractC7094Qg0.E(i, aVar.p()) ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
    }

    public static final PorterDuff.Mode b(int i) {
        AbstractC7094Qg0.a aVar = AbstractC7094Qg0.a;
        return AbstractC7094Qg0.E(i, aVar.a()) ? PorterDuff.Mode.CLEAR : AbstractC7094Qg0.E(i, aVar.x()) ? PorterDuff.Mode.SRC : AbstractC7094Qg0.E(i, aVar.g()) ? PorterDuff.Mode.DST : AbstractC7094Qg0.E(i, aVar.B()) ? PorterDuff.Mode.SRC_OVER : AbstractC7094Qg0.E(i, aVar.k()) ? PorterDuff.Mode.DST_OVER : AbstractC7094Qg0.E(i, aVar.z()) ? PorterDuff.Mode.SRC_IN : AbstractC7094Qg0.E(i, aVar.i()) ? PorterDuff.Mode.DST_IN : AbstractC7094Qg0.E(i, aVar.A()) ? PorterDuff.Mode.SRC_OUT : AbstractC7094Qg0.E(i, aVar.j()) ? PorterDuff.Mode.DST_OUT : AbstractC7094Qg0.E(i, aVar.y()) ? PorterDuff.Mode.SRC_ATOP : AbstractC7094Qg0.E(i, aVar.h()) ? PorterDuff.Mode.DST_ATOP : AbstractC7094Qg0.E(i, aVar.C()) ? PorterDuff.Mode.XOR : AbstractC7094Qg0.E(i, aVar.t()) ? PorterDuff.Mode.ADD : AbstractC7094Qg0.E(i, aVar.v()) ? PorterDuff.Mode.SCREEN : AbstractC7094Qg0.E(i, aVar.s()) ? PorterDuff.Mode.OVERLAY : AbstractC7094Qg0.E(i, aVar.e()) ? PorterDuff.Mode.DARKEN : AbstractC7094Qg0.E(i, aVar.o()) ? PorterDuff.Mode.LIGHTEN : AbstractC7094Qg0.E(i, aVar.q()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
