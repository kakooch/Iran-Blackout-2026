package ir.nasim;

import ir.nasim.KO3;
import ir.nasim.chat.ChatFragment;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.story.repository.StoryRepository;

/* loaded from: classes4.dex */
public abstract class RP0 {
    public static void a(ChatFragment chatFragment, C6975Pu c6975Pu) {
        chatFragment.anonymousContentUseCase = c6975Pu;
    }

    public static void b(ChatFragment chatFragment, InterfaceC21843uE interfaceC21843uE) {
        chatFragment.appRatingNavigator = interfaceC21843uE;
    }

    public static void c(ChatFragment chatFragment, InterfaceC16501lO interfaceC16501lO) {
        chatFragment.audioPlayer = interfaceC16501lO;
    }

    public static void d(ChatFragment chatFragment, InterfaceC23146wR interfaceC23146wR) {
        chatFragment.authenticatorNavigator = interfaceC23146wR;
    }

    public static void e(ChatFragment chatFragment, BankingModule bankingModule) {
        chatFragment.bankingModule = bankingModule;
    }

    public static void f(ChatFragment chatFragment, InterfaceC21124t90 interfaceC21124t90) {
        chatFragment.bindDisplayList = interfaceC21124t90;
    }

    public static void g(ChatFragment chatFragment, C18812pI0 c18812pI0) {
        chatFragment.changeContactContentUseCase = c18812pI0;
    }

    public static void h(ChatFragment chatFragment, InterfaceC11677dQ0 interfaceC11677dQ0) {
        chatFragment.chatNavigator = interfaceC11677dQ0;
    }

    public static void i(ChatFragment chatFragment, InterfaceC8288Vi1 interfaceC8288Vi1) {
        chatFragment.contactNavigator = interfaceC8288Vi1;
    }

    public static void j(ChatFragment chatFragment, InterfaceC15814kD2 interfaceC15814kD2) {
        chatFragment.galleryNavigator = interfaceC15814kD2;
    }

    public static void k(ChatFragment chatFragment, AbstractC13778go1 abstractC13778go1) {
        chatFragment.ioDispatcher = abstractC13778go1;
    }

    public static void l(ChatFragment chatFragment, InterfaceC24798zD3 interfaceC24798zD3) {
        chatFragment.liveNavigator = interfaceC24798zD3;
    }

    public static void m(ChatFragment chatFragment, KO3.a aVar) {
        chatFragment.markWonHandlerFactory = aVar;
    }

    public static void n(ChatFragment chatFragment, InterfaceC16114kj5 interfaceC16114kj5) {
        chatFragment.postToStoryUseCase = interfaceC16114kj5;
    }

    public static void o(ChatFragment chatFragment, JM2 jm2) {
        chatFragment.profileNavigator = jm2;
    }

    public static void p(ChatFragment chatFragment, InterfaceC24908zP5 interfaceC24908zP5) {
        chatFragment.reportNavigator = interfaceC24908zP5;
    }

    public static void q(ChatFragment chatFragment, AR6 ar6) {
        chatFragment.storyNavigator = ar6;
    }

    public static void r(ChatFragment chatFragment, StoryRepository storyRepository) {
        chatFragment.storyRepository = storyRepository;
    }

    public static void s(ChatFragment chatFragment, FD7 fd7) {
        chatFragment.updateGateway = fd7;
    }

    public static void t(ChatFragment chatFragment, InterfaceC10956cU7 interfaceC10956cU7) {
        chatFragment.videoPlayerNavigator = interfaceC10956cU7;
    }

    public static void u(ChatFragment chatFragment, InterfaceC16935m68 interfaceC16935m68) {
        chatFragment.webAppNavigator = interfaceC16935m68;
    }
}
