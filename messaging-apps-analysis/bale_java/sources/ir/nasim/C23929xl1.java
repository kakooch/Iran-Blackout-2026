package ir.nasim;

import ai.bale.proto.FilesStruct$FastThumb;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.AbstractC2383g;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C23929xl1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14341hl1;
import ir.nasim.O25;
import ir.nasim.RY1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.xl1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23929xl1 extends RecyclerView.C {
    public static final a A = new a(null);
    public static final int B = 8;
    private final String u;
    private final C14949il1 v;
    private final UA2 w;
    private InterfaceC13730gj3 x;
    private final InterfaceC20315ro1 y;
    private InterfaceC14341hl1 z;

    /* renamed from: ir.nasim.xl1$a */
    public static final class a {
        private a() {
        }

        public final Bitmap a(FilesStruct$FastThumb filesStruct$FastThumb) {
            byte[] bArrA0;
            if (filesStruct$FastThumb == null) {
                return null;
            }
            try {
                AbstractC2383g thumb = filesStruct$FastThumb.getThumb();
                if (thumb == null || (bArrA0 = thumb.a0()) == null) {
                    return null;
                }
                if (!(!(bArrA0.length == 0))) {
                    return null;
                }
                AbstractC2383g thumb2 = filesStruct$FastThumb.getThumb();
                return C16670lg0.b(thumb2 != null ? thumb2.a0() : null);
            } catch (Exception unused) {
                return null;
            }
        }

        public final C23929xl1 b(ViewGroup viewGroup, UA2 ua2, String str) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onClick");
            AbstractC13042fc3.i(str, "title");
            C14949il1 c14949il1C = C14949il1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c14949il1C, "inflate(...)");
            c14949il1C.c.B(16.0f, true);
            c14949il1C.f.setTypeface(C6011Lu2.k());
            c14949il1C.q.setTypeface(C6011Lu2.k());
            c14949il1C.p.setTypeface(C6011Lu2.k());
            c14949il1C.u.setTypeface(C6011Lu2.k());
            c14949il1C.j.setTypeface(C6011Lu2.i());
            c14949il1C.t.setTypeface(C6011Lu2.k());
            return new C23929xl1(str, c14949il1C, ua2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xl1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14341hl1 d;
        final /* synthetic */ C23929xl1 e;

        /* renamed from: ir.nasim.xl1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ C23929xl1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, C23929xl1 c23929xl1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
                this.e = c23929xl1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C23929xl1 c23929xl1) {
                c23929xl1.v.l.setVisibility(8);
                c23929xl1.v.m.setVisibility(0);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                RY1 ry1 = (RY1) this.c;
                if (!AbstractC20906so1.g(this.d) || this.e.x == null) {
                    return C19938rB7.a;
                }
                if (ry1 instanceof RY1.a) {
                    String descriptor = ((RY1.a) ry1).a().getDescriptor();
                    ImageView imageView = this.e.v.k;
                    AbstractC13042fc3.h(imageView, "image");
                    QI2.p(descriptor, imageView, null, 4, null);
                    this.e.v.l.setVisibility(0);
                    this.e.v.m.setVisibility(8);
                } else if (!(ry1 instanceof RY1.b)) {
                    if (!(ry1 instanceof RY1.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (this.e.O0() != null && (this.e.O0() instanceof InterfaceC14341hl1.a)) {
                        a aVar = C23929xl1.A;
                        InterfaceC14341hl1 interfaceC14341hl1O0 = this.e.O0();
                        AbstractC13042fc3.g(interfaceC14341hl1O0, "null cannot be cast to non-null type ir.nasim.jaryan.search.data.model.ContentSearchResult.PhotoResult");
                        Bitmap bitmapA = aVar.a(((InterfaceC14341hl1.a) interfaceC14341hl1O0).e());
                        if (bitmapA != null) {
                            this.e.v.k.setImageBitmap(bitmapA);
                        } else {
                            final C23929xl1 c23929xl1 = this.e;
                            new SA2() { // from class: ir.nasim.yl1
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C23929xl1.b.a.y(c23929xl1);
                                }
                            };
                        }
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14341hl1 interfaceC14341hl1, C23929xl1 c23929xl1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14341hl1;
            this.e = c23929xl1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2D = ((InterfaceC14341hl1.a) this.d).d();
                a aVar = new a(interfaceC20315ro1, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2D, aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xl1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ RY1 c;
        final /* synthetic */ C23929xl1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RY1 ry1, C23929xl1 c23929xl1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ry1;
            this.d = c23929xl1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String descriptor = ((RY1.a) this.c).a().getDescriptor();
            ImageView imageView = this.d.v.k;
            AbstractC13042fc3.h(imageView, "image");
            QI2.p(descriptor, imageView, null, 4, null);
            this.d.v.l.setVisibility(0);
            this.d.v.m.setVisibility(8);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.xl1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ C23929xl1 e;
        final /* synthetic */ Bitmap f;

        /* renamed from: ir.nasim.xl1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ C23929xl1 e;
            final /* synthetic */ Bitmap f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, C23929xl1 c23929xl1, Bitmap bitmap, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
                this.e = c23929xl1;
                this.f = bitmap;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C23929xl1 c23929xl1) {
                c23929xl1.v.l.setVisibility(8);
                c23929xl1.v.m.setVisibility(0);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                RY1 ry1 = (RY1) this.c;
                if (!AbstractC20906so1.g(this.d) || this.e.x == null) {
                    return C19938rB7.a;
                }
                if (ry1 instanceof RY1.a) {
                    String descriptor = ((RY1.a) ry1).a().getDescriptor();
                    ImageView imageView = this.e.v.k;
                    AbstractC13042fc3.h(imageView, "image");
                    QI2.p(descriptor, imageView, null, 4, null);
                    this.e.v.l.setVisibility(0);
                    this.e.v.m.setVisibility(8);
                } else if (!(ry1 instanceof RY1.b) && (ry1 instanceof RY1.c)) {
                    Bitmap bitmap = this.f;
                    if (bitmap != null) {
                        C23929xl1 c23929xl1 = this.e;
                        c23929xl1.v.l.setVisibility(0);
                        c23929xl1.v.m.setVisibility(8);
                        c23929xl1.v.k.setImageBitmap(bitmap);
                    } else {
                        final C23929xl1 c23929xl12 = this.e;
                        new SA2() { // from class: ir.nasim.zl1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C23929xl1.d.a.y(c23929xl12);
                            }
                        };
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC10258bL6 interfaceC10258bL6, C23929xl1 c23929xl1, Bitmap bitmap, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
            this.e = c23929xl1;
            this.f = bitmap;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, this.f, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC10258bL6 interfaceC10258bL6 = this.d;
                a aVar = new a(interfaceC20315ro1, this.e, this.f, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23929xl1(String str, C14949il1 c14949il1, UA2 ua2) {
        super(c14949il1.getRoot());
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(c14949il1, "binding");
        AbstractC13042fc3.i(ua2, "onClick");
        this.u = str;
        this.v = c14949il1;
        this.w = ua2;
        this.y = AbstractC20906so1.a(C12366eV1.c());
        c14949il1.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23929xl1.E0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C23929xl1 c23929xl1, View view) {
        AbstractC13042fc3.i(c23929xl1, "this$0");
        InterfaceC14341hl1 interfaceC14341hl1 = c23929xl1.z;
        if (interfaceC14341hl1 != null) {
            c23929xl1.w.invoke(interfaceC14341hl1);
        }
    }

    private final void L0(InterfaceC10258bL6 interfaceC10258bL6, Bitmap bitmap) {
        RY1 ry1 = (RY1) interfaceC10258bL6.getValue();
        if (ry1 instanceof RY1.a) {
            AbstractC10533bm0.d(AH0.a.o(), null, null, new c(ry1, this, null), 3, null);
            return;
        }
        if (bitmap != null) {
            this.v.l.setVisibility(0);
            this.v.m.setVisibility(8);
            this.v.k.setImageBitmap(bitmap);
        } else {
            new SA2() { // from class: ir.nasim.wl1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C23929xl1.M0(this.a);
                }
            };
        }
        this.x = AbstractC10533bm0.d(AH0.a.o(), null, null, new d(interfaceC10258bL6, this, bitmap, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M0(C23929xl1 c23929xl1) {
        AbstractC13042fc3.i(c23929xl1, "this$0");
        c23929xl1.v.l.setVisibility(8);
        c23929xl1.v.m.setVisibility(0);
        return C19938rB7.a;
    }

    private final String N0(Context context, long j) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        long j2 = 60;
        long j3 = jCurrentTimeMillis / j2;
        long j4 = j3 / j2;
        long j5 = j4 / 24;
        long j6 = j5 / 7;
        long j7 = j5 / 30;
        String string = jCurrentTimeMillis < 60 ? context.getString(ID5.story_date_now) : j3 < 60 ? context.getString(ID5.minutes_ago, Long.valueOf(j3)) : j4 < 24 ? context.getString(ID5.hour_ago, Long.valueOf(j4)) : j5 < 7 ? context.getString(ID5.day_ago, Long.valueOf(j5)) : j6 < 4 ? context.getString(ID5.week_ago, Long.valueOf(j6)) : j7 < 12 ? context.getString(ID5.month_ago, Long.valueOf(j7)) : context.getString(ID5.year_ago, Long.valueOf(j5 / 365));
        AbstractC13042fc3.f(string);
        return XY6.v(string);
    }

    public final void J0(InterfaceC14341hl1 interfaceC14341hl1, boolean z, C20644sM5 c20644sM5) {
        AbstractC13042fc3.i(c20644sM5, "matcher");
        this.z = interfaceC14341hl1;
        if (interfaceC14341hl1 == null) {
            this.v.e.setVisibility(8);
            this.v.o.setVisibility(0);
            return;
        }
        this.v.e.setVisibility(0);
        this.v.o.setVisibility(8);
        if (z) {
            this.v.t.setText(this.u);
            this.v.t.setVisibility(0);
        } else {
            this.v.t.setVisibility(8);
        }
        if (interfaceC14341hl1 instanceof InterfaceC14341hl1.a) {
            this.v.l.setVisibility(8);
            this.v.m.setVisibility(0);
            this.v.v.setVisibility(8);
            this.x = AbstractC10533bm0.d(this.y, null, null, new b(interfaceC14341hl1, this, null), 3, null);
            Bitmap bitmapA = A.a(((InterfaceC14341hl1.a) interfaceC14341hl1).e());
            if (bitmapA != null) {
                this.v.k.setImageBitmap(bitmapA);
            }
            this.v.n.setGuidelineEnd((int) ((80 * AbstractC3742Cd6.c()) + 0.5d));
        } else if (interfaceC14341hl1 instanceof InterfaceC14341hl1.b) {
            this.v.v.setVisibility(8);
            this.v.l.setVisibility(8);
            this.v.m.setVisibility(8);
            this.v.n.setGuidelineEnd(0);
        } else {
            if (!(interfaceC14341hl1 instanceof InterfaceC14341hl1.c)) {
                throw new NoWhenBranchMatchedException();
            }
            this.v.l.setVisibility(0);
            this.v.v.setVisibility(0);
            this.v.m.setVisibility(8);
            InterfaceC14341hl1.c cVar = (InterfaceC14341hl1.c) interfaceC14341hl1;
            Bitmap bitmapA2 = A.a(cVar.e());
            InterfaceC10258bL6 interfaceC10258bL6D = cVar.d();
            if (interfaceC10258bL6D != null) {
                L0(interfaceC10258bL6D, bitmapA2);
            }
            if (cVar.d() == null) {
                if (bitmapA2 != null) {
                    this.v.k.setImageBitmap(bitmapA2);
                }
                if (bitmapA2 == null) {
                    C14949il1 c14949il1 = this.v;
                    ImageView imageView = c14949il1.k;
                    Context context = c14949il1.getRoot().getContext();
                    AbstractC13042fc3.h(context, "getContext(...)");
                    imageView.setBackgroundColor(OY0.b(context, AbstractC13999hA5.n100));
                }
            }
            this.v.n.setGuidelineEnd((int) ((80 * AbstractC3742Cd6.c()) + 0.5d));
        }
        SpannableString spannableStringI = AbstractC17636nI6.i(interfaceC14341hl1.a());
        for (OU3 ou3 : C20644sM5.e(c20644sM5, AbstractC17636nI6.i(AbstractC20153rZ6.M(interfaceC14341hl1.a(), "_", Separators.SP, false, 4, null)), 0, 2, null)) {
            Context context2 = this.v.getRoot().getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            spannableStringI.setSpan(new ForegroundColorSpan(OY0.b(context2, AbstractC13999hA5.colorPrimary)), ou3.c().o(), ou3.c().t() + 1, 33);
        }
        TextView textView = this.v.u;
        String str = (String) interfaceC14341hl1.c().v().b();
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        this.v.c.q(interfaceC14341hl1.c());
        this.v.j.setText(spannableStringI);
        C14949il1 c14949il12 = this.v;
        TextView textView2 = c14949il12.f;
        Context context3 = c14949il12.getRoot().getContext();
        AbstractC13042fc3.h(context3, "getContext(...)");
        textView2.setText(N0(context3, interfaceC14341hl1.l().d()));
        TextView textView3 = this.v.q;
        O25.a aVar = O25.A;
        Object objB = interfaceC14341hl1.c().u().b();
        AbstractC13042fc3.h(objB, "get(...)");
        textView3.setText(XY6.v(aVar.a(((Number) objB).intValue()) + Separators.SP + this.v.getRoot().getContext().getString(ID5.member)));
    }

    public final InterfaceC14341hl1 O0() {
        return this.z;
    }

    public final void P0() {
        AbstractC20267rj3.j(this.y.getCoroutineContext(), null, 1, null);
        InterfaceC13730gj3 interfaceC13730gj3 = this.x;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.x = null;
    }
}
