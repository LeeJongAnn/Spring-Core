## 스프링 핵심 원리 


### DI(Dependency Injection)란 무엇인가
1. 외부에서 어떤 객체가 선택될지 정해서 주입해주는 것을 DI(Dependency Injection)이라고 한다.
객체를 생성하면서 동시에 어떤 객체가 생성될지 정해버리게 되면 향후에 설계 변경 시 OCP를 위반하게 된다.(Open Closed Principal)


      
        public class MemberServiceImpl implements MemberService{

        private  MemberRepository memberRepository = new MemoryMemberRepository();
    
        @Override
        public void join(Member member) {
                memberRepository.save(member);
        }
    
        @Override
        public Member findMember(Long memberId) {
           return memberRepository.findById(memberId);
    
        }
    }

위의 코드는 MemberService를 구현한 MemberServiceImpl의 코드이다, 이것은 1번의 예시로 
memberRepository가 new MemoryMemberRepository()로 생성하면서 정해져 있다는 것을 알 수 있다.

### 이것은 유연성이 떨어지게 되는 코드이다 . 
왜냐하면 만약에 MemoryMemberRepository 말고 다른 Repository로 변경해야된다면 , 직접 구현체를 변경해야되며 
구현체 (MemberServiceImpl) 는 본인의 역할 (실행이라는)에 충실하지 못하고 생성까지 떠맡게 된다.

그리하여 이것은 좋은 코드가 아니라고 할 수 있겠다.





