import com.lovo.ss.entity.GoodsEntity;
import com.lovo.ss.entity.OrderEntity;
import com.lovo.ss.service.IGoodsService;
import com.lovo.ss.service.IOrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderTest {

    IOrderService service;
    IGoodsService goodsService;

    @Before
    public void before(){
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("application.xml");
        service = (IOrderService) context.getBean("orderService");
        goodsService = (IGoodsService) context.getBean("goodsService");

    }


    @Test
    public void test(){
        service.addOrder(new OrderEntity(66.5,1));
    }

    @Test
    public void goodsTest(){
        goodsService.add(new GoodsEntity("汉堡",33));
    }
}
