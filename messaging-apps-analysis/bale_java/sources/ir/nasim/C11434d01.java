package ir.nasim;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import ir.nasim.AbstractC6718Or3;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.d01, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11434d01 implements InterfaceC10670c01 {
    public static final b Companion = new b(null);
    private final VV0 a;
    private final InterfaceC9336Zm4 b;
    private final InterfaceC9336Zm4 c;
    private AudioTrack d;
    private final AtomicBoolean e;

    /* renamed from: ir.nasim.d01$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.d01$a$a, reason: collision with other inner class name */
        static final class C1001a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ boolean c;
            /* synthetic */ boolean d;

            C1001a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC4616Fw7.a(AbstractC6392Nk0.a(this.c), AbstractC6392Nk0.a(this.d));
            }

            public final Object n(boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
                C1001a c1001a = new C1001a(interfaceC20295rm1);
                c1001a.c = z;
                c1001a.d = z2;
                return c1001a.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return n(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
            }
        }

        /* renamed from: ir.nasim.d01$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C11434d01 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C11434d01 c11434d01, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c11434d01;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws UnsupportedOperationException {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                XV4 xv4 = (XV4) this.c;
                this.d.i(((Boolean) xv4.a()).booleanValue(), ((Boolean) xv4.b()).booleanValue());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(xv4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11434d01.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.S(C11434d01.this.b, C11434d01.this.c, new C1001a(null)));
                b bVar = new b(C11434d01.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, bVar, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.d01$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public C11434d01(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        VV0 vv0 = new VV0(abstractC13778go1);
        this.a = vv0;
        this.b = AbstractC12281eL6.a(Boolean.FALSE);
        this.c = AbstractC12281eL6.a(Boolean.TRUE);
        this.e = new AtomicBoolean(false);
        AbstractC10533bm0.d(vv0, null, null, new a(null), 3, null);
    }

    private final AudioTrack f() throws UnsupportedOperationException {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(h(2) * 160);
        AudioTrack audioTrackBuild = new AudioTrack.Builder().setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(16000).setChannelMask(4).build()).setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(1).build()).setBufferSizeInBytes(byteBufferAllocateDirect.capacity()).setTransferMode(0).setSessionId(0).build();
        AbstractC13042fc3.h(audioTrackBuild, "build(...)");
        audioTrackBuild.write(byteBufferAllocateDirect, byteBufferAllocateDirect.remaining(), 0);
        audioTrackBuild.setLoopPoints(0, 159, -1);
        return audioTrackBuild;
    }

    private final int h(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Bad audio format " + i);
        }
        int i2 = 1;
        if (i == 1 || i == 2) {
            return 2;
        }
        if (i != 3) {
            i2 = 4;
            if (i != 4) {
                if (i == 13) {
                    return 2;
                }
                throw new IllegalArgumentException("Bad audio format " + i);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean z, boolean z2) throws UnsupportedOperationException {
        if (z && z2) {
            k();
        } else {
            j();
        }
    }

    private final void j() {
        AudioTrack audioTrack;
        if (this.e.compareAndSet(true, false) && (audioTrack = this.d) != null) {
            synchronized (audioTrack) {
                try {
                    if (audioTrack.getState() == 1) {
                        audioTrack.pause();
                    } else {
                        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                        if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.d(null, "Attempted to stop communication workaround but track was not initialized.", new Object[0]);
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final void k() throws UnsupportedOperationException {
        if (this.e.compareAndSet(false, true)) {
            AudioTrack audioTrackF = this.d;
            if (audioTrackF == null) {
                audioTrackF = f();
                this.d = audioTrackF;
            }
            synchronized (audioTrackF) {
                try {
                    if (audioTrackF.getState() == 1) {
                        audioTrackF.play();
                    } else {
                        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                        if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.g(null, "Attempted to start communication workaround but track was not initialized.", new Object[0]);
                        }
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC10670c01
    public void a() {
        this.c.setValue(Boolean.TRUE);
    }

    @Override // ir.nasim.InterfaceC10670c01
    public void b() {
        this.c.setValue(Boolean.FALSE);
    }

    public void g() {
        this.a.close();
        stop();
        AudioTrack audioTrack = this.d;
        if (audioTrack != null) {
            synchronized (audioTrack) {
                audioTrack.release();
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }
    }

    @Override // ir.nasim.InterfaceC10670c01
    public void start() {
        this.b.setValue(Boolean.TRUE);
    }

    @Override // ir.nasim.InterfaceC10670c01
    public void stop() {
        this.b.setValue(Boolean.FALSE);
    }
}
