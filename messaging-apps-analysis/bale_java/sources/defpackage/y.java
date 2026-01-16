package defpackage;

import android.media.AudioRecord;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C12366eV1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.UA2;
import ir.nasim.WM3;

/* loaded from: classes.dex */
public final class y {
    private final UA2 a;
    private final int b;
    private final int c;
    private final AudioRecord d;
    private boolean e;
    private final InterfaceC20315ro1 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: y$a$a, reason: collision with other inner class name */
        static final class C1835a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ y c;
            final /* synthetic */ boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1835a(y yVar, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = yVar;
                this.d = z;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1835a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.a.invoke(AbstractC6392Nk0.a(this.d));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1835a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return y.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            short[] sArr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                sArr = new short[1024];
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sArr = (short[]) this.b;
                AbstractC10685c16.b(obj);
            }
            while (y.this.e) {
                boolean z = false;
                if (y.this.d.read(sArr, 0, sArr.length) > 0) {
                    y yVar = y.this;
                    int length = sArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        if (sArr[i2] > yVar.c) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                WM3 wm3C = C12366eV1.c();
                C1835a c1835a = new C1835a(y.this, z, null);
                this.b = sArr;
                this.c = 1;
                if (AbstractC9323Zl0.g(wm3C, c1835a, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public y(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onSpeechDetected");
        this.a = ua2;
        this.b = 44100;
        this.c = 800;
        this.d = new AudioRecord(1, 44100, 16, 2, AudioRecord.getMinBufferSize(44100, 16, 2));
        this.f = AbstractC20906so1.a(C12366eV1.b());
    }

    public final void e() {
        this.e = true;
        this.d.startRecording();
        AbstractC10533bm0.d(this.f, null, null, new a(null), 3, null);
    }

    public final void f() throws IllegalStateException {
        if (this.e) {
            this.e = false;
            this.d.stop();
            AbstractC20906so1.d(this.f, null, 1, null);
        }
    }
}
