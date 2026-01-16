package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC16408lD5;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC5729Ko7;
import ir.nasim.AbstractC9751aV3;
import ir.nasim.C7605Sk7;
import ir.nasim.GE5;
import ir.nasim.M02;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public final class BadgeState {
    private final State a;
    private final State b;
    final float c;
    final float d;
    final float e;

    BadgeState(Context context, int i, int i2, int i3, State state) throws XmlPullParserException, Resources.NotFoundException, IOException {
        State state2 = new State();
        this.b = state2;
        state = state == null ? new State() : state;
        if (i != 0) {
            state.a = i;
        }
        TypedArray typedArrayA = a(context, state.a, i2, i3);
        Resources resources = context.getResources();
        this.c = typedArrayA.getDimensionPixelSize(GE5.Badge_badgeRadius, resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_badge_radius));
        this.e = typedArrayA.getDimensionPixelSize(GE5.Badge_badgeWidePadding, resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_badge_long_text_horizontal_padding));
        this.d = typedArrayA.getDimensionPixelSize(GE5.Badge_badgeWithTextRadius, resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_badge_with_text_radius));
        state2.d = state.d == -2 ? 255 : state.d;
        state2.h = state.h == null ? context.getString(AbstractC23026wD5.mtrl_badge_numberless_content_description) : state.h;
        state2.i = state.i == 0 ? AbstractC16408lD5.mtrl_badge_content_description : state.i;
        state2.j = state.j == 0 ? AbstractC23026wD5.mtrl_exceed_max_badge_number_content_description : state.j;
        state2.l = Boolean.valueOf(state.l == null || state.l.booleanValue());
        state2.f = state.f == -2 ? typedArrayA.getInt(GE5.Badge_maxCharacterCount, 4) : state.f;
        if (state.e != -2) {
            state2.e = state.e;
        } else if (typedArrayA.hasValue(GE5.Badge_number)) {
            state2.e = typedArrayA.getInt(GE5.Badge_number, 0);
        } else {
            state2.e = -1;
        }
        state2.b = Integer.valueOf(state.b == null ? u(context, typedArrayA, GE5.Badge_backgroundColor) : state.b.intValue());
        if (state.c != null) {
            state2.c = state.c;
        } else if (typedArrayA.hasValue(GE5.Badge_badgeTextColor)) {
            state2.c = Integer.valueOf(u(context, typedArrayA, GE5.Badge_badgeTextColor));
        } else {
            state2.c = Integer.valueOf(new C7605Sk7(context, AbstractC21175tE5.TextAppearance_MaterialComponents_Badge).i().getDefaultColor());
        }
        state2.k = Integer.valueOf(state.k == null ? typedArrayA.getInt(GE5.Badge_badgeGravity, 8388661) : state.k.intValue());
        state2.m = Integer.valueOf(state.m == null ? typedArrayA.getDimensionPixelOffset(GE5.Badge_horizontalOffset, 0) : state.m.intValue());
        state2.n = Integer.valueOf(state.m == null ? typedArrayA.getDimensionPixelOffset(GE5.Badge_verticalOffset, 0) : state.n.intValue());
        state2.o = Integer.valueOf(state.o == null ? typedArrayA.getDimensionPixelOffset(GE5.Badge_horizontalOffsetWithText, state2.m.intValue()) : state.o.intValue());
        state2.p = Integer.valueOf(state.p == null ? typedArrayA.getDimensionPixelOffset(GE5.Badge_verticalOffsetWithText, state2.n.intValue()) : state.p.intValue());
        state2.q = Integer.valueOf(state.q == null ? 0 : state.q.intValue());
        state2.r = Integer.valueOf(state.r != null ? state.r.intValue() : 0);
        typedArrayA.recycle();
        if (state.g == null) {
            state2.g = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.g = state.g;
        }
        this.a = state;
    }

    private TypedArray a(Context context, int i, int i2, int i3) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet attributeSet;
        int styleAttribute;
        if (i != 0) {
            AttributeSet attributeSetA = M02.a(context, i, "badge");
            styleAttribute = attributeSetA.getStyleAttribute();
            attributeSet = attributeSetA;
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        return AbstractC5729Ko7.h(context, attributeSet, GE5.Badge, i2, styleAttribute == 0 ? i3 : styleAttribute, new int[0]);
    }

    private static int u(Context context, TypedArray typedArray, int i) {
        return AbstractC9751aV3.a(context, typedArray, i).getDefaultColor();
    }

    int b() {
        return this.b.q.intValue();
    }

    int c() {
        return this.b.r.intValue();
    }

    int d() {
        return this.b.d;
    }

    int e() {
        return this.b.b.intValue();
    }

    int f() {
        return this.b.k.intValue();
    }

    int g() {
        return this.b.c.intValue();
    }

    int h() {
        return this.b.j;
    }

    CharSequence i() {
        return this.b.h;
    }

    int j() {
        return this.b.i;
    }

    int k() {
        return this.b.o.intValue();
    }

    int l() {
        return this.b.m.intValue();
    }

    int m() {
        return this.b.f;
    }

    int n() {
        return this.b.e;
    }

    Locale o() {
        return this.b.g;
    }

    State p() {
        return this.a;
    }

    int q() {
        return this.b.p.intValue();
    }

    int r() {
        return this.b.n.intValue();
    }

    boolean s() {
        return this.b.e != -1;
    }

    boolean t() {
        return this.b.l.booleanValue();
    }

    void v(int i) {
        this.a.d = i;
        this.b.d = i;
    }

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();
        private int a;
        private Integer b;
        private Integer c;
        private int d;
        private int e;
        private int f;
        private Locale g;
        private CharSequence h;
        private int i;
        private int j;
        private Integer k;
        private Boolean l;
        private Integer m;
        private Integer n;
        private Integer o;
        private Integer p;
        private Integer q;
        private Integer r;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i) {
                return new State[i];
            }
        }

        public State() {
            this.d = 255;
            this.e = -2;
            this.f = -2;
            this.l = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeSerializable(this.b);
            parcel.writeSerializable(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            CharSequence charSequence = this.h;
            parcel.writeString(charSequence == null ? null : charSequence.toString());
            parcel.writeInt(this.i);
            parcel.writeSerializable(this.k);
            parcel.writeSerializable(this.m);
            parcel.writeSerializable(this.n);
            parcel.writeSerializable(this.o);
            parcel.writeSerializable(this.p);
            parcel.writeSerializable(this.q);
            parcel.writeSerializable(this.r);
            parcel.writeSerializable(this.l);
            parcel.writeSerializable(this.g);
        }

        State(Parcel parcel) {
            this.d = 255;
            this.e = -2;
            this.f = -2;
            this.l = Boolean.TRUE;
            this.a = parcel.readInt();
            this.b = (Integer) parcel.readSerializable();
            this.c = (Integer) parcel.readSerializable();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.h = parcel.readString();
            this.i = parcel.readInt();
            this.k = (Integer) parcel.readSerializable();
            this.m = (Integer) parcel.readSerializable();
            this.n = (Integer) parcel.readSerializable();
            this.o = (Integer) parcel.readSerializable();
            this.p = (Integer) parcel.readSerializable();
            this.q = (Integer) parcel.readSerializable();
            this.r = (Integer) parcel.readSerializable();
            this.l = (Boolean) parcel.readSerializable();
            this.g = (Locale) parcel.readSerializable();
        }
    }
}
