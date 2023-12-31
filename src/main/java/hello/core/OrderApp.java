package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {


    public static void main(String[] args) {

    AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderservice = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderservice = new OrderServiceImpl(null);

        Long memberId = 1L;
        Member member = new Member(memberId, "Jong", Grade.VIP);
        memberService.join(member);
        Order order = orderservice.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order = " + order.calculatePrice());

    }

}
