package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTests {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memeberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member jong = new Member(memberId, "Jong", Grade.VIP);
        memberService.join(jong);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getItemName()).isEqualTo("itemA");

    }
}
