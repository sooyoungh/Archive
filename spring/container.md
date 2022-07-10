![image](https://user-images.githubusercontent.com/77563814/178150396-0ba57c46-e5dd-4077-b770-8ffe3d7374c1.png)
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
		
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	...
}
